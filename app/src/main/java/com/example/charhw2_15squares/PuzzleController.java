package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23
 */

import android.view.View;
import android.widget.Button;


import java.util.Random;

public class PuzzleController implements View.OnClickListener, Runnable {
    private PuzzleView view;
    protected PuzzleModel model;

    public PuzzleController (PuzzleView v) {
        view = v;
        model = view.getPuzzleModel();
    }//ctor

    /** Shuffles the numbers array [0-15] and stores it as a separate array*/
    public int[] shuffleNumbers () {
        int[] tempArr = model.numbers;
        Random random = new Random();
        for (int i = tempArr.length - 1; i > 0; i--) {
            int rand = random.nextInt(i + 1);
            int temp = tempArr[i];
            tempArr[i] = tempArr[rand];
            tempArr[rand] = temp;
        }

        return tempArr;
    }//shuffleNumbers

    /**
     * Sets the text for each individual button
     *
     * @param tempNum The random number to be appended to the button
     * @param tempBut The button to be appended to
     */
    public void appendNumbers (int tempNum, Button tempBut, int i, int j) {
        tempBut.setText(tempNum + "");
        if (tempNum == 16) {
            tempBut.setVisibility(View.INVISIBLE);
        }
        model.buttons[i][j] = tempBut;
    }//appendNumbers

    /**
    * Checks to see if all of the numbers are in the correct order
    *
    * @return true if all of the button's numbers are in order, false if they are not.
    * */
    public boolean checkNumbers () {
        for (int i = 0; i < model.buttons.length; i++) {
            for (int j = 0; j < model.buttons[i].length; j++) {
                int num = Integer.parseInt(String.valueOf(model.buttons[i][j].getText())); //Pulls out the number from the button
                if (!(model.numbers[i] == num)) {
                    return false;
                }
            }
        }
        return true;
    }//checkNumbers

    public void swapButtons (Button b1){

    }//swapButtons

    @Override
    public void onClick(View view) {

        checkNumbers();
    }

    @Override
    public void run() {

    }
}
