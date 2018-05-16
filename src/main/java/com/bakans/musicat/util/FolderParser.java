package com.bakans.musicat.util;

import com.bakans.musicat.entity.Song;
import org.apache.commons.io.FilenameUtils;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FolderParser {


    public static List<Song> parse(String path) {
        List<Song> list = new ArrayList<Song>();
        prepareList(list, path);
        return list;
    }

    private static void prepareList(List<Song> list, String path) {
        File directory = new File(path);
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if ((file.isFile()) && (FilenameUtils.getExtension(file.getName()).equals("mp3"))) {
                try {
                    Song song = new Song();
                    MP3File mp3File = new MP3File(file);

                    song.setPath(file.getAbsolutePath());
                    song.setArtist(Helper.getMP3Artist(mp3File));
                    song.setAlbum(Helper.getMP3Album(mp3File));
                    song.setTitle(Helper.getMP3Title(mp3File));
                    song.setLength(Helper.getMP3Len(mp3File));
                    list.add(song);
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
}
