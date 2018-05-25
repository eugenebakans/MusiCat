package com.bakans.musicat.util;

import com.bakans.musicat.entity.Artist;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import static j2html.TagCreator.*;

public class HtmlPrinter implements IPrinter {
    public void print(String str) {

    }

    public void print(Set<Artist> list) {
        File f = new File("result.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            String source =
                    html(
                            head(
                                    title("MusiCat v1.00")
                            ),
                            body(
                                    h1(pre("Folder(s) parsing results:")),
                                    div(
                                            each(list, artist ->
                                                    div(attrs(".artist"),
                                                            h2(pre(artist.getName())),
                                                            each(artist.getAlbums(), album ->
                                                                    div(attrs(".album"),
                                                                            h3(pre("    Album: " + album.getAlbumTitle())),
                                                                            each(album.getTrackList(), track ->
                                                                                    div(attrs(".track"),
                                                                                            pre("       Title: " + track.getTrackTitle() + "; Length: " + track.getLengthInMins() + "; Source path: " + track.getPath())
                                                                                    )
                                                                            )

                                                                    )

                                                            )
                                                    )
                                            )
                                    )
                            )
                    ).renderFormatted();
            bw.write(source);
            bw.close();
            Desktop.getDesktop().browse(f.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
