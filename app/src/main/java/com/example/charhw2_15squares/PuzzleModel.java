package com.example.charhw2_15squares;

/**
 * Author: Ashton Char
 * Course: CS 301A
 * Date: 2/14/23
 */

import android.widget.Button;

import java.util.Random;

public class PuzzleModel {
    private int row;
    private int col;
    protected final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    protected Button[][] buttons;
    private Random rand;
}
