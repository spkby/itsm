package by.itsm.msg;

import by.itsm.msg.core.ServerRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
        context.registerShutdownHook();

        ServerRunner endpoint = context.getBean(ServerRunner.class);
        while (true) {
            endpoint.run();
        }
    }
}
