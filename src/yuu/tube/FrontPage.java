package yuu.tube;

import java.util.Scanner;

public class FrontPage {
    private static Scanner scanner = new Scanner(System.in);

    private static String trendVid = "/trendVid/";

    private static String trend1 = "Pink_Sweat$_At_My_Worst_(Officil_l_Video)";
    private static String trend2 = "Do_you_love_me_(Boston_Dynamics)";
    private static String trend3 = "Can't_Get_You_out_of_My_Head_(Cover)_AnnenMayKantereit_x_Parcels";
    private static String trend4 = "Cat_Vibing_To_Ievan_Polkka_(Official_Video_HD)_Cat_Vibing_To_Music_Cat_Vibing_Meme";
    private static String trend5 = "Starship_SN8_High_Altitude_Flight_Recap";

    // Main FrontPage
    public static void hi(){
        System.out.println("");
        System.out.println("🔥🔥 Welcome to Yuu-Tube v1.0  🔥🔥\n");

        System.out.println("Trending on Yuu-Tube");
        System.out.println("1️⃣ Pink Sweat$ At My Worst (Official Video)");
        System.out.println("2️⃣ Do you love me (Boston Dynamics)");
        System.out.println("3️⃣ Can't Get You out of My Head (Cover) AnnenMayKantereit x Parcels");
        System.out.println("4️⃣ Cat Vibing To Ievan Polkka (Official Video HD) Cat Vibing To Music Cat Vibing Meme");
        System.out.println("5️⃣ Starship SN8 High Altitude Flight Recap");

        System.out.println("");
        System.out.println("What are you up to now ? 🏖");
        System.out.println("✅ Sign Up (S)\n✅ Log in  (L)");
        System.out.print("Please select [S or L] : ");
    }

    // Choices Page
    public static void choices(){
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("[ 1 ] 🔥 Watch Trending");
        System.out.println("[ 2 ] 🛠 Add New Video");
        System.out.println("[ 3 ] 🌈 Watch my Video");
        System.out.println("[ 4 ] 🚀 Search Youtube Channel");
        System.out.println("[ 5 ] 📦 Open another video format");
        System.out.println("[ 6 ] 💁 Edit account");
        System.out.println("[ 7 ] 🏖 About Yuu-Tube");
        System.out.println("[ 8 ] 😔 Log Out");
        System.out.println("");
        System.out.print("Please choose [1 - 8] : ");
    }

    // Trending Page
    public static void trending(){
        System.out.println("");
        System.out.println("🔥 Trending on Yuu-Tube");
        System.out.println("1️⃣ Pink Sweat$ At My Worst (Official Video)");
        System.out.println("2️⃣ Do you love me (Boston Dynamics)");
        System.out.println("3️⃣ Can't Get You out of My Head (Cover) AnnenMayKantereit x Parcels");
        System.out.println("4️⃣ Cat Vibing To Ievan Polkka (Official Video HD) Cat Vibing To Music Cat Vibing Meme");
        System.out.println("5️⃣ Starship SN8 High Altitude Flight Recap");
        System.out.println("");
        System.out.print("Please choose [1 - 5] : ");

        int chooseVideo = scanner.nextInt();
        chooseTrendingVideo(chooseVideo); // method to open the trending video

        System.out.print("Do you want to watch more ? y | n : ");
        String answer = scanner.next();

        switch (answer.toLowerCase()){
            case "y":
                System.out.print("Please choose [1 - 5] : ");
                chooseTrendingVideo(scanner.nextInt()); // open trending video again

                System.out.print("Back to Homepage ? y | n : ");
                String answerToHomepageFromTrending = scanner.next();
                if (answerToHomepageFromTrending.equals("y")){
                    Console.backToHomePage();
                } else if(answerToHomepageFromTrending.equals("n")) {
                    // if n
                    // return to that page back
                    trending();
                }
                break;
            case "n":
                // Back to Homepage
                Console.backToHomePage();
                break;
            default:
                System.out.println("y | n only 😊");
                trending(); // back to trending page
        }
    }

    // choose trending video to open
    public static void chooseTrendingVideo(int numberVideo){
        switch (numberVideo){
            case 1:
                Video.open(trendVid, trend1); // fileMame, videoName
                break;
            case 2:
                Video.open(trendVid, trend2);
                break;
            case 3:
                Video.open(trendVid, trend3);
                break;
            case 4:
                Video.open(trendVid, trend4);
                break;
            case 5:
                Video.open(trendVid, trend5);
                break;
            default:
                System.out.println("Choose [1 - 5] only 😊");
                trending();
        }
    }

    // add new video for registered user
    public static void addNewVideo(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("🛠 Add New Video");
        System.out.print("Username : ");
        String username = scanner.next();
        System.out.print("Youtube Channel Name : ");
        String youtubeChannelName = scanner.next();
        System.out.print("File name : ");
        String fileName = scanner.next();
        System.out.print("Title : ");
        String titleVideo = scanner.next();
        // method to add user video to the database
        Video.addVideo(username, youtubeChannelName, fileName, titleVideo);

        // Back to Homepage
        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomepageFromAddNewVideo = scanner.next();
        if (answerToHomepageFromAddNewVideo.equals("y")){
            Console.backToHomePage();
        } else if(answerToHomepageFromAddNewVideo.equals("n")) {
            // if n
            // return to that page back
            addNewVideo();
        }
    }

