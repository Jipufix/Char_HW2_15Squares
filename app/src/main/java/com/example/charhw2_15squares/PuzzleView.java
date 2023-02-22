package com.example.charhw2_15squares;

/*
  Author: Ashton Char
  Course: CS 301A
  Date: 2.8.23
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class PuzzleView extends SurfaceView{


    private PuzzleModel model;

    public PuzzleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Initializes the PuzzleModel object
        model = new PuzzleModel();

        //IDK what this does but I was told it was important
        setWillNotDraw(false);
    }//ctor


    @Override
    public void onDraw (Canvas canvas) {

    }

    /** PuzzleModel getter method */
    public PuzzleModel getPuzzleModel() {
        return model;
    }
}
