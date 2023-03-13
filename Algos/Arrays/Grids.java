import java.util.*;
import java.math.*;

public class Grids{

/*
 * @param im lazy theyre all self explanatory
 * @result the same Grid but a square at [rowNum][colNum] and a radius of radius around that point now have the value of value
 * does not break if at an edge
 */
    public static int[][] addSquare(int[][] Grid, int rowNum, int colNum, int radius, int value){
        int[][] result = Grid;
        for (int row = rowNum - radius; row<= rowNum+radius; row++){
            for (int col = colNum - radius; col <= colNum+radius; col++){
                if (row >= 0 && row < 20 && col >= 0 && col < 20) {
                    Grid[row][col] = value;
                }
            }
        }
        return result;
    }

/*
 * a print method that abides by codeQuest's stupid rules like no spaces at the end of lines
 */
    public static void printGrid(int[][]Grid){
        for (int i = 0; i<Grid.length; i++){
            int[] rows = Grid[i];
            for (int z = 0; z<rows.length-1; z++){
                System.out.print(rows[z] + " ");
            }
            System.out.print(rows[rows.length-1]);
            System.out.println("");
        }
    }
}