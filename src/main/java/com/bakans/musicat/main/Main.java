package com.bakans.musicat.main;

import com.bakans.musicat.entity.Artist;
import com.bakans.musicat.util.ConsolePrinter;
import com.bakans.musicat.util.FolderParser;
import com.bakans.musicat.util.HtmlPrinter;
import com.bakans.musicat.util.IPrinter;

import java.util.Set;

public class Main {
    public static void main(String [] args) {
        IPrinter printer = new HtmlPrinter();
        for(String arg:args) {
            Set<Artist> list = FolderParser.parse(arg);
            printer.print(list);
        }
    }
}
