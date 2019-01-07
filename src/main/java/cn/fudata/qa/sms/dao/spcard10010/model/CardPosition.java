package cn.fudata.qa.sms.dao.spcard10010.model;

public class CardPosition {
    private Integer id;

    private String phonum;

    private String pwd;

    private String idcard;

    private String name;

    private String type;

    private Integer poolid;

    private Integer portnum;

    private Integer fee;

    private String desc;

    public CardPosition(Integer id, String phonum, String pwd, String idcard, String name, String type, Integer poolid, Integer portnum, Integer fee, String desc) {
        this.id = id;
        this.phonum = phonum;
        this.pwd = pwd;
        this.idcard = idcard;
        this.name = name;
        this.type = type;
        this.poolid = poolid;
        this.portnum = portnum;
        this.fee = fee;
        this.desc = desc;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}