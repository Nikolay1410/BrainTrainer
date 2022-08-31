package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.braintrainer.levels.Level1;
import com.example.braintrainer.levels.Level2;
import com.example.braintrainer.levels.Level3;
import com.example.braintrainer.levels.Level4;
import com.example.braintrainer.levels.Level5;
import com.example.braintrainer.levels.Level6;
import com.example.braintrainer.levels.Level7;

import java.util.ArrayList;
import java.util.Locale;

public class ActivityGame extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewTimer;
    private TextView textViewScore;
    private final ArrayList<TextView> options = new ArrayList<>();
    private final ArrayList<String> level = new ArrayList<>();

    private String question;
    private int rightAnswerPosition;

    private int countOfQuestions = 0;
    private int countOfRightAnswer = 0;

    private boolean gameOver = false;
    private int rightAnswer;

    private int maxResult;

    private Level1 level1;
    private Level2 level2;
    private Level3 level3;
    private Level4 level4;
    private Level5 level5;
    private Level6 level6;
    private Level7 level7;

    int position;
    int positionRestart;
    int nextLevel;

    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();

        }
        else
            Toast.makeText(getBaseContext(), "Если хотите выйти нажмите кнопку дважды",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewTimer = findViewById(R.id.textViewTimer);
        textViewScore = findViewById(R.id.textViewScore);
        TextView textView0 = findViewById(R.id.textView0);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        maxResult = preferences.getInt("max", 0);

        level1 = new Level1();
        level2 = new Level2();
        level3 = new Level3();
        level4 = new Level4();
        level5 = new Level5();
        level6 = new Level6();
        level7 = new Level7();

        options.add(textView0);
        options.add(textView1);
        options.add(textView2);
        options.add(textView3);
        playNext();
        CountDownTimer timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                textViewTimer.setText(getTime(l));
                if (l < 10000){
                    textViewTimer.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }

            @Override
            public void onFinish() {
                gameOver = true;
                if (countOfRightAnswer >= maxResult){
                    preferences.edit().putInt("max", countOfRightAnswer).apply();
                }
                Intent intent = new Intent(ActivityGame.this, ScoreActivity.class);
                switch (positionRestart){
                    case 0: intent.putExtra("result", countOfRightAnswer);
                        break;
                    case 1: intent.putExtra("result", countOfRightAnswer *2);
                        break;
                    case 2: intent.putExtra("result", countOfRightAnswer *3);
                        break;
                    case 3: intent.putExtra("result", countOfRightAnswer *4);
                        break;
                    case 4: intent.putExtra("result", countOfRightAnswer * 6);
                        break;
                    case 5: intent.putExtra("result", countOfRightAnswer * 8);
                        break;
                    case 6: intent.putExtra("result", countOfRightAnswer * 10);
                        break;
                }
                intent.putExtra("position", positionRestart);
                intent.putExtra("nextLevel", nextLevel);
                startActivity(intent);
                finishAndRemoveTask();
            }
        };
        timer.start();
    }

    @SuppressLint("SetTextI18n")
    private void playNext(){
        generateQuestions();
        for (int i = 0; i <options.size(); i++){
            if (i == rightAnswerPosition){
                options.get(i).setText(Integer.toString(rightAnswer));
            }else {
                options.get(i).setText(Integer.toString(generateWrongAnswer()));
            }
        }
        String score = String.format("%s / %s", countOfRightAnswer, countOfQuestions);
        textViewScore.setText(score);
    }

    private  void generateQuestions(){
        SharedPreferences preferencesLevel = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int level1Pref = preferencesLevel.getInt("level1", 0);
        int level2Pref = preferencesLevel.getInt("level2", 0);
        int level3Pref = preferencesLevel.getInt("level3", 0);
        int level4Pref = preferencesLevel.getInt("level4", 0);
        int level5Pref = preferencesLevel.getInt("level5", 0);
        int level6Pref = preferencesLevel.getInt("level6", 0);
        int level7Pref = preferencesLevel.getInt("level7", 0);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("positionGame"))
        {
            position = intent.getIntExtra("positionGame", 0);
        }
        if (intent != null && intent.hasExtra("positionLevel"))
        {
            position = intent.getIntExtra("positionLevel", 0);
        }
        if (intent != null && intent.hasExtra("positionRestart"))
        {
            position = intent.getIntExtra("positionRestart", 0);
        }
        if (intent != null && intent.hasExtra("positionNext"))
        {
            position = intent.getIntExtra("positionNext", 0);
        }

        switch (position){
            case 0:
                level.add("Level 1");
                level1.generateQuestions();
                question = level1.getQuestion();
                rightAnswer = level1.getRightAnswer();
                if (level1Pref < countOfRightAnswer) {
                    preferencesLevel.edit().putInt("level1", countOfRightAnswer).apply();
                }
                positionRestart = position;
                position = 0;
                if (countOfRightAnswer > 13){
                    nextLevel = 1;
                }else {
                    nextLevel = 0;
                }
                break;
            case 1:
                level.add("Level 2");
                level2.generateQuestions();
                question = level2.getQuestion();
                rightAnswer = level2.getRightAnswer();
                if (level2Pref < countOfRightAnswer*2) {
                    preferencesLevel.edit().putInt("level2", countOfRightAnswer*2).apply();
                }
                positionRestart = position;
                position = 0;
                if (countOfRightAnswer > 8){
                    nextLevel = 1;
                }else {
                    nextLevel = 0;
                }
                break;
            case 2:
                level.add("Level 3");
                level3.generateQuestions();
                question = level3.getQuestion();
                rightAnswer = level3.getRightAnswer();
                if (level3Pref < countOfRightAnswer*3) {
                    preferencesLevel.edit().putInt("level3", countOfRightAnswer*3).apply();
                }
                positionRestart = position;
                position = 0;
                if (countOfRightAnswer > 10){
                    nextLevel = 1;
                }else {
                    nextLevel = 0;
                }
                break;
            case 3:
                level.add("Level 4");
                level4.generateQuestions();
                question = level4.getQuestion();
                rightAnswer = level4.getRightAnswer();
                if (level4Pref < countOfRightAnswer*4) {
                    preferencesLevel.edit().putInt("level4", countOfRightAnswer*4).apply();
                }
                positionRestart = position;
                position = 0;
                if (countOfRightAnswer > 10){
                    nextLevel = 1;
                }else {
                    nextLevel = 0;
                }
                break;
            case 4:
                level.add("Level 5");
                level5.generateQuestions();
                question = level5.getQuestion();
                rightAnswer = level5.getRightAnswer();
                if (level5Pref < countOfRightAnswer*6) {
                    preferencesLevel.edit().putInt("level5", countOfRightAnswer*6).apply();
                }
                positionRestart = position;
                position = 0;
                if (countOfRightAnswer > 8){
                    nextLevel = 1;
                }else {
                    nextLevel = 0;
                }
                break;
            case 5:
                level.add("Level 6");
                level6.generateQuestions();
                question = level6.getQuestion();
                rightAnswer = level6.getRightAnswer();
                if (level6Pref < countOfRightAnswer*8) {
                    preferencesLevel.edit().putInt("level6", countOfRightAnswer*8).apply();
                }
                positionRestart = position;
                position = 0;
                if (countOfRightAnswer > 8){
                    nextLevel = 1;
                }else {
                    nextLevel = 0;
                }
                break;
            case 6:
                level.add("Level 7");
                level7.generateQuestions();
                question = level7.getQuestion();
                rightAnswer = level7.getRightAnswer();
                if (level7Pref < countOfRightAnswer*10) {
                    preferencesLevel.edit().putInt("level7", countOfRightAnswer*10).apply();
                }
                positionRestart = position;
                position = 0;
                nextLevel = 0;
                break;
        }

        textViewQuestion.setText(question);
        rightAnswerPosition = (int) (Math.random() * 4);
    }


    private int generateWrongAnswer(){
        int result = 0;
        switch (positionRestart){
            case 0: result = level1.generateWrongAnswer();
                break;
            case 1: result = level2.generateWrongAnswer();
                break;
            case 2: result = level3.generateWrongAnswer();
                break;
            case 3: result = level4.generateWrongAnswer();
                break;
            case 4: result = level5.generateWrongAnswer();
                break;
            case 5: result = level6.generateWrongAnswer();
                break;
            case 6: result = level7.generateWrongAnswer();
                break;
        }
        return result;
    }

    private String getTime(long millis){
        int seconds = (int) (millis / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format(Locale.getDefault(), "%02d : %02d", minutes, seconds);
    }

    public void onClickAnswer(View view) {
        if (!gameOver) {
            TextView textView = (TextView) view;
            int answer = Integer.parseInt(textView.getText().toString());
            if (answer == rightAnswer) {
                countOfRightAnswer++;
                Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Неверно", Toast.LENGTH_SHORT).show();
            }
            countOfQuestions++;
            playNext();
        }
    }
}