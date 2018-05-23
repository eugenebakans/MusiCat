package com.bakans.musicat.util;

import com.bakans.musicat.entity.Artist;

import java.util.List;
import java.util.Set;

public interface IPrinter {
    public void print(String str);
    public void print(Set<Artist> list);
}
