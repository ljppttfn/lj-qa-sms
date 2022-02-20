package lj.qa.sms.model;


import lombok.Data;

/**
 * @author lj
 * date 2019/1/8
 */
@Data
public class SmsSendRequestVo {
    private String from;
    private String to;
    private String text;
}
