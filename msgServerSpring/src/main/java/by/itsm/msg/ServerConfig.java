package by.itsm.msg;

import by.itsm.msg.core.RequestProcessor;
import by.itsm.msg.core.ServerRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.PostConstruct;
import javax.inject.Provider;

import java.util.List;

@Configuration
@ComponentScan("by.itsm.msg")
@PropertySource(value = "classpath:server.properties")
public class ServerConfig {

    @Autowired
    private ConfigurableEnvironment environment;

    @Value("${server.thread.count}")
    private Integer threadCount;

    @Value("${spring.profiles.active}")
    private String profiles;

    @Value("${server.port}")
    private int port;

    @PostConstruct
    public void initProfiles() {
        environment.setActiveProfiles(profiles.split(","));
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ServerRunner rootEndpoint(
            ObjectMapper mapper,
            Provider<List<RequestProcessor>> processors) {
        return new ServerRunner(
                port,
                threadCount,
                mapper,
                processors);
    }
}
