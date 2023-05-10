package MinecraftMath.files;

public class Question {

    static char grade;
    static int difficultyLevel = 0;


    //Possible values, "true" for Multiple Choice.   "false" for True or False.
    static boolean isMultipleChoice = true;

    static String isTrue = "True";

    public String getIsTrue(){
        return isTrue;
    }
    static String answer;

    public boolean getIsMultipleChoice(){

        return isMultipleChoice;
    }
    public Question() {

    }
}
