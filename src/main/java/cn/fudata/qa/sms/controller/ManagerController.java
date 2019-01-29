package cn.fudata.qa.sms.controller;


import cn.fudata.qa.sms.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youlong
 * date 2019/1/29
 */
@Api(value = "/manager", tags = "猫池操作")
@RestController
@RequestMapping(value = "/manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @ApiOperation(value = "初始化猫池端口号和手机号对应关系")
    @PostMapping(value = "/init")
    public boolean init(){
        try {
            managerService.init_all_cardPositionPortNum();
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
