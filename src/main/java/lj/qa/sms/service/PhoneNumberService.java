package lj.qa.sms.service;


import lj.qa.sms.dao.model.CardPosition;
import lj.qa.sms.dao.model.CardPositionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lj
 * date 2019/1/7
 */

@Service
public class PhoneNumberService {
//    private final CardPositionMapper cardPositionMapper;
    @Autowired
    CardPositionService cardPositionService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 根据手机号码，获取运营商类型, 如果不在数据库中，则返回空
     *
     * @param phoNum phoneNumber
     * @return PhoneNumberType
     */
    public PhoneNumberType phone_type(String phoNum) {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria().andPhonumEqualTo(phoNum);

        List<CardPosition> list = cardPositionService.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        } else {
            CardPosition card = list.get(0);
            String card_type = card.getType();
            for (PhoneNumberType type : PhoneNumberType.values()) {
                if (type.getCode().equals(card_type)) {
                    return type;
                }
            }
        }
        return null;
    }


    public CardPosition get_cardPos_by_phone(String phoNum) {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria().andPhonumEqualTo(phoNum);
        try {
            List<CardPosition> list = cardPositionService.selectByExample(example);
            return list.get(0);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }


    public List<CardPosition> get_phone_all() {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria().andPortnumGreaterThan(0);
        return cardPositionService.selectByExample(example);
    }

    /**
     * 根据运营商类型获取该类型下的所有卡信息,仅返回猫池中的卡
     *
     * @param type 运营商类型，枚举类 PhoneNumberType
     * @return list
     */
    public List<CardPosition> get_phone_by_type(PhoneNumberType type) {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria()
                .andTypeEqualTo(type.getCode())
                .andPortnumGreaterThan(0);
        return cardPositionService.selectByExample(example);
    }

    /**
     * 根据运营商类型获取该类型下的所有卡信息
     *
     * @param type 运营商类型，枚举类 PhoneNumberType
     * @return list
     */
    public List<CardPosition> get_all_phone_by_type(PhoneNumberType type) {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria()
                .andTypeEqualTo(type.getCode());
        return cardPositionService.selectByExample(example);
    }


    public List<CardPosition> get_phone_by_province(String province) {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria()
                .andProvinceEqualTo(province)
                .andPortnumGreaterThan(0);
        return cardPositionService.selectByExample(example);
    }

    public List<CardPosition> get_phone_by_type_and_province(String type, String province) {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria()
                .andTypeEqualTo(type)
                .andProvinceEqualTo(province)
                .andPortnumGreaterThan(0);
        return cardPositionService.selectByExample(example);
    }

    public List<CardPosition> get_phone_detail(String phoNum) {
        CardPositionExample example = new CardPositionExample();
        example.createCriteria().andPhonumEqualTo(phoNum);
        return cardPositionService.selectByExample(example);
    }


}
