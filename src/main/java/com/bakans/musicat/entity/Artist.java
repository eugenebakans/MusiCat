package com.bakans.musicat.entity;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private List<Album> albums;

    public Artist() {
        this.name = null;
        this.albums = new ArrayList<Album>();
    }
    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<Album>();
    }

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public boolean hasAlbum(String title) {
        for(Album alb:albums) {
            if(alb.getAlbumTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
    public Album getAlbum(String title) {
        for(Album alb:albums) {
            if(alb.getAlbumTitle().equals(title)) {
                return alb;
            }
        }
        return null;
    }
    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Artist: " + name + "\r\n");
        for(Album alb:albums) {
            builder.append(alb.toString()).append("\r\n");
        }
        return builder.toString();
    }
}
