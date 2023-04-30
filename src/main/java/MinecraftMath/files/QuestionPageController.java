package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuestionPageController extends MasterController {
    private final int correctAnswer = 30;
    private int submittedAnswer;

    @FXML
    public Button resetSceneButton;
    @FXML
    private Button submitButton;
    @FXML
    private Button beginTestButton;
    @FXML
    private MenuButton answerMenu;
    @FXML
    private MenuItem option1, option2, option3, option4;
    @FXML
    private Label resultLabel;

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
    @FXML
    public void beginTest() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) beginTestButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RealQuiz.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserDataOntoScene();
    }
}
