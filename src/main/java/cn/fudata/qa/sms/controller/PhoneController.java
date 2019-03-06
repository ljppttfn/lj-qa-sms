package cn.fudata.qa.sms.controller;

import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.service.PhoneNumberService;
import cn.fudata.qa.sms.service.PhoneNumberType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youlong
 * date 2019/1/8
 */
@Api(value = "/phone", tags = "手机卡号")
@RestController
@RequestMapping(value = "/phone")
public class PhoneController {
    @Autowired
    PhoneNumberService service;

    @ApiOperation(value = "获取猫池中的所有手机卡号")
    @GetMapping(value = "/getAll")
    public List<CardPosition> get_all_phone() {
        return service.get_phone_all();
    }


    @ApiOperation(value = "获取猫池中特定运营商类型下的所有手机卡号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "运营商类型代码", dataType = "String", paramType = "path", example = "10010,10000,10086", required = true),
            @ApiImplicitParam(name = "province", value = "省份名称", dataType = "String", paramType = "query", example = "浙江")
    })
    @GetMapping(value = "/getByType/{type}")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public List<CardPosition> get_phone_by_type(@PathVariable("type") String type,
                                                @RequestParam(value = "province", required = false) String province) {
        for (PhoneNumberType t : PhoneNumberType.values()) {
            if (t.getCode().equals(type)) {
                if (province != null) {
                    return service.get_phone_by_type_and_province(t.getCode(), province);
                } else {
                    return service.get_phone_by_type(t);
                }
            }
        }

        return null;
    }


    @ApiOperation(value = "根据省份获取猫池中该省份下的所有手机卡号")
    @ApiImplicitParam(name = "province", value = "省份名称", dataType = "String", paramType = "query", example = "浙江", required = true)
    @GetMapping(value = "/getByProvince")
    public List<CardPosition> get_phone_by_province(@RequestParam("province") String province) {
        return service.get_phone_by_province(province);
    }


    @ApiOperation(value = "获取手机号的详细信息，如密码等")
    @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "path", required = true)
    @GetMapping(value = "/getDetail/{phone}")
    public List<CardPosition> get_phone_detail(@PathVariable("phone") String phone){
        return service.get_phone_detail(phone);
    }

}
