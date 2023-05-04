module MinecraftMath {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.java;

    opens MinecraftMath.files to javafx.fxml;
    exports MinecraftMath.files;
}