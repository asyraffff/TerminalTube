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
        chooseTrendingVideo(chooseVideo);

        System.out.print("Do you want to watch more ? y | n : ");
        String answer = scanner.next();

        switch (answer.toLowerCase()){
            case "y":
                System.out.print("Please choose [1 - 5] : ");
                chooseTrendingVideo(scanner.nextInt());
                break;
            case "n":
                System.out.print("Back to Homepage ? y | n : ");
                String answerToHomeFromTrendVid = scanner.next();
                Console.backToHomePage(answerToHomeFromTrendVid);
                break;
            default:
                System.out.println("y | n only 😊");
        }
    }

    public static void chooseTrendingVideo(int numberVideo){
        switch (numberVideo){
            case 1:
                Video.open(trendVid, trend1);
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
        }
    }

    public static void choices(){
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("[ 1 ] 🔥 Watch Trending");
        System.out.println("[ 2 ] 🛠 Add New Video");
        System.out.println("[ 3 ] 🌈 Watch my Video");
        System.out.println("[ 4 ] 🚀 Search Youtube Channel");
        System.out.println("[ 5 ] 💁 Edit account");
        System.out.println("[ 6 ] 🏖 About Yuu-Tube");
        System.out.println("[ 7 ] 😔 Log Out");
        System.out.println("");
        System.out.print("Please choose [1 - 6] : ");
    }

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
        Video.addVideo(username, youtubeChannelName, fileName, titleVideo);

        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomeFromWatchAddVideo = scanner.next();
        Console.backToHomePage(answerToHomeFromWatchAddVideo);
    }

    public static void openVideo(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("🌈 Watch my Video");
        System.out.print("Username : ");
        String username = scanner.next();
        Video.findVideo(username);
        System.out.print("Choose video to open : ");
        String answer = scanner.next();
        String filePath = SQL_Util.findFileForThatVideo(answer);
        Video.open(filePath, answer);

        System.out.print("Do you want to watch more ? y | n : ");
        String yesOrNo = scanner.next();

        switch (yesOrNo.toLowerCase()){
            case "y":
                System.out.print("Choose video to open : ");
                String vidTitle = scanner.next();
                String filePathName = SQL_Util.findFileForThatVideo(answer);
                Video.open(filePathName, vidTitle);

                System.out.print("Back to Homepage ? y | n : ");
                String answerToHomeFromWatchAgainVideo = scanner.next();
                Console.backToHomePage(answerToHomeFromWatchAgainVideo);
                break;
            case "n":
                System.out.print("Back to Homepage ? y | n : ");
                String answerToHomeFromOpenVideo = scanner.next();
                Console.backToHomePage(answerToHomeFromOpenVideo);
                break;
            default:
                System.out.println("y | n only 😊");
        }
    }

    public static void editAccount(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("💁 Edit account");
        System.out.print("Username : ");
        String username = scanner.next();
        SQL_Util.userDetails(username);
        System.out.print("What do you want to edit ? : ");
        String answer = scanner.next();
        switch (answer.toLowerCase()){
            case "username":
                System.out.println("");
                System.out.print("New Username : ");
                String newUsername = scanner.next();
                SQL_Util.editUsername(username, newUsername);
                break;
            case "email":
                System.out.println("");
                System.out.print("New Email : ");
                String newEmail = scanner.next();
                String oldEmail = SQL_Util.getEmail(username);
                SQL_Util.editEmail(oldEmail, newEmail);
                break;
            case "password":
                System.out.println("");
                System.out.print("New Password : ");
                String newPass = scanner.next();
                String oldPass = SQL_Util.getPassword(username);
                SQL_Util.editPassword(oldPass, newPass);
                break;
            case "video":
                System.out.println("");
                System.out.print("Username : ");
                String name = scanner.next();
                int userId = SQL_Util.getUid(name);
                SQL_Util.returnUserVideo(userId);
                System.out.println("");
                System.out.print("Do you want to delete video ? [y / n] : ");
                String answerForDeleteVideo = scanner.next();
                switch (answerForDeleteVideo.toLowerCase()){
                    case "y":
                        System.out.print("Choose video to delete : ");
                        String videoName = scanner.next();
                        Video.delete(videoName);
                        break;
                    case "n":
                        System.out.print("Back to Homepage ? y | n : ");
                        String answerToHome = scanner.next();
                        Console.backToHomePage(answerToHome);
                        break;
                    default:
                        System.out.println("y or n only 😊");
                }
                break;
            default:
                System.out.println("Choose [username / email / password] only 😊");
        }
        SQL_Util.userDetails(username);

        System.out.println("");
        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomeFromEditAcc = scanner.next();
        Console.backToHomePage(answerToHomeFromEditAcc);
    }

    public static void search(){
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("🚀 Search Youtube Channel");
        System.out.println("");
        SQL_Util.displayYoutubeChannelName();
        System.out.println("");
        System.out.print("Choose Youtube Channel to open 💡 : ");
        String answer = scanner.next();
        System.out.println("");
        SQL_Util.displayVideoListFromYoutubeChannel(answer);
        System.out.println("");
        System.out.print("Choose video to open : ");
        String chooseVid = scanner.next();
        String filePath = SQL_Util.findFileForThatVideo(chooseVid);
        Video.open(filePath, chooseVid);

        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomeFromSearch = scanner.next();
        Console.backToHomePage(answerToHomeFromSearch);
    }

    public static void aboutPage() {
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("🏖 About Yuu-Tube");
        System.out.println("");
        System.out.println("Youtube was created at 31 December 2020 👴");
        SQL_Util.aboutVideoAndUserDatabase();
        System.out.println("");
        System.out.println("OUR TEAM 🏁");
        System.out.println("1️⃣ Asyraf   🧑‍💻");
        System.out.println("2️⃣ Afiq     🧑‍💻");
        System.out.println("3️⃣ Tianyi   👨🏻‍💻");
        System.out.println("4️⃣ Keisava  👨🏻‍💻");
        System.out.println("5️⃣ Arina    👩‍💻");
        System.out.println("");
        System.out.print("Back to Homepage ? y | n : ");
        String answerToHomeFromAbout = scanner.next();
        Console.backToHomePage(answerToHomeFromAbout);
    }
}
