package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23
 */

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;


import java.util.Random;

public class PuzzleController implements View.OnClickListener, Runnable {
    protected PuzzleView view;
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
    @SuppressLint("SetTextI18n")
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

    /** Helper method to find the invisible button*/
    public Button findInvButton () {
        for (int i = 0; i < model.buttons.length ; i++) {
            for (int j = 0; j < model.buttons[i].length; j++) {
                if (model.buttons[i][j].getVisibility() == View.INVISIBLE) {
                    return model.buttons[i][j];
                }
            }
        }
        return null;
    }//findInvButton

    /**
     * Checks to see if a button is adjacent to the invisible button
     *
     * @param b    The button to be checked
     * @param row  The row of the invisible button
     * @param col  The column of the invisible button
     * @return     Returns true if the buttons can be swapped, false if not
     */
    public boolean isAdjacent(Button b, int row, int col) {
        boolean swappable = false;

        if (row > 0) {//checks Left
            if (b == model.buttons[row - 1][col]) {
                swappable = true;
            }
        }
        if (row < model.buttons[row].length - 1) {//checks right
            if (b == model.buttons[row + 1][col]) {
                swappable = true;
            }
        }
        if (col > 0) {
            if (b == model.buttons[row][col - 1]) {
                swappable = true;
            }
        }
        if (col < model.buttons.length - 1) {
            if (b == model.buttons[row][col + 1]) {
                swappable = true;
            }
        }
        return swappable;
    }//isAdjacent

    /**
     * Swaps a clicked button with the invisible button
     *
     * @param b1 The button clicked that needs to be swapped
     */
    public void swapButtons (Button b1){
        Button b2;
        if (findInvButton() != null) {
            b2 = findInvButton(); //Invisible Button
        } else {return;}

        int row = model.getRow(b2); int col = model.getCol(b2);

        if (isAdjacent(b1, row, col)) {
            String temp = (String) (b1.getText());
            b1.setText(b2.getText());
            b2.setText(temp);

            b1.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.VISIBLE);
        }
    }//swapButtons

    @Override
    public void onClick(View view) {
        Button b1 = (Button) view;
        swapButtons(b1);
        checkNumbers();
    }

    @Override
    public void run() {

    }
}
