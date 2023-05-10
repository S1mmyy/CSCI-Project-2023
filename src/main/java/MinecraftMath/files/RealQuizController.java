package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class RealQuizController extends MasterController {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserDataOntoScene();
        questionList = 0;
        try {
            generateQuestion();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private int questionList = 1;
    private int correctAnswer = 49;
    private int submittedAnswer;

    private int sectionPoints = 0;

    @FXML
    private Button submitButton;
    @FXML
    private Label questionListCount;
    @FXML
    private Label gradeDisplay;
    @FXML
    private Button questionGenerator;
    @FXML
    private Button resultsButton;
    @FXML
    private MenuButton answerMenu;
    @FXML
    private MenuItem option1, option2, option3, option4;
    @FXML
    private Label resultLabel;
    @FXML
    private ImageView questionVisual;

    @FXML
    private void submitAnswer()
    {
        Question question = new Question();

        //TRUE OR FALSE QUESTION CHECKER
        if(!question.isMultipleChoice){
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
        sectionPoints += 10;
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
        System.out.println(sectionPoints); //MODIFY CODE TO INCLUDE THIS INTO THE DATABASE
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
    public void generateQuestion() throws IOException {
        gradeDisplay.setText("Grade "+userHolder.getUser().getGrade()+" Section IMPLEMENT GET SECTION");
        Arithmetic arm = new Arithmetic(userHolder.getUser().getGrade());
        questionList++;
        questionListCount.setText(questionList + " out of 10");
        if(questionList > 10){
            goResults();

            //INCREASE USER QUESTION SET PER GRADE, OR INCREASE GRADE LEVEL IF QUESTION SET IS HIGHER THAN 3
        }
        resultLabel.setText("");
        questionGenerator.setDisable(true);
        answerMenu.setDisable(false);
        submitButton.setDisable(true);
        answerMenu.setText("Select answer");

        questionBox.setText(arm.getQuestion(userHolder.getUser().getGrade(),2));
        //RENAME QUESTION SET TO BE ACTUAL VALUE
        correctAnswer = arm.getAnswer();
        Random rightAns = new Random();

        option1.setText(String.valueOf((arm.getAnswer()-1)));
        option2.setText(String.valueOf((arm.getAnswer()+1)));
        option3.setText(String.valueOf((arm.getAnswer()+2)));
        option4.setText(String.valueOf((arm.getAnswer()-2)));

        switch (rightAns.nextInt(4)) {
            case 0 -> option1.setText(String.valueOf(arm.getAnswer()));
            case 1 -> option2.setText(String.valueOf(arm.getAnswer()));
            case 2 -> option3.setText(String.valueOf(arm.getAnswer()));
            case 3 -> option4.setText(String.valueOf(arm.getAnswer()));
        }



    }
    @FXML
    public void setVisual(Image image){

        questionVisual.setImage(image);

    }
}
