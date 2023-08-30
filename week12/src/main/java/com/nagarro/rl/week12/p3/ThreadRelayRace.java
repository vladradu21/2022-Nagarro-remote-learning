package com.nagarro.rl.week12.p3;

public class ThreadRelayRace {

    private static final int NUM_TEAMS = 3;
    private static final int THREADS_PER_TEAM = 2;

    public static void main(String[] args) throws InterruptedException {
        ThreadRelayRaceContext context = new ThreadRelayRaceContext(NUM_TEAMS, THREADS_PER_TEAM);

        ThreadRelayCompetitor[][] competitors = new ThreadRelayCompetitor[NUM_TEAMS][THREADS_PER_TEAM];

        for (int i = 0; i < NUM_TEAMS; i++) {
            for (int j = 0; j < THREADS_PER_TEAM; j++) {
                competitors[i][j] = new ThreadRelayCompetitor(i + 1, j + 1, context);
                new Thread(competitors[i][j]).start();
            }
        }
    }
}
