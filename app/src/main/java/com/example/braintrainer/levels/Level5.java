package com.example.braintrainer.levels;

public class Level5 {
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
            result = (int) (Math.random() * (18 - 2 + 1) + 2);
        }while (result == rightAnswer);
        return result+rightAnswer;
    }

    public void generateQuestions() {
        int division = (int) (Math.random() * (90 - 15 + 1) + 15);
        int divisionB = (int) (Math.random() * (25 - 3 + 1) + 3);
        int divisionA = division * divisionB;

        int multiplyMinA = (int) (Math.random() * (8 - 1 + 1) + 1);
        int multiplyMinB = (int) (Math.random() * (8 - 1 + 1) + 1);
        int multiplyMin = multiplyMinA*multiplyMinB;
        int multiplyMax = multiplyMinA*division;

        int multiplyB = (int) (int) (Math.random() * (18 - 2 + 1) + 2);
        int isPositive = (int) (Math.random() * 6);
        switch (isPositive) {
            case 0:
                rightAnswer = (divisionA / divisionB) * multiplyB;
                question = String.format("(%s / %s) * %s", divisionA, divisionB, multiplyB);
                break;
            case 1:
                rightAnswer = multiplyB * (divisionA / divisionB);
                question = String.format("%s * (%s / %s)", multiplyB, divisionA, divisionB);
                break;
            case 2:
                rightAnswer = (multiplyMin * multiplyB) / multiplyMinA;
                question = String.format("(%s * %s) / %s", multiplyMin, multiplyB, multiplyMinA);
                break;
            case 3:
                rightAnswer = multiplyMax / (multiplyMinA * multiplyB);
                question = String.format("%s / (%s * %s)", multiplyMax, multiplyMinA, multiplyB);
                break;
            case 4:
                rightAnswer = (divisionA / divisionB) * multiplyB;
                question = String.format("%s / %s * %s", divisionA, divisionB, multiplyB);
                break;
            case 5:
                rightAnswer = multiplyMin * multiplyB / multiplyMinA;
                question = String.format("%s * %s / %s", multiplyMin, multiplyB, multiplyMinA);
                break;

        }
    }
}
