package edu.escuelaing.arsw.labs.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Ex32 {
    public static void main(String[] args) throws IOException {
        URL url;
        BufferedReader reader;
        BufferedWriter writer;
        String inputLine;
        if (args.length > 0) {
            url = new URL(args[0]);
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingresa la página web que deseas visitar: ");
            url = new URL(reader.readLine());
        }
        reader = new BufferedReader(new InputStreamReader(url.openStream()));
        writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("resultado.html"),
                        StandardCharsets.UTF_8));
        inputLine = reader.readLine();
        try {
            while (inputLine != null) {
                writer.write(inputLine);
                inputLine = reader.readLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
