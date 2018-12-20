package com.itsm.pub.courses.patients.worker.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.worker.mapper.SaleMapper;
import com.itsm.pub.courses.patients.worker.mapper.StateMapper;
import liquibase.integration.spring.SpringLiquibase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.vibur.dbcp.ViburDBCPDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.itsm.pub.courses.patients")
@PropertySource("classpath:application.properties")
public class WorkerConfig {

    @Autowired
    private ConfigurableEnvironment environment;

    @Value("${server.driver}")
    private String driver;
    @Value("${server.url}")
    private String url;
    @Value("${server.user}")
    private String user;
    @Value("${server.password}")
    private String password;

    @Bean
    public DataSource ds() {
        ViburDBCPDataSource ds = new ViburDBCPDataSource();

        ds.setDriverClassName(driver);
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);

        ds.start();

        return ds;
    }

    @Bean
    public SpringLiquibase springLiquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(ds);
        liquibase.setChangeLog("classpath:db/changeLog.xml");

        return liquibase;
    }


    @PostConstruct
    public void initProfiles() {
        String profiles = environment.getProperty("spring.profiles.active");
        environment.setActiveProfiles(profiles.split(","));
    }

    @Bean
    public SqlSessionFactoryBean mybatisSessionFactoryBean(DataSource ds) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfigLocation(new ClassPathResource("mybatis_config.xml"));
        bean.setDataSource(ds);
        return bean;
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


    @Bean
    public MapperFactoryBean<StateMapper> stateMapperFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<StateMapper> factoryBean = new MapperFactoryBean<>(StateMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<SaleMapper> saleMapperFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<SaleMapper> factoryBean = new MapperFactoryBean<>(SaleMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }
}
