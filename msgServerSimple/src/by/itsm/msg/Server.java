package by.itsm.msg;

import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Constants.SOCKET_PORT);

            System.out.println(Constants.SERVER_STARTED + Constants.SPACE + Inet4Address.getLocalHost().getHostAddress());
            while (true) {
                Socket server = serverSocket.accept();
                System.out.println(Constants.CLIENT_CONNECTED);
                new Thread(new Worker(server)).start();
            }

        } catch (IOException e) {
            System.err.println(Constants.SOCKET_ERROR + e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println(Constants.SOCKET_ERROR + e);
                }
            }
        }
    }
}
