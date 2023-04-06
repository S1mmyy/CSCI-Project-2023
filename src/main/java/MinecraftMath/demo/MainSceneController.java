package MinecraftMath.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;

public class MainSceneController {

    private final int correctAnswer = 4;
    private int submittedAnswer;

    @FXML
    private Button submitButton;
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
}