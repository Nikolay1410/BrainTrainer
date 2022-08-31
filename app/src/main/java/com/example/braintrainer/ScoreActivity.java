package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button buttonNext = findViewById(R.id.buttonNext);
        Intent intent = getIntent();

        if (intent.hasExtra("position"))
        {
            position = intent.getIntExtra("position", 0);
        }
        if (intent.hasExtra("result"))
        {
            int result = intent.getIntExtra("result", 0);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            int max = preferences.getInt("max", 0);
            String score = String.format("Ваш результат: %s\nМаксимальный результат: %s", result, max);
            textViewResult.setText(score);
        }
        if (intent.hasExtra("nextLevel"))
        {
            int nextLevel= intent.getIntExtra("nextLevel", 0);
            if (nextLevel == 1){
                buttonNext.setVisibility(View.VISIBLE);
                buttonNext.setText(String.format("Level: %s", position+2));
            }else {
                buttonNext.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void onClickStartNewGame(View view) {
        Intent intentRestart = new Intent(this, ActivityGame.class);
        intentRestart.putExtra("positionRestart", position);
        startActivity(intentRestart);
    }

    public void onClickScoreExit(View view) {
        Intent intentExit = new Intent(this, MainActivity.class);
        startActivity(intentExit);
        finishAndRemoveTask();
    }

    public void onClickNextLevel(View view) {
        Intent intentNext = new Intent(this, ActivityGame.class);
        intentNext.putExtra("positionNext", position+1);
        startActivity(intentNext);
    }
}