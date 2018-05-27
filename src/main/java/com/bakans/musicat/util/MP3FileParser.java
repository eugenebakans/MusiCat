package com.bakans.musicat.util;

import com.mpatric.mp3agic.Mp3File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MP3FileParser {

    public static String getMP3Title(Mp3File song) {
        String title;
        Pattern p = Pattern.compile("([\\S]).*");//add pattern constant
        if(song.hasId3v2Tag()) {
            title = song.getId3v2Tag().getTitle();
            if(title != null) {
                Matcher m = p.matcher(title);
                if (m.matches()) return title;
            }//repeated code segments
        }
        if(song.hasId3v1Tag()) {
            title = song.getId3v1Tag().getTitle();
            if(title != null) {
                Matcher m = p.matcher(title);
                if (m.matches()) return title;
            }
        }
        return "Unknown title";//add constanr
    }

    public static String getMP3Artist(Mp3File song) {
        String artist = null;
        Pattern p = Pattern.compile("([\\S]).*");
        if(song.hasId3v2Tag()) {
            artist = song.getId3v2Tag().getArtist();
            if(artist != null) {
                Matcher m = p.matcher(artist);
                if (m.matches()) return artist;
            }
        }
        if(song.hasId3v1Tag()) {
            artist = song.getId3v1Tag().getArtist();
            if(artist != null) {
                Matcher m = p.matcher(artist);
                if (m.matches()) return artist;
            }
        }
        return "Unknown artist";
    }

    public static String getMP3Album(Mp3File song) {
        String album;
        Pattern p = Pattern.compile("([\\S]).*");
        if(song.hasId3v2Tag()) {
            album = song.getId3v2Tag().getAlbum();
            if(album != null) {
                Matcher m = p.matcher(album);
                if(m.matches()) return album;
            }

        }
        if(song.hasId3v1Tag()) {
            album = song.getId3v1Tag().getAlbum();
            if(album != null) {
                Matcher m = p.matcher(album);
                if(m.matches()) return album;
            }
        }
        return "Unknown album";
    }

    public static int getMP3Len(Mp3File song) {
        return (int)song.getLengthInSeconds();
    }

}
