package yuu.tube;

import java.awt.*;
import java.io.File;

public class TryAnotherVideoFormat {
    public static void main(String[] args) {
        try {
            String path = "/Users/amirulasyraf/Documents/video/avi/Bear_In_The_Woods.avi";
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