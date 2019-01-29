package cn.fudata.qa.sms.service;

import cn.fudata.qa.sms.dao.mapper.spcard10000.PortInfoMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard10010.CardPositionMapper;
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
    CardPositionMapper cardPositionMapper;

    private final
    PortInfoMapper10010 portInfoMapper10010;

    private final
    PortInfoMapper10000 portInfoMapper10000;

    private final
    PortInfoMapper10086 portInfoMapper10086;

    private final
    PhoneNumberService phoneNumberService;

    @Autowired
    public ManagerService(CardPositionMapper cardPositionMapper, PortInfoMapper10010 portInfoMapper10010, PortInfoMapper10000 portInfoMapper10000, PortInfoMapper10086 portInfoMapper10086, PhoneNumberService phoneNumberService) {
        this.cardPositionMapper = cardPositionMapper;
        this.portInfoMapper10010 = portInfoMapper10010;
        this.portInfoMapper10000 = portInfoMapper10000;
        this.portInfoMapper10086 = portInfoMapper10086;
        this.phoneNumberService = phoneNumberService;
    }


    private void init_portNumAndPhoNum(PhoneNumberType type){
        List<CardPosition> cp_list = phoneNumberService.get_phone_by_type(type);
        for(CardPosition cardPosition: cp_list){
            String phoneNum = cardPosition.getPhonum();

            //原表中的端口号信息
            Integer portNum = cardPosition.getPortnum();

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

            //从猫池中获取的最新的端口号信息
            if(portInfo != null){
                portNum = portInfo.getPortnum();
            }

            if(portNum != null && portNum != 0){
                cardPosition.setPortnum(portNum);
                cardPositionMapper.updateByPrimaryKey(cardPosition);
            }
        }
    }

    public void init_all_cardPositionPortNum(){
        init_portNumAndPhoNum(PhoneNumberType.CARD10000);
        init_portNumAndPhoNum(PhoneNumberType.CARD10010);
        init_portNumAndPhoNum(PhoneNumberType.CARD10086);
    }
}
