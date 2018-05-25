package com.bakans.musicat.util;

import com.bakans.musicat.entity.Artist;

import java.util.Set;

public class ConsolePrinter implements IPrinter {
    public void print(String str) {
        System.out.println(str);
    }
    public void print(Set<Artist> list) {
        for (Artist artist:list){
            try {
                System.out.println(artist.toString());
            } catch(Exception e) {
                continue;
            }
        }
    }


}
