package cn.fudata.qa.sms.dao.spcard10086.model;

public class SmsRecv {
    private Integer id;

    private Integer portnum;

    private String phonum;

    private String imsi;

    private String iccid;

    private String smsdate;

    private String smsnumber;

    private String smscontent;

    public SmsRecv(Integer id, Integer portnum, String phonum, String imsi, String iccid, String smsdate, String smsnumber, String smscontent) {
        this.id = id;
        this.portnum = portnum;
        this.phonum = phonum;
        this.imsi = imsi;
        this.iccid = iccid;
        this.smsdate = smsdate;
        this.smsnumber = smsnumber;
        this.smscontent = smscontent;
    }

    public SmsRecv() {
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

    public String getPhonum() {
        return phonum;
    }

    public void setPhonum(String phonum) {
        this.phonum = phonum == null ? null : phonum.trim();
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid == null ? null : iccid.trim();
    }

    public String getSmsdate() {
        return smsdate;
    }

    public void setSmsdate(String smsdate) {
        this.smsdate = smsdate == null ? null : smsdate.trim();
    }

    public String getSmsnumber() {
        return smsnumber;
    }

    public void setSmsnumber(String smsnumber) {
        this.smsnumber = smsnumber == null ? null : smsnumber.trim();
    }

    public String getSmscontent() {
        return smscontent;
    }

    public void setSmscontent(String smscontent) {
        this.smscontent = smscontent == null ? null : smscontent.trim();
    }
}