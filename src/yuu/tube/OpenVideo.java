package yuu.tube;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class OpenVideo {

        public static void trendingVideo(String trendVidNumber){
            try {
                String path = "/Users/amirulasyraf/Documents/" + trendVidNumber + ".mp4";
                File file = new File(path);
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
//            URI oURL = new URI("https://www.youtube.com/");
//            desktop.browse(oURL);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

}
