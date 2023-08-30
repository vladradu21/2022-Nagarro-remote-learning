package com.nagarro.rl.week12.p2;

public class ThreadRaceCompetitor implements Runnable{

    private final int id;
    private final ThreadRaceContext context;

    public ThreadRaceCompetitor(int id, ThreadRaceContext context) {
        this.id = id;
        this.context = context;
    }

    @Override
    public void run() {
        // Simulating the race by sleeping for a random time
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Competitor: " + this.id + " has finised!");
        // Informing context that this competitor has finished
        context.finishedRace(this.id);
    }
}
