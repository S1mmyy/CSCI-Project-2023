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
import java.util.Random;

public class RealQuizController {
    private int correctAnswer = 49;
    private int submittedAnswer;


    @FXML
    private void exitAction(){
        System.exit(1);
    }
    public Button resetSceneButton;
    @FXML
    private Button submitButton;
    @FXML
    private Button landingButton;
    @FXML
    private Button resultsButton;
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
    private void resetScene() // Remove this method entirely, we don't need to reset the question attempts if the user is taking a test.
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

    @FXML
    public void goResults() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) resultsButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Results.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }




    @FXML
    private Label questionBox;
    @FXML
    public void generateQuestion(){
        Arithmetic arm = new Arithmetic('4');
        questionBox.setText(arm.getQuestion());
        correctAnswer = arm.getAnswer();
        Random rightAns = new Random();

        option1.setText("1");
        option2.setText("2");
        option3.setText("3");
        option4.setText("4");

        switch(rightAns.nextInt(4)) {
            case 0:
                option1.setText(String.valueOf(arm.getAnswer()));
                break;
            case 1:
                option2.setText(String.valueOf(arm.getAnswer()));
                break;
            case 2:
                option3.setText(String.valueOf(arm.getAnswer()));
                break;
            case 3:
                option4.setText(String.valueOf(arm.getAnswer()));
                break;
        }
    }


    @FXML
    public void goLanding() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) landingButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
}
