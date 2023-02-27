package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23

  ENHANCEMENTS INCLUDED:
  - Solve Button to show that the background changes color when solved
  - Randomly initializes in a "solvable state" (look at ValidityChecker Java class)
  - Sound effects from SSBM added to regular buttons and solved state (look at SoundManager Java class)
 */


import android.content.Context;
import android.content.pm.ActivityInfo;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        PuzzleView view = findViewById(R.id.puzzleView);
        PuzzleModel model = view.getPuzzleModel();
        ValidityChecker validCheck = new ValidityChecker();
        SoundManager soundManager = new SoundManager(view);
        PuzzleController controller = new PuzzleController(view, validCheck, soundManager);

        Button resetBut = (Button) findViewById(model.resetId);
        Button solveBut = (Button) findViewById(model.solveId);
        resetBut.setOnClickListener(controller);
        solveBut.setOnClickListener(controller);

        model.shuffledNumbers = controller.shuffleNumbers();
        //Sets up every button to be accessed and used
        for (int i = 0; i < model.buttons.length; i++) {
            for (int j = 0; j < model.buttons[i].length; j++) {
                Button tempBut = (Button) findViewById(model.buttonIds[(i * 4) + j]);
                controller.appendNumbers(model.shuffledNumbers[(i * 4) + j], tempBut);
                model.buttons[i][j] = tempBut;
                tempBut.setOnClickListener(controller);
            }
        }
    }//onCreate

    /** GETTER METHOD */
    public Context getContext() {
        return getApplicationContext();
    }//getContext
}