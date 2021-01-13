package yuu.tube;

import java.util.Scanner;

public class User {
    private static Scanner scanner = new Scanner(System.in);

    public static void signUp(String username, String email, String password, String twoFACode){
        // initiate the connection with the database
        SQL_Util.initConnection();
        SQL_Util.addUser(username, email, password, twoFACode);
    }

    public static void logIn(String email, String password){
        // initiate the connection with the database
        SQL_Util.initConnection();
        SQL_Util.isSignedUp(email, password);
    }

    public static void editAcc(String oldUsername){
        System.out.print("What do you want to edit ? : ");
        String answer = scanner.next();

        switch (answer.toLowerCase()){
            case "username":
                System.out.println("");
                System.out.print("New Username : ");
                String newUsername = scanner.next(); // new username
                SQL_Util.editUsername(oldUsername, newUsername);
                // edit username in database with passing the old and new username
                break;
            case "email":
                System.out.println("");
                System.out.print("New Email : ");
                String newEmail = scanner.next(); // new email
                String oldEmail = SQL_Util.getEmail(oldUsername); // get the old email from database from that username
                SQL_Util.editEmail(oldEmail, newEmail);
                // edit email in database with passing the old and new email
                break;
            case "password":
                System.out.println("");
                System.out.print("New Password : ");
                String newPass = scanner.next(); // new password
                String oldPass = SQL_Util.getPassword(oldUsername); // get the old pass from database with that username
                SQL_Util.editPassword(oldPass, newPass);
                // edit user password with passing the old and new pass
                break;
            case "video":
                System.out.println("");
                System.out.println("Video : ");

                int userId = SQL_Util.getUid(oldUsername); // get the user id from that username
                SQL_Util.returnUserVideo(userId); // return user video from that user id

                System.out.println("");
                // Delete video
                Console.deleteVideo();
                break;
            default:
                System.out.println("Choose [username / email / password] only 😊");
        }
    }
}
