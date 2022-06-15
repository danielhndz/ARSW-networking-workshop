package edu.escuelaing.arsw.labs.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang3.math.NumberUtils;

public class Ex431 {
    public static void main(String[] args) throws IOException {
        int port = 35000;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server socket created ...");
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port + ".");
            System.exit(1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client socket accepted ...");
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            if (NumberUtils.isCreatable(inputLine)) {
                outputLine = "Respuesta: " + Math.pow(Double.valueOf(inputLine), 2);
            } else {
                outputLine = "Respuesta: " + inputLine;
            }
            out.println(outputLine);
            if (outputLine.equals("Respuesta: Bye")) {
                break;
            }
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

}
