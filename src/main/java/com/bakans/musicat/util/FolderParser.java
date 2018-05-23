package com.bakans.musicat.util;

import com.bakans.musicat.entity.Album;
import com.bakans.musicat.entity.Artist;
import com.bakans.musicat.entity.Song;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.commons.io.FilenameUtils;

import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FolderParser {

    public static Set<Artist> parse(String path) {
        Set<Artist> list = new HashSet<Artist>();
        prepareList(list, path);
        return list;
    }

    private static void prepareList(Set<Artist> list, String path) {
        File directory = new File(path);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if ((file.isFile()) && (FilenameUtils.getExtension(file.getName()).equals("mp3"))) {
                Mp3File mp3File = null;
                try {
                    mp3File = new Mp3File(file);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedTagException e) {
                    e.printStackTrace();
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                }
                String absPath = file.getAbsolutePath();
                String artist = MP3FileParser.getMP3Artist(mp3File);
                String album = MP3FileParser.getMP3Album(mp3File);
                String title = MP3FileParser.getMP3Title(mp3File);
                String length = MP3FileParser.getMP3Len(mp3File);

                Song song = new Song(title, length,absPath);
                addToList(list, artist, album, song);


            } else if (file.isDirectory()) {
                prepareList(list, file.getAbsolutePath());
            }
        }
    }
    private static void addToList (Set<Artist> list, String artist, String album, Song song) {
        Artist newArt = new Artist(artist);
        Album newAlb = new Album(album);
        if(list.isEmpty()) {

            newAlb.addTrack(song);
            newArt.addAlbum(newAlb);
            list.add(newArt);
            return;
        }
        boolean hasArtist = false;
        for(Artist art:list) {
            if (art.getName().equals(artist)) {
                if(art.hasAlbum(album)) {
                    if(!art.getAlbum(album).hasTrack(song)){
                        art.getAlbum(album).addTrack(song);
                        return;
                    }

                } else {
                    newAlb.addTrack(song);
                    art.addAlbum(newAlb);
                    return;
                }
                hasArtist = true;
            }
        }
        if(!hasArtist) {
            newAlb.addTrack(song);
            newArt.addAlbum(newAlb);
            list.add(newArt);
            return;
        }
    }

}
