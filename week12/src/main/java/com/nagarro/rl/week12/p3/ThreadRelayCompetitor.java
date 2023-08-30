package com.nagarro.rl.week12.p3;

public class ThreadRelayCompetitor implements Runnable {

    private final int teamId;
    private final int threadId;
    private final ThreadRelayRaceContext context;

    public ThreadRelayCompetitor(int teamId, int threadId, ThreadRelayRaceContext context) {
        this.teamId = teamId;
        this.threadId = threadId;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Competitor: " + this.threadId + " from team: " + this.teamId + " has finised!");
        context.finishedRace(this.teamId, this.threadId);
    }
}
