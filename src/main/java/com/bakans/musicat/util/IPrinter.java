package com.bakans.musicat.util;

import org.farng.mp3.MP3File;

import java.util.List;

public interface IPrinter {
    public void print(String str);
    public void print(List<MP3File> list);
}
