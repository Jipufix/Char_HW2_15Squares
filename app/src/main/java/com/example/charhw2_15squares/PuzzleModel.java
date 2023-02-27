package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23
 */

import android.widget.Button;

public class PuzzleModel {
    protected int puzzleSize = 4;
    protected  int[] numbers = new int[puzzleSize * puzzleSize];
    protected int[] shuffledNumbers = new int[puzzleSize * puzzleSize];
    int[] buttonIds = {R.id.button_00, R.id.button_01, R.id.button_02, R.id.button_03,
                        R.id.button_10, R.id.button_11, R.id.button_12, R.id.button_13,
                        R.id.button_20, R.id.button_21, R.id.button_22, R.id.button_23,
                        R.id.button_30, R.id.button_31, R.id.button_32, R.id.button_33};
    int resetId = R.id.reset;
    int solveId = R.id.solve;
    protected Button[][] buttons = new Button[puzzleSize][puzzleSize];

    public PuzzleModel() {
        for (int i = 1; i <= numbers.length; i++) {
            numbers[i - 1] = i;
        }
    }//ctor

    /** Getter method to return the row of a given button*/
    public int getRow (Button b) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++)
                if (b == buttons[i][j]) {
                    return i;
                }
        }
        return -1;
    }//getRow

    /** Getter method to return the column of a given button*/
    public int getCol (Button b) {
        for (Button[] button : buttons) {
            for (int j = 0; j < button.length; j++)
                if (b == button[j]) {
                    return j;
                }
        }
        return -1;
    }//getCol
}
