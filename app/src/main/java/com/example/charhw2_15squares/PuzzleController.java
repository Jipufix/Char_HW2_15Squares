package com.example.charhw2_15squares;

/**
 * Author: Ashton Char
 * Course: CS 301A
 * Date: 2/14/23
 */
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.logging.Handler;

public class PuzzleController implements View.OnClickListener, Runnable {
    private PuzzleView view;
    private PuzzleModel model;

    public PuzzleController (PuzzleView v) {
        view = v;
        model = view.getPuzzleModel();
    }//ctor


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

    void addButton (int row, int col, View id) {

    }//addButton

    @Override
    public void onClick(View view) {

    }

    @Override
    public void run() {

    }
}
