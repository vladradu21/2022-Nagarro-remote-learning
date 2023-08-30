package com.nagarro.rl.week12.p1;

import java.util.LinkedList;
import java.util.List;

public class MessageQueue {

    private List<String> messages = new LinkedList<>();
    private int maxQueueSize = 10;

    public synchronized void addMessage(String message) {
        while (messages.size() >= maxQueueSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        messages.add(message);
        notifyAll();
    }

    public synchronized String consumeMessage() {
        while (messages.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String message = messages.remove(0);
        notifyAll();
        return message;
    }
}

