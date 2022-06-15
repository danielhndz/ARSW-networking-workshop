package edu.escuelaing.arsw.labs.net;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex31 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://campusvirtual.escuelaing.edu.co/moodle/mod/page/view.php?id=128751");
        System.out.println("getProtocol : " + url.getProtocol());
        System.out.println("getAuthority : " + url.getAuthority());
        System.out.println("getHost : " + url.getHost());
        System.out.println("getPort : " + url.getPort());
        System.out.println("getPath : " + url.getPath());
        System.out.println("getQuery : " + url.getQuery());
        System.out.println("getFile : " + url.getFile());
        System.out.println("getRef : " + url.getRef());
    }
}
