package yuu.tube;

import java.util.Locale;
import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    // sign Up or Log in method
    public static void signupOrLogin(String answer){
        switch (answer.toLowerCase()){
            case "s":
                System.out.println("\nSign Up 🌈");
                System.out.print("Username : ");
                String username = scanner.next();
                System.out.print("Email : ");
                String emailSignUp = scanner.next();
                System.out.print("Password : ");
                String passSignUp = scanner.next();

                User.signUp(username, emailSignUp, passSignUp); //Sign Up

                System.out.println("\n  🥳 Welcome to the Yuu-Tube " + username + " 🥳");
                System.out.println("");
                FrontPage.choices(); // Choices Page
                break;

            case "l":
                System.out.println("\nGreat 🚀");
                System.out.print("Email : ");
                String emailLogIn = scanner.next();
                System.out.print("Password : ");
                String passLogIn = scanner.next();

                User.logIn(emailLogIn, passLogIn); // Log In

                FrontPage.choices(); // Choices Page
                break;
            default:
                System.out.print("\n🚨 S or L word only 🚨 : ");
                String answerAgain = scanner.next();
                signupOrLogin(answerAgain);
        }
    }

    // choose what page to open
    public static void choose(int answer){
        switch (answer) {
            case 1:
                FrontPage.trending();
                break;
            case 2:
                FrontPage.addNewVideo();
                break;
            case 3:
                FrontPage.openVideo();
                break;
            case 4:
                FrontPage.search();
                break;
            case 5:
                FrontPage.anotherVideoFormat();
                break;
            case 6:
                FrontPage.editAccount();
                break;
            case 7:
                FrontPage.aboutPage();
                break;
            case 8:
                System.out.println("");
                System.out.println("Bye Bye 👋");
                break;
            default:
                System.out.println("Choose [1 - 6] only 😊");
        }
    }

    // Back to Homepage method
    public static String backToHomePage(String command){
        System.out.print("Back to Homepage ? y | n : ");
        String answerBackToHomepage = scanner.next();

        if (answerBackToHomepage.equals("y")){
            FrontPage.choices(); // choices page
            int userChoose = scanner.nextInt();
            choose(userChoose); // user choose what page to open
        } else {
            return command;
        }
        return command;
    }

    public static void videoLikeOrDislike(String videoTitle){
        System.out.print("Do you like it ? [y / n] : ");
        String likeOrNot = scanner.next();
        Video.likeOrNotLikeVideo(likeOrNot, videoTitle);
    }

    public static void deleteVideo(){
        System.out.print("Do you want to delete video ? [y / n] : ");
        String answerForDeleteVideo = scanner.next();

        switch (answerForDeleteVideo.toLowerCase()){
            case "y":
                System.out.print("Choose video to delete : ");
                String videoName = scanner.next();
                Video.delete(videoName); // delete video from give video title name
                break;
            case "n":
                // Back to homepage
                backToHomePage("deleteVideo()");
                break;
            default:
                System.out.println("y or n only 😊");
        }
    }

    public static void chooseVideoToOpen(String chooseVid){
        String filePath = SQL_Util.findFileForThatVideo(chooseVid);// find fileName from that videoTitle
        Video.open(filePath, chooseVid);// open the video with fileName and videoTitle argument
    }

    // open another video format
    public static void anotherFormat(){
        System.out.println("AVI | FLV | WMV");
        System.out.print("Choose which video format you want to open : ");

        String format = scanner.next();

        switch (format.toLowerCase()){
            case "avi":
                TryAnotherVideoFormat.avi();
                break;
            case "flv":
                TryAnotherVideoFormat.flv();
                break;
            case "wmv":
                TryAnotherVideoFormat.wmv();
                break;
            default:
                System.out.println("AVI | FLV | WMV only 😊");
        }
    }
}
