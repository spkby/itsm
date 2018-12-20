package by.itsm.msg;

import by.itsm.msg.dto.Request;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientMain {

    private static final String ENTER_MESSAGE = "Enter message";
    private static final String SPACE = " ";


    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println(ENTER_MESSAGE);
            System.exit(1);
        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClientConfig.class);
        Runnable client = context.getBean(Runnable.class);

        Request request = context.getBean(Request.class);
        //request.setName(NAME);
        request.setMessage(parse(args));

        client.run();

    }

    private static String parse(String[] msg) {

        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < msg.length; i++) {
            txt.append(msg[i]);
            if (i + 1 != msg.length) {
                txt.append(SPACE);
            }
        }
        return txt.toString();
    }
}
