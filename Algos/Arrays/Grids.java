import java.util.*;
import java.math.*;

public class Grids{

/**
 * @param im lazy theyre all self explanatory
 * @result the same Grid but a square at [rowNum][colNum] and a radius of radius around that point now have the value of value
 * does not break if at an edge
 */
    public static int[][] addSquare(int[][] Grid, int rowNum, int colNum, int radius, int value){
        int[][] result = Grid;
        int columns = Grid[0].length;
        for (int row = rowNum - radius; row<= rowNum+radius; row++){
            for (int col = colNum - radius; col <= colNum+radius; col++){
                if (row >= 0 && row < Grid.length && col >= 0 && col < columns) {
                    Grid[row][col] = value;
                }
            }
        }
        return result;
    }

/**
*@param self explanatory
*@result creates a chess board with a certain amount of rows and columns
* the top left corner is true and you can figure out what other items are true using that
* white = true, black = false
* im not racist i swear
 */
    public static boolean[][] makeChessBoard(rows, columns) {
        boolean[][] chessBoard = new boolean[rows][columns];
        for (int rowNum = 0; rowNum < rows; rowNum++) {
            for (int colNum = 0; colNum < columns; colNum++) {
                if ((rowNum % 2 == colNum%2) {
                    chessBoard[rowNum][colNum] = true;
                }
            }
        }
        return chessBoard;
    }



/**
* @param Grid - 2d array that you want printed
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