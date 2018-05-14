package com.bakans.musicat.util;

import org.apache.commons.io.FilenameUtils;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FolderParser {


    public static List<MP3File> parse(String path) {
        List<MP3File> list = new ArrayList<MP3File>();
        prepareList(list, path);
        return list;
    }

    private static void prepareList(List<MP3File> list, String path) {
        File directory = new File(path);
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if ((file.isFile()) && (FilenameUtils.getExtension(file.getName()).equals("mp3"))) {
                try {
                    list.add(new MP3File(file));
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
