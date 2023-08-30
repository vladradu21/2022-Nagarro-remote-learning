package com.nagarro.rl.week15.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final int PORT = 8081;
    private static final String URL = "https://en.wikipedia.org/";

    public static void main(String[] args) {
        try {
            Socket socket = connectToServer();
            sendGetRequest(socket);
            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling Client request: " + e.getMessage());
        }
    }

    private static Socket connectToServer() throws IOException {
        return new Socket("localhost", PORT);
    }

    private static void sendGetRequest(Socket socket) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader in = new BufferedReader(inputStreamReader);

        out.println("GET " + URL);
        in.lines().forEach(System.out::println);
    }
}
