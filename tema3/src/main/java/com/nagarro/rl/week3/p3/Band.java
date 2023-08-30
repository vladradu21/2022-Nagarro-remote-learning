package com.nagarro.rl.week3.p3;

import java.util.List;

public class Band {
    private String nameOfTheBand;
    private List<Guitarist> guitaristList;
    private Drummer drummer;

    public Band(String nameOfTheBand, List<Guitarist> guitaristList, Drummer drummer) {
        this.nameOfTheBand = nameOfTheBand;
        this.guitaristList = guitaristList;
        this.drummer = drummer;
    }
}
