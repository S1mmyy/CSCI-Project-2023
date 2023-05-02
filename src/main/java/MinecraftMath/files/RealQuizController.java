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
    private Button submitButton;
    @FXML
    private Button questionGenerator;
    @FXML
    private Button landingButton;
    @FXML
    private Button resultsButton;
    @FXML
    private MenuButton answerMenu;
    @FXML
    private MenuItem option1, option2, option3, option4;
    @FXML
    private Label resultLabel;

    @FXML
    private void submitAnswer()
    {
        Question question = new Question();

        //TRUE OR FALSE QUESTION CHECKER
        if(question.getQuestionType().equals("tf")){
            if(question.getIsTrue().equals("True") && answerMenu.getText().equals("True") || question.getIsTrue().equals("False") && answerMenu.getText().equals("False")){
                correctAnswerGiven();
            }else{
                incorrectAnswerGiven();

            }
        //MULTIPLE CHOICE QUESTION CHECKER
        }else{
            submittedAnswer = Integer.parseInt(answerMenu.getText());
            if (submittedAnswer == correctAnswer)
                correctAnswerGiven();
            else
                incorrectAnswerGiven();
        }

        submitButton.setDisable(true);
        questionGenerator.setDisable(false);

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
        answerMenu.setDisable(true);
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
        resultLabel.setText("");
        questionGenerator.setDisable(true);
        answerMenu.setDisable(false);
        submitButton.setDisable(true);
        answerMenu.setText("Select answer");

        questionBox.setText(arm.getQuestion());
        correctAnswer = arm.getAnswer();
        Random rightAns = new Random();

        option1.setText(String.valueOf((arm.getAnswer()-1)));
        option2.setText(String.valueOf((arm.getAnswer()+1)));
        option3.setText(String.valueOf((arm.getAnswer()+2)));
        option4.setText(String.valueOf((arm.getAnswer()-2)));

        if(arm.getQuestionType().equals("mc")){
            option3.setVisible(true);
            option4.setVisible(true);
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
        }else{
            option3.setVisible(false);
            option4.setVisible(false);

            option1.setText("True");
            option2.setText("False");


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

    @FXML
    private void exitAction(){
        System.exit(1);
    }
}
