package com.bakans.musicat.main;

import com.bakans.musicat.entity.Song;
import com.bakans.musicat.util.ConsolePrinter;
import com.bakans.musicat.util.FolderParser;
import com.bakans.musicat.util.IPrinter;
import com.bakans.musicat.util.Input;
import org.farng.mp3.MP3File;

import java.util.List;

public class Main {
    public static void main(String [] args) {
        IPrinter printer = new ConsolePrinter();
        for(String arg:args) {
            List<Song> fileList = FolderParser.parse(arg);
            printer.print(fileList);
        }
    }
}
