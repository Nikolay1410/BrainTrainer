package com.example.braintrainer.levels;

public class Level4 {
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
            result = (int) (Math.random() * (25 - 3 + 1) + 3);
        }while (result == rightAnswer);
        return result+rightAnswer;
    }

    public void generateQuestions() {
        int division = (int) (Math.random() * (90 - 15 + 1) + 15);
        int divisionB = (int) (Math.random() * (25 - 3 + 1) + 3);
        int divisionA = division * divisionB;
                rightAnswer = divisionA / divisionB;
                question = String.format("%s / %s", divisionA, divisionB);
    }
}