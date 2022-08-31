package com.example.braintrainer.levels;

public class Level1 {
    private int rightAnswer;
    private String question;
    private final int min = 5;
    private final int max = 30;

    public int getRightAnswer() {
        return rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public int generateWrongAnswer(){
        int result;
        do{
            result = (int) (Math.random() * max * 2 +1) - (max - min);
        }while (result ==rightAnswer);
        return result;
    }

    public void generateQuestions() {
        int a = (int) (Math.random() * (max - min + 1) + min);
        int b = (int) (Math.random() * (max - min + 1) + min);
        int isPositive = (int) (Math.random() * 2);
        switch (isPositive) {
            case 0:
                rightAnswer = a + b;
                question = String.format("%s + %s", a, b);
                break;
            case 1:
                rightAnswer = a - b;
                question = String.format("%s - %s", a, b);
                break;
        }
    }
}
