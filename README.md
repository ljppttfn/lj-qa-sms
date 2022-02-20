# 猫池SMS平台
本系统为基于新酷卡猫池系统二次开发的猫池管理系统。
主要实现管理猫池设备中的各卡：
- 通过Api 方式获取各短信
- 通过PC+软件方式 实现拨号及造流量

Swagger 接口地址：http://lj-sms.info/swagger-ui.html


## 注意事项
1. 每套软件配备单独的mysql库（移动、联通、电信各一套设备）
2. mysql采用Docker创建，未做数据备份，初始化sql脚本见 `doc` 目录

## 初始化猫池端口与卡对应关系：
1. 首先插卡，操作新酷卡软件，至每个端口号正确识别出卡号
    - 方式1：采用新酷卡提供的免费wap方式获取手机号，或收费短信方式获取；如默认识别的网络获取失败，尝试切换网络
    - 方式2：将历史保存的手机号和 imsi、iccid 对应关系导入新酷卡软件；每台主机桌面都已保存
2. 执行初始化接口： POST：  http://lj-qa-sms.lj-qa.k2-test.lj.info/manager/init

## 初始化：
1. K2上新建3个mysql实例，分别对应 移动、联通、电信，并初始化每个mysql的用户权限：
```
1.mysql -uroot -proot
2.create database spcard;
3.grant all privileges on *.* to root@"%" identified by "root" ;
4.flush privileges ;
```
2. 分别进入各自数据库，执行 `doc/`目录下的 `spcard-init.sql`，创建表，并执行各自数据初始化脚本，如`card_position_init_10000.sql`
3. 修改oblisk上的配置文件，更新mysql配置，并打包重启
4. 分别通过teamviewer或者向日葵 软件，登录3台主机，更改mysql配置，并重启新酷卡软件
5. 执行初始化接口：`POST：  http://lj-qa-sms.lj-qa.k2-test.lj.info/manager/init`


## 猫池环境
#### 1. 3台Win10 PC机，分别做为移动、联通、电信3套设备的主机。

