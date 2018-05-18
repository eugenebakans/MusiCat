package com.bakans.musicat.util;

import com.bakans.musicat.entity.Album;
import com.bakans.musicat.entity.Artist;
import com.bakans.musicat.entity.Song;
import org.apache.commons.io.FilenameUtils;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FolderParser {

    public static List<Artist> parse(String path) {
        List<Artist> list = new ArrayList<Artist>();
        prepareList(list, path);
        return list;
    }

    private static void prepareList(List<Artist> list, String path) {
        File directory = new File(path);
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if ((file.isFile()) && (FilenameUtils.getExtension(file.getName()).equals("mp3"))) {
                try {
                    MP3File mp3File = new MP3File(file);
                    addSongToList(list, mp3File);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TagException e) {
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                prepareList(list, file.getAbsolutePath());
            }
        }
    }

    private static boolean addSongToList(List<Artist> list, MP3File mp3File) {
        String absPath = mp3File.getMp3file().getAbsolutePath();
        String artist = MP3FileParser.getMP3Artist(mp3File);
        String album = MP3FileParser.getMP3Album(mp3File);
        String title = MP3FileParser.getMP3Title(mp3File);
        String length = MP3FileParser.getMP3Len(mp3File);

        Song song = new Song(title, length,absPath);

        for(Artist art:list) {
            if(art.getName().equals(artist)) {
                art.addAlbum(new Album(album));
                art.getAlbum(album).addTrack(song);
            } else {
                Artist newArt = new Artist(artist);
                Album newAlb = new Album(album);
                newAlb.addTrack(song);
                newArt.addAlbum(newAlb);
                list.add(newArt);
                return true;
            }
        }
        /*for(Artist art:list) {
            if(art.getName().equals(artist)) {
                for(Album a:art.getAlbums()) {
                    if(a.getAlbumTitle().equals(album)) {
                        for(Song s:a.getTrackList()) {
                            if(s.getTrackTitle().equals(title)) {
                                return false;
                            } else {
                                a.addTrack(song);
                                return true;
                            }
                        }
                    } else {
                        Album newAlb = new Album(album);
                        newAlb.addTrack(song);
                        art.addAlbum(newAlb);
                        return true;
                    }
                }

            } else {
                Artist newArt = new Artist(artist);
                Album newAlb = new Album(album);
                newAlb.addTrack(song);
                newArt.addAlbum(newAlb);
                list.add(newArt);
                return true;

            }
        }*/

        return false;
    }
}
