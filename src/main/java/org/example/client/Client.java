package org.example.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public void start() {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Conectat la server!");

            while (true) {
                System.out.print("Introdu comanda: ");
                String comanda = scanner.nextLine();
                out.println(comanda);

                String raspuns = in.readLine();
                System.out.println("Raspuns server: " + raspuns);

                if ("exit".equalsIgnoreCase(comanda)) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().start();
    }
}
