package MinecraftMath.files;

import java.text.MessageFormat;

public class User {
    private String name;
    private int grade, avatarNum;

    public User(String newName, int newGrade, int newAvatarNum) {
        name = newName;
        grade = newGrade;
        avatarNum = newAvatarNum;
    }

    public void printUser() {
        System.out.println(MessageFormat.format("Name: {0}\nGrade: {1}\nAvatarNum: {2}", name, grade, avatarNum));
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
}
