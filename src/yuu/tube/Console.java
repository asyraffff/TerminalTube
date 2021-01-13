package yuu.tube;

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

                // generate unique 2fa code
                String twoFACode = twoFA.generateCode();
                sendHTMLEmail.send(emailSignUp, twoFACode); // send to user email
                System.out.println("");
                System.out.println("We already sent your 2FA code to your email");
                System.out.println("Please check your email 😊");

                User.signUp(username, emailSignUp, passSignUp, twoFACode); //Sign Up

                System.out.println("\n  🥳 Welcome to the Yuu-Tube " + username + " 🥳");
                System.out.println("");

                System.out.println("Please log in 💡\n");
                logIn();
                break;

            case "l":
                System.out.println("\nGreat 🚀");
                logIn();
                break;
            default:
                System.out.print("\n🚨 S or L word only 🚨 : ");
                String answerAgain = scanner.next();
                signupOrLogin(answerAgain);
        }
    }

    public static void logIn(){
        System.out.print("Email : ");
        String emailLogIn = scanner.next();
        System.out.print("Password : ");
        String passLogIn = scanner.next();
        System.out.print("2FA Code : ");
        String twoFACode = scanner.next();

        twoFA.compare(emailLogIn, passLogIn, twoFACode);
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
    public static void backToHomePage(){
        FrontPage.choices(); // choices page
        int userChoose = scanner.nextInt();
        Console.choose(userChoose); // user choose what page to open
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
                backToHomePage();
                break;
            default:
                System.out.println("y or n only 😊");
                deleteVideo();
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
                anotherFormat();
        }
    }
}
