package cn.fudata.qa.sms.dao.spcard10086.mapper;

import cn.fudata.qa.sms.dao.spcard10086.model.PortInfo;
import cn.fudata.qa.sms.dao.spcard10086.model.PortInfoExample;
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

public interface PortInfoMapper10086 {
    @SelectProvider(type=PortInfoSqlProvider.class, method="countByExample")
    long countByExample(PortInfoExample example);

    @DeleteProvider(type=PortInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(PortInfoExample example);

    @Delete({
        "delete from port_info",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into port_info (PortNum, IMSI, ",
        "ICCID, PhoNum)",
        "values (#{portnum,jdbcType=INTEGER}, #{imsi,jdbcType=VARCHAR}, ",
        "#{iccid,jdbcType=VARCHAR}, #{phonum,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PortInfo record);

    @InsertProvider(type=PortInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PortInfo record);

    @SelectProvider(type=PortInfoSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="Id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="PortNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="IMSI", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ICCID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PhoNum", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<PortInfo> selectByExample(PortInfoExample example);

    @Select({
        "select",
        "Id, PortNum, IMSI, ICCID, PhoNum",
        "from port_info",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="Id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="PortNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="IMSI", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="ICCID", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="PhoNum", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    PortInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PortInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PortInfo record, @Param("example") PortInfoExample example);

    @UpdateProvider(type=PortInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PortInfo record, @Param("example") PortInfoExample example);

    @UpdateProvider(type=PortInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PortInfo record);

    @Update({
        "update port_info",
        "set PortNum = #{portnum,jdbcType=INTEGER},",
          "IMSI = #{imsi,jdbcType=VARCHAR},",
          "ICCID = #{iccid,jdbcType=VARCHAR},",
          "PhoNum = #{phonum,jdbcType=VARCHAR}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PortInfo record);
}