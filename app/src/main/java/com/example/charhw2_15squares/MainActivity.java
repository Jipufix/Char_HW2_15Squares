package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23
 */

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        PuzzleView view = findViewById(R.id.puzzleView);
        PuzzleModel model = view.getPuzzleModel();
        PuzzleController controller = new PuzzleController(view);

        int[] shuffledNum = controller.shuffleNumbers();
        for (int i = 0; i < model.buttons.length; i++){
            for (int j = 0; j < model.buttons[i].length; j++){
                int tempNum = shuffledNum[(i * 4) + j];
                Button tempBut = (Button) findViewById(model.buttonIds[(i * 4) + j]);
                tempBut.setText(tempNum + "");
                model.buttons[i][j] = tempBut;
            }
        }
    }//onCreate


}