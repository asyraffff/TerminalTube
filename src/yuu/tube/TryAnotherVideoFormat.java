package yuu.tube;

import java.awt.*;
import java.io.File;

public class TryAnotherVideoFormat {

    public static void avi() {
        try {
            String path = "/Users/amirulasyraf/Documents/avi/Bear_In_The_Woods.avi";
            File file = new File(path);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void flv() {
        try {
            String path = "/Users/amirulasyraf/Documents/flv/Playful_Dogs_During_Winter_Season.flv";
            File file = new File(path);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void wmv() {
        try {
            String path = "/Users/amirulasyraf/Documents/wmv/sample_WMV_file.wmv";
            File file = new File(path);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
