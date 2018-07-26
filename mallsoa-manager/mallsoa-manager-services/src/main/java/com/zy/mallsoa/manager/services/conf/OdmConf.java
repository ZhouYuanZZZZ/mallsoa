package com.zy.mallsoa.manager.services.conf;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;

@Configuration
public class OdmConf implements EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(OdmConf.class);

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "mysqlDb")
    public DataSource dataSource() {

        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(environment.getProperty("odm.url"));
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(environment.getProperty("odm.password"));
        mysqlXaDataSource.setUser(environment.getProperty("odm.username"));

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        return xaDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("mysqlDb") DataSource mysqlDb) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDb);

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setConfigLocation(resolver.getResources(environment.getProperty("odm.mybatisConfigLocationLocation"))[0]);
        } catch (Exception e) {
            logger.error("create sqlSessionFactory error", e.toString());
            throw new RuntimeException(e);
        }

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //扫描Mapper配置文件与接口的包名
        mapperScannerConfigurer.setBasePackage(environment.getProperty("odm.mapperScannerConfigurerBasePackage"));
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;
    }

    public DataSourceTransactionManager transactionManager(@Qualifier("mysqlDb") DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);

        return dataSourceTransactionManager;
    }
}
