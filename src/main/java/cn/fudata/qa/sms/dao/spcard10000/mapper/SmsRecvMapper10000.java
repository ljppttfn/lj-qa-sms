package cn.fudata.qa.sms.dao.spcard10000.mapper;

import cn.fudata.qa.sms.dao.spcard10000.model.SmsRecv;
import cn.fudata.qa.sms.dao.spcard10000.model.SmsRecvExample;
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

public interface SmsRecvMapper10000 {
    @SelectProvider(type=SmsRecvSqlProvider.class, method="countByExample")
    long countByExample(SmsRecvExample example);

    @DeleteProvider(type=SmsRecvSqlProvider.class, method="deleteByExample")
    int deleteByExample(SmsRecvExample example);

    @Delete({
        "delete from sms_recv",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sms_recv (PortNum, PhoNum, ",
        "IMSI, ICCID, smsDate, ",
        "smsNumber, smsContent)",
        "values (#{portnum,jdbcType=INTEGER}, #{phonum,jdbcType=VARCHAR}, ",
        "#{imsi,jdbcType=VARCHAR}, #{iccid,jdbcType=VARCHAR}, #{smsdate,jdbcType=VARCHAR}, ",
        "#{smsnumber,jdbcType=VARCHAR}, #{smscontent,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SmsRecv record);

    @InsertProvider(type=SmsRecvSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(SmsRecv record);

    @SelectProvider(type=SmsRecvSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="Id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="PortNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="PhoNum", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="IMSI", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ICCID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsDate", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsNumber", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsContent", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<SmsRecv> selectByExample(SmsRecvExample example);

    @Select({
        "select",
        "Id, PortNum, PhoNum, IMSI, ICCID, smsDate, smsNumber, smsContent",
        "from sms_recv",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="Id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="PortNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="PhoNum", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="IMSI", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ICCID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsDate", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsNumber", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="smsContent", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    SmsRecv selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SmsRecvSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SmsRecv record, @Param("example") SmsRecvExample example);

    @UpdateProvider(type=SmsRecvSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SmsRecv record, @Param("example") SmsRecvExample example);

    @UpdateProvider(type=SmsRecvSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SmsRecv record);

    @Update({
        "update sms_recv",
        "set PortNum = #{portnum,jdbcType=INTEGER},",
          "PhoNum = #{phonum,jdbcType=VARCHAR},",
          "IMSI = #{imsi,jdbcType=VARCHAR},",
          "ICCID = #{iccid,jdbcType=VARCHAR},",
          "smsDate = #{smsdate,jdbcType=VARCHAR},",
          "smsNumber = #{smsnumber,jdbcType=VARCHAR},",
          "smsContent = #{smscontent,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SmsRecv record);
}