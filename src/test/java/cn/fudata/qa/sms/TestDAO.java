package cn.fudata.qa.sms;


import cn.fudata.qa.sms.dao.mapper.spcard10000.PortInfoMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard10010.CardPositionMapper;
import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsRecvMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsRecvMapper10086;
import cn.fudata.qa.sms.dao.model.*;
import cn.fudata.qa.sms.service.ManagerService;
import cn.fudata.qa.sms.service.SMSService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
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


    @Autowired
    PortInfoMapper10000 portInfoMapper10000;

    @Test
    public void test_card(){
        CardPositionExample ex_card = new CardPositionExample();
        ex_card.createCriteria().andTypeEqualTo("10000").andPortnumGreaterThan(0);

        List<CardPosition> list_card = cardPositionMapper.selectByExample(ex_card);
        System.out.println(" card_postion size:  "+list_card.size());

        PortInfoExample portInfoExample = new PortInfoExample();
        portInfoExample.createCriteria();
        List<PortInfo> list_port = portInfoMapper10000.selectByExample(portInfoExample);
        System.out.println("list_port: "+list_port.size());

        List<String> list_phone_card = new ArrayList<>();
        for(CardPosition cardPosition: list_card){
            list_phone_card.add(cardPosition.getPhonum());
        }

        for(PortInfo portInfo: list_port){
            String phone = portInfo.getPhonum();
            if(!list_phone_card.contains(phone)){
                System.out.println(">>>>> 不包含的phone："+phone);
            }
        }
    }
}
