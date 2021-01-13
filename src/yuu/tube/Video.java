package yuu.tube;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Video {
    private static Scanner scanner = new Scanner(System.in);

    // method to add user video to database
    public static void addVideo(String username,String youtubeName, String fileName, String titleVideo){
        SQL_Util.addVideo(youtubeName, fileName,titleVideo); // add video to Video Database

        // find userId and videoId
        int userId = SQL_Util.getUid(username);
        int videoId = SQL_Util.getVid(titleVideo);
        // Reference the user video to the user itself
        SQL_Util.addVideoToUser(userId, videoId);
    }

    // find video for a specific username from database
    public static void findVideo(String username){
        int usernameId = SQL_Util.getUid(username);
        SQL_Util.returnUserVideo(usernameId); // return all that user's video
    }

    // Open the video
    public static void open(String fileName, String titleName){
        try {
            // filepath from desktop
            String path = "/Users/amirulasyraf/Documents/" + fileName + "/" + titleName + ".mp4";
            File file = new File(path); // handle the file path using the File class
            Desktop desktop = Desktop.getDesktop(); // initiate the connection with the desktop
            desktop.open(file); // open the file from the desktop
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // delete video
    public static void delete(String title){
        int vid = SQL_Util.getVid(title); // get the video id from the video title name
        SQL_Util.deleteVideo1(vid); // delete video from reference database(VideoUser)
        SQL_Util.deleteVideo2(vid); // delete video from video database
    }

    // like and dislike video
    public static void likeOrNotLikeVideo(String answer, String videoTitle){
        switch (answer.toLowerCase()){
            case "y":
                SQL_Util.likeVideo(videoTitle);
                break;
            case "n":
                SQL_Util.dislikeVideo(videoTitle);
                break;
            default:
                System.out.println("[y or n] only 😊");
                FrontPage.openVideo();
        }
    }
}
