package com.bakans.musicat.util;

import java.util.Scanner;

public class Input {
    public static String inputString() {
        Scanner in = new Scanner(System.in);
        String i = in.next();
        in.close();
        return i;
    }
}
