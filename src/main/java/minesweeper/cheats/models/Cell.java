package minesweeper.cheats.models;

import lombok.Builder;
import lombok.Getter;
import minesweeper.cheats.MinesField;
import minesweeper.cheats.exceptions.InvalidCellCharacterException;

import java.util.List;

@Getter
@Builder
public abstract class Cell {

    protected CellPosition cellPosition;
    protected MinesField minesField;

    public Cell(int x, int y, MinesField minesField) {
        this.minesField = minesField;
        this.cellPosition = CellPosition.builder()
                .x(x)
                .y(y)
                .build();
    }

    public static Cell fromString(String character, int x, int y, MinesField minesField) {
        if(character.equals("*")) {
            return new Mine(x, y, minesField);
        } else if(character.equals(".")) {
            return new EmptyCell(x, y, minesField);
        } else {
            throw new InvalidCellCharacterException("Could not create a new Cell due to invalid cell character.");
        }
    }


    public abstract boolean isMine();

    public List<Cell> getNeighbourhood() {
        return minesField.getCellNeighbourhood(this);
    }

    public int getMinesCountAround() {
        return (int) getNeighbourhood().stream()
                .filter(Cell::isMine)
                .count();
    }

}
