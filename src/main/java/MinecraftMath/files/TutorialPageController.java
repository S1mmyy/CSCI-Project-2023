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
        loadUserDataOntoScene();
        loadYouTubeEmbed();
    }

    // Determines which youtube video to load depending on the progress the student has made
    private void loadYouTubeEmbed() {
        String videoEmbedCode = "";
        int userGrade = userHolder.getUser().getGrade();
        int userCurrSet = userHolder.getUser().getQuestionSet();
        switch (userGrade) {
            case 0, 1: {
                switch (userCurrSet) {
                    case 1 -> videoEmbedCode = "zU5LwvJJt5Y";
                    case 2 -> videoEmbedCode = "zJyT6MIlkAw";
                    case 3 -> videoEmbedCode = "wH6JiePHdwA";
                }
            }
            case 2, 3: {
                switch (userCurrSet) {
                    case 1 -> videoEmbedCode = "cE-yrJv4TEs";
                    case 2 -> videoEmbedCode = "i31rRt5m1-4";
                    case 3 -> videoEmbedCode = "10dTx1Zy_4w";
                }
            }
            case 4: {
                switch (userCurrSet) {
                    case 1 -> videoEmbedCode = "dATl8pFPDbw";
                    case 2 -> videoEmbedCode = "oyYUbvcxWqg";
                    case 3 -> videoEmbedCode = "2UmbdX8iMqI";
                }
            }

        }
        youtubeEmbedView.getEngine().load("https://www.youtube.com/embed/" + videoEmbedCode);
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
