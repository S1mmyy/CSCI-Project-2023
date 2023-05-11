package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController extends MasterController {
    @FXML
    private Label resultsText;

    @FXML
    private Button snakeButton;
    @FXML
    private ImageView eggImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadUserDataOntoScene();

        resultsText.setText("Results! \nYou received a total score of "+userHolder.getUser().getGradeScore()+"%");

        if(userHolder.getUser().getGradeScore() > 85){

            snakeButton.setVisible(true);
            eggImage.setVisible(true);

        }
    }

    @FXML
    private Button landingButton;

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
