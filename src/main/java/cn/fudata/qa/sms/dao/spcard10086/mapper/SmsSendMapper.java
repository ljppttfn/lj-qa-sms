package cn.fudata.qa.sms.dao.spcard10086.mapper;

import cn.fudata.qa.sms.dao.spcard10086.model.SmsSend;
import cn.fudata.qa.sms.dao.spcard10086.model.SmsSendExample;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SmsSendMapper {
    @SelectProvider(type=SmsSendSqlProvider.class, method="countByExample")
    long countByExample(SmsSendExample example);

    @DeleteProvider(type=SmsSendSqlProvider.class, method="deleteByExample")
    int deleteByExample(SmsSendExample example);

    @Delete({
        "delete from sms_send",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sms_send (PortNum, smsNumber, ",
        "smsSubject, smsContent, ",
        "smsType, PhoNum, ",
        "smsState)",
        "values (#{portnum,jdbcType=INTEGER}, #{smsnumber,jdbcType=VARCHAR}, ",
        "#{smssubject,jdbcType=VARCHAR}, #{smscontent,jdbcType=VARCHAR}, ",
        "#{smstype,jdbcType=INTEGER}, #{phonum,jdbcType=VARCHAR}, ",
        "#{smsstate,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SmsSend record);

    @InsertProvider(type=SmsSendSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SmsSend record);

    @SelectProvider(type=SmsSendSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="Id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="PortNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="smsNumber", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsSubject", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsContent", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsType", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="PhoNum", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsState", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<SmsSend> selectByExample(SmsSendExample example);

    @Select({
        "select",
        "Id, PortNum, smsNumber, smsSubject, smsContent, smsType, PhoNum, smsState",
        "from sms_send",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="Id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="PortNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="smsNumber", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsSubject", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsContent", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsType", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="PhoNum", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsState", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    SmsSend selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SmsSendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SmsSend record, @Param("example") SmsSendExample example);

    @UpdateProvider(type=SmsSendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SmsSend record, @Param("example") SmsSendExample example);

    @UpdateProvider(type=SmsSendSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SmsSend record);

    @Update({
        "update sms_send",
        "set PortNum = #{portnum,jdbcType=INTEGER},",
          "smsNumber = #{smsnumber,jdbcType=VARCHAR},",
          "smsSubject = #{smssubject,jdbcType=VARCHAR},",
          "smsContent = #{smscontent,jdbcType=VARCHAR},",
          "smsType = #{smstype,jdbcType=INTEGER},",
          "PhoNum = #{phonum,jdbcType=VARCHAR},",
          "smsState = #{smsstate,jdbcType=INTEGER}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SmsSend record);
}