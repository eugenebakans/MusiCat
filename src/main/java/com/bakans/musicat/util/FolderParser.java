package com.bakans.musicat.util;

import com.bakans.musicat.entity.*;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FolderParser {

    public static Set<Artist> parse(String path) {
        Set<Artist> list = new HashSet<>();
        prepareList(list, path);
        return list;
    }

    private static void prepareList(Set<Artist> list, String path) {
        File directory = new File(path);
        File[] fList = directory.listFiles();
        if (fList == null) return;
        for (File file : fList) {
            if ((file.isFile()) && (FilenameUtils.getExtension(file.getName()).equals("mp3"))) {
                Mp3File mp3File;
                try {
                    mp3File = new Mp3File(file);
                } catch (IOException | UnsupportedTagException | InvalidDataException e) {
                    e.printStackTrace();
                    return;
                }
                String absPath = file.getAbsolutePath();
                String artist = MP3FileParser.getMP3Artist(mp3File);
                String album = MP3FileParser.getMP3Album(mp3File);
                String title = MP3FileParser.getMP3Title(mp3File);
                int length = MP3FileParser.getMP3Len(mp3File);

                Song song = new Song(title, length, absPath);
                addToList(list, artist, album, song);

            } else if (file.isDirectory()) {
                prepareList(list, file.getAbsolutePath());
            }
        }
    }

    private static void addToList(Set<Artist> list, String artist, String album, Song song) {//can you simplify it...
        Artist newArt = new Artist(artist);
        Album newAlb = new Album(album);
        if (!list.isEmpty()) {
            for (Artist art : list) {
                if (art.getName().equals(artist)) {
                    if (art.hasAlbum(album)) {
                        art.getAlbum(album).addTrack(song);
                        return;
                    } else {
                        newAlb.addTrack(song);
                        art.addAlbum(newAlb);
                        return;
                    }
                }
            }
        }
        newAlb.addTrack(song);
        newArt.addAlbum(newAlb);
        list.add(newArt);
    }

}
