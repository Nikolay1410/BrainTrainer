package com.example.braintrainer.levels;

public class Level6 {
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
        int isPositive = (int) (Math.random() * 36);
        switch (isPositive) {
            case 0:
                rightAnswer = division + (divisionA / divisionB) * multiplyB;
                question = String.format("%s + (%s / %s) * %s", division, divisionA, divisionB, multiplyB);
                break;
            case 1:
                rightAnswer = division - (divisionA / divisionB) * multiplyB;
                question = String.format("%s - (%s / %s) * %s", division, divisionA, divisionB, multiplyB);
                break;
            case 2:
                rightAnswer = (divisionA / divisionB) * multiplyB + division;
                question = String.format("(%s / %s) * %s + %s", divisionA, divisionB, multiplyB, division);
                break;
            case 3:
                rightAnswer = (divisionA / divisionB) * multiplyB - division;
                question = String.format("(%s / %s) * %s - %s", divisionA, divisionB, multiplyB, division);
                break;
            case 4:
                rightAnswer = (divisionA / divisionB) - division * multiplyB;
                question = String.format("(%s / %s) - %s * %s", divisionA, divisionB, division, multiplyB);
                break;
            case 5:
                rightAnswer = (divisionA / divisionB) + division * multiplyB;
                question = String.format("(%s / %s) + %s * %s", divisionA, divisionB, division, multiplyB);
                break;
            case 6:
                rightAnswer = division + multiplyB * (divisionA / divisionB);
                question = String.format("%s + %s * (%s / %s)", division, multiplyB, divisionA, divisionB);
                break;
            case 7:
                rightAnswer = division - multiplyB * (divisionA / divisionB);
                question = String.format("%s - %s * (%s / %s)", division, multiplyB, divisionA, divisionB);
                break;
            case 8:
                rightAnswer = multiplyB * (divisionA / divisionB) + division;
                question = String.format("%s * (%s / %s) + %s", multiplyB, divisionA, divisionB, division);
                break;
            case 9:
                rightAnswer = multiplyB * (divisionA / divisionB) - division;
                question = String.format("%s * (%s / %s) - %s", multiplyB, divisionA, divisionB, division);
                break;
            case 10:
                rightAnswer = multiplyB * division - (divisionA / divisionB);
                question = String.format("%s * %s - (%s / %s)", multiplyB, division, divisionA, divisionB);
                break;
            case 11:
                rightAnswer = multiplyB * division + (divisionA / divisionB);
                question = String.format("%s * %s + (%s / %s)", multiplyB, division, divisionA, divisionB);
                break;
            case 12:
                rightAnswer = division - (multiplyMin * multiplyB) / multiplyMinA;
                question = String.format("%s - (%s * %s) / %s",division, multiplyMin, multiplyB, multiplyMinA);
                break;
            case 13:
                rightAnswer = division + (multiplyMin * multiplyB) / multiplyMinA;
                question = String.format("%s + (%s * %s) / %s",division, multiplyMin, multiplyB, multiplyMinA);
                break;
            case 14:
                rightAnswer = (multiplyMin * multiplyB) / multiplyMinA + division;
                question = String.format("(%s * %s) / %s + %s", multiplyMin, multiplyB, multiplyMinA, division);
                break;
            case 15:
                rightAnswer = (multiplyMin * multiplyB) / multiplyMinA - division;
                question = String.format("(%s * %s) / %s - %s", multiplyMin, multiplyB, multiplyMinA, division);
                break;
            case 16:
                rightAnswer = (multiplyMin * multiplyB) - divisionA / division;
                question = String.format("(%s * %s) - %s / %s", multiplyMin, multiplyB, divisionA, division);
                break;
            case 17:
                rightAnswer = (multiplyMin * multiplyB) + divisionA / division;
                question = String.format("(%s * %s) + %s / %s", multiplyMin, multiplyB, divisionA, division);
                break;
            case 18:
                rightAnswer = division + multiplyMax / (multiplyMinA * multiplyB);
                question = String.format("%s + %s / (%s * %s)",division, multiplyMax, multiplyMinA, multiplyB);
                break;
            case 19:
                rightAnswer = division - multiplyMax / (multiplyMinA * multiplyB);
                question = String.format("%s - %s / (%s * %s)",division, multiplyMax, multiplyMinA, multiplyB);
                break;
            case 20:
                rightAnswer = multiplyMax / (multiplyMinA * multiplyB) - division;
                question = String.format("%s / (%s * %s) - %s", multiplyMax, multiplyMinA, multiplyB, division);
                break;
            case 21:
                rightAnswer = multiplyMax / (multiplyMinA * multiplyB) + division;
                question = String.format("%s / (%s * %s) + %s", multiplyMax, multiplyMinA, multiplyB, division);
                break;
            case 22:
                rightAnswer = divisionA / division - (multiplyMinA * multiplyB);
                question = String.format("%s / %s - (%s * %s)", divisionA, division, multiplyMinA, multiplyB);
                break;
            case 23:
                rightAnswer = divisionA / division + (multiplyMinA * multiplyB);
                question = String.format("%s / %s + (%s * %s)", divisionA, division, multiplyMinA, multiplyB);
                break;
            case 24:
                rightAnswer = division + divisionA / divisionB * multiplyB;
                question = String.format("%s + %s / %s * %s", division, divisionA, divisionB, multiplyB);
                break;
            case 25:
                rightAnswer = division - divisionA / divisionB * multiplyB;
                question = String.format("%s - %s / %s * %s", division, divisionA, divisionB, multiplyB);
                break;
            case 26:
                rightAnswer = divisionA / divisionB * multiplyB - division;
                question = String.format("%s / %s * %s - %s", divisionA, divisionB, multiplyB, division);
                break;
            case 27:
                rightAnswer = divisionA / divisionB * multiplyB + division;
                question = String.format("%s / %s * %s + %s", divisionA, divisionB, multiplyB, division);
                break;
            case 28:
                rightAnswer = divisionA / divisionB - multiplyB * division;
                question = String.format("%s / %s - %s * %s", divisionA, divisionB, multiplyB, division);
                break;
            case 29:
                rightAnswer = divisionA / divisionB + multiplyB * division;
                question = String.format("%s / %s + %s * %s", divisionA, divisionB, multiplyB, division);
                break;
            case 30:
                rightAnswer = division + multiplyMin * multiplyB / multiplyMinA;
                question = String.format("%s + %s * %s / %s",division, multiplyMin, multiplyB, multiplyMinA);
                break;
            case 31:
                rightAnswer = division - multiplyMin * multiplyB / multiplyMinA;
                question = String.format("%s - %s * %s / %s",division, multiplyMin, multiplyB, multiplyMinA);
                break;
            case 32:
                rightAnswer = multiplyMin * multiplyB / multiplyMinA - division;
                question = String.format("%s * %s / %s - %s", multiplyMin, multiplyB, multiplyMinA, division);
                break;
            case 33:
                rightAnswer = multiplyMin * multiplyB / multiplyMinA + division;
                question = String.format("%s * %s / %s + %s", multiplyMin, multiplyB, multiplyMinA, division);
                break;
            case 34:
                rightAnswer = multiplyMin * multiplyB + divisionA / division;
                question = String.format("%s * %s + %s / %s", multiplyMin, multiplyB, divisionA, division);
                break;
            case 35:
                rightAnswer = multiplyMin * multiplyB - divisionA / division;
                question = String.format("%s * %s - %s / %s", multiplyMin, multiplyB, divisionA, division);
                break;


        }
    }
}
