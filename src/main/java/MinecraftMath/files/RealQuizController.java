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
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class RealQuizController extends MasterController {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserDataOntoScene();
        questionList = 0;
        try {
            generateQuestion();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private int questionList = 1;
    private int correctAnswer = 49;
    private int submittedAnswer;

    private double sectionPoints = 0.0;

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
    public void goResults() throws IOException, SQLException {
        System.out.println(sectionPoints);

        String updateUserSet = "UPDATE user_account SET question_set = " + (userHolder.getUser().getQuestionSet() + 1) + " WHERE name = '" + userHolder.getUser().getName() + "'";
        String updateUserGrade = "UPDATE user_account SET grade = " + (userHolder.getUser().getGrade() + 1) + " WHERE name = '" + userHolder.getUser().getName() + "'";
        String resetUserSet = "UPDATE user_account SET question_set = " + 1 + " WHERE name = '" + userHolder.getUser().getName() + "'";
        String userGradeCap = "UPDATE user_account SET grade = " + 5 + " WHERE name = '" + userHolder.getUser().getName() + "'";
        String updateUserScore = "";

        if(userHolder.getUser().getGrade() == 0){
            updateUserScore = "UPDATE user_account SET grade_score_k = " + (Math.round((sectionPoints/3) * 10.0) / 10.0) + " WHERE name = '" + userHolder.getUser().getName() + "'";
        }else{
            updateUserScore = "UPDATE user_account SET grade_score_"+userHolder.getUser().getGrade()+" = " + (Math.round((sectionPoints/3) * 10.0) / 10.0) + " WHERE name = '" + userHolder.getUser().getName() + "'";
        }


        statement = connectDB.createStatement();
        statement.executeUpdate(updateUserSet);

        statement.executeUpdate(updateUserScore);


        userHolder.getUser().incQuestionSet();

        if(userHolder.getUser().getQuestionSet() > 3){
            statement.executeUpdate(updateUserGrade);
            userHolder.getUser().resetQuestionSet();
            statement.executeUpdate(resetUserSet);
            userHolder.getUser().incUserGrade();
            if(userHolder.getUser().getGrade() > 4){
                //IMPLEMENT CONGRATS SCREEN  and  MINIGAME
                userHolder.getUser().setGrade(5);
                statement.executeUpdate(userGradeCap);
            }
        }

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
    public void generateQuestion() throws IOException, SQLException {
        gradeDisplay.setText("Grade "+userHolder.getUser().getGrade()+" Section "+userHolder.getUser().getQuestionSet());
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

        questionBox.setText(arm.getQuestion(userHolder.getUser().getGrade(),userHolder.getUser().getQuestionSet()));
        System.out.println("QUESTION SET "+userHolder.getUser().getQuestionSet());
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
