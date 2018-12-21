package by.itsm.patients.worker;

import by.itsm.patients.elasticmq.ElasticConfig;
import by.itsm.patients.liquibase.LiquibaseConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
@Import({LiquibaseConfig.class, ElasticConfig.class})
@ComponentScan("by.itsm.patients.worker")
@PropertySource("classpath:reports.properties")
class WorkerConfig {

    @Value("${mybatis.config.xml}")
    private String config;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        final Resource configLocation = new ClassPathResource(config);
        sqlSessionFactoryBean.setConfigLocation(configLocation);

        return sqlSessionFactoryBean.getObject();
    }

}
