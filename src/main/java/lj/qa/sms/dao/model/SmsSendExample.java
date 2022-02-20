package lj.qa.sms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class SmsSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsSendExample() {
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

        public Criteria andSmssubjectIsNull() {
            addCriterion("smsSubject is null");
            return (Criteria) this;
        }

        public Criteria andSmssubjectIsNotNull() {
            addCriterion("smsSubject is not null");
            return (Criteria) this;
        }

        public Criteria andSmssubjectEqualTo(String value) {
            addCriterion("smsSubject =", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectNotEqualTo(String value) {
            addCriterion("smsSubject <>", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectGreaterThan(String value) {
            addCriterion("smsSubject >", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectGreaterThanOrEqualTo(String value) {
            addCriterion("smsSubject >=", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectLessThan(String value) {
            addCriterion("smsSubject <", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectLessThanOrEqualTo(String value) {
            addCriterion("smsSubject <=", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectLike(String value) {
            addCriterion("smsSubject like", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectNotLike(String value) {
            addCriterion("smsSubject not like", value, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectIn(List<String> values) {
            addCriterion("smsSubject in", values, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectNotIn(List<String> values) {
            addCriterion("smsSubject not in", values, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectBetween(String value1, String value2) {
            addCriterion("smsSubject between", value1, value2, "smssubject");
            return (Criteria) this;
        }

        public Criteria andSmssubjectNotBetween(String value1, String value2) {
            addCriterion("smsSubject not between", value1, value2, "smssubject");
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

        public Criteria andSmstypeIsNull() {
            addCriterion("smsType is null");
            return (Criteria) this;
        }

        public Criteria andSmstypeIsNotNull() {
            addCriterion("smsType is not null");
            return (Criteria) this;
        }

        public Criteria andSmstypeEqualTo(Integer value) {
            addCriterion("smsType =", value, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeNotEqualTo(Integer value) {
            addCriterion("smsType <>", value, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeGreaterThan(Integer value) {
            addCriterion("smsType >", value, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("smsType >=", value, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeLessThan(Integer value) {
            addCriterion("smsType <", value, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeLessThanOrEqualTo(Integer value) {
            addCriterion("smsType <=", value, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeIn(List<Integer> values) {
            addCriterion("smsType in", values, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeNotIn(List<Integer> values) {
            addCriterion("smsType not in", values, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeBetween(Integer value1, Integer value2) {
            addCriterion("smsType between", value1, value2, "smstype");
            return (Criteria) this;
        }

        public Criteria andSmstypeNotBetween(Integer value1, Integer value2) {
            addCriterion("smsType not between", value1, value2, "smstype");
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

        public Criteria andSmsstateIsNull() {
            addCriterion("smsState is null");
            return (Criteria) this;
        }

        public Criteria andSmsstateIsNotNull() {
            addCriterion("smsState is not null");
            return (Criteria) this;
        }

        public Criteria andSmsstateEqualTo(Integer value) {
            addCriterion("smsState =", value, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateNotEqualTo(Integer value) {
            addCriterion("smsState <>", value, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateGreaterThan(Integer value) {
            addCriterion("smsState >", value, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("smsState >=", value, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateLessThan(Integer value) {
            addCriterion("smsState <", value, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateLessThanOrEqualTo(Integer value) {
            addCriterion("smsState <=", value, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateIn(List<Integer> values) {
            addCriterion("smsState in", values, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateNotIn(List<Integer> values) {
            addCriterion("smsState not in", values, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateBetween(Integer value1, Integer value2) {
            addCriterion("smsState between", value1, value2, "smsstate");
            return (Criteria) this;
        }

        public Criteria andSmsstateNotBetween(Integer value1, Integer value2) {
            addCriterion("smsState not between", value1, value2, "smsstate");
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