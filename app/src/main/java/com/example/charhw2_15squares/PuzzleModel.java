package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23
 */

import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class PuzzleModel {
    protected final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    int[] buttonIds = {R.id.button_00, R.id.button_01, R.id.button_02, R.id.button_03,
                        R.id.button_10, R.id.button_11, R.id.button_12, R.id.button_13,
                        R.id.button_20, R.id.button_21, R.id.button_22, R.id.button_23,
                        R.id.button_30, R.id.button_31, R.id.button_32, R.id.button_33};
    protected ArrayList<Button> buttons = new ArrayList<Button>();
}
