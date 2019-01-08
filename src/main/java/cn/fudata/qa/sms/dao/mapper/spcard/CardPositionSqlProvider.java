package cn.fudata.qa.sms.dao.mapper.spcard;

import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.CardPositionExample.Criteria;
import cn.fudata.qa.sms.dao.model.CardPositionExample.Criterion;
import cn.fudata.qa.sms.dao.model.CardPositionExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CardPositionSqlProvider {

    public String countByExample(CardPositionExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("card_position");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CardPositionExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("card_position");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CardPosition record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("card_position");
        
        if (record.getPhonum() != null) {
            sql.VALUES("PhoNum", "#{phonum,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("Pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            sql.VALUES("IdCard", "#{idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getRealname() != null) {
            sql.VALUES("RealName", "#{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("Type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getPoolid() != null) {
            sql.VALUES("PoolID", "#{poolid,jdbcType=INTEGER}");
        }
        
        if (record.getPortnum() != null) {
            sql.VALUES("PortNum", "#{portnum,jdbcType=INTEGER}");
        }
        
        if (record.getFee() != null) {
            sql.VALUES("Fee", "#{fee,jdbcType=INTEGER}");
        }
        
        if (record.getMsg() != null) {
            sql.VALUES("Msg", "#{msg,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.VALUES("Province", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.VALUES("City", "#{city,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CardPositionExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("Id");
        } else {
            sql.SELECT("Id");
        }
        sql.SELECT("PhoNum");
        sql.SELECT("Pwd");
        sql.SELECT("IdCard");
        sql.SELECT("RealName");
        sql.SELECT("Type");
        sql.SELECT("PoolID");
        sql.SELECT("PortNum");
        sql.SELECT("Fee");
        sql.SELECT("Msg");
        sql.SELECT("Province");
        sql.SELECT("City");
        sql.FROM("card_position");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CardPosition record = (CardPosition) parameter.get("record");
        CardPositionExample example = (CardPositionExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("card_position");
        
        if (record.getId() != null) {
            sql.SET("Id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPhonum() != null) {
            sql.SET("PhoNum = #{record.phonum,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("Pwd = #{record.pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            sql.SET("IdCard = #{record.idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getRealname() != null) {
            sql.SET("RealName = #{record.realname,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("Type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getPoolid() != null) {
            sql.SET("PoolID = #{record.poolid,jdbcType=INTEGER}");
        }
        
        if (record.getPortnum() != null) {
            sql.SET("PortNum = #{record.portnum,jdbcType=INTEGER}");
        }
        
        if (record.getFee() != null) {
            sql.SET("Fee = #{record.fee,jdbcType=INTEGER}");
        }
        
        if (record.getMsg() != null) {
            sql.SET("Msg = #{record.msg,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("Province = #{record.province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.SET("City = #{record.city,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("card_position");
        
        sql.SET("Id = #{record.id,jdbcType=INTEGER}");
        sql.SET("PhoNum = #{record.phonum,jdbcType=VARCHAR}");
        sql.SET("Pwd = #{record.pwd,jdbcType=VARCHAR}");
        sql.SET("IdCard = #{record.idcard,jdbcType=VARCHAR}");
        sql.SET("RealName = #{record.realname,jdbcType=VARCHAR}");
        sql.SET("Type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("PoolID = #{record.poolid,jdbcType=INTEGER}");
        sql.SET("PortNum = #{record.portnum,jdbcType=INTEGER}");
        sql.SET("Fee = #{record.fee,jdbcType=INTEGER}");
        sql.SET("Msg = #{record.msg,jdbcType=VARCHAR}");
        sql.SET("Province = #{record.province,jdbcType=VARCHAR}");
        sql.SET("City = #{record.city,jdbcType=VARCHAR}");
        
        CardPositionExample example = (CardPositionExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CardPosition record) {
        SQL sql = new SQL();
        sql.UPDATE("card_position");
        
        if (record.getPhonum() != null) {
            sql.SET("PhoNum = #{phonum,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("Pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getIdcard() != null) {
            sql.SET("IdCard = #{idcard,jdbcType=VARCHAR}");
        }
        
        if (record.getRealname() != null) {
            sql.SET("RealName = #{realname,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("Type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getPoolid() != null) {
            sql.SET("PoolID = #{poolid,jdbcType=INTEGER}");
        }
        
        if (record.getPortnum() != null) {
            sql.SET("PortNum = #{portnum,jdbcType=INTEGER}");
        }
        
        if (record.getFee() != null) {
            sql.SET("Fee = #{fee,jdbcType=INTEGER}");
        }
        
        if (record.getMsg() != null) {
            sql.SET("Msg = #{msg,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            sql.SET("Province = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.SET("City = #{city,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CardPositionExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}