package com.nagarro.rl.week12.p3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static java.util.stream.IntStream.range;

public class ThreadRelayRaceContext {

    private final Map<Integer, Map<Integer, Integer>> results;
    private final int numTeams;
    private final int numThreadsPerTeam;
    private final CountDownLatch allCompetitorsFinished;

    public ThreadRelayRaceContext(int numTeams, int numThreadsPerTeam) {
        this.numTeams = numTeams;
        this.numThreadsPerTeam = numThreadsPerTeam;
        this.results = new HashMap<>();
        range(1, numTeams+1).forEach(i -> results.put(i, new HashMap<>()));
        this.allCompetitorsFinished = new CountDownLatch(numTeams * numThreadsPerTeam);
    }

    public void finishedRace(int teamId, int threadId) {
        synchronized (results) {
            results.get(teamId).put(threadId, 1);
            allCompetitorsFinished.countDown();
            if (allCompetitorsFinished.getCount() == 0) {
                printResults();
            } else if (results.get(teamId).size() == numThreadsPerTeam) {
                printTeamResults(teamId);
            }
        }
    }

    private void printResults() {
        System.out.println("\nFinal Results:");
        range(1, numTeams+1).forEach(i -> {
            int totalTime = results.get(i).values().stream().reduce(0, Integer::sum);
            System.out.println("Team " + i + " finished in " + totalTime + " seconds.");
        });
    }

    private void printTeamResults(int teamId) {
        System.out.println("\nTeam " + teamId + " results:");
        range(1, numThreadsPerTeam+1).forEach(i -> {
            System.out.println("Thread " + i + " finished in position " + results.get(teamId).get(i));
        });
    }
}