    // Open Video method from choices Page
    public static void openVideo(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("🌈 Watch my Video");
        System.out.print("Username : ");
        String username = scanner.next();

        Video.findVideo(username); // find video from that username in database

        // when the video are list out
        // user need to choose the video from that list to open it
        System.out.print("Choose video to open : ");
        String answer = scanner.next();

        Console.chooseVideoToOpen(answer); // open chosen video

        // like or dislike video
        Console.videoLikeOrDislike(answer); // pass videoTitle name

        System.out.print("Do you want to watch more ? y | n : ");
        String yesOrNo = scanner.next();

        switch (yesOrNo.toLowerCase()){
            case "y":
                System.out.print("Choose video to open : ");
                String vidTitle = scanner.next();
                String filePathName = SQL_Util.findFileForThatVideo(answer);
                Video.open(filePathName, vidTitle);

                // like or dislike video
                Console.videoLikeOrDislike(vidTitle);
                // back to homepage
                System.out.print("Back to Homepage ? y | n : ");
                String answerToHomepageFromOpenVideo = scanner.next();
                if (answerToHomepageFromOpenVideo.equals("y")){
                    Console.backToHomePage();
                } else if(answerToHomepageFromOpenVideo.equals("n")) {
                    // if n
                    // return to that page back
                    openVideo();
                }
                break;
            case "n":
                // Back to Homepage
                Console.backToHomePage();
                break;
            default:
                System.out.println("y | n only 😊");
                openVideo();
        }
    }

    // edit User Account
    public static void editAccount(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("💁 Edit account");
        System.out.print("Username : ");
        String username = scanner.next();
        SQL_Util.userDetails(username); // find user details in database

        // Edit user method
        User.editAcc(username);

        // return new user details
        SQL_Util.userDetails(username);

        System.out.println("");
        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomepageFromEditAcc = scanner.next();
        if (answerToHomepageFromEditAcc.equals("y")){
            Console.backToHomePage();
        } else if(answerToHomepageFromEditAcc.equals("n")) {
            // if n
            // return to that page back
            editAccount();
        }
    }

    // Search page
    public static void search(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("🚀 Search Youtube Channel");
        System.out.println("");

        SQL_Util.displayYoutubeChannelName(); // display all Youtube Channel name

        System.out.println("");
        System.out.print("Choose Youtube Channel to open 💡 : ");
        String answer = scanner.next();
        System.out.println("");

        SQL_Util.displayVideoListFromYoutubeChannel(answer);
        // display all the video from that Youtube Channel

        System.out.println("");
        System.out.print("Choose video to open : ");
        String chooseVid = scanner.next();

        Console.chooseVideoToOpen(chooseVid);
        // choose video to open

        Console.videoLikeOrDislike(chooseVid);
        // like or dislike video

        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomepageFromTrending = scanner.next();
        if (answerToHomepageFromTrending.equals("y")){
            Console.backToHomePage();
        } else if(answerToHomepageFromTrending.equals("n")) {
            // if n
            // return to that page back
            search();
        }
    }

    // About Page
    public static void aboutPage() {
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("🏖 About Yuu-Tube");
        System.out.println("");
        System.out.println("Youtube was created at 31 December 2020 👴");

        SQL_Util.aboutVideoAndUserDatabase();
        // details of video and user database

        System.out.println("");
        System.out.println("OUR TEAM 🏁");
        System.out.println("1️⃣ Asyraf   🧑‍💻");
        System.out.println("2️⃣ Afiq     🧑‍💻");
        System.out.println("3️⃣ Tianyi   👨🏻‍💻");
        System.out.println("4️⃣ Keisava  👨🏻‍💻");
        System.out.println("5️⃣ Arina    👩‍💻");
        System.out.println("");

        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomepageFromAbout = scanner.next();
        if (answerToHomepageFromAbout.equals("y")){
            Console.backToHomePage();
        } else if(answerToHomepageFromAbout.equals("n")) {
            // if n
            // return to that page back
            aboutPage();
        }
    }

    // another video format
    public static void anotherVideoFormat(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("📦 Open another video format");
        System.out.println("");

        Console.anotherFormat();

        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomepageFromAnotherVidFormat = scanner.next();
        if (answerToHomepageFromAnotherVidFormat.equals("y")){
            Console.backToHomePage();
        } else if(answerToHomepageFromAnotherVidFormat.equals("n")) {
            // if n
            // return to that page back
            Console.anotherFormat();

            System.out.print("Back to Homepage ? y | n : ");
            String answerToHomepageFromAnotherVidFormat2 = scanner.next();
            if (answerToHomepageFromAnotherVidFormat2.equals("y")){
                Console.backToHomePage();
            } else if(answerToHomepageFromAnotherVidFormat2.equals("n")) {
                // if n
                // return to that page back
                Console.anotherFormat();
                Console.backToHomePage();
            }
        }
    }
}
