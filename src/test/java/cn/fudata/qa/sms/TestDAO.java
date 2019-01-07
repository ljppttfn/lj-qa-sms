package cn.fudata.qa.sms;

import cn.fudata.qa.sms.dao.spcard10010.mapper.CardPositionMapper;
import cn.fudata.qa.sms.dao.spcard10010.model.CardPosition;
import cn.fudata.qa.sms.dao.spcard10010.model.CardPositionExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author youlong
 * date 2019/1/7
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDAO {
    @Resource
    CardPositionMapper mapper;

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
}
