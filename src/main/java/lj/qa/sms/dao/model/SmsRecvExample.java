package lj.qa.sms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class SmsRecvExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsRecvExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPortnumIsNull() {
            addCriterion("PortNum is null");
            return (Criteria) this;
        }

        public Criteria andPortnumIsNotNull() {
            addCriterion("PortNum is not null");
            return (Criteria) this;
        }

        public Criteria andPortnumEqualTo(Integer value) {
            addCriterion("PortNum =", value, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumNotEqualTo(Integer value) {
            addCriterion("PortNum <>", value, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumGreaterThan(Integer value) {
            addCriterion("PortNum >", value, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PortNum >=", value, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumLessThan(Integer value) {
            addCriterion("PortNum <", value, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumLessThanOrEqualTo(Integer value) {
            addCriterion("PortNum <=", value, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumIn(List<Integer> values) {
            addCriterion("PortNum in", values, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumNotIn(List<Integer> values) {
            addCriterion("PortNum not in", values, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumBetween(Integer value1, Integer value2) {
            addCriterion("PortNum between", value1, value2, "portnum");
            return (Criteria) this;
        }

        public Criteria andPortnumNotBetween(Integer value1, Integer value2) {
            addCriterion("PortNum not between", value1, value2, "portnum");
            return (Criteria) this;
        }

        public Criteria andPhonumIsNull() {
            addCriterion("PhoNum is null");
            return (Criteria) this;
        }

        public Criteria andPhonumIsNotNull() {
            addCriterion("PhoNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonumEqualTo(String value) {
            addCriterion("PhoNum =", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotEqualTo(String value) {
            addCriterion("PhoNum <>", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumGreaterThan(String value) {
            addCriterion("PhoNum >", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumGreaterThanOrEqualTo(String value) {
            addCriterion("PhoNum >=", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumLessThan(String value) {
            addCriterion("PhoNum <", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumLessThanOrEqualTo(String value) {
            addCriterion("PhoNum <=", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumLike(String value) {
            addCriterion("PhoNum like", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotLike(String value) {
            addCriterion("PhoNum not like", value, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumIn(List<String> values) {
            addCriterion("PhoNum in", values, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotIn(List<String> values) {
            addCriterion("PhoNum not in", values, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumBetween(String value1, String value2) {
            addCriterion("PhoNum between", value1, value2, "phonum");
            return (Criteria) this;
        }

        public Criteria andPhonumNotBetween(String value1, String value2) {
            addCriterion("PhoNum not between", value1, value2, "phonum");
            return (Criteria) this;
        }

        public Criteria andImsiIsNull() {
            addCriterion("IMSI is null");
            return (Criteria) this;
        }

        public Criteria andImsiIsNotNull() {
            addCriterion("IMSI is not null");
            return (Criteria) this;
        }

        public Criteria andImsiEqualTo(String value) {
            addCriterion("IMSI =", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotEqualTo(String value) {
            addCriterion("IMSI <>", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThan(String value) {
            addCriterion("IMSI >", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThanOrEqualTo(String value) {
            addCriterion("IMSI >=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThan(String value) {
            addCriterion("IMSI <", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThanOrEqualTo(String value) {
            addCriterion("IMSI <=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLike(String value) {
            addCriterion("IMSI like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotLike(String value) {
            addCriterion("IMSI not like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiIn(List<String> values) {
            addCriterion("IMSI in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotIn(List<String> values) {
            addCriterion("IMSI not in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiBetween(String value1, String value2) {
            addCriterion("IMSI between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotBetween(String value1, String value2) {
            addCriterion("IMSI not between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andIccidIsNull() {
            addCriterion("ICCID is null");
            return (Criteria) this;
        }

        public Criteria andIccidIsNotNull() {
            addCriterion("ICCID is not null");
            return (Criteria) this;
        }

        public Criteria andIccidEqualTo(String value) {
            addCriterion("ICCID =", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotEqualTo(String value) {
            addCriterion("ICCID <>", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidGreaterThan(String value) {
            addCriterion("ICCID >", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidGreaterThanOrEqualTo(String value) {
            addCriterion("ICCID >=", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLessThan(String value) {
            addCriterion("ICCID <", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLessThanOrEqualTo(String value) {
            addCriterion("ICCID <=", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLike(String value) {
            addCriterion("ICCID like", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotLike(String value) {
            addCriterion("ICCID not like", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidIn(List<String> values) {
            addCriterion("ICCID in", values, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotIn(List<String> values) {
            addCriterion("ICCID not in", values, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidBetween(String value1, String value2) {
            addCriterion("ICCID between", value1, value2, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotBetween(String value1, String value2) {
            addCriterion("ICCID not between", value1, value2, "iccid");
            return (Criteria) this;
        }

        public Criteria andSmsdateIsNull() {
            addCriterion("smsDate is null");
            return (Criteria) this;
        }

        public Criteria andSmsdateIsNotNull() {
            addCriterion("smsDate is not null");
            return (Criteria) this;
        }

        public Criteria andSmsdateEqualTo(String value) {
            addCriterion("smsDate =", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateNotEqualTo(String value) {
            addCriterion("smsDate <>", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateGreaterThan(String value) {
            addCriterion("smsDate >", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateGreaterThanOrEqualTo(String value) {
            addCriterion("smsDate >=", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateLessThan(String value) {
            addCriterion("smsDate <", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateLessThanOrEqualTo(String value) {
            addCriterion("smsDate <=", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateLike(String value) {
            addCriterion("smsDate like", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateNotLike(String value) {
            addCriterion("smsDate not like", value, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateIn(List<String> values) {
            addCriterion("smsDate in", values, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateNotIn(List<String> values) {
            addCriterion("smsDate not in", values, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateBetween(String value1, String value2) {
            addCriterion("smsDate between", value1, value2, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsdateNotBetween(String value1, String value2) {
            addCriterion("smsDate not between", value1, value2, "smsdate");
            return (Criteria) this;
        }

        public Criteria andSmsnumberIsNull() {
            addCriterion("smsNumber is null");
            return (Criteria) this;
        }

        public Criteria andSmsnumberIsNotNull() {
            addCriterion("smsNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSmsnumberEqualTo(String value) {
            addCriterion("smsNumber =", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberNotEqualTo(String value) {
            addCriterion("smsNumber <>", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberGreaterThan(String value) {
            addCriterion("smsNumber >", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberGreaterThanOrEqualTo(String value) {
            addCriterion("smsNumber >=", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberLessThan(String value) {
            addCriterion("smsNumber <", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberLessThanOrEqualTo(String value) {
            addCriterion("smsNumber <=", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberLike(String value) {
            addCriterion("smsNumber like", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberNotLike(String value) {
            addCriterion("smsNumber not like", value, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberIn(List<String> values) {
            addCriterion("smsNumber in", values, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberNotIn(List<String> values) {
            addCriterion("smsNumber not in", values, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberBetween(String value1, String value2) {
            addCriterion("smsNumber between", value1, value2, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmsnumberNotBetween(String value1, String value2) {
            addCriterion("smsNumber not between", value1, value2, "smsnumber");
            return (Criteria) this;
        }

        public Criteria andSmscontentIsNull() {
            addCriterion("smsContent is null");
            return (Criteria) this;
        }

        public Criteria andSmscontentIsNotNull() {
            addCriterion("smsContent is not null");
            return (Criteria) this;
        }

        public Criteria andSmscontentEqualTo(String value) {
            addCriterion("smsContent =", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotEqualTo(String value) {
            addCriterion("smsContent <>", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentGreaterThan(String value) {
            addCriterion("smsContent >", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentGreaterThanOrEqualTo(String value) {
            addCriterion("smsContent >=", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentLessThan(String value) {
            addCriterion("smsContent <", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentLessThanOrEqualTo(String value) {
            addCriterion("smsContent <=", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentLike(String value) {
            addCriterion("smsContent like", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotLike(String value) {
            addCriterion("smsContent not like", value, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentIn(List<String> values) {
            addCriterion("smsContent in", values, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotIn(List<String> values) {
            addCriterion("smsContent not in", values, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentBetween(String value1, String value2) {
            addCriterion("smsContent between", value1, value2, "smscontent");
            return (Criteria) this;
        }

        public Criteria andSmscontentNotBetween(String value1, String value2) {
            addCriterion("smsContent not between", value1, value2, "smscontent");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}