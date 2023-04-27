module MinecraftMath {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.json;

    opens MinecraftMath.files to javafx.fxml;
    exports MinecraftMath.files;
}