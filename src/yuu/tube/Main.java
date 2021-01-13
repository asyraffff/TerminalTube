package yuu.tube;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // front page
        FrontPage.hi();

        // SignUp or Login function
        Scanner sc = new Scanner(System.in); // scan for user answer
        String answer = sc.next(); // s or l
        Console.signupOrLogin(answer);

        // Choices page
        int userChoose = sc.nextInt(); // get the user choose page input
        Console.choose(userChoose);

    }
}


