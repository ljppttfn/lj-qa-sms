package cn.fudata.qa.sms.dao.mapper.spcard;

import cn.fudata.qa.sms.dao.model.CardPosition;
import cn.fudata.qa.sms.dao.model.CardPositionExample;

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

public interface CardPositionMapper {
    @SelectProvider(type = CardPositionSqlProvider.class, method = "countByExample")
    long countByExample(CardPositionExample example);

    @DeleteProvider(type = CardPositionSqlProvider.class, method = "deleteByExample")
    int deleteByExample(CardPositionExample example);

    @Delete({
            "delete from card_position",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into card_position (PhoNum, Pwd, ",
            "IdCard, RealName, ",
            "Type, PoolID, PortNum, ",
            "Fee, Msg, Province, ",
            "City)",
            "values (#{phonum,jdbcType=VARCHAR}, #{pwd,jdbcType=VARCHAR}, ",
            "#{idcard,jdbcType=VARCHAR}, #{realname,jdbcType=VARCHAR}, ",
            "#{type,jdbcType=VARCHAR}, #{poolid,jdbcType=INTEGER}, #{portnum,jdbcType=INTEGER}, ",
            "#{fee,jdbcType=INTEGER}, #{msg,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
            "#{city,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(CardPosition record);

    @InsertProvider(type = CardPositionSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(CardPosition record);

    @SelectProvider(type = CardPositionSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "Id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "PhoNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Pwd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "IdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "RealName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "PoolID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "PortNum", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Fee", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Msg", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Province", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "City", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<CardPosition> selectByExample(CardPositionExample example);

    @Select({
            "select",
            "Id, PhoNum, Pwd, IdCard, RealName, Type, PoolID, PortNum, Fee, Msg, Province, ",
            "City",
            "from card_position",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "Id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "PhoNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Pwd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "IdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "RealName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "PoolID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "PortNum", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Fee", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Msg", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Province", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "City", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    CardPosition selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "Id, PhoNum, Pwd, IdCard, RealName, Type, PoolID, PortNum, Fee, Msg, Province, ",
            "City",
            "from card_position",
            "where PhoNum = #{phoNum,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "Id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "PhoNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Pwd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "IdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "RealName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "PoolID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "PortNum", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Fee", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Msg", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Province", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "City", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    CardPosition selectByPhoNum(String phoNum);

    @Select({
            "select",
            "Id, PhoNum, Pwd, IdCard, RealName, Type, PoolID, PortNum, Fee, Msg, Province, ",
            "City",
            "from card_position",
            "where Type = #{type,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
            @Arg(column = "Id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "PhoNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Pwd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "IdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "RealName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "PoolID", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "PortNum", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Fee", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "Msg", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "Province", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "City", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    List<CardPosition> selectByType(String type);

    @UpdateProvider(type = CardPositionSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CardPosition record, @Param("example") CardPositionExample example);

    @UpdateProvider(type = CardPositionSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") CardPosition record, @Param("example") CardPositionExample example);

    @UpdateProvider(type = CardPositionSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardPosition record);

    @Update({
            "update card_position",
            "set PhoNum = #{phonum,jdbcType=VARCHAR},",
            "Pwd = #{pwd,jdbcType=VARCHAR},",
            "IdCard = #{idcard,jdbcType=VARCHAR},",
            "RealName = #{realname,jdbcType=VARCHAR},",
            "Type = #{type,jdbcType=VARCHAR},",
            "PoolID = #{poolid,jdbcType=INTEGER},",
            "PortNum = #{portnum,jdbcType=INTEGER},",
            "Fee = #{fee,jdbcType=INTEGER},",
            "Msg = #{msg,jdbcType=VARCHAR},",
            "Province = #{province,jdbcType=VARCHAR},",
            "City = #{city,jdbcType=VARCHAR}",
            "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardPosition record);
}