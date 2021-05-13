package minesweeper.cheats.models;

import lombok.Builder;

@Builder
public abstract class Cell {

    protected int x;
    protected int y;
    protected Cell[][] minesField;

    public Cell(int x, int y, Cell[][] minesField) {
        this.x = x;
        this.y = y;
        this.minesField = minesField;
    }

    public Cell fromString(String character) {
        if(character.equals("*")) {
            return new Mine();
        }
    }

    public abstract boolean isMine();

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getMinesCountAround() {

    }
}
