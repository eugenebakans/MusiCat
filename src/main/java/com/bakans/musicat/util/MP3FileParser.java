package com.bakans.musicat.util;

import com.mpatric.mp3agic.Mp3File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MP3FileParser {

    public static final String PATTERN_STRING = "([\\S]).*";
    public static final String UNKNOWN_TITLE = "Unknown title";
    public static final String UNKNOWN_ARTIST = "Unknown artist";
    public static final String UNKNOWN_ALBUM = "Unknown album";

    public static String getMP3Title(Mp3File song) {
        String title;
        if (song.hasId3v2Tag()) {
            title = song.getId3v2Tag().getTitle();
            if (matchParam(title)) return title;
        }
        if (song.hasId3v1Tag()) {
            title = song.getId3v1Tag().getTitle();
            if (matchParam(title)) return title;
        }
        return UNKNOWN_TITLE;
    }

    public static String getMP3Artist(Mp3File song) {
        String artist;
        if (song.hasId3v2Tag()) {
            artist = song.getId3v2Tag().getArtist();
            if (matchParam(artist)) return artist;
        }
        if (song.hasId3v1Tag()) {
            artist = song.getId3v1Tag().getArtist();
            if (matchParam(artist)) return artist;
        }
        return UNKNOWN_ARTIST;
    }

    public static String getMP3Album(Mp3File song) {
        String album;
        if (song.hasId3v2Tag()) {
            album = song.getId3v2Tag().getAlbum();
            if (matchParam(album)) return album;

        }
        if (song.hasId3v1Tag()) {
            album = song.getId3v1Tag().getAlbum();
            if (matchParam(album)) return album;
        }
        return UNKNOWN_ALBUM;
    }

    private static boolean matchParam(String param) {
        if (param != null) {
            Pattern p = Pattern.compile(PATTERN_STRING);
            Matcher m = p.matcher(param);
            if (m.matches()) return true;
        }
        return false;
    }

    public static int getMP3Len(Mp3File song) {
        return (int) song.getLengthInSeconds();
    }

}
