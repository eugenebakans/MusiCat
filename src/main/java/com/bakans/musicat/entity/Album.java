package com.bakans.musicat.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Album {
    private String albumTitle;
    private Set<Song> trackList;

    public Album() {
        this.trackList = new HashSet<>();
    }

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
        this.trackList = new HashSet<>();
    }

    public Album(String albumTitle, Set<Song> trackList) {
        this.albumTitle = albumTitle;
        this.trackList = trackList;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Set<Song> getTrackList() {
        return trackList;
    }

    public void setTrackList(Set<Song> trackList) {
        this.trackList = trackList;
    }

    public boolean hasTrack(Song obj) {
        for (Song track : trackList) {
            if ((track.getTrackTitle().equals(obj.getTrackTitle()))
                    && (track.getPath().equals(obj.getPath()))
                    && (track.getLength() == obj.getLength())) {
                return true; //replace with equals and verify it
            }
        }
        return false;
    }

    public Song getTrack(String title) {//use java8 streams api
        for (Song track : trackList) {
            if (track.getTrackTitle().equals(title)) {
                return track;
            }
        }
        return null;
    }

    public void addTrack(Song album) {
        this.trackList.add(album);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\t\t").append("Album: ").append(albumTitle).append(System.lineSeparator());
        for (Song song : trackList) {
            builder.append(song.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Album other = (Album) obj;
        return Objects.equals(albumTitle, other.albumTitle);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + albumTitle.hashCode();
        //    result = prime * result + trackList.hashCode();
        return result;
    }
}
