package yuu.tube;

public class User {

    public static void signUp(String username, String email, String password){
        SQL_Util.initConnection();
        SQL_Util.addUser(username, email, password);
    }

    public static void logIn(String email, String password){
        SQL_Util.initConnection();
        SQL_Util.isSignedUp(email, password);
    }
}
