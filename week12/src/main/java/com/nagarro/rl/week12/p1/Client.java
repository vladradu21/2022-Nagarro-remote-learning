package com.nagarro.rl.week12.p1;

public class Client implements Runnable{

    private MessageQueue messageQueue;
    private int clientId;

    public Client(MessageQueue messageQueue, int clientId) {
        this.messageQueue = messageQueue;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            String message = "Client " + clientId + " message " + i;
            messageQueue.addMessage(message);
            System.out.println("Client " + clientId + " produced message: " + message);
        }
    }
}
