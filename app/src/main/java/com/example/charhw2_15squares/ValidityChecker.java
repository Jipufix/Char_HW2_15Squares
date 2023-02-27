package com.example.charhw2_15squares;

/**
 *  A supplemental class that checks to see if the shuffled puzzle
 *  has a valid solution.
 *
 *  Created as to not crowd up the already crowded puzzle controller class.
 */
public class ValidityChecker {
    /**
     * HELPER METHOD
     * Counts the number of inversions; An inversion occurs when
     * a trailing number has less value than the preceding number.
     *
     * @param tempArr The temporary array of shuffled ints to be checked
     * @return        The total number of inversions in "tempArr"
     */

    public int numInversions (int[] tempArr, PuzzleModel model) {
        int counter = 0;
        for (int i = 0; i < tempArr.length - 1; i++) {
            for (int j = i + 1; j < tempArr.length; j++) {
                if (tempArr[i] > tempArr[j])
                    counter++;
            }
        }
        return counter;
    }//numInversions

    /**
     * HELPER METHOD
     * Returns the row of the invisible button
     *
     * @return The row number of rows from the bottom starting from 1
     */
    private int indexOf16 (int[] tempArr, PuzzleModel model) {
        for (int i = model.puzzleSize - 1; i >= 0; i--) {
            for (int j = model.puzzleSize - 1; j >= 0; j--) {
                if (tempArr[(i * 4) + j] == 16) {
                    return model.puzzleSize - i;
                }
            }
        }
        return -1;
    }//indexOf16

    /**
     * Actual method to check whether or not a puzzle is solvable
     */
    public boolean checkValidity (int[] tempArr, PuzzleModel model) {
        int numInversions = numInversions(tempArr, model);
        int row = indexOf16(tempArr, model);//Taken from bottom to top, so you subtract from the total

        if (Math.sqrt(tempArr.length) % 2 == 1) {//odd number of rows
            return numInversions % 2 == 0;//Needs even inv
        }
        else {//even number of rows
            return ((row % 2 == 0) && (numInversions % 2 == 1) ||
                    (row % 2 == 1) && (numInversions % 2 == 0)); //Needs even row + odd inv or odd row + even inv
        }
    }//checkValidity
}
