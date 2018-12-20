package by.itsm.msg;

import java.io.*;
import java.net.Socket;

public class Worker implements Runnable {

    private Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
             DataInputStream reader = new DataInputStream(socket.getInputStream())) {

            String line = reader.readUTF();
            System.out.println(socket.getInetAddress().toString() + Constants.DELIMITER + line);

            Parse msg = new Parse(line);
            System.out.println(msg);

            Thread.sleep(Constants.TIME_SLEEP);

            writer.writeUTF(Constants.ANSWER_START + Constants.ANSWER_HELLO + msg.getName() + Constants.ANSWER_END);
            writer.flush();
            System.out.println(Constants.ANSWER_SENT + Constants.TO + msg.getName() + Constants.OPEN_ROUND_BRACKET
                    + socket.getInetAddress().toString() + Constants.CLOSE_ROUND_BRACKET);

        } catch (IOException | InterruptedException e) {
            System.err.println(Constants.ERROR + e);
        }

    }
}
