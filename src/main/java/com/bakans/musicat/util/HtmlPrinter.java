package com.bakans.musicat.util;

import com.bakans.musicat.entity.Artist;

import java.util.Set;

import static j2html.TagCreator.*;

public class HtmlPrinter implements IPrinter {
    public void print(String str) {

    }

    public void print(Set<Artist> list) {
        html(
            head(
                title("MusiCat v1.00")
            ),
            body(
                p("Some text here")
            )

        ).render();


    }
}
