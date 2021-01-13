package yuu.tube;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class sendHTMLEmail
{
    public static void send(String recipient, String twoFACode){
        String to = recipient;//change accordingly
        String from = "yuutubeproject@gmail.com";//change accordingly
        String host = "smtp.gmail.com";//or IP address

        //Get the session object
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("yuutubeproject@gmail.com", "zrunrsmabfzbpmwb");

            }

        });

        //compose the message
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping 🔥 | your 2FA Code 😊");

            message.setText("Hello, this is your 2FA Code : " + twoFACode + "\n\nHave fun 🥳");

            // Send message
            Transport.send(message);

        }catch (MessagingException mex) {mex.printStackTrace();}
    }
}