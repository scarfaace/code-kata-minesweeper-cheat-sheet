package minesweeper.cheats;

import minesweeper.cheats.models.Cell;

public class MinesFieldCheatsCreator {

    public int[][] creator(MinesField minesField) {
        Cell[][] minesFieldArray = minesField.getMinesField();
        int[][] minesCheatsArray = new int[minesField.getFieldHeight()][minesField.getFieldWidth()];

        for(int y=0; y<=minesField.getFieldHeight(); y++) {
            for(int x=0; x<=minesField.getFieldWidth(); x++) {
                Cell currentCell = minesFieldArray[y][x];
                minesCheatsArray[y][x] = currentCell.getMinesCountAround();
            }
        }
        return minesCheatsArray;
    }

}
