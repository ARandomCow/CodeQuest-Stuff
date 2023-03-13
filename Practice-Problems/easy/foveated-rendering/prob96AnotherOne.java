import java.util.*;

public class prob96AnotherOne
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int rowNum = input.nextInt();
                int colNum = input.nextInt();
                int[][] Grid = new int[20][20];
                for (int i = 0; i < 20; i++) 
                {
                    for (int j = 0; j < 20; j++) 
                    {
                        Grid[i][j] = 10;
                    }
                }
                Grid = addSquare(Grid, rowNum, colNum, 2, 25);
                Grid = addSquare(Grid, rowNum, colNum, 1, 50);
                Grid[rowNum][colNum] = 100;


                // Print Grid
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
    }
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
}