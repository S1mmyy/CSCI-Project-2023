package MinecraftMath.files;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //read database password from untracked file
            URL fileUrl = getClass().getResource("/MinecraftMath/assets/dbpw.txt");
            File txtFile = new File((fileUrl.getPath()));
            Scanner sc = new Scanner(txtFile);

            databaseLink = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com:3306/sql9616894", "sql9616894", sc.next());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            e.getCause();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't login to database without password!");
        }
        return databaseLink;
    }
}
