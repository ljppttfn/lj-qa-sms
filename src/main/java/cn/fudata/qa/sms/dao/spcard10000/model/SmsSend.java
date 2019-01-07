package cn.fudata.qa.sms.dao.spcard10000.model;

public class SmsSend {
    private Integer id;

    private Integer portnum;

    private String smsnumber;

    private String smssubject;

    private String smscontent;

    private Integer smstype;

    private String phonum;

    private Integer smsstate;

    public SmsSend(Integer id, Integer portnum, String smsnumber, String smssubject, String smscontent, Integer smstype, String phonum, Integer smsstate) {
        this.id = id;
        this.portnum = portnum;
        this.smsnumber = smsnumber;
        this.smssubject = smssubject;
        this.smscontent = smscontent;
        this.smstype = smstype;
        this.phonum = phonum;
        this.smsstate = smsstate;
    }

    public SmsSend() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPortnum() {
        return portnum;
    }

    public void setPortnum(Integer portnum) {
        this.portnum = portnum;
    }

    public String getSmsnumber() {
        return smsnumber;
    }

    public void setSmsnumber(String smsnumber) {
        this.smsnumber = smsnumber == null ? null : smsnumber.trim();
    }

    public String getSmssubject() {
        return smssubject;
    }

    public void setSmssubject(String smssubject) {
        this.smssubject = smssubject == null ? null : smssubject.trim();
    }

    public String getSmscontent() {
        return smscontent;
    }

    public void setSmscontent(String smscontent) {
        this.smscontent = smscontent == null ? null : smscontent.trim();
    }

    public Integer getSmstype() {
        return smstype;
    }

    public void setSmstype(Integer smstype) {
        this.smstype = smstype;
    }

    public String getPhonum() {
        return phonum;
    }

    public void setPhonum(String phonum) {
        this.phonum = phonum == null ? null : phonum.trim();
    }

    public Integer getSmsstate() {
        return smsstate;
    }

    public void setSmsstate(Integer smsstate) {
        this.smsstate = smsstate;
    }
}