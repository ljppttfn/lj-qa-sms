package cn.fudata.qa.sms;


import cn.fudata.qa.sms.dao.mapper.spcard10010.CardPositionMapper;
import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsRecvMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsRecvMapper10086;
import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.CardPositionExample;
import cn.fudata.qa.sms.dao.model.SmsRecv;
import cn.fudata.qa.sms.service.SMSService;
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
    CardPositionMapper mapper;

    @Autowired
    SMSService smsService;

    @Autowired
    SmsRecvMapper10086 smsRecvMapper10086;

    @Autowired
    SmsRecvMapper10010 smsRecvMapper10010;

    @Test
    public void test(){
        List<CardPosition> list = mapper.selectAll();
        System.out.println(list.size());
        for(CardPosition cp: list){
            System.out.println(cp.getPhonum()+"  "+cp.getPwd() + " "+cp.getType());
        }
    }


    @Test
    public void test2(){
        CardPositionExample example = new CardPositionExample();
        example.createCriteria().andIdLessThan(100);
        List<CardPosition> list = mapper.selectByExample(example);
        for(CardPosition cp: list){
            System.out.println(cp.getPhonum()+"  "+cp.getPwd() + " "+cp.getType());
        }
    }

    @Test
    public void test_get_sms(){
        String ctx = smsService.get_sms_latest("13244711160");
        System.out.println(ctx);
    }

    @Test
    public void test_3(){
        SmsRecv res = smsRecvMapper10086.selectByPrimaryKey(1);
        System.out.println(res);

        SmsRecv res2 = smsRecvMapper10010.selectByPrimaryKey(1);
        System.out.println(res2);
    }
}
