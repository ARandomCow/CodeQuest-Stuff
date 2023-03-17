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
 * @param intGrid - 2d array with possible repeats
 * @return Grid with no repeats
 */
    public static int[][] removeAllRepeats(Integer[][] intGrid)
    {

        List<Integer[]> intGridList = new ArrayList<Integer[]>(Arrays.asList(intGrid));
//        System.out.println("Current grid size: " + intGridList.size());
        for (int i = 0; i<intGridList.size(); i++){
            for (int y = i+1; y< intGridList.size(); y++){
                if(Arrays.equals(intGridList.get(i), intGridList.get(y))){
                    intGridList.remove(y);
                    y--;
                }
            }
        }
//        System.out.println("New grid size: " + intGridList.size());
        int[][] resultGrid = new int[intGridList.size()][];
        for (int i = 0; i<resultGrid.length; i++){
            resultGrid[i] = new int[intGridList.get(i).length];
            for (int y = 0; y<resultGrid[i].length;y++){
//                printIntArr(intList, ", ");
                resultGrid[i][y] = intGridList.get(i)[y].intValue();
            }
        }
        return resultGrid;
    }



/**
 * @param inputGrid - 2d array that you want sorted
 * @return - grid but the arrays have been swapped so that the arrays with the smallest numbers come first
 * THE ARRAYS THEMSELVES INSIDE THE GRID ARE UNALTERED
 */
    public static int[][] gridSort(int[][] inputGrid){
        int[][] grid = inputGrid;
        for (int firstIndex = 0; firstIndex< grid.length; firstIndex++){
            for (int sortIndex = firstIndex+1; sortIndex< grid.length; sortIndex++){
                int smallestGridLength = grid[firstIndex].length;
                if (grid[firstIndex].length > grid[sortIndex].length){
                    smallestGridLength = grid[sortIndex].length;
                }
                for (int element = 0; element< smallestGridLength; element++){
                    if (grid[sortIndex][element] < grid[firstIndex][element]){
                        int[] temp = grid[firstIndex];
                        grid[firstIndex] = grid[sortIndex];
                        grid[sortIndex] = temp;
                        break;
                    } else if (grid[sortIndex][element] > grid[firstIndex][element]){
                        break;
                    }
                }

            }
        }
        return grid;
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