package com.bakans.musicat.entity;

import org.farng.mp3.MP3File;

public class Song {
    private String trackTitle;
    private String length;
    private String path;

    public Song() {

    }
    public Song(String trackTitle, String length, String path) {
        this.trackTitle = trackTitle;
        this.length = length;
        this.path = path;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Song: ").append(trackTitle).append(", ").append(length).append(", path: ").append(path);
        return builder.toString();
    }
}
