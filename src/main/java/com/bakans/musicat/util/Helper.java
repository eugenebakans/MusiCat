package com.bakans.musicat.util;

import org.farng.mp3.MP3File;

public class Helper {
    public static String getMP3Title(MP3File song) {
        String title;
        if(song.hasID3v2Tag()) {
            if(song.getID3v2Tag().hasFrame("TIT2")) {
                title = song.getID3v2Tag().getFrame("TIT2").getBody().getBriefDescription();
                return title;
            } else if(song.getID3v2Tag().hasFrame("TT2")) {
                title = song.getID3v2Tag().getFrame("TT2").getBody().getBriefDescription();
                return title;
            }
        }
        if(song.hasID3v1Tag()) {
            if(song.getID3v1Tag().getTitle() != null) {
                title = song.getID3v1Tag().getTitle();
                return title;
            }
        }
        if(song.hasFilenameTag()) {
            title = song.getFilenameTag().composeFilename();
            return title;
        }
        return "Unknown title";
    }
    public static String getMP3Artist(MP3File song) {
        String artist;
        if(song.hasID3v2Tag()) {
            if(song.getID3v2Tag().hasFrame("TPE1")) {
                artist = song.getID3v2Tag().getFrame("TPE1").getBody().getBriefDescription();
                return artist;
            } else if(song.getID3v2Tag().hasFrame("TP1")) {
                artist = song.getID3v2Tag().getFrame("TP1").getBody().getBriefDescription();
                return artist;
            }
        }
        if(song.hasID3v1Tag()) {
            if(song.getID3v1Tag().getArtist() != null) {
                artist = song.getID3v1Tag().getArtist();
                return artist;
            }
        }
        if(song.hasFilenameTag()) {
            artist = song.getFilenameTag().getLeadArtist();
            return artist;
        }
        return "Unknown artist";
    }
    public static String getMP3Album(MP3File song) {
        String album;
        if(song.hasID3v2Tag()) {
            if(song.getID3v2Tag().hasFrame("TALB")) {
                album = song.getID3v2Tag().getFrame("TALB").getBody().getBriefDescription();
                return album;
            } else if(song.getID3v2Tag().hasFrame("TAL")) {
                album = song.getID3v2Tag().getFrame("TAL").getBody().getBriefDescription();
                return album;
            }
        }
        if(song.hasID3v1Tag()) {
            if(song.getID3v1Tag().getAlbum() != null) {
                album = song.getID3v1Tag().getAlbum();
                return album;
            }
        }
        return "Unknown album";
    }
    public static String getMP3Len(MP3File song) {
        String length;
        if(song.hasID3v2Tag()) {
            if(song.getID3v2Tag().hasFrame("TLEN")) {
                length = song.getID3v2Tag().getFrame("TLEN").getBody().getBriefDescription();
                return length;
            } else if(song.getID3v2Tag().hasFrame("TLE")) {
                length = song.getID3v2Tag().getFrame("TLE").getBody().getBriefDescription();
                return length;
            }
        }
        return "Unknown length";
    }
}
