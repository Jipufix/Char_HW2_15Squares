package com.example.charhw2_15squares;

import android.content.Context;
import android.view.SurfaceView;

public class PuzzleView extends SurfaceView {
private PuzzleModel puzzleModel;

    public PuzzleView(Context context) {
        super(context);

        //Initializes the PuzzleModel object
        puzzleModel = new PuzzleModel();


    }//ctor
}
