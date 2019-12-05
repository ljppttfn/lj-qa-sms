package cn.fudata.qa.sms.service;

import cn.fudata.qa.sms.dao.mapper.spcard10000.CardPositionMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard10010.CardPositionMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10086.CardPositionMapper10086;
import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.CardPositionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lj.yl
 * date 2019/12/5
 * desc 将3套库的操作集中到一个文件
 */
@Service
public class CardPositionService {

    private final
    CardPositionMapper10000 cardPositionMapper10000;

    private final
    CardPositionMapper10010 cardPositionMapper10010;

    private final
    CardPositionMapper10086 cardPositionMapper10086;

    @Autowired
    public CardPositionService(CardPositionMapper10000 cardPositionMapper10000, CardPositionMapper10010 cardPositionMapper10010, CardPositionMapper10086 cardPositionMapper10086) {
        this.cardPositionMapper10000 = cardPositionMapper10000;
        this.cardPositionMapper10010 = cardPositionMapper10010;
        this.cardPositionMapper10086 = cardPositionMapper10086;
    }

    public List<CardPosition> selectByExample(CardPositionExample example){
        List<CardPosition> res = new ArrayList<>();

        List<CardPosition> res_10000 = cardPositionMapper10000.selectByExample(example);
        List<CardPosition> res_10010 = cardPositionMapper10010.selectByExample(example);
        List<CardPosition> res_10086 = cardPositionMapper10086.selectByExample(example);

        res.addAll(res_10000);
        res.addAll(res_10010);
        res.addAll(res_10086);

        return res;
    }

    public CardPosition selectByPhoNum(String phoNum){
        CardPosition cp;

        cp = cardPositionMapper10000.selectByPhoNum(phoNum);
        if(cp != null){
            return cp;
        }
        cp = cardPositionMapper10010.selectByPhoNum(phoNum);
        if(cp != null){
            return cp;
        }
        cp = cardPositionMapper10086.selectByPhoNum(phoNum);
        if(cp != null){
            return cp;
        }
        return null;
    }

    public void updateByPrimaryKey(CardPosition cardPosition, PhoneNumberType type){
        switch (type){
            case CARD10000:
                cardPositionMapper10000.updateByPrimaryKey(cardPosition);
                break;
            case CARD10010:
                cardPositionMapper10010.updateByPrimaryKey(cardPosition);
                break;
            case CARD10086:
                cardPositionMapper10086.updateByPrimaryKey(cardPosition);
                break;
        }
    }
}
