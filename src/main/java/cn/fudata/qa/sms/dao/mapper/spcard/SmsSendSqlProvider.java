package cn.fudata.qa.sms.dao.mapper.spcard;

import cn.fudata.qa.sms.dao.model.SmsSend;
import cn.fudata.qa.sms.dao.model.SmsSendExample.Criteria;
import cn.fudata.qa.sms.dao.model.SmsSendExample.Criterion;
import cn.fudata.qa.sms.dao.model.SmsSendExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SmsSendSqlProvider {

    public String countByExample(SmsSendExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sms_send");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SmsSendExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sms_send");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SmsSend record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sms_send");
        
        if (record.getPortnum() != null) {
            sql.VALUES("PortNum", "#{portnum,jdbcType=INTEGER}");
        }
        
        if (record.getSmsnumber() != null) {
            sql.VALUES("smsNumber", "#{smsnumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSmssubject() != null) {
            sql.VALUES("smsSubject", "#{smssubject,jdbcType=VARCHAR}");
        }
        
        if (record.getSmscontent() != null) {
            sql.VALUES("smsContent", "#{smscontent,jdbcType=VARCHAR}");
        }
        
        if (record.getSmstype() != null) {
            sql.VALUES("smsType", "#{smstype,jdbcType=INTEGER}");
        }
        
        if (record.getPhonum() != null) {
            sql.VALUES("PhoNum", "#{phonum,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsstate() != null) {
            sql.VALUES("smsState", "#{smsstate,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SmsSendExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("Id");
        } else {
            sql.SELECT("Id");
        }
        sql.SELECT("PortNum");
        sql.SELECT("smsNumber");
        sql.SELECT("smsSubject");
        sql.SELECT("smsContent");
        sql.SELECT("smsType");
        sql.SELECT("PhoNum");
        sql.SELECT("smsState");
        sql.FROM("sms_send");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SmsSend record = (SmsSend) parameter.get("record");
        SmsSendExample example = (SmsSendExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sms_send");
        
        if (record.getId() != null) {
            sql.SET("Id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPortnum() != null) {
            sql.SET("PortNum = #{record.portnum,jdbcType=INTEGER}");
        }
        
        if (record.getSmsnumber() != null) {
            sql.SET("smsNumber = #{record.smsnumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSmssubject() != null) {
            sql.SET("smsSubject = #{record.smssubject,jdbcType=VARCHAR}");
        }
        
        if (record.getSmscontent() != null) {
            sql.SET("smsContent = #{record.smscontent,jdbcType=VARCHAR}");
        }
        
        if (record.getSmstype() != null) {
            sql.SET("smsType = #{record.smstype,jdbcType=INTEGER}");
        }
        
        if (record.getPhonum() != null) {
            sql.SET("PhoNum = #{record.phonum,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsstate() != null) {
            sql.SET("smsState = #{record.smsstate,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sms_send");
        
        sql.SET("Id = #{record.id,jdbcType=INTEGER}");
        sql.SET("PortNum = #{record.portnum,jdbcType=INTEGER}");
        sql.SET("smsNumber = #{record.smsnumber,jdbcType=VARCHAR}");
        sql.SET("smsSubject = #{record.smssubject,jdbcType=VARCHAR}");
        sql.SET("smsContent = #{record.smscontent,jdbcType=VARCHAR}");
        sql.SET("smsType = #{record.smstype,jdbcType=INTEGER}");
        sql.SET("PhoNum = #{record.phonum,jdbcType=VARCHAR}");
        sql.SET("smsState = #{record.smsstate,jdbcType=INTEGER}");
        
        SmsSendExample example = (SmsSendExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SmsSend record) {
        SQL sql = new SQL();
        sql.UPDATE("sms_send");
        
        if (record.getPortnum() != null) {
            sql.SET("PortNum = #{portnum,jdbcType=INTEGER}");
        }
        
        if (record.getSmsnumber() != null) {
            sql.SET("smsNumber = #{smsnumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSmssubject() != null) {
            sql.SET("smsSubject = #{smssubject,jdbcType=VARCHAR}");
        }
        
        if (record.getSmscontent() != null) {
            sql.SET("smsContent = #{smscontent,jdbcType=VARCHAR}");
        }
        
        if (record.getSmstype() != null) {
            sql.SET("smsType = #{smstype,jdbcType=INTEGER}");
        }
        
        if (record.getPhonum() != null) {
            sql.SET("PhoNum = #{phonum,jdbcType=VARCHAR}");
        }
        
        if (record.getSmsstate() != null) {
            sql.SET("smsState = #{smsstate,jdbcType=INTEGER}");
        }
        
        sql.WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SmsSendExample example, boolean includeExamplePhrase) {
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