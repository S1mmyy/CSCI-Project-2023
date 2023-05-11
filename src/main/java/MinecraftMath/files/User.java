package MinecraftMath.files;

public class User {
    private String name;
    private int grade, avatarNum, questionSet;

    private double[] gradeScores;
    private double sectionPoints = 0.0;

    public User(String newName, int newGrade, int newAvatarNum, int newQuestionSet, double[] newGradeScores) {
        name = newName;
        grade = newGrade;
        avatarNum = newAvatarNum;
        questionSet = newQuestionSet;
        gradeScores = newGradeScores;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAvatarNum() {
        return avatarNum;
    }
    public void setAvatarNum(int avatarNum) {
        this.avatarNum = avatarNum;
    }

    public int getQuestionSet() { return questionSet; }
    public void setQuestionSet(int questionSet) { this.questionSet = questionSet; }

    public double[] getGradeScore() {
        return gradeScores;
    }
    public void setGradeScore(double[] gradeScores) {
        this.gradeScores = gradeScores;
    }

    public void setSectionPoints(int sectionPoints) {
        this.sectionPoints = sectionPoints;
    }

    public double getSectionPoints() { return sectionPoints; }

    public void addSectionPoints(){
         sectionPoints = sectionPoints+10;

    }

    public void incQuestionSet() {
        questionSet++;
    }

    public void incUserGrade() {
        grade++;
    }

    public void resetQuestionSet() {
        questionSet=1;
    }
}
