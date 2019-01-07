package cn.fudata.qa.sms.dao.model;

public class PortInfo {
    private Integer id;

    private Integer portnum;

    private String imsi;

    private String iccid;

    private String phonum;

    public PortInfo(Integer id, Integer portnum, String imsi, String iccid, String phonum) {
        this.id = id;
        this.portnum = portnum;
        this.imsi = imsi;
        this.iccid = iccid;
        this.phonum = phonum;
    }

    public PortInfo() {
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

    public String getPhonum() {
        return phonum;
    }

    public void setPhonum(String phonum) {
        this.phonum = phonum == null ? null : phonum.trim();
    }
}