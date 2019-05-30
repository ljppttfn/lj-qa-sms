package cn.fudata.qa.sms.service;

import cn.fudata.qa.sms.dao.mapper.spcard10010.CardPositionMapper;

import cn.fudata.qa.sms.dao.mapper.spcard10000.SmsRecvMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard10000.SmsSendMapper10000;

import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsRecvMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsSendMapper10010;

import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsSendMapper10086;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsRecvMapper10086;

import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.SmsRecv;
import cn.fudata.qa.sms.dao.model.SmsRecvExample;
import cn.fudata.qa.sms.dao.model.SmsSend;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author youlong
 * date 2019/1/7
 */
@Service
public class SMSService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final
    CardPositionMapper cardPositionMapper;

    private final
    SmsRecvMapper10000 smsRecvMapper10000;

    private final
    SmsRecvMapper10010 smsRecvMapper10010;

    private final
    SmsRecvMapper10086 smsRecvMapper10086;

    private final
    SmsSendMapper10000 smsSendMapper10000;

    private final
    SmsSendMapper10010 smsSendMapper10010;

    private final
    SmsSendMapper10086 smsSendMapper10086;

    @Autowired
    public SMSService(CardPositionMapper cardPositionMapper, SmsRecvMapper10000 smsRecvMapper10000, SmsRecvMapper10010 smsRecvMapper10010, SmsRecvMapper10086 smsRecvMapper10086, SmsSendMapper10000 smsSendMapper10000, SmsSendMapper10010 smsSendMapper10010, SmsSendMapper10086 smsSendMapper10086) {
        this.cardPositionMapper = cardPositionMapper;
        this.smsRecvMapper10000 = smsRecvMapper10000;
        this.smsRecvMapper10010 = smsRecvMapper10010;
        this.smsRecvMapper10086 = smsRecvMapper10086;
        this.smsSendMapper10000 = smsSendMapper10000;
        this.smsSendMapper10010 = smsSendMapper10010;
        this.smsSendMapper10086 = smsSendMapper10086;
    }

    public List<SmsRecv> get_sms_by_phone_time(String phoNum, long time){
        List<SmsRecv> sms_list = new ArrayList<>();

        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return sms_list;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time2 = LocalDateTime.ofEpochSecond(time/1000,0, ZoneOffset.ofHours(8));
        String beginData = time2.format(formatter);

        SmsRecvExample example = new SmsRecvExample();
        example.createCriteria().andPortnumEqualTo(cp.getPortnum())
                .andSmsdateGreaterThan(beginData);
        example.setOrderByClause("smsdate desc");
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectByExample(example);
                break;
            case "10010":
                sms_list = smsRecvMapper10010.selectByExample(example);
                break;
            case "10086":
                sms_list = smsRecvMapper10086.selectByExample(example);
                break;
            default:
                return null;
        }

        return sms_list;
    }

    /**
     * 根据手机号获取最新的一条完整的短信
     *
     * @param phoNum phoneNumber
     * @return smsContent
     */
    public SmsRecv get_sms_latest(String phoNum) {
        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return null;
        }
        List<SmsRecv> sms_list;
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectLast5ByPort(cp.getPortnum());
                break;
            case "10010":
                sms_list = smsRecvMapper10010.selectLast5ByPort(cp.getPortnum());
                break;
            case "10086":
                sms_list = smsRecvMapper10086.selectLast5ByPort(cp.getPortnum());
                break;
            default:
                return null;
        }

        if (sms_list == null) {
            logger.info("手机号 {} 无短信", phoNum);
            return null;
        }

        return assembly_sms(sms_list);

    }


    /**
     * 返回最新收到的一条完整的短信。
     * <p>
     * 因为猫池缘故，会将一条短信切割开，因此需要聚合为一条完整的短信，否则短信验证码不确定会在哪条记录内；
     * 聚合方案：默认6s内的连续短信为同1条完整短信
     *
     * @param sms_list 待聚合的sms list，必须是数据库中按时间倒序的list
     * @return 最新收到的一条完整的短信
     */
    private SmsRecv assembly_sms(List<SmsRecv> sms_list) {
        if (sms_list == null) {
            return null;
        } else {
            if (sms_list.size() == 1) {
                return sms_list.get(0);
            } else {  //当有多条短信时，因为猫池缘故，会将一条短信切割开，需要聚合
                int duration = 20; //默认6s内的连续短信为同1条完整短信

                SmsRecv smsRecv1 = sms_list.get(0);
                String smsdate1 = smsRecv1.getSmsdate();
                StringBuilder sb1 = new StringBuilder(smsRecv1.getSmscontent());
                LocalDateTime time1 = LocalDateTime.parse(smsdate1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                for (int i = 1; i < sms_list.size(); i++) {
                    SmsRecv smsRecv_tmp = sms_list.get(i);
                    String smsdate_tmp = smsRecv_tmp.getSmsdate();
                    LocalDateTime time_tmp = LocalDateTime.parse(smsdate_tmp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                    //连续时间内的连续短信为同1条完整短信，将短信内容挨个组装到接收时间为最后的一条短信前面
                    if (time1.minusSeconds(duration).isBefore(time_tmp)) {
                        String sms_content = smsRecv_tmp.getSmscontent();
                        sb1.insert(0, sms_content);

                        //循环检查，连续2个短信间间隔在有效期内则持续拼接
                        time1 = LocalDateTime.parse(smsdate_tmp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    }
                }
                smsRecv1.setSmscontent(String.valueOf(sb1));
                return smsRecv1;
            }
        }
    }


    /**
     * 根据手机号获取5min内的最新的一条短信
     *
     * @param phoNum phoneNumber
     * @return smsContent
     */
    public SmsRecv get_sms_latest_in5min(String phoNum) {
        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return null;
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String beginData = LocalDateTime.now().minusMinutes(5).format(formatter);


        SmsRecvExample example = new SmsRecvExample();
        example.createCriteria().andPortnumEqualTo(cp.getPortnum())
                .andSmsdateGreaterThan(beginData);
        example.setOrderByClause("smsdate desc");

        List<SmsRecv> sms_list;
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectByExample(example);
                break;
            case "10010":
                sms_list = smsRecvMapper10010.selectByExample(example);
                break;
            case "10086":
                sms_list = smsRecvMapper10086.selectByExample(example);
                break;
            default:
                return null;
        }
        if (sms_list == null || sms_list.size() == 0) {
            logger.info("手机号 {} 在最近的5min内无短信", phoNum);
            return null;
        } else {
            return assembly_sms(sms_list);
        }
    }


    /**
     * 获取当前时间之后的第一条短信，持续1min后如果无短信则返回null： 每隔10s查询一次，可能有多条，拼接成一条短信返回
     * @param phoNum 手机号
     * @return SmsRecv or null
     */
    public SmsRecv get_sms_latest_afterNowUntil1min(String phoNum) {

        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return null;
        }

        // 查询的短信时间范围是：当前时间至1min之后，每隔10s查询一次，若有内容则直接返回，拼接成一条短信
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String beginData = LocalDateTime.now().format(formatter);
        String endData = LocalDateTime.now().plusMinutes(1).format(formatter);

        SmsRecvExample example = new SmsRecvExample();
        example.createCriteria().andPortnumEqualTo(cp.getPortnum())
                .andSmsdateGreaterThan(beginData).andSmsdateLessThan(endData);
        example.setOrderByClause("smsdate desc");

        int c = 0;
        List<SmsRecv> sms_list;
        do {
            c++;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (cp.getType()) {
                case "10000":
                    sms_list = smsRecvMapper10000.selectByExample(example);
                    break;
                case "10010":
                    sms_list = smsRecvMapper10010.selectByExample(example);
                    break;
                case "10086":
                    sms_list = smsRecvMapper10086.selectByExample(example);
                    break;
                default:
                    return null;
            }
            if (sms_list == null || sms_list.size() == 0) {
                logger.info("手机号 {} 在最近的10s内无短信, 第 {} 次查询", phoNum, c);
            } else {
                return assembly_sms(sms_list);
            }
        }while (c<6);

        return null;
    }


    /**
     * 根据手机号码，查询所有短信
     *
     * @param phoNum phoneNumber
     * @return sms list
     */
    public List<SmsRecv> get_sms_all(String phoNum) {
        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return null;
        }
        List<SmsRecv> sms_list;
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectByPort(cp.getPortnum());
                break;
            case "10010":
                sms_list = smsRecvMapper10010.selectByPort(cp.getPortnum());
                break;
            case "10086":
                sms_list = smsRecvMapper10086.selectByPort(cp.getPortnum());
                break;
            default:
                return null;
        }
        if (sms_list == null || sms_list.size() == 0) {
            logger.info("手机号 {} 无短信", phoNum);
            return null;
        } else {
            return sms_list;
        }
    }


    /**
     * 获取最新5条短信
     *
     * @param phoNum phoneNumber
     * @return sms list
     */
    public List<SmsRecv> get_sms_last5(String phoNum) {
        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return null;
        }
        List<SmsRecv> sms_list;
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectLast5ByPort(cp.getPortnum());
                break;
            case "10010":
                sms_list = smsRecvMapper10010.selectLast5ByPort(cp.getPortnum());
                break;
            case "10086":
                sms_list = smsRecvMapper10086.selectLast5ByPort(cp.getPortnum());
                break;
            default:
                return null;
        }
        if (sms_list == null || sms_list.size() == 0) {
            logger.info("手机号 {} 无短信", phoNum);
            return null;
        } else {
            return sms_list;
        }
    }


    /**
     * 插入短信，手动配置 发送方号码、接收方号码，及短信内容
     *
     * @param fromPhoNum 发送方号码
     * @param toPhoNum   接收方号码
     * @param text       短信内容
     * @return boolean，成功true，失败false
     */
    public JSONObject send_sms(String fromPhoNum, String toPhoNum, String text) {
        JSONObject result = new JSONObject();

        CardPosition cp = cardPositionMapper.selectByPhoNum(fromPhoNum);
        if (cp == null ) {
            String msg=String.format("手机号 %s 非猫池中的手机号，请检查！",fromPhoNum);
            logger.info(msg);
            result.put("result",false);
            result.put("msg", msg);
            return result;
        }
        if(cp.getPortnum() == null || cp.getPortnum() == 0){
            String msg=String.format("手机号 %s 在猫池中的无可用端口，请检查！",fromPhoNum);
            logger.info(msg);
            result.put("result",false);
            result.put("msg", msg);
            return result;
        }

        SmsSend smsSend = new SmsSend();
        smsSend.setPortnum(cp.getPortnum());
        smsSend.setSmsnumber(toPhoNum);
        smsSend.setSmscontent(text);
        smsSend.setSmssubject("Auto Test SMS Subject");
        smsSend.setSmstype(0);
        smsSend.setSmsstate(0);

        int res = 0;
        switch (cp.getType()) {
            case "10000":
                res = smsSendMapper10000.insert(smsSend);
                break;
            case "10010":
                res = smsSendMapper10010.insert(smsSend);
                break;
            case "10086":
                res = smsSendMapper10086.insert(smsSend);
                break;
            default:
                result.put("result",false);
                result.put("msg", "未知卡类型");
                break;
        }
        if(res > 0) {
            result.put("result",true);
            result.put("msg", "短信发送任务提交成功, 影响条数："+res);
        }else {
            result.put("result",false);
            result.put("msg", "短信发送任务提交失败, 影响条数："+res);
        }
        return result;
    }
}
