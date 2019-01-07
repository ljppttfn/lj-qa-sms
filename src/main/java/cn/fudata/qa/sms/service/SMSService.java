package cn.fudata.qa.sms.service;

import cn.fudata.qa.sms.dao.mapper.spcard10000.SmsRecvMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard.CardPositionMapper;
import cn.fudata.qa.sms.dao.mapper.spcard.SmsRecvMapper;
import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.SmsRecv;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsRecvMapper10086;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youlong
 * date 2019/1/7
 */
@Service
public class SMSService {

    @Autowired
    PhoneNumberService phoneNumberService;

    @Autowired
    CardPositionMapper cardPositionMapper;

    @Autowired
    SmsRecvMapper10000 smsRecvMapper10000;

    @Autowired
    SmsRecvMapper smsRecvMapper10010;

    @Autowired
    SmsRecvMapper10086 smsRecvMapper10086;

    /**
     * 根据手机号获取最新的一条短信
     *
     * @param phoNum phoneNumber
     * @return smsContent
     */
    public String get_sms_latest(String phoNum) {
        CardPosition cp = cardPositionMapper.selectByPhoNum(phoNum);
        if (cp == null) {
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
            return null;
        } else {
            return sms_list.get(0).getSmscontent();
        }
    }


}
