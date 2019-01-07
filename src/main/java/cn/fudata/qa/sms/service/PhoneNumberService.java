package cn.fudata.qa.sms.service;

import cn.fudata.qa.sms.dao.mapper.spcard.CardPositionMapper;
import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.CardPositionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youlong
 * date 2019/1/7
 */

@Service
public class PhoneNumberService {
//    private final CardPositionMapper cardPositionMapper;
//
//    @Autowired
//    public PhoneNumberService(CardPositionMapper cardPositionMapper) {
//        this.cardPositionMapper = cardPositionMapper;
//    }

    @Autowired
    CardPositionMapper cardPositionMapper;

    /**
     * 根据手机号码，获取运营商类型, 如果不在数据库中，则返回空
     * @param phoNum phoneNumber
     * @return PhoneNumberType
     */
    public PhoneNumberType phone_type(String phoNum){
        CardPositionExample example = new CardPositionExample();
        example.createCriteria().andPhonumEqualTo(phoNum);

        List<CardPosition> list = cardPositionMapper.selectByExample(example);
        if(list == null || list.size() == 0){
            return null;
        }else {
            CardPosition card = list.get(0);
            String card_type = card.getType();
            for(PhoneNumberType type:PhoneNumberType.values()){
                if(type.code.equals(card_type)){
                    return type;
                }
            }
        }
        return null;
    }


    public void phone_all(){

    }

    public void phone_10000(){

    }

    public void phone_10010(){

    }

    public void phone_10086(){

    }
}
