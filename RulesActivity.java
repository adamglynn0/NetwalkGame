package com.adamglynn.netwalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        rulestext1();
    }

    /*
    This is a very simple class which just displays the rules in plain text. I did this by creating a TextView
    and using .setText to write whatever I wanted to be displayed. I have also placed the TextView inside a
    ScrollView, although scroll has not been needed, for future development when functionality is added I may
    need to add extra instructions
     */

    private void rulestext1() {
        TextView rulesText = (TextView) findViewById(R.id.textView);
        rulesText.setText("How To Play" +
                "\n" +
                "\n" +
                "Playing the game is very simple. Once you have clicked the 'Play' button, you will" +
                "be taken to another menu which has 3 options; easy, medium and hard. The easy option will have" +
                "a smaller grid and the harder the option, the bigger the grid becomes. After selecting your " +
                "difficulty you will be directed to the game and presented with a grid. The aim of the game is" +
                "to connected all of the nodes to the server by rotating each item. You can rotate a grid tile" +
                "as many times as you wish, but your number of clicks is recorded below the grid." +
                "\n" +
                "\n" +
                "After completing the game, your score will be recorded to the high scores. The high scores can " +
                "be navigated to through the main menu. These high scores are stored in different pages depending " +
                "on which difficulty you selected prior to playing the game.");
    }
}




