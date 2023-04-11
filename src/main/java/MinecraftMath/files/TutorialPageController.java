package MinecraftMath.files;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class TutorialPageController {
    public WebView webView;
    public AnchorPane anchorPane;
    public Button endTutButton;

    public void startPractice() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) endTutButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("QuestionPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
