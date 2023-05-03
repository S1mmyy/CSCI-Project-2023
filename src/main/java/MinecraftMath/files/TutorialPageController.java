package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TutorialPageController extends MasterController {
    @FXML
    private WebView youtubeEmbedView;
    @FXML
    private Button endTutButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        youtubeEmbedView.getEngine().load("https://www.youtube.com/embed/8cz_IB65pZM");
        loadUserDataOntoScene();
    }

    public void startPractice() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) endTutButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("QuestionPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
