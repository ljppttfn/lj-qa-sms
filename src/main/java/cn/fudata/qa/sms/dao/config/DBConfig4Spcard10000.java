package cn.fudata.qa.sms.dao.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author youlong
 * date 2019/1/7
 */

@Configuration
@MapperScan(basePackages = "cn.fudata.qa.sms.dao.spcard10000.mapper", sqlSessionTemplateRef = "SqlSessionTemplate4Spcard10000")
public class DBConfig4Spcard10000 {

    @Bean(name = "DB4Spcard10000")
    @ConfigurationProperties(prefix = "spring.datasource.spcard10000")
    public DataSource dataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "DBTransactionManager4Spcard10000")
    public DataSourceTransactionManager transactionManager(@Qualifier("DB4Spcard10000") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SqlSessionFactory4Spcard10000")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("DB4Spcard10000") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "SqlSessionTemplate4Spcard10000")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("SqlSessionFactory4Spcard10000") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }
}
