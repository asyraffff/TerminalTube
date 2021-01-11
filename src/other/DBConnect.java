package other;

import java.sql.*;

public class DBConnect {
    public static void main(String[] args) {
        try {
            String host = "jdbc:mysql://localhost:3306/user";
            String uName = "root";
            String uPass = "tropika17";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from user.users";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int id_cool = rs.getInt("ID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String create_time = rs.getString("create_time");

                String p = id_cool + " " + username + " " + email + " " + password + " " + create_time;
                System.out.println(p);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
