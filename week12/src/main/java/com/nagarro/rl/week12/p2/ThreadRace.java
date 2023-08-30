package com.nagarro.rl.week12.p2;

import static java.util.stream.IntStream.range;

public class ThreadRace {

    public static void main(String[] args) {
        ThreadRaceContext context = new ThreadRaceContext(10);

        range(0, 10).forEach(i -> {
            ThreadRaceCompetitor competitor = new ThreadRaceCompetitor(i, context);
            Thread thread = new Thread(competitor);
            thread.start();
        });
    }
}
