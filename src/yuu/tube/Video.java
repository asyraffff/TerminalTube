package yuu.tube;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Video {
    private static Scanner scanner = new Scanner(System.in);

    public static void addVideo(String username,String youtubeName, String fileName, String titleVideo){
        SQL_Util.addVideo(youtubeName, fileName,titleVideo);
        int userId = SQL_Util.getUid(username);
        int videoId = SQL_Util.getVid(titleVideo);
        SQL_Util.addVideoToUser(userId, videoId);
    }

    public static void findVideo(String username){
        int usernameId = SQL_Util.getUid(username);
        SQL_Util.returnUserVideo(usernameId);
    }

    public static void open(String fileName, String titleName){
        try {
            String path = "/Users/amirulasyraf/Documents/" + fileName + "/" + titleName + ".mp4";
            File file = new File(path);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delete(String title){
        int vid = SQL_Util.getVid(title);
        SQL_Util.deleteVideo1(vid);
        SQL_Util.deleteVideo2(vid);
    }
}
