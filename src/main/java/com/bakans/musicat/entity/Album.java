package com.bakans.musicat.entity;

import java.util.HashSet;
import java.util.Set;

public class Album {
    private String albumTitle;
    private Set<Song> trackList;

    public Album() {
        this.albumTitle = null;
        this.trackList = new HashSet<Song>();
    }

    public Album(String albumTitle) {
        this.albumTitle = albumTitle;
        this.trackList = new HashSet<Song>();
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
        for(Song track:trackList) {
            if((track.getTrackTitle().equals(obj.getTrackTitle()))
                    && (track.getPath().equals(obj.getPath()))
                    && (track.getLength().equals(obj.getLength()))) {
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
        builder.append("\t\t").append( "Album: " + albumTitle + "\r\n" );
        for(Song song:trackList) {
            builder.append(song.toString()).append("\r\n");
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
        if (albumTitle != other.albumTitle)
            return false;
       /* if (trackList != other.trackList)
            return false;*/
        return true;
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
