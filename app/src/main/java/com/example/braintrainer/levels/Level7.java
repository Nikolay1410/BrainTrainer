package com.example.braintrainer.levels;

public class Level7 { private int rightAnswer;
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
                rightAnswer = division + (divisionA / divisionB) * multiplyB - multiplyMax;
                question = String.format("%s + (%s / %s) * %s - %s", division, divisionA, divisionB, multiplyB, multiplyMax);
                break;
            case 1:
                rightAnswer = division - (divisionA / divisionB) * multiplyB + multiplyMax;
                question = String.format("%s - (%s / %s) * %s + %s", division, divisionA, divisionB, multiplyB, multiplyMax);
                break;
            case 2:
                rightAnswer = multiplyMax - (divisionA / divisionB) - division * multiplyB;
                question = String.format("%s - (%s / %s) - %s * %s",multiplyMax, divisionA, divisionB, division, multiplyB);
                break;
            case 3:
                rightAnswer = multiplyMax + (divisionA / divisionB) + division * multiplyB;
                question = String.format("%s + (%s / %s) + %s * %s", multiplyMax, divisionA, divisionB, division, multiplyB);
                break;
            case 4:
                rightAnswer = division + multiplyB * (divisionA / divisionB) - multiplyMax;
                question = String.format("%s + %s * (%s / %s) - %s", division, multiplyB, divisionA, divisionB, multiplyMax);
                break;
            case 5:
                rightAnswer = division - multiplyB * (divisionA / divisionB) + multiplyMax;
                question = String.format("%s - %s * (%s / %s) + %s", division, multiplyB, divisionA, divisionB, multiplyMax);
                break;
            case 6:
                rightAnswer = multiplyMax - multiplyB * division - (divisionA / divisionB);
                question = String.format("%s - %s * %s - (%s / %s)",multiplyMax, multiplyB, division, divisionA, divisionB);
                break;
            case 7:
                rightAnswer = multiplyMax + multiplyB * division + (divisionA / divisionB);
                question = String.format("%s + %s * %s + (%s / %s)", multiplyMax, multiplyB, division, divisionA, divisionB);
                break;
            case 8:
                rightAnswer = multiplyMax - (multiplyMin * multiplyB) / multiplyMinA + division;
                question = String.format("%s - (%s * %s) / %s + %s", multiplyMax, multiplyMin, multiplyB, multiplyMinA, division);
                break;
            case 9:
                rightAnswer = multiplyMax + (multiplyMin * multiplyB) / multiplyMinA - division;
                question = String.format("%s + (%s * %s) / %s - %s",multiplyMax, multiplyMin, multiplyB, multiplyMinA, division);
                break;
            case 10:
                rightAnswer = multiplyMax - (multiplyMin * multiplyB) - divisionA / division;
                question = String.format("%s - (%s * %s) - %s / %s", multiplyMax, multiplyMin, multiplyB, divisionA, division);
                break;
            case 11:
                rightAnswer = multiplyMax + (multiplyMin * multiplyB) + divisionA / division;
                question = String.format("%s + (%s * %s) + %s / %s", multiplyMax, multiplyMin, multiplyB, divisionA, division);
                break;
            case 12:
                rightAnswer = division + multiplyMax / (multiplyMinA * multiplyB) - multiplyMin;
                question = String.format("%s + %s / (%s * %s) - %s",division, multiplyMax, multiplyMinA, multiplyB, multiplyMin);
                break;
            case 13:
                rightAnswer = division - multiplyMax / (multiplyMinA * multiplyB) + multiplyMin;
                question = String.format("%s - %s / (%s * %s) + %s",division, multiplyMax, multiplyMinA, multiplyB, multiplyMin);
                break;
            case 14:
                rightAnswer = multiplyMin + multiplyMax / (multiplyMinA * multiplyB) - division;
                question = String.format("%s + %s / (%s * %s) - %s", multiplyMin, multiplyMax, multiplyMinA, multiplyB, division);
                break;
            case 15:
                rightAnswer = divisionA / division + (multiplyMinA * multiplyB) - multiplyMax;
                question = String.format("%s / %s + (%s * %s) - %s", divisionA, division, multiplyMinA, multiplyB, multiplyMax);
                break;
            case 16:
                rightAnswer = multiplyMax + divisionA / divisionB * multiplyB - division;
                question = String.format("%s + %s / %s * %s - %s", multiplyMax, divisionA, divisionB, multiplyB, division);
                break;
            case 17:
                rightAnswer = multiplyMax - divisionA / divisionB * multiplyB + division;
                question = String.format("%s - %s / %s * %s + %s", multiplyMax, divisionA, divisionB, multiplyB, division);
                break;
            case 18:
                rightAnswer = divisionA / divisionB - multiplyB * division - multiplyMax;
                question = String.format("%s / %s - %s * %s - %s", divisionA, divisionB, multiplyB, division, multiplyMax);
                break;
            case 19:
                rightAnswer = divisionA / divisionB + multiplyB * division + multiplyMax;
                question = String.format("%s / %s + %s * %s + %s", divisionA, divisionB, multiplyB, division, multiplyMax);
                break;
            case 20:
                rightAnswer = division + multiplyMin * multiplyB / multiplyMinA - multiplyMax;
                question = String.format("%s + %s * %s / %s - %s",division, multiplyMin, multiplyB, multiplyMinA, multiplyMax);
                break;
            case 21:
                rightAnswer = division - multiplyMin * multiplyB / multiplyMinA +multiplyMax;
                question = String.format("%s - %s * %s / %s + %s",division, multiplyMin, multiplyB, multiplyMinA, multiplyMax);
                break;
            case 22:
                rightAnswer = multiplyMin * multiplyB + divisionA / division - multiplyMax;
                question = String.format("%s * %s + %s / %s - %s", multiplyMin, multiplyB, divisionA, division, multiplyMax);
                break;
            case 23:
                rightAnswer = multiplyMin * multiplyB - divisionA / division + multiplyMax;
                question = String.format("%s * %s - %s / %s + %s", multiplyMin, multiplyB, divisionA, division, multiplyMax);
                break;
        }
    }
}
