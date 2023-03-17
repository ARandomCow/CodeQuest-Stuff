import java.util.Scanner;

public class GameOfLife {
    
    public static void main(String[] args) {
        // Read Test Cases 
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numTests; i++) {
            // Generate Playing Grid
            int numGenerations = input.nextInt();
            input.nextLine();
            int[][] grid = new int[10][10];

            // Populate Grid
            for (int j = 0; j < 10; j++) {
                String line = input.nextLine();

                for (int k = 0; k < 10; k++) {
                    grid[j][k] = Integer.parseInt(line.charAt(k) + "");
                }
            }

            // Calculate Generations - Given in test case
            for (int j = 0; j < numGenerations; j++) {
                grid = nextGeneration(grid);
            }

            // Print new Grid 
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    System.out.print(grid[j][k]);
                }
                System.out.println();
            }
        }
    }
    
    // Calculates alive/dead cells based on a current generation grid
    public static int[][] nextGeneration(int[][] grid) {
        int[][] newGrid = new int[10][10];

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                int liveNeighbors = countLiveNeighbors(grid, i, j);
                if (grid[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        newGrid[i][j] = 0;
                    } else {
                        newGrid[i][j] = 1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        newGrid[i][j] = 1;
                    } else {
                        newGrid[i][j] = 0;
                    }
                }
            }
        }
        return newGrid;
    }
    
    // Used in nextGeneration to find live neighbor cells
    public static int countLiveNeighbors(int[][] grid, int row, int col) {
        int count = 0;
        
        for (int i = row - 1; i <= row + 1; i++) {

            for (int j = col - 1; j <= col + 1; j++) {

                if (i >= 0 && i < 10 && j >= 0 && j < 10 && !(i == row && j == col)) {
                    count += grid[i][j];
                }
            }
        }
        return count;
    }
}
