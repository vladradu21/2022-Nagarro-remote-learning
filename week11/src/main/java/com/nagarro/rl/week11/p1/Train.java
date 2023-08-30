package com.nagarro.rl.week11.p1;

import java.util.Objects;

public class Train {

    private int trainNumber;
    private String trainType;
    private int numberOfWagons;
    private static boolean fixedHashCode = true;

    public Train(int trainNumber, String trainType, int numberOfWagons) {
        this.trainNumber = trainNumber;
        this.trainType = trainType;
        this.numberOfWagons = numberOfWagons;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainType() {
        return trainType;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainNumber == train.trainNumber && numberOfWagons == train.numberOfWagons && Objects.equals(trainType, train.trainType);
    }

    @Override
    public int hashCode() {
        if (fixedHashCode) {
            return 3;
        }
        return Objects.hash(trainNumber, trainType, numberOfWagons);
    }

    public static void setFixedHashCode(boolean fixedHashCode) {
        Train.fixedHashCode = fixedHashCode;
    }
}
