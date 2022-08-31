package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int maxResult;
    private int maxResultLevel1;
    private int maxResultLevel2;
    private int maxResultLevel3;
    private int maxResultLevel4;
    private int maxResultLevel5;
    private int maxResultLevel6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonLevel = findViewById(R.id.buttonLevels);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Button buttonGo = findViewById(R.id.buttonGo);
        maxResult = preferences.getInt("max", 0);
        maxResultLevel1 = preferences.getInt("level1", 0);
        maxResultLevel2 = preferences.getInt("level2", 0);
        maxResultLevel3 = preferences.getInt("level3", 0);
        maxResultLevel4 = preferences.getInt("level4", 0);
        maxResultLevel5 = preferences.getInt("level5", 0);
        maxResultLevel6 = preferences.getInt("level6", 0);
        int maxResultLevel7 = preferences.getInt("level7", 0);
        TextView generalResult = findViewById(R.id.generalResult);
        TextView textViewGeneralText = findViewById(R.id.textViewGeneralText);
        int generalRes = maxResultLevel1 + maxResultLevel2 + maxResultLevel3 + maxResultLevel4 +
                maxResultLevel5 + maxResultLevel6 + maxResultLevel7;
        if (generalRes > 0){
            buttonLevel.setVisibility(View.VISIBLE);
            generalResult.setVisibility(View.VISIBLE);
            textViewGeneralText.setVisibility(View.VISIBLE);
        }else {
            buttonLevel.setVisibility(View.INVISIBLE);
            generalResult.setVisibility(View.INVISIBLE);
            textViewGeneralText.setVisibility(View.INVISIBLE);
        }
        String res = ""+ generalRes;
        generalResult.setText(res);

        if (maxResult > 0){
            buttonGo.setText("Продолжить игру");
        }


    }

    public void onClickExit(View view) {
        this.finishAffinity();
    }

    public void onClickGo(View view) {
        int position = 0;

        if (maxResult >13 && maxResultLevel1 >0){
            position = 1;
        }
        if (maxResult >8 && maxResultLevel2 >0){
            position = 2;
        }
        if (maxResult >10 && maxResultLevel3 >0){
            position = 3;
        }
        if (maxResult >10 && maxResultLevel4 >0){
            position = 4;
        }
        if (maxResult >8 && maxResultLevel5 >0){
            position = 5;
        }
        if (maxResult >8 && maxResultLevel6 >0){
            position = 6;
        }


        Intent intent = new Intent(this, ActivityGame.class);
        intent.putExtra("positionGame", position);
        startActivity(intent);
    }

    public void onClickLevels(View view) {
        Intent intentLevel = new Intent(this, ActivityLevel.class);
        startActivity(intentLevel);
    }
}