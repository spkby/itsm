package by.itsm.msg.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import by.itsm.msg.dto.Request;
import by.itsm.msg.dto.Response;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerRunner implements Runnable {

    private final int port;
    private final int threadCount;
    private final ObjectMapper objectMapper;
    private final Provider<List<RequestProcessor>> requestProcessorProvider;
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public ServerRunner(
            int port,
            int threadCount,
            ObjectMapper objectMapper,
            Provider<List<RequestProcessor>> requestProcessorProvider) {
        this.port = port;
        this.threadCount = threadCount;
        this.objectMapper = objectMapper;
        this.requestProcessorProvider = requestProcessorProvider;
    }

    @PostConstruct
    public void init() throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newFixedThreadPool(threadCount);
    }

    @PreDestroy
    public void destroy() {
        executorService.shutdownNow();
    }

    @Override
    public void run() {
        try {
            Socket socket = serverSocket.accept();
            accept(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void accept(Socket socket) {
        executorService.submit(() -> {
            try (DataInputStream reader = new DataInputStream(socket.getInputStream());
                 DataOutputStream writer = new DataOutputStream(socket.getOutputStream())) {

                String requestString = reader.readUTF();
                Request request = objectMapper.readValue(requestString, Request.class);

                List<RequestProcessor> processors = requestProcessorProvider.get();

                Response response = null;

                for (RequestProcessor processor : processors) {
                    if (processor.accept(request)) {
                        response = processor.process(request);
                        break;
                    }
                }

                String responseString = objectMapper.writeValueAsString(response);

                writer.writeUTF(responseString);
                writer.flush();

                System.out.println("Response: " + response);
                System.out.println("Message: " + response.getMessage());

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
