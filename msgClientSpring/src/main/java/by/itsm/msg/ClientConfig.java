package by.itsm.msg;

import by.itsm.msg.dto.Request;
import by.itsm.msg.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.*;
import java.net.Socket;

@Configuration
@PropertySource(value = "classpath:client.properties")
public class ClientConfig {

    private static final String SENT = "Sent: ";
    private static final String ANSWER = "Answer: ";
    private static final String ERROR = "ERROR:";

    @Value("${server.port}")
    public int port;

    @Value("${server.host}")
    public String host;

    @Value("${client.name}")
    public String name;

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }

    @Bean
    public Request request() {
        return new Request();
    }

    @Bean
    public Runnable executor(ObjectMapper mapper, Request request) {
        return () -> {

            try (Socket socket = new Socket(host, port);
                 DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                 DataInputStream reader = new DataInputStream(socket.getInputStream())) {

                request.setName(name);
                String requestString = mapper.writeValueAsString(request);
                requestString.length();

                writer.writeUTF(requestString);
                writer.flush();
                System.out.println(SENT + requestString);

                Response response = mapper.readValue(reader.readUTF(), Response.class);
                System.out.println(ANSWER + response.getMessage());

            } catch (IOException e) {
                System.err.println(ERROR + e);
            }
        };
    }
}