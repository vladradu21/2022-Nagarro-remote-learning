package com.nagarro.rl.week3.p3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CDplayer myCdPlayer = new CDplayer("MyCDPlayer", new ArrayList<>());
        myCdPlayer.addSongToCDplayer(new Song("FirstSong"));
        myCdPlayer.addSongToCDplayer(new Song("SecondSong"));

        myCdPlayer.playSongs();
    }
}
