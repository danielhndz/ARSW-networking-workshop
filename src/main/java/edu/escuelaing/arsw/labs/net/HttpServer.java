package edu.escuelaing.arsw.labs.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    private static int port = 35000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("Server socket created ...");
            } catch (IOException e) {
                System.err.println("Could not listen on port: " + port + ".");
                System.exit(1);
            }

            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client socket accepted ...");
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            try {
                HttpServerProcessor.process(clientSocket);
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Close server failed.");
                System.exit(1);
            }
        }
    }
}
