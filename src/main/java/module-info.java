module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens MinecraftMath.demo to javafx.fxml;
    exports MinecraftMath.demo;
}