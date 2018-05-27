package com.bakans.musicat.util;

import com.bakans.musicat.entity.Artist;

import java.util.List;
import java.util.Set;

public interface IPrinter {
    void print(String str);
    void print(Set<Artist> list);
}
