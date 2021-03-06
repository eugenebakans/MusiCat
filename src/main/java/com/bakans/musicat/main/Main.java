package com.bakans.musicat.main;

import com.bakans.musicat.entity.Artist;
import com.bakans.musicat.util.FolderParser;
import com.bakans.musicat.util.HtmlPrinter;
import com.bakans.musicat.util.IPrinter;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Artist> set = new HashSet<Artist>();
        for (String arg : args) {
            set.addAll(FolderParser.parse(arg));
        }

        IPrinter printer = new HtmlPrinter();
        printer.print(set);
    }
}