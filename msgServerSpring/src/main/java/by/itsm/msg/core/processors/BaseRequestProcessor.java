package by.itsm.msg.core.processors;

import by.itsm.msg.core.BeanSleeper;
import by.itsm.msg.core.RequestProcessor;
import by.itsm.msg.dto.Request;
import by.itsm.msg.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BaseRequestProcessor implements RequestProcessor {

    private final BeanSleeper sleeper;

    @Value("${server.thread.sleep}")
    private int sleep;

    @Autowired
    public BaseRequestProcessor(BeanSleeper sleeper) {
        this.sleeper = sleeper;
    }

    @Override
    public boolean accept(Request request) {
        return request != null && !"moo".equals(request.getMessage());
    }

    @Override
    public Response process(Request request) {
        sleeper.sleep(sleep);
        System.out.println("Message: " + request.toString());
        System.out.println("Name: " + request.getName());
        System.out.println("Message: " + request.getMessage());
        return new Response("Hello, " + request.getName());
    }
}
