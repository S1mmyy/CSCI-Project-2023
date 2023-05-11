package MinecraftMath.files;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;
import java.util.Scanner;

public class Arithmetic extends Question{

    static int a,b;

    static char operation;
    static int answer;
    static Random ran = new Random();
    static char [] ops = {'+','-','*','/'};
    static char actualOp;

    static int wrongOption1,wrongOption2,wrongOption3;



    static int p,q;

    public Arithmetic(int grade, int questionSet)
    {

        if(grade==0  || grade ==1)
        {
            switch (questionSet) {

                case 1:
                    a = ran.nextInt(11);
                    b = ran.nextInt(11);
                    isMultipleChoice = true;
                    operation = ops[0];
                    break;
                case 2:
                    isMultipleChoice = true;
                    a = ran.nextInt(21)+9;
                    b = ran.nextInt(9);
                    operation = ops[ran.nextInt(2)];
                    break;
                case 3:

                    isMultipleChoice = false;
                    //a = ran.nextInt(7);
                    setAnswer(3);

                    break;

            }

        }

        else if(grade == 2 || grade==3)
        {

            switch (questionSet) {

                case 1:
                    isMultipleChoice = true;
                    a = ran.nextInt(101);
                    b = ran.nextInt(101);
                    operation = ops[0];
                    break;
                case 2:
                    isMultipleChoice = true;
                    a = ran.nextInt(21);
                    b = ran.nextInt(21);
                    operation = ops[2];
                    break;
                case 3:
                    isMultipleChoice = false;

                    setAnswer(6);
                    break;
            }
        }
/*
        else if(grade==3)
        {
            a=ran.nextInt(5001);
            b=ran.nextInt(5001);
            operation = ops[ran.nextInt(3)];
        }*/

        else if(grade==4)
        {

            switch (questionSet) {

                case 1:
                    isMultipleChoice = true;
                    p = ran.nextInt(202);
                    q = ran.nextInt(12);
                    a = p;
                    b = q;
                    operation = ops[ran.nextInt(3)+1];
                    break;
                case 2:
                    isMultipleChoice = false;
                    p = ran.nextInt(202);
                    q = ran.nextInt(12);
                    a = p;
                    b = q;
                    operation = ops[ran.nextInt(3)+1];
                    break;

                case 3:
                    isMultipleChoice = false;
                    setAnswer(5);
                    break;
            }

        }


        actualOp = operation;

        if(actualOp == '+') {

            answer = a + b;
        }
        if(actualOp == '-') {

            answer = a - b;

        }
        if(actualOp == '*') {

            answer = a * b;

        }

        if(actualOp == '/'){

            a = p*q;

            b = q;

            answer = p;
            wrongOption1 = a+b;
            wrongOption2 = a/b;
            wrongOption3 = a-b;
        }

    }
/*
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What grade are you in?");
        grade = sc.next().charAt(0);
        Arithmetic question = new Arithmetic(grade);
        System.out.println(question.getQuestion());
        int userAnswer = sc.nextInt();
        System.out.println(question.getAnswer());
        if(userAnswer == question.getAnswer())
            System.out.println("correct!");
        else
            System.out.println("incorrect");

    }*/


    public String getQuestion(int grade, int questionSet)
    {

        String question = "Congrats! You did it all";
        if(grade == 0 || grade == 1){
            switch (questionSet) {
                case 1:
                    question = "What is " + a + " " + operation + " " + b + " equal to?";
                    break;
                case 2:
                    question = "What is " + a + " " + operation + " " + b + " equal to?";
                    break;
                case 3:
                        if(ran.nextInt(4) == 1) {
                            setAnswer(3);
                            question = "Does a triangle have "+ answer +" sides?";
                            isTrue = "True";

                        }else {
                            setAnswer(5);
                            question = "Does a triangle have "+ (ran.nextInt(8)+4) +" sides?";
                            isTrue = "False";
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
        if(grade == 2 || grade == 3){

            switch (questionSet) {
                case 1:
                    question = "Steve has a grind of iron \nthat is " + a + operation + b + " blocks. \nHow many blocks does he \nhave in total?";
                    break;
                case 2:
                    question = "Steve has a grind of iron \nthat is " + a + " by " + b + " blocks. \nHow many blocks does he \nhave in total?";
                    break;
                case 3:
                    if(ran.nextInt(4) == 1) {
                        setAnswer(6);
                        question = "Does a hexagon have "+ answer +" sides?";
                        isTrue = "True";

                    }else {
                        setAnswer(4);
                        question = "Does a hexagon have "+ (ran.nextInt(8)+6) +" sides?";
                        isTrue = "False";
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        if(grade == 4){

            switch (questionSet) {
                case 1:
                    question = "What is " + a + " " + operation + " " + b + " equal to?";
                    break;
                case 2:
                    if(isMultipleChoice){
                        question = "What is " + a + " " + operation + " " + b + " equal to?";
                      //  isMultipleChoice = false;
                    }
                    if (!isMultipleChoice){
                        if(ran.nextInt(2) == 1) {
                            question = "Is " + a + " " + operation + " " + b +" = "+ answer +" ?";
                            isTrue = "True";

                        }else {
                            int incorr = b+1;
                            question = "Is " + a + " " + operation + " " + incorr + " = " + answer + " ?";
                            isTrue = "False";
                        }
                      //  isMultipleChoice = true;

                    }
                    break;
                case 3:
                    if(ran.nextInt(4) == 1) {
                        setAnswer(5);
                        question = "Does a pentagon have "+ answer +" sides?";
                        isTrue = "True";

                    }else {
                        setAnswer(3);
                        question = "Does a pentagon have "+ (ran.nextInt(8)+5) +" sides?";
                        isTrue = "False";
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        }

        return question;
    }

    public int getAnswer()
    {
        if(isMultipleChoice){
            return answer;
        }else{

        }
        return answer;
    }

    public void setAnswer(int a){

        answer = a;
    }

    public char getOperation(){
        return operation;
    }

    public int getFirstNum(){


        return a;
    }
    public int getSecondNum(){


        return b;
    }




}
