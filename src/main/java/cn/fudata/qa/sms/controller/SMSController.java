package cn.fudata.qa.sms.controller;

import cn.fudata.qa.sms.dao.model.SmsRecv;
import cn.fudata.qa.sms.model.SmsSendRequestVo;
import cn.fudata.qa.sms.service.SMSService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author youlong
 * date 2019/1/3
 */

@Api(value = "/sms", tags = "短信操作")
@RestController
@RequestMapping(value = "/sms")
public class SMSController {

    @Autowired
    SMSService smsService;

    @ApiOperation(value = "获取最新一条短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getLatest/{phoNum}")
    public SmsRecv get_latest_sms_by_phone(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_latest(phoNum);
    }

    @ApiOperation(value = "获取最新5条短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getLatest5/{phoNum}")
    public List<SmsRecv> get_last5_sms_by_phone(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_last5(phoNum);
    }

    @ApiOperation(value = "获取所有短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getAll/{phoNum}")
    public List<SmsRecv> get_all_sms_by_phone(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_all(phoNum);
    }

    /**
     * 这种方式仅支持请求头的 Content-Type = application/json；
     * 但未找到正确的方式支持这种方式在swagger定义： 参数为Map
     *
     * @param body json格式
     * @return boolean
     */
    @ApiOperation(value = "发送短信-测试3")
    @PostMapping(value = "/send3")
    public boolean send3(@RequestBody Map<String, Object> body) {
        String fromPhoNum = body.get("from").toString();
        String toPhoNum = body.get("to").toString();
        String text = body.get("text").toString();
        return smsService.send_sms(fromPhoNum, toPhoNum, text);
    }

    /**
     * 这种方式支持请求头 Content-Type: application/x-www-form-urlencoded  及默认请求头
     *
     * @param from fromPhoneNumber
     * @param to   toPhoneNumber
     * @param text smsText
     * @return boolean
     */
    @ApiOperation(value = "发送短信-测试2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "from", value = "短信发送方号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "to", value = "短信接收方号码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "短信内容", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping(value = "/send2")
    public boolean send2(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("text") String text) {
        return smsService.send_sms(from, to, text);
    }

    /**
     * 这种方式仅支持请求头的 Content-Type = application/json
     * @param smsSendRequestVo body对象
     * @return boolean
     */
    @ApiOperation(value = "发送短信", produces="application/json")
    @ApiImplicitParam(name = "smsSendRequestVo", value = "短信发送对象", required = true, dataType = "SmsSendRequestVo")
    @PostMapping(value = "/send")
    public boolean send(@RequestBody SmsSendRequestVo smsSendRequestVo) {
        String fromPhoNum = smsSendRequestVo.getFrom();
        String toPhoNum = smsSendRequestVo.getTo();
        String text = smsSendRequestVo.getText();
        return smsService.send_sms(fromPhoNum, toPhoNum, text);
    }

}
