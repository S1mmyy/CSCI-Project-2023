package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LandingPageController {

    @FXML
    private Button learnButton;

    @FXML
    private void learnAction() throws Exception {
        Stage stage;
        Parent root;

        stage = (Stage) learnButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TutorialPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void exitAction(){
        System.exit(1);
    }
}