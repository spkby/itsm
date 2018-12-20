package com.training.config;

import com.training.mapper.StateMapper;
import com.training.mapper.TransactionMapper;
import com.training.mapper.UserMapper;
import liquibase.integration.spring.SpringLiquibase;
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
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.training")
public class WorkerConfig {

    private final ConfigurableEnvironment env;

    @Value("${ds.database-driver}")
    private String className;
    @Value("${ds.url}")
    private String url;
    @Value("${ds.username}")
    private String userName;
    @Value("${ds.password}")
    private String password;
    @Value("${db.changelog}")
    private String changeLog;

    @Autowired
    public WorkerConfig(ConfigurableEnvironment env) {
        this.env = env;
    }


    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(className);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SpringLiquibase springLiquibase(DataSource dataSource) {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog(changeLog);
        return springLiquibase;
    }

    @Bean
    public SqlSessionFactoryBean mybatisSessionFactoryBean(DataSource ds) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfigLocation(new ClassPathResource("mapper/config.xml"));
        bean.setDataSource(ds);
        return bean;
    }

    @Bean
    public MapperFactoryBean<StateMapper> stateMapperFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<StateMapper> factoryBean = new MapperFactoryBean<>(StateMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<UserMapper> userMapperFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<>(UserMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    public MapperFactoryBean<TransactionMapper> transactionMapperFactory(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<TransactionMapper> factoryBean = new MapperFactoryBean<>(TransactionMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @PostConstruct
    public void initProfiles() {
        String profiles = env.getProperty("spring.profiles.active");
        env.setActiveProfiles(profiles.split(","));
    }

}
