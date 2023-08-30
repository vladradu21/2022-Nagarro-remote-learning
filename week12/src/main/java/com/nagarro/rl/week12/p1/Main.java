package com.nagarro.rl.week12.p1;

public class Main {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        Thread serverThread = new Thread(new Server(queue));

        Thread clientThread1 = new Thread(new Client(queue, 1));
        Thread clientThread2 = new Thread(new Client(queue, 2));

        clientThread1.start();
        clientThread2.start();
        serverThread.start();
    }
}
