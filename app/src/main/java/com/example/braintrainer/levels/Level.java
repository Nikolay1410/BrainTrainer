package com.example.braintrainer.levels;

public class Level {
    private final int maxBall;
    private final int levelNumber;
    private final String example;

    public Level(int maxBall, int levelNumber, String example) {
        this.maxBall = maxBall;
        this.levelNumber = levelNumber;
        this.example = example;
    }

    public int getMaxBall() {
        return maxBall;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String getExample() {
        return example;
    }
}
