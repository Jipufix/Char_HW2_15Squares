package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2/14/23
 */

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        /*PuzzleView view = findViewById(R.id.puzzleView);
        PuzzleController controller = new PuzzleController(view);

        //Initializes all of the buttons
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //The getResources().getIdentifier() sets up the int as a resource then an ID number
                //The getPackageName() returns the name of the working package/project
                int id = getResources().getIdentifier("button_" + (i+1) + (j+1), "id", getPackageName());
                controller.addButton(i, j, findViewById(id));
            }
        }*/




    }//onCreate


}