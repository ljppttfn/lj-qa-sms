package cn.fudata.qa.sms;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author youlong
 * date 2019/3/2
 */
public class TestTmp {
    @Test
    public void test(){
//        Calendar cal = Calendar.getInstance();
//        cal.set(2020, 9,10,20,20,20);
//        Date d = cal.getTime();
////        Date d = new Date();
//        SimpleDateFormat f1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(f1.format(d));
//        System.out.println(f2.format(d));
//
//
//        LocalDateTime dateTime1 = LocalDateTime.of(2018, 10,10,20,20,20);
//        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
//        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        String sf1 = df1.format(dateTime1);
//        System.out.println(sf1);
//        System.out.println(df2.format(dateTime1));

        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());

        LocalDateTime time2 =LocalDateTime.ofEpochSecond(1556265338714l/1000,0,ZoneOffset.ofHours(8));
        System.out.println(time2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String beginData = time2.format(formatter);
        System.out.println(beginData);
    }
}
