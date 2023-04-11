package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class LandingPageController {

    @FXML
    private Button learnButton;

    @FXML
    private void exitAction(){
        System.exit(1);
    }

    @FXML
    private void learnAction() throws Exception {
        Stage stage;
        Parent root;

        stage = (Stage) learnButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TutorialPage.fxml"));

        WebView webView = new WebView();
        webView.getEngine().load("https://www.youtube.com/embed/8cz_IB65pZM");

        AnchorPane anchorPane = (AnchorPane) root.lookup("#anchorPane");
        anchorPane.getChildren().add(webView);
        AnchorPane.setTopAnchor(webView, 110.0);
        AnchorPane.setRightAnchor(webView, 200.0);
        AnchorPane.setLeftAnchor(webView, 190.0);
        AnchorPane.setBottomAnchor(webView, 80.0);

        stage.setScene(new Scene(root));
        stage.show();
    }
}