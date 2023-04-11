package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainSceneController {

    private final int correctAnswer = 4;
    private int submittedAnswer;

    @FXML
    private Button submitButton;
    @FXML
    private Button learnButton;

    @FXML
    private MenuButton answerMenu;
    @FXML
    private MenuItem option1, option2, option3, option4;
    @FXML
    private Label resultLabel;

    @FXML
    private void exitAction(){
        System.exit(1);
    }

    @FXML
    private void learnAction () throws Exception {
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
    @FXML
    private void submitAnswer()
    {
        submittedAnswer = Integer.parseInt(answerMenu.getText());
        if (submittedAnswer == correctAnswer)
            correctAnswerGiven();
        else
            incorrectAnswerGiven();
    }
    @FXML
    private void resetScene()
    {
        submitButton.setDisable(true);
        answerMenu.setDisable(false);
        answerMenu.setText("Select answer");
        resultLabel.setText("");
    }
    @FXML
    private void selectAnswer1()
    {
        answerMenu.setText(option1.getText());
        submitButton.setDisable(false);
    }
    @FXML
    private void selectAnswer2()
    {
        answerMenu.setText(option2.getText());
        submitButton.setDisable(false);
    }
    @FXML
    private void selectAnswer3()
    {
        answerMenu.setText(option3.getText());
        submitButton.setDisable(false);
    }
    @FXML
    private void selectAnswer4()
    {
        answerMenu.setText(option4.getText());
        submitButton.setDisable(false);
    }

    @FXML
    private void correctAnswerGiven()
    {
        resultLabel.setText("Correct!");
        resultLabel.setTextFill(Paint.valueOf("green"));
        answerMenu.setDisable(true);
    }
    @FXML
    private void incorrectAnswerGiven()
    {
        resultLabel.setText("Incorrect.");
        resultLabel.setTextFill(Paint.valueOf("red"));
    }
}