package cn.fudata.qa.sms;


import cn.fudata.qa.sms.dao.mapper.spcard10010.CardPositionMapper;
import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsRecvMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsRecvMapper10086;
import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.CardPositionExample;
import cn.fudata.qa.sms.dao.model.SmsRecv;
import cn.fudata.qa.sms.service.ManagerService;
import cn.fudata.qa.sms.service.SMSService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author youlong
 * date 2019/1/7
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDAO {
//    @Resource
//    CardPositionMapper mapper;

    @Autowired
    CardPositionMapper cardPositionMapper;

    @Autowired
    SMSService smsService;

    @Autowired
    SmsRecvMapper10086 smsRecvMapper10086;

    @Autowired
    SmsRecvMapper10010 smsRecvMapper10010;

    @Test
    public void test(){
        CardPositionExample example = new CardPositionExample();
        example.createCriteria();
        List<CardPosition> list = cardPositionMapper.selectByExample(example);
        System.out.println(list.size());
        for(CardPosition cp: list){
            System.out.println(cp.getPhonum()+"  "+cp.getPwd() + " "+cp.getType());
        }
    }


    @Test
    public void test2(){
        CardPositionExample example = new CardPositionExample();
        example.createCriteria().andIdLessThan(100);
        List<CardPosition> list = cardPositionMapper.selectByExample(example);
        for(CardPosition cp: list){
            System.out.println(cp.getPhonum()+"  "+cp.getPwd() + " "+cp.getType());
        }
    }

    @Test
    public void test_get_sms(){
        SmsRecv ctx = smsService.get_sms_latest("15599446806");
        System.out.println(ctx.getSmscontent());
    }

    @Test
    public void test_3(){
        SmsRecv res = smsService.get_sms_latest_in5min("15511963903");
        System.out.println(JSON.toJSONString(res));
    }


    @Autowired
    ManagerService managerService;

    @Test
    public void test_card_init(){
        managerService.init_all_cardPositionPortNum();
    }
}
