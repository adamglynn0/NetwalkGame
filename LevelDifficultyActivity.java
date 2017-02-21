package com.adamglynn.netwalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LevelDifficultyActivity extends AppCompatActivity {


    /*
    Methods inside this class are very similar to the main menu due to activity being
    comprised of many buttons. The main difference with this is I have added an int
    to the intent which correlates to the difficulty level. This int added to the intent
    will be used to determine how large the grid is. eg. easy will be a 3x3 grid.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);
    }

    public void easyClick(View v){
        Intent intent = new Intent(LevelDifficultyActivity.this, NetwalkGameActivity.class);
       intent.putExtra("int_value", 3);
       startActivity(intent);
    }

    public void mediumClick(View v){
        Intent intent = new Intent(LevelDifficultyActivity.this, NetwalkGameActivity.class);
        intent.putExtra("int_value", 5);
        startActivity(intent);
    }

    public void hardClick(View v){
        Intent intent = new Intent(LevelDifficultyActivity.this, NetwalkGameActivity.class);
        intent.putExtra("int_value", 7);
        startActivity(intent);
    }
}
