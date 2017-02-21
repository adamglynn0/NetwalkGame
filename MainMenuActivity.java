package com.adamglynn.netwalk;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    //The methods below create an intent and indicate the activity that is currently running
    //and the class that needs to be executed. The class is then launched by placing the intent
    //inside the startActivity() function
    public void playClick(View v){
        Intent intent = new Intent(MainMenuActivity.this, LevelDifficultyActivity.class);
        startActivity(intent);
    }

   public void howToPlay(View v){
        Intent intent = new Intent(MainMenuActivity.this, RulesActivity.class);
        startActivity(intent);
   }

    //Method creates a dialog to ask the user if they are sure they wish to quit. This
    //happens when the user clicks on the 'exit' button.
    public void exit(View view){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();

        //The address below is the link to where I found the code displayed above and below.
        //http://stackoverflow.com/questions/2257963/how-to-show-a-dialog-to-confirm-that-the-user
        // -wishes-to-exit-an-android-activity
    }

    //Method below to ask user if they are sure they want to close the application when pressing
    //the back button
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();

        //http://stackoverflow.com/questions/2257963/how-to-show-a-dialog-to-confirm-that-the-user
        // -wishes-to-exit-an-android-activity
    }
}
