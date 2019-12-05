package cn.fudata.qa.sms;


import cn.fudata.qa.sms.dao.mapper.spcard10000.CardPositionMapper10000;
import cn.fudata.qa.sms.dao.mapper.spcard10010.SmsRecvMapper10010;
import cn.fudata.qa.sms.dao.mapper.spcard10086.SmsRecvMapper10086;
import cn.fudata.qa.sms.dao.model.*;
import cn.fudata.qa.sms.service.*;
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

    @Autowired
    CardPositionMapper10000 cardPositionMapper10000;

    @Autowired
    CardPositionService cardPositionService;

    @Autowired
    SMSService smsService;

    @Autowired
    SmsRecvMapper10086 smsRecvMapper10086;

    @Autowired
    SmsRecvMapper10010 smsRecvMapper10010;

    @Autowired
    PhoneNumberService phoneNumberService;

    @Test
    public void test(){
        List<CardPosition> res = phoneNumberService.get_all_phone_by_type(PhoneNumberType.CARD10000);
        System.out.println(res.size());

        CardPositionExample example = new CardPositionExample();
        example.createCriteria()
                .andTypeEqualTo("10000");
        List<CardPosition> res2 = cardPositionMapper10000.selectByExample(example);
        System.out.println(res2.size());
    }


    @Test
    public void test2(){
        CardPosition res = cardPositionService.selectByPhoNum("13394774451");
        System.out.println(res.getProvince());

        CardPosition res2 = cardPositionService.selectByPhoNum("15061230248");
        System.out.println(res2.getProvince());

        CardPosition res3 = cardPositionService.selectByPhoNum("15601002797");
        System.out.println(res3.getProvince());
    }


}
