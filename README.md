# FuData 猫池SMS平台

管理猫池设备中的各卡：
- 通过Api 方式获取各短信
- 通过PC+软件方式 实现拨号及造流量

Swagger 接口地址：http://fudata-qa-sms.wodlee-qa.k2-test.fudata.info/swagger-ui.html


## 注意事项
1. 每套软件配备单独的mysql库
2. mysql采用Docker创建，未做数据备份，初始化sql脚本见 `doc` 目录

## 初始化猫池端口与卡对应关系：
1. 首先插卡，操作新酷卡软件，至每个端口号正确识别出卡号
    - 方式1：采用新酷卡提供的免费wap方式获取手机号，或收费短信方式获取；如默认识别的网络获取失败，尝试切换网络
    - 方式2：将历史保存的手机号和 imsi、iccid 对应关系导入新酷卡软件；每台主机桌面都已保存
2. 执行初始化接口： POST：  http://fudata-qa-sms.wodlee-qa.k2-test.fudata.info/manager/init

## 猫池环境
#### 1. 3台主机teamviewer连接方式：
猫池电脑账密， 3台都是：youlong /   密码


TeamView ID| PWD| Desc
---|---|---
1178170054 | 000000 | 联通PC
1172491085 | 000000 | 电信PC
1179307008 | 000000 | 移动pc

#### 2. 主机固定的三个ip：(没用到)
172.16.8.101-103   
255.255.255.0   
172.16.8.254   
192.168.4.189   
