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

            databaseLink = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com:3306/sql9616894", "sql9616894", "0wls");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
