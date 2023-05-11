package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController extends MasterController {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserDataOntoScene();
    }

    @FXML
    private Button landingButton;
    @FXML
    private Button snakeButton;
    @FXML
    private void openSnake() throws Exception {
        Snake snake = new Snake();
        snake.openSnake();
    }

    @FXML
    private void goLanding() throws Exception {
        Stage stage;
        Parent root;


        stage = (Stage) landingButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
