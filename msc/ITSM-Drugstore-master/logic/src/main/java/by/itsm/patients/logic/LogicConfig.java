package by.itsm.patients.logic;

import by.itsm.patients.logic.context.HashSalt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("by.itsm.patients.logic")
@EnableTransactionManagement()
@PropertySource("classpath:logic.properties")
public class LogicConfig {

    @Value("${salt}")
    private String salt;

    @Bean
    public HashSalt HashSalt() {
        HashSalt hashSalt = new HashSalt(salt);
        return hashSalt;
    }

    @Autowired
    private ConfigurableEnvironment environment;

    @Value("${audit.enabled}")
    public boolean isAuditEnabled;

    @Bean
    @DependsOn("springLiquibase")
    public LocalContainerEntityManagerFactoryBean sessionFactory(JpaVendorAdapter jpaVendorAdapter, Properties jpaProperties, DataSource ds) {
        LocalContainerEntityManagerFactoryBean factoryBean
                = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(ds);
        factoryBean.setPackagesToScan("by.itsm.patients.common.entity");
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setJpaProperties(jpaProperties);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public TransactionTemplate txTemplate(PlatformTransactionManager txManager) {
        return new TransactionTemplate(txManager);
    }

    @Bean
    public AuditEnabled isAuditEnable() {
        AuditEnabled auditEnabled = new AuditEnabled();
        auditEnabled.setEnabled(isAuditEnabled);
        return auditEnabled;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

        return properties;
    }

}
