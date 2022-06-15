package edu.escuelaing.arsw.labs.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServerProcessor {

    private static final String HEADER = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n";
    private static String dir = "src/main/res";

    public static void process(Socket clientSocket) throws IOException {
        String inputLine, outputLine = "";
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (inputLine.startsWith("GET")) {
                outputLine = readFile(inputLine, inputLine.replace("GET ", "").replace(" HTTP/1.1", ""));
                out.println(outputLine);
            }
            if (!in.ready()) {
                break;
            }
        }

        out.close();
        in.close();
        clientSocket.close();
    }

    private static String readFile(String inputLine, String route) {
        String nameFile = dir + route;
        if (route.isBlank() || route.equals("/")) {
            return defaultContent(inputLine);
        }
        try {
            return HEADER
                    + Files.readString(Path.of(
                            "",
                            nameFile.replace("/", System.getProperty("file.separator"))));
        } catch (IOException e) {
            return readFile(inputLine, "/index.html");
        }
    }

    private static String defaultContent(String inputLine) {
        return HEADER
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>WITHOUT MEDIA</title>\n"
                + "</head>"
                + "<body>"
                + "<h2>My Web Site</h2>"
                + "<div> Request : " + inputLine + "</div>"
                + "</body>"
                + "</html>";
    }

}
