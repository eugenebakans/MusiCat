package com.bakans.musicat.util;

import com.mpatric.mp3agic.Mp3File;

public class MP3FileParser {

    public static String getMP3Title(Mp3File song) {
        String title = null;
        if(song.hasId3v2Tag()) {
            title = song.getId3v2Tag().getTitle();
            if((title != null) & (title != "")) return title;
        }
        if(song.hasId3v1Tag()) {
            title = song.getId3v1Tag().getTitle();
            if((title != null) & (title != "")) return title;
        }

        return "Unknown title";
    }
    public static String getMP3Artist(Mp3File song) {
        String artist = null;
        if(song.hasId3v2Tag()) {
            artist = song.getId3v2Tag().getArtist();
            if((artist != null) & (artist != "")) return artist;
        }
        if(song.hasId3v1Tag()) {
            artist = song.getId3v1Tag().getArtist();
            if((artist != null) & (artist != "")) return artist;
        }

        return "Unknown artist";
    }
    public static String getMP3Album(Mp3File song) {
        String album;
        if(song.hasId3v2Tag()) {
            album = song.getId3v2Tag().getAlbum();
            if((album != null) & (album != "")) return album;
        }
        if(song.hasId3v1Tag()) {
            album = song.getId3v1Tag().getAlbum();
            if((album != null) & (album != "")) return album;
        }

        return "Unknown album";
    }

    public static String getMP3Len(Mp3File song) {
        int length;
        length = (int)song.getLengthInSeconds();
        return Integer.toString(length);
    }

}
