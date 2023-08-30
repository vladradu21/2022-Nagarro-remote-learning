package com.nagarro.rl.week12.p1;

public class Server implements Runnable{

    private MessageQueue messageQueue;

    public Server(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            String message = messageQueue.consumeMessage();
            System.out.println("Server consumed message: " + message);
        }
    }
}
