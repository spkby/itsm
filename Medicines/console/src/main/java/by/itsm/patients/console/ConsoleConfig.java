package by.itsm.patients.console;

import by.itsm.patients.elasticmq.ElasticConfig;
import by.itsm.patients.liquibase.LiquibaseConfig;
import by.itsm.patients.logic.LogicConfig;
import org.springframework.context.annotation.*;

import java.util.Scanner;

@Configuration
@Import({LogicConfig.class, LiquibaseConfig.class, ElasticConfig.class})
@ComponentScan("by.itsm.patients.console")
@PropertySource("classpath:console.properties")
public class ConsoleConfig {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
