package com.example.braintrainer.levels;


public class Level2 {
    private int rightAnswer;
    private String question;

    public int getRightAnswer() {
        return rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public int generateWrongAnswer(){
        int result;
        do{
            result = (int) (Math.random() * 20 * 2 +1) - (20 - 2);
        }while (result == rightAnswer);
        return result+rightAnswer;
    }

    public void generateQuestions() {
        int min = 5;
        int max = 30;
        int a = (int) (Math.random() * (max - min + 1) + min);
        int b = (int) (Math.random() * (max - min + 1) + min);
        int c = (int) (Math.random() * (max - min + 1) + min);
        int isPositive = (int) (Math.random() * 4);
        switch (isPositive) {
            case 0:
                rightAnswer = a + b - c;
                question = String.format("%s + %s - %s", a, b, c);
                break;
            case 1:
                rightAnswer = a - b + c;
                question = String.format("%s - %s + %s", a, b, c);
                break;
            case 2:
                rightAnswer = a - b - c;
                question = String.format("%s - %s - %s", a, b, c);
                break;
            case 3:
                rightAnswer = a + b + c;
                question = String.format("%s + %s +%s", a, b, c);
                break;
        }
    }
}
