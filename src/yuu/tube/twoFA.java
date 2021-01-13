package yuu.tube;

import java.util.Random;

public class twoFA {
    // generate 2fa code
    public static String generateCode() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static void compare(String email,String password, String userTwoFACode){
        SQL_Util.initConnection();
        String fromDatabase = SQL_Util.getTwoFACodeFromUser(email);

        if(userTwoFACode.equals(fromDatabase)){
            User.logIn(email, password); // Log In

            FrontPage.choices(); // Choices Page
        } else {
            Console.logIn();
        }
    }
}
