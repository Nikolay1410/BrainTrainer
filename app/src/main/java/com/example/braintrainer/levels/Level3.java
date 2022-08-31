package com.example.braintrainer.levels;

public class Level3 {
    private int rightAnswer;
    private String question;

    public int getRightAnswer() {
        return rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void generateQuestions() {
        int min = 5;
        int max = 30;
        int a = (int) (Math.random() * (max - min + 1) + min);
        int b = (int) (Math.random() * (18 - 2 + 1) + 2);
        int isPositive = (int) (Math.random() * 2);
        switch (isPositive) {
            case 0:
                rightAnswer = a * b;
                question = String.format("%s * %s", a, b);
                break;
            case 1:
                rightAnswer = b * a;
                question = String.format("%s * %s", b, a);
                break;
        }
    }
    public int generateWrongAnswer(){
        int result;
        do{
            result = (int) (Math.random() * 20 * 2 +1) - (20 - 2);
        }while (result == rightAnswer);
        return result+rightAnswer;
    }
}
