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
        builder.append("\t\t\t\t").append("Song: ").append(trackTitle).append(", ").append(length).append(", path: ").append(path);
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + trackTitle.hashCode();
        result = prime * result + length.hashCode();
        result = prime * result + path.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (trackTitle != other.trackTitle)
            return false;
        if (trackTitle != other.trackTitle)
            return false;
        if (length != other.length)
            return false;
        if (path != other.path)
            return false;
        return true;
    }
}
