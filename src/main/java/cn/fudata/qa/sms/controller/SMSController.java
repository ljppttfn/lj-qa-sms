package cn.fudata.qa.sms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youlong
 * date 2019/1/3
 */
@RestController
@RequestMapping(value = "/sms")
public class SMSController {

    @RequestMapping(value = "/latest/{phone}")
    public String get_latest_sms_by_phone(@PathVariable("phone") String phone){
        String sms_content="";
        return sms_content;
    }
}
