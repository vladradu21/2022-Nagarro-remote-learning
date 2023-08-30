package com.nagarro.rl.week11.p1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create HashMap
        Map<Train, List<Integer>> trainSchedule = new HashMap<>();

        // Populate HashMap with 10000 records
        populateTrainSchedule(trainSchedule);

        // Test performance with constant hashcode
        long startTime = System.currentTimeMillis();
        testTrainSchedule(trainSchedule);
        long endTime = System.currentTimeMillis();
        long elapsedTimeWithConstantHashCode = endTime - startTime;

        // Rewrite hashCode() method in Train class to use non-constant values
        setTrainHashcodeToNonConstant();

        // Test performance with non-constant hashcode
        startTime = System.currentTimeMillis();
        testTrainSchedule(trainSchedule);
        endTime = System.currentTimeMillis();
        long elapsedTimeWithNonConstantHashCode = endTime - startTime;

        // Compare results
        System.out.println("Elapsed time with constant hashcode: " + elapsedTimeWithConstantHashCode + "ms");
        System.out.println("Elapsed time with non-constant hashcode: " + elapsedTimeWithNonConstantHashCode + "ms");
    }

    private static void populateTrainSchedule(Map<Train, List<Integer>> trainSchedule) {
        // Generate 10000 trains with random schedules
        for (int i = 0; i < 10000; i++) {
            Train train = new Train(i, "Express", (int) (Math.random() * 10) + 1);
            List<Integer> schedule = new ArrayList<>();
            for (int j = 0; j < 365; j++) {
                if (Math.random() < 0.05) { // Train runs on 5% of days
                    schedule.add(j + 1);
                }
            }
            trainSchedule.put(train, schedule);
        }
    }

    private static void testTrainSchedule(Map<Train, List<Integer>> trainSchedule) {
        // Retrieve schedule for random trains
        for (int i = 0; i < 1000; i++) {
            int randomTrainNumber = (int) (Math.random() * 10000);
            Train randomTrain = new Train(randomTrainNumber, "Express", (int) (Math.random() * 10) + 1);
            List<Integer> schedule = trainSchedule.get(randomTrain);
        }
    }

    private static void setTrainHashcodeToNonConstant() {
        Train.setFixedHashCode(false);
    }
}

