package yuu.tube;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

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

                User.signUp(username, emailSignUp, passSignUp);

                System.out.println("\n  🥳 Welcome to the Yuu-Tube " + username + " 🥳");
                System.out.println("");
                FrontPage.choices();
                break;

            case "l":
                System.out.println("\nGreat 🚀");
                System.out.print("Email : ");
                String emailLogIn = scanner.next();
                System.out.print("Password : ");
                String passLogIn = scanner.next();

                User.logIn(emailLogIn, passLogIn);

                FrontPage.choices();
                break;
            default:
                System.out.print("\n🚨 S or L word only 🚨 : ");
                String answerAgain = scanner.next();
                signupOrLogin(answerAgain);
        }
    }

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
                FrontPage.editAccount();
                break;
            case 6:
                FrontPage.aboutPage();
                break;
            case 7:
                System.out.println("");
                System.out.println("Bye Bye 👋");
                break;
            default:
                System.out.println("Choose [1 - 6] only 😊");
        }
    }

    public static void backToHomePage(String answer){
        if (answer.equals("y")){
            FrontPage.choices();
            int userChoose = scanner.nextInt();
            choose(userChoose);
        }
    }
}
