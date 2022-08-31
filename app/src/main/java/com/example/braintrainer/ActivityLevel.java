package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.braintrainer.adapter.LevelAdapter;
import com.example.braintrainer.levels.Level;

import java.util.ArrayList;

public class ActivityLevel extends AppCompatActivity {
    private final ArrayList<Level> levels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        RecyclerView recyclerViewLevel = findViewById(R.id.recyclerViewLevel);
        SharedPreferences preferencesLevel = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int maxResult1 = preferencesLevel.getInt("level1", 0);
        int maxResult2 = preferencesLevel.getInt("level2", 0);
        int maxResult3 = preferencesLevel.getInt("level3", 0);
        int maxResult4 = preferencesLevel.getInt("level4", 0);
        int maxResult5 = preferencesLevel.getInt("level5", 0);
        int maxResult6 = preferencesLevel.getInt("level6", 0);
        int maxResult7 = preferencesLevel.getInt("level7", 0);
        if (maxResult1 > 0)
        {
            levels.add(new Level(maxResult1, 1, "x + x"));
        }
        if (maxResult2 > 0)
        {
            levels.add(new Level(maxResult2, 2, "x + x - x"));
        }
        if (maxResult3 > 0)
        {
            levels.add(new Level(maxResult3, 3, "x * x"));
        }
        if (maxResult4 > 0)
        {
            levels.add(new Level(maxResult4, 4, "x / x"));
        }
        if (maxResult5 > 0)
        {
            levels.add(new Level(maxResult5, 5, "x * (x / x)"));
        }
        if (maxResult6 > 0)
        {
            levels.add(new Level(maxResult6, 6, "x + (x * x) / x"));
        }
        if (maxResult7 > 0)
        {
            levels.add(new Level(maxResult7, 7, "x + (x * x) / x - x"));
        }

        LevelAdapter levelAdapter = new LevelAdapter(levels);
        recyclerViewLevel.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLevel.setAdapter(levelAdapter);
        levelAdapter.setOnLevelClickListener(position -> {
            Intent intent = new Intent(getApplicationContext(), ActivityGame.class);
            intent.putExtra("positionLevel", position);
            startActivity(intent);
        });
    }
}