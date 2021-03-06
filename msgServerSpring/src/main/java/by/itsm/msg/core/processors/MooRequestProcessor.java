package by.itsm.msg.core.processors;

import by.itsm.msg.core.RequestProcessor;
import by.itsm.msg.dto.Request;
import by.itsm.msg.dto.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!moo")
public class MooRequestProcessor implements RequestProcessor {

    @Value("${server.moo.superpower}")
    private Boolean hasMooSuperpower;

    @Override
    public Response process(Request request) {
        return new Response("this server doesn't have moo superpower");
    }

    @Override
    public boolean accept(Request request) {
        return !hasMooSuperpower && request != null && "moo".equals(request.getMessage());
    }
}
