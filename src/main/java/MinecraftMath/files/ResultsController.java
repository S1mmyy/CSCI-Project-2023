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

    private int newGrade = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadUserDataOntoScene();

        if(userHolder.getUser().getQuestionSet() == 3){
            newGrade = ((int) userHolder.getUser().getSectionPoints()/2);

        } else if (userHolder.getUser().getQuestionSet() == 4) {
            newGrade = ((int) userHolder.getUser().getSectionPoints()/3);
        }else{
            newGrade = ((int) userHolder.getUser().getSectionPoints());
        }


        resultsText.setText("Results! \nYou received a \ntotal score of \n"+newGrade+"%");

        if(newGrade > 80){


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
