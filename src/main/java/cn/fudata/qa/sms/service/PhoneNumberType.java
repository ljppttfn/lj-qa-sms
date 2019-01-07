package cn.fudata.qa.sms.service;

/**
 * @author youlong
 * date 2019/1/7
 */
public enum PhoneNumberType {
    CARD10010("10010", "联通"),
    CARD10086("10086", "移动"),
    CARD10000("10000", "电信");

    String code;
    String desc;

    PhoneNumberType(String code, String desc){
        this.code=code;
        this.desc=desc;
    }
}
