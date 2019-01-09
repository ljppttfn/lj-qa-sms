package cn.fudata.qa.sms.service;

import cn.fudata.qa.sms.dao.mapper.spcard10000.SmsRecvMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard.CardPositionMapper;
import cn.fudata.qa.sms.dao.mapper.spcard10000.SmsSendMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsRecvMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsSendMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsSendMapper10086;
import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.SmsRecv;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsRecvMapper10086;
import cn.fudata.qa.sms.dao.model.SmsSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 根据手机号获取最新的一条短信
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
        SmsRecv sms_list;
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectLatestByPort(cp.getPortnum());
                break;
            case "10010":
                sms_list = smsRecvMapper10010.selectLatestByPort(cp.getPortnum());
                break;
            case "10086":
                sms_list = smsRecvMapper10086.selectLatestByPort(cp.getPortnum());
                break;
            default:
                return null;
        }
        if (sms_list == null) {
            logger.info("手机号 {} 无短信", phoNum);
            return null;
        } else {
            return sms_list;
        }
    }


    /**
     * 根据手机号码，查询所有短信
     * @param phoNum phoneNumber
     * @return sms list
     */
    public List<SmsRecv> get_sms_all(String phoNum){
        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return null;
        }
        List<SmsRecv> sms_list;
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectByPort(cp.getPortnum()) ;
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
     * @param phoNum phoneNumber
     * @return sms list
     */
    public List<SmsRecv> get_sms_last5(String phoNum){
        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", phoNum);
            return null;
        }
        List<SmsRecv> sms_list;
        switch (cp.getType()) {
            case "10000":
                sms_list = smsRecvMapper10000.selectLast5ByPort(cp.getPortnum()) ;
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
     * @param fromPhoNum 发送方号码
     * @param toPhoNum 接收方号码
     * @param text 短信内容
     * @return boolean，成功true，失败false
     */
    public boolean send_sms(String fromPhoNum,String toPhoNum, String text){
        CardPosition cp = cardPositionMapper.selectByPhoNum(fromPhoNum);
        if (cp == null) {
            logger.info("手机号 {} 非猫池中的手机号，请检查！", fromPhoNum);
            return false;
        }

        SmsSend smsSend=new SmsSend();
        smsSend.setPortnum(cp.getPortnum());
        smsSend.setSmsnumber(toPhoNum);
        smsSend.setSmscontent(text);
        smsSend.setSmssubject("Auto Test SMS Subject");
        smsSend.setSmstype(0);
        smsSend.setSmsstate(0);

        int res;
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
                return false;
        }
        return res > 0;
    }
}
