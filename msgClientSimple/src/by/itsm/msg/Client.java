package by.itsm.msg;

import java.io.*;
import java.net.Socket;

public class Client {

    private static final int PORT = 9999;
    private static final String NAME = "vlaship";
    private static final String HOST = "127.0.0.1";
    private static final String ENTER_MESSAGE = "Enter message";
    private static final String MSG_START = "{\"name\":\"";
    private static final String MSG_MIDDLE = "\",\"message\":\"";
    private static final String MSG_END = "\"}";
    private static final String SENT = "Sent: ";
    private static final String ANSWER = "Answer: ";
    private static final String ERROR = "ERROR:";
    private static final String SPACE = " ";

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println(ENTER_MESSAGE);
            System.exit(1);
        }

        int start = 0;
        String host = HOST;

        if (args.length > 1) {
            host = args[0];
            start = 1;
        }

        try (Socket socket = new Socket(host, PORT);
             DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
             DataInputStream reader = new DataInputStream(socket.getInputStream())) {

            StringBuilder txt = new StringBuilder();
            for (int i = start; i < args.length; i++) {
                txt.append(args[i]);
                if (i + 1 != args.length) {
                    txt.append(SPACE);
                }
            }

            String msg = MSG_START + NAME + MSG_MIDDLE + txt + MSG_END;
            writer.writeUTF(msg);
            writer.flush();
            System.out.println(SENT + msg);

            String response = reader.readUTF();
            System.out.println(ANSWER + response);

        } catch (IOException e) {
            System.err.println(ERROR + e);
        }
    }
}
