package com.nagarro.rl.week3.p3;

import java.util.ArrayList;
import java.util.List;

public class IPod extends MusicPlayer{
    private List<PlayList> myPlayLists = new ArrayList<>();

    public IPod(String name, List<PlayList> myPlayLists) {
        super(name);
        this.myPlayLists = myPlayLists;
    }
}
