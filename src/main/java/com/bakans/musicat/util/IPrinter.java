package com.bakans.musicat.util;

import com.bakans.musicat.entity.Song;

import java.util.List;

public interface IPrinter {
    public void print(String str);
    public void print(List<Song> list);
}
