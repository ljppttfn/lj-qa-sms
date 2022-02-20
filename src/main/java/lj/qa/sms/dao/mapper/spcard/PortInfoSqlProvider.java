package lj.qa.sms.dao.mapper.spcard;

import lj.qa.sms.dao.model.PortInfo;
import lj.qa.sms.dao.model.PortInfoExample.Criteria;
import lj.qa.sms.dao.model.PortInfoExample.Criterion;
import lj.qa.sms.dao.model.PortInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PortInfoSqlProvider {

    public String countByExample(PortInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("port_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PortInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("port_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PortInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("port_info");
        
        if (record.getPortnum() != null) {
            sql.VALUES("PortNum", "#{portnum,jdbcType=INTEGER}");
        }
        
        if (record.getImsi() != null) {
            sql.VALUES("IMSI", "#{imsi,jdbcType=VARCHAR}");
        }
        
        if (record.getIccid() != null) {
            sql.VALUES("ICCID", "#{iccid,jdbcType=VARCHAR}");
        }
        
        if (record.getPhonum() != null) {
            sql.VALUES("PhoNum", "#{phonum,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PortInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("Id");
        } else {
            sql.SELECT("Id");
        }
        sql.SELECT("PortNum");
        sql.SELECT("IMSI");
        sql.SELECT("ICCID");
        sql.SELECT("PhoNum");
        sql.FROM("port_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PortInfo record = (PortInfo) parameter.get("record");
        PortInfoExample example = (PortInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("port_info");
        
        if (record.getId() != null) {
            sql.SET("Id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPortnum() != null) {
            sql.SET("PortNum = #{record.portnum,jdbcType=INTEGER}");
        }
        
        if (record.getImsi() != null) {
            sql.SET("IMSI = #{record.imsi,jdbcType=VARCHAR}");
        }
        
        if (record.getIccid() != null) {
            sql.SET("ICCID = #{record.iccid,jdbcType=VARCHAR}");
        }
        
        if (record.getPhonum() != null) {
            sql.SET("PhoNum = #{record.phonum,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("port_info");
        
        sql.SET("Id = #{record.id,jdbcType=INTEGER}");
        sql.SET("PortNum = #{record.portnum,jdbcType=INTEGER}");
        sql.SET("IMSI = #{record.imsi,jdbcType=VARCHAR}");
        sql.SET("ICCID = #{record.iccid,jdbcType=VARCHAR}");
        sql.SET("PhoNum = #{record.phonum,jdbcType=VARCHAR}");
        
        PortInfoExample example = (PortInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PortInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("port_info");
        
        if (record.getPortnum() != null) {
            sql.SET("PortNum = #{portnum,jdbcType=INTEGER}");
        }
        
        if (record.getImsi() != null) {
            sql.SET("IMSI = #{imsi,jdbcType=VARCHAR}");
        }
        
        if (record.getIccid() != null) {
            sql.SET("ICCID = #{iccid,jdbcType=VARCHAR}");
        }
        
        if (record.getPhonum() != null) {
            sql.SET("PhoNum = #{phonum,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PortInfoExample example, boolean includeExamplePhrase) {
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