package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewTimer;
    private TextView textViewScore;
    private TextView textView0;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ArrayList<TextView> options = new ArrayList<>();

    private String question;
    private int rightAnswer;
    private int rightAnswerPosition;
    private boolean isPositive;
    private int min = 5;
    private int max = 30;

    private int countOfQuestions = 0;
    private int countOfRightAnswer = 0;

    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewTimer = findViewById(R.id.textViewTimer);
        textViewScore = findViewById(R.id.textViewScore);
        textView0 = findViewById(R.id.textView0);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        options.add(textView0);
        options.add(textView1);
        options.add(textView2);
        options.add(textView3);
        playNext();
        CountDownTimer timer = new CountDownTimer(20000, 1000) {
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
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                int max = preferences.getInt("max", 0);
                if (countOfRightAnswer >= max){
                    preferences.edit().putInt("max", countOfRightAnswer).apply();
                }
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("result", countOfRightAnswer);
                startActivity(intent);
            }
        };
        timer.start();
    }

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
        int a = (int) (Math.random() * (max - min + 1)+min);
        int b = (int) (Math.random() * (max - min + 1)+min);
        int mark = (int) (Math.random()*2);
        isPositive = mark == 1;
        if(isPositive){
            rightAnswer = a + b;
            question = String.format("%s + %s", a, b);
        }else {
            rightAnswer = a - b;
            question = String.format("%s - %s", a, b);
        }
        textViewQuestion.setText(question);
        rightAnswerPosition = (int) (Math.random() * 4);
    }
    private int generateWrongAnswer(){
        int result;
        do{
            result = (int) (Math.random() * max * 2 +1) - (max - min);
        }while (result ==rightAnswer);
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