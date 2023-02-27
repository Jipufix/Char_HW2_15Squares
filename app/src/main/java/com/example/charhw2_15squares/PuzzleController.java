package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23`
 */


import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class PuzzleController implements View.OnClickListener {
    protected PuzzleView view;
    protected PuzzleModel model;
    protected ValidityChecker vc;

    public PuzzleController (PuzzleView v, ValidityChecker validCheck) {
        view = v;
        model = view.getPuzzleModel();
        vc = validCheck;
    }//ctor

    /** Shuffles the numbers array and stores it as a separate array */
    public int[] shuffleNumbers () {
        int[] tempArr = new int[model.numbers.length];
        for (int num : model.numbers) {
            tempArr[num - 1] = num;
        }
        Random random = new Random();
        for (int i = tempArr.length - 1; i > 0; i--) {
            int rand = random.nextInt(i + 1);
            int temp = tempArr[i];
            tempArr[i] = tempArr[rand];
            tempArr[rand] = temp;
        }

        while (!vc.checkValidity(tempArr, model)) {//recursive case until a valid set of numbers is reached
            tempArr = shuffleNumbers();
        }

        return tempArr;
    }//shuffleNumbers

    /**
     * Sets the text for each individual button
     *
     * @param tempNum The random number to be appended to the button
     * @param tempBut The button to be appended to
     */
    public void appendNumbers (int tempNum, Button tempBut) {
        String tempString = tempNum + "";
        tempBut.setText(tempString);
        if (tempNum == 16) {
            tempBut.setVisibility(View.INVISIBLE);
        }
    }//appendNumbers

    /**
    * Checks to see if all of the numbers are in the correct order
    *
    * @return true if all of the button's numbers are in order, false if they are not.
    * */
    public boolean checkNumbers() {
        for (int i = 0; i < model.buttons.length; i++) {
            for (int j = 0; j < model.buttons[i].length; j++) {
                int num = Integer.parseInt(String.valueOf(model.buttons[i][j].getText())); //Pulls out the number from the button
                if (!(model.numbers[(i * 4) + j] == num)) {
                    return false;
                }
            }
        }
        return true;
    }//checkNumbers

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

    /** HELPER METHOD
     * Finds the invisible button
     * */
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
     * HELPER METHOD
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
        if (col > 0) {//checks above
            if (b == model.buttons[row][col - 1]) {
                swappable = true;
            }
        }
        if (col < model.buttons.length - 1) {//checks below
            if (b == model.buttons[row][col + 1]) {
                swappable = true;
            }
        }
        return swappable;
    }//isAdjacent

    @Override
    public void onClick(View view) {
        Button b1 = (Button) view;//Button Clicked

        //Learned how to find the root view using this: https://stackoverflow.com/questions/4761686/how-to-set-background-color-of-an-activity-to-white-programmatically
        View root = view.getRootView();//Root View that contains EVERYTHING
        GridLayout layout = (GridLayout) root.findViewById(R.id.glayout);

        if (b1.getId() == model.resetId) {//Reset button is clicked
            model.shuffledNumbers = shuffleNumbers();
            for (int i = 0; i < model.buttons.length; i++) {
                for (int j = 0; j < model.buttons[i].length; j++) {
                    model.buttons[i][j].setVisibility(View.VISIBLE);
                    appendNumbers(model.shuffledNumbers[(i * 4) + j], model.buttons[i][j]);
                }
            }
        }
        else if (b1.getId() == model.solveId) {// Solves the puzzle
            for (int i = 0; i < model.buttons.length; i++) {
                for (int j = 0; j < model.buttons[i].length; j++) {
                    model.buttons[i][j].setVisibility(View.VISIBLE);
                    appendNumbers((i * 4) + j + 1, model.buttons[i][j]);
                }
            }
        }
        else{//Button within puzzle is clicked
            swapButtons(b1);
        }

        //This is where the background is checked after the buttons' actions are completed
        if (checkNumbers()) {
            //Numbers are all in the right spot, change the background color to the "correct color"
            layout.setBackgroundColor(Color.GREEN);
        }
        else {
            //Numbers are in the wrong spot, change the background color back to black
            layout.setBackgroundColor(Color.BLACK);
        }



    }//onClick
}
