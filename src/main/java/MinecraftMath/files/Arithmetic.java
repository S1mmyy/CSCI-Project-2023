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

    public Arithmetic(char grade)
    {

        if(grade=='k')
        {
            a = ran.nextInt(21);
            b = ran.nextInt(21);
            operation = ops[0];

        }

        else if(grade == '1' || grade=='2')
        {
            a= ran.nextInt(101);
            b= ran.nextInt(101);
            operation = ops[ran.nextInt(2)];
        }

        else if(grade=='3')
        {
            a=ran.nextInt(5001);
            b=ran.nextInt(5001);
            operation = ops[ran.nextInt(3)];
        }

        else if(grade=='4')
        {
            p = ran.nextInt(202);
            q = ran.nextInt(12);
            a = p;
            b = q;
            operation = ops[ran.nextInt(4)];
        }


        actualOp= operation;

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


    public String getQuestion()
    {
        String question = "ERROR DETECTED! Contact admin.";
        if(questionType.equals("mc")){
            question = "What is " + a + " " + operation + " " + b + " equal to?";


        }
        if (questionType.equals("tf")){
            if(ran.nextInt(2) == 1) {
                question = "Is " + a + " " + operation + " " + b +" = "+ answer +" ?";
                isTrue = "True";

            }else {
                int incorr = b+1;
                question = "Is " + a + " " + operation + " " + incorr + " = " + answer + " ?";
                isTrue = "False";
            }

        }
        return question;
    }

    public int getAnswer()
    {
        if(questionType.equals("mc")){
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
