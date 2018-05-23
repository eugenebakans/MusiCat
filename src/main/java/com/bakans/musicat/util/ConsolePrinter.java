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
            StringBuilder builder = new StringBuilder();


         /*   builder.append("Song: ")
                    .append(track.getFilenameTag().composeFilename())//вывод полного имени файла, без пути
                    .append(" - ")
                    .append( track.getID3v2Tag().getFrame("TIT2").getBody().getBriefDescription());
            System.out.println(builder.toString());*/
           // System.out.println((artist == null ? "Unknown artist": artist == "" ? "empty" : artist));
          /*  System.out.println("Album: " + (track.getID3v1Tag().getAlbumTitle() == null ? "null" : track.getID3v1Tag().getAlbumTitle()));
            System.out.println("Song title: " + (track.getID3v1Tag().getSongTitle() == null ? "null" : track.getID3v1Tag().getSongTitle()));*/
         //   System.out.println("\r\n");
        }
    }


}
