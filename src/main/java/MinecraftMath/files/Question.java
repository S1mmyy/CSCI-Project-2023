package MinecraftMath.files;

public class Question {

    static char grade;
    static int difficultyLevel = 0;


    //Possible values, "mc" for Multiple Choice.   "tf" for True or False.
    static String questionType = "tf";

    static String isTrue = "True";

    public String getIsTrue(){
        return isTrue;
    }
    static String answer;

    public String getQuestionType(){

        return questionType;
    }
    public Question() {

    }
}
