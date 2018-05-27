package com.bakans.musicat.entity;

import java.util.HashSet;
import java.util.Set;

public class Artist {
    private String name;
    private Set<Album> albums;

    public Artist() {
        this.name = null;
        this.albums = new HashSet<>();
    }
    public Artist(String name) {
        this.name = name;
        this.albums = new HashSet<>();
    }

    public Artist(String name, Set<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artist other = (Artist) obj;
        if (name != other.name)
            return false;
      /*  if (albums != other.albums)
            return false;*/
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        //    result = prime * result + albums.hashCode();
        return result;
    }

}
