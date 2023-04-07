package MinecraftMath.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("Title.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("LandingPage.fxml"));
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        // Load root elements of each scene
        Parent root1 = loader1.load();
        Parent root2 = loader2.load();
        Parent root3 = loader3.load();

        // Get controllers for each scene
        Scene1Controller controller1 = loader1.getController();
        Scene2Controller controller2 = loader2.getController();
        Scene3Controller controller3 = loader3.getController();

        // Create scenes
        Scene scene1 = new Scene(root1);
        Scene scene2 = new Scene(root2);
        Scene scene3 = new Scene(root3);

        // Set controllers for each scene
        controller1.setScene(scene2);
        controller2.setScene(scene3);
        controller3.setScene(scene1);

        // Set initial scene
        primaryStage.setScene(scene1);

        // Show stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}