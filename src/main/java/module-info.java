module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens MinecraftMath.files to javafx.fxml;
    exports MinecraftMath.files;
}