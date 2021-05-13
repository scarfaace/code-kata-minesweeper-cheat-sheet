package minesweeper.cheats;

import lombok.Builder;
import minesweeper.cheats.models.Cell;


@Builder
public class MinesField {

    private Cell[][] minesField;

    public MinesField(Cell[][] minesField) {
        this.minesField = minesField;
    }

    public Cell[][] getMinesField() {
        return minesField;
    }

    // TODO fix these two getters (we need width and height)
    public int getHeight() {
        return minesField.length;
    }

    public int getWidth() {
        return minesField.length;
    }
}
