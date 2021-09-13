package no.kristiania.http;

import java.io.IOException;
import java.net.Socket;

public class HttpClient {
    private int statusCode = 200;

    public HttpClient(final String host, int port, final String request) throws IOException {
        Socket socket = new Socket(host, port);
        socket.getOutputStream().write(("GET " + request + " HTTP/1.1\r\n" +
                "Host: " + host + " \r\n" +
                "\r\n").getBytes());

        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            if (c != '\n') break;
            System.out.print((char) c);
        }
    }

    public static void main(String[] args) throws IOException {
        new HttpClient("httpbin.org", 80, "/html");
    }

    public int getStatusCode() {
        return statusCode;
    }
}
