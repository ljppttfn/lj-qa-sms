package lj.qa.sms.dao.model;

public class CardPosition {
    private Integer id;

    private String phonum;

    private String pwd;

    private String idcard;

    private String realname;

    private String type;

    private String province;

    private String city;

    private Integer poolid;

    private Integer portnum;

    private Integer fee;

    private String imsi;

    private String iccid;

    private String msg;

    public CardPosition(Integer id, String phonum, String pwd, String idcard, String realname, String type, String province, String city, Integer poolid, Integer portnum, Integer fee, String imsi, String iccid, String msg) {
        this.id = id;
        this.phonum = phonum;
        this.pwd = pwd;
        this.idcard = idcard;
        this.realname = realname;
        this.type = type;
        this.province = province;
        this.city = city;
        this.poolid = poolid;
        this.portnum = portnum;
        this.fee = fee;
        this.imsi = imsi;
        this.iccid = iccid;
        this.msg = msg;
    }

    public CardPosition() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonum() {
        return phonum;
    }

    public void setPhonum(String phonum) {
        this.phonum = phonum == null ? null : phonum.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getPoolid() {
        return poolid;
    }

    public void setPoolid(Integer poolid) {
        this.poolid = poolid;
    }

    public Integer getPortnum() {
        return portnum;
    }

    public void setPortnum(Integer portnum) {
        this.portnum = portnum;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}