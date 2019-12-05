package cn.fudata.qa.sms.service;

import cn.fudata.qa.sms.dao.mapper.spcard10000.PortInfoMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard10010.PortInfoMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10086.PortInfoMapper10086;
import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.PortInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youlong
 * date 2019/1/29
 */

@Service
public class ManagerService {

    private final
    CardPositionService cardPositionService;

    private final
    PortInfoMapper10010 portInfoMapper10010;

    private final
    PortInfoMapper10000 portInfoMapper10000;

    private final
    PortInfoMapper10086 portInfoMapper10086;

    private final
    PhoneNumberService phoneNumberService;

    @Autowired
    public ManagerService(CardPositionService cardPositionService, PortInfoMapper10010 portInfoMapper10010, PortInfoMapper10000 portInfoMapper10000, PortInfoMapper10086 portInfoMapper10086, PhoneNumberService phoneNumberService) {
        this.cardPositionService = cardPositionService;
        this.portInfoMapper10010 = portInfoMapper10010;
        this.portInfoMapper10000 = portInfoMapper10000;
        this.portInfoMapper10086 = portInfoMapper10086;
        this.phoneNumberService = phoneNumberService;
    }


    private void init_portNumAndPhoNum(PhoneNumberType type){
        List<CardPosition> cp_list = phoneNumberService.get_all_phone_by_type(type);
        for(CardPosition cardPosition: cp_list){
            String phoneNum = cardPosition.getPhonum();

            //根据手机号从 PortInfo 表中读取端口号、IMSI、ICCID等信息并更新
            PortInfo portInfo = null;
            switch (type){
                case CARD10000:
                    portInfo = portInfoMapper10000.selectByPhoNum(phoneNum);
                    break;
                case CARD10010:
                    portInfo = portInfoMapper10010.selectByPhoNum(phoneNum);
                    break;
                case CARD10086:
                    portInfo = portInfoMapper10086.selectByPhoNum(phoneNum);
                    break;
            }

            if(portInfo != null){
                cardPosition.setPortnum(portInfo.getPortnum());
                cardPosition.setIccid(portInfo.getIccid());
                cardPosition.setImsi(portInfo.getImsi());


            } else {
                cardPosition.setPortnum(0);
                cardPosition.setIccid("");
                cardPosition.setImsi("");
            }
            cardPositionService.updateByPrimaryKey(cardPosition, type);
        }
    }

    public void init_all_cardPositionPortNum(){
        init_portNumAndPhoNum(PhoneNumberType.CARD10000);
        init_portNumAndPhoNum(PhoneNumberType.CARD10010);
        init_portNumAndPhoNum(PhoneNumberType.CARD10086);
    }
}
