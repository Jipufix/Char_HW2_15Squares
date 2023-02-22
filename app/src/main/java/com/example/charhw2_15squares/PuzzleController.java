package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23
 */

import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;


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

    /** Helper method to find the invisible button*/
    public int findInvButton () {
        for (int i = 0; i < model.buttons.size(); i++) {
            int num = Integer.parseInt(String.valueOf(model.buttons.get(i).getText())); //Pulls out the number from the button
            if (num == 16) {
                return i;
            }
        }
        return -1;
    }//findInvButton


    /**
     * Swaps a clicked button with the invisible button
     *
     * @param b1 The button clicked that needs to be swapped
     */
    public void swapButtons (Button b1){
        int i = findInvButton();//Index of the invisible button
        Button b2 = model.buttons.get(i);

//        int buttonHeight = b1.getHeight() + 50;
//        int buttonWidth = b1.getWidth() + 50;
//        int rowDifference = (int) Math.abs(b1.getX() - b2.getX());
//        int colDifference = (int) Math.abs(b1.getY() - b2.getY());
//
//        //checks to see if the buttons are adjacent
//        if  ((rowDifference <= buttonWidth && colDifference <= 50) ||
//                (rowDifference <= 50 && colDifference <= buttonHeight)) {
//            String temp = (String) b1.getText();
//            b1.setText(b2.getText());
//            b2.setText(temp);
//
//            b1.setVisibility(View.INVISIBLE);
//            b2.setVisibility(View.VISIBLE);
//        }
        int left = i - 1;
        int right = i + 1;
        int above = i - 4;
        int below = i + 4;
        if (i % 4 == 0) {//button is on the left

        }
        if (b1 == model.buttons.get(left)){
            
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
