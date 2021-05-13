package minesweeper.cheats.factory;

import lombok.Builder;
import lombok.Getter;
import minesweeper.cheats.MinesField;
import minesweeper.cheats.models.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinesFieldFactory {

    public MinesField fromTxt(String txtFilePath) {
        try {
            FieldDimensions fieldDimensions = getFieldDimensions(txtFilePath);
            Cell[][] minesField = new Cell[fieldDimensions.getHeight()][fieldDimensions.getWidth()];

            int lineNumber = 0;
            File myObj = new File(txtFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] lineCharacters = myReader.nextLine().split("");
                Cell[] cells = Arrays.stream(lineCharacters)
                        .map(character -> )
                minesField[lineNumber] = lineCharacters;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed reading field file.");
            e.printStackTrace();
        }
    }

    private FieldDimensions getFieldDimensions(String txtFilePath) {
        int height = 0;
        int width = 0;
        Set<Integer> widths = new HashSet<Integer>();

        try {
            File myObj = new File(txtFilePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                int lineWidth = line.length();
                if(!widths.contains(lineWidth) && !widths.isEmpty()) {
                    throw new RuntimeException("Line widths of field not always the sane.");
                }
                widths.add(lineWidth);
                width = lineWidth;
                height += 1;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed reading field file.");
            e.printStackTrace();
        }
        if(height == 0) {
            throw new RuntimeException("Field is empty");
        }
        return FieldDimensions.builder()
                .height(height)
                .width(width)
                .build();
    }

    @Getter
    @Builder
    private class FieldDimensions {
        private int height;
        private int width;
    }
}
