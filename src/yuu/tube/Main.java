package yuu.tube;

import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // front page
        FrontPage.hi();

        // SignUp or Login function
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        Console.signupOrLogin(answer);

        // Choices page
        int userChoose = sc.nextInt();
        Console.choose(userChoose);

    }
}


