package MinecraftMath.files;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Minecraft Math!");
        Font.loadFont(MainApplication.class.getResource("MinecraftFont.otf").toExternalForm(), 10);


        stage.setScene(scene);
        stage.show();




    }

    public static void main(String[] args) {
        launch();
    }
}