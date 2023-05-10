module MinecraftMath {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.java;
    requires java.desktop;

    opens MinecraftMath.files to javafx.fxml;
    exports MinecraftMath.files;
}