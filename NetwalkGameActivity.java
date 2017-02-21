package com.adamglynn.netwalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by adamglynn on 1/31/17.
 */

public class NetwalkGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        //Getting the added int value which was passed from the other intent in LevelDifficultyActivity
        int size = intent.getIntExtra("int_value", 3);

        //I have also passed the variable 'size' int in the object call below
        NetwalkGridView nGridView = new NetwalkGridView(getApplicationContext(),size);
        setContentView(nGridView);
    }


}
