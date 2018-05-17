package com.bakans.musicat.entity;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String albumTitle;
    private List<Song> trackList;

    public Album() {
        this.albumTitle = null;
        this.trackList = new ArrayList<Song>();
    }

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
        this.trackList = new ArrayList<Song>();
    }

    public Album(String albumTitle, List<Song> trackList) {
        this.albumTitle = albumTitle;
        this.trackList = trackList;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public List<Song> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Song> trackList) {
        this.trackList = trackList;
    }

    public boolean hasTrack(String title) {
        for(Song track:trackList) {
            if(track.getTrackTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
    public Song getTrack(String title) {
        for(Song track:trackList) {
            if(track.getTrackTitle().equals(title)) {
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
        builder.append( "Album: " + albumTitle + "\r\n" );
        for(Song song:trackList) {
            builder.append(song.toString()).append("\r\n");
        }
        return builder.toString();
    }
}
