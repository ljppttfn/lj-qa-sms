package lj.qa.sms.controller;

import lj.qa.sms.dao.model.SmsRecv;
import lj.qa.sms.model.SmsSendRequestVo;
import lj.qa.sms.service.SMSService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lj
 * date 2019/1/3
 */

@Api(value = "/sms", tags = "短信操作")
@RestController
@RequestMapping(value = "/sms")
public class SMSController {

    @Autowired
    SMSService smsService;

    @ApiOperation(value = "获取当前时间之后的第一条短信，持续1min后如果无短信则返回null，每隔10s查询一次，若有内容则直接返回，多条则拼接成一条短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getLatestAfterNowUntil1min/{phoNum}")
    public SmsRecv get_sms_latest_afterNowUntil1min(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_latest_afterNowUntil1min(phoNum);
    }

    @ApiOperation(value = "获取之前最新一条完整的短信：猫池可能拆分一条短信，此处返回聚合后的完整短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getLatest/{phoNum}")
    public SmsRecv get_latest_sms_by_phone(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_latest(phoNum);
    }

    @ApiOperation(value = "获取给定时间之后的所有短信(不包含所给的时间)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "time", value = "开始时间,毫秒", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "/getLatest/{phoNum}/{time}")
    public List<SmsRecv> get_sms_by_phone_time(@PathVariable("phoNum") String phoNum, @PathVariable("time") String time) {
        return smsService.get_sms_by_phone_time(phoNum, Long.parseLong(time));
    }


    @ApiOperation(value = "获取之前5min内最新一条短信：猫池可能拆分一条短信，此处返回聚合后的完整短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getLatestIn5Min/{phoNum}")
    public SmsRecv get_latest_sms_by_phone_in5min(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_latest_in5min(phoNum);
    }

    @ApiOperation(value = "获取之前最新5条短信：不聚合短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getLatest5/{phoNum}")
    public List<SmsRecv> get_last5_sms_by_phone(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_last5(phoNum);
    }

    @ApiOperation(value = "获取之前所有短信：不聚合短信")
    @ApiImplicitParam(name = "phoNum", value = "手机号", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getAll/{phoNum}")
    public List<SmsRecv> get_all_sms_by_phone(@PathVariable("phoNum") String phoNum) {
        return smsService.get_sms_all(phoNum);
    }

//    /**
//     * 这种方式仅支持请求头的 Content-Type = application/json；
//     * 但未找到正确的方式支持这种方式在swagger定义： 参数为Map
//     *
//     * @param body json格式
//     * @return boolean
//     */
//    @ApiOperation(value = "发送短信-测试3")
//    @PostMapping(value = "/send3")
//    public JSONObject send3(@RequestBody Map<String, Object> body) {
//        String fromPhoNum = body.get("from").toString();
//        String toPhoNum = body.get("to").toString();
//        String text = body.get("text").toString();
//        return smsService.send_sms(fromPhoNum, toPhoNum, text);
//    }

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
    public JSONObject send2(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("text") String text) {
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
    public JSONObject send(@RequestBody SmsSendRequestVo smsSendRequestVo) {
        String fromPhoNum = smsSendRequestVo.getFrom();
        String toPhoNum = smsSendRequestVo.getTo();
        String text = smsSendRequestVo.getText();
        return smsService.send_sms(fromPhoNum, toPhoNum, text);
    }

}
