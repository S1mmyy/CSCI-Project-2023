package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LandingPageController extends MasterController {
    @FXML
    private Label gradeLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loadUserDataOntoScene();
        if(userHolder.getUser().getGrade() < 1){
            gradeLabel.setText("Grade K Section "+userHolder.getUser().getQuestionSet());
        }else{
            gradeLabel.setText("Grade "+userHolder.getUser().getGrade()+" Section "+userHolder.getUser().getQuestionSet());
        }

    }

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
}