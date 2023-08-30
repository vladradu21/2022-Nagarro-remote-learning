package com.nagarro.rl.week12.p2;

import java.util.LinkedList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class ThreadRaceContext {

    private final List<Integer> rankings = new LinkedList<>();
    private final int nrOfCompetitors;

    public ThreadRaceContext(int nrOfCompetitors) {
        this.nrOfCompetitors = nrOfCompetitors;
    }

    public synchronized void finishedRace(int competitorId) {
        rankings.add(competitorId);
        if (rankings.size() == nrOfCompetitors) {
            printResults();
        }
    }

    private void printResults() {
        System.out.println("\nFinal Rankings:");
        range(0, rankings.size()).forEach(i -> {
            System.out.println("Competitor " + rankings.get(i));
        });
    }
}
