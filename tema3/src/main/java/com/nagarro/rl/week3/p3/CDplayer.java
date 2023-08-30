package com.nagarro.rl.week3.p3;

import java.util.List;

public class CDplayer extends MusicPlayer{
    private List<Song> songList;

    public CDplayer(String name, List<Song> songList) {
        super(name);
        this.songList = songList;
    }

    public void addSongToCDplayer(Song newSong) {
        songList.add(newSong);
    }

    public void playSongs() {
        for(Song mySong : songList) {
            System.out.println(mySong.getNameOfTheSong());
        }
    }
}
