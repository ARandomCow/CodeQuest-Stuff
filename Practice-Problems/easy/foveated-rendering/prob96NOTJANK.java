import java.util.*;

public class prob96NOTJANK {


    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());

            System.out.println("Test Cases: " + testCases);

            for(int testcase = 0; testcase < testCases; testcase++) {
                System.out.println("\nTest Case: " + testcase);
                
                // Point 
                int x = input.nextInt();
                int y = input.nextInt();

                // Create Grid
                int Grid[][] = new int[20][20];

                // Populate Point
                Grid[x][y] = 100;

                // Populate 50%
                int[][] cells50 = getAdjacentCells(x, y);

                //System.out.println("Adjacent Count: " + cells50.length); 

                for (int q = 0; q<9; q++) {
                    //System.out.println("\nX: " + cells50[0][q]);
                    //System.out.println("Y: " + cells50[1][q]);
                    Grid[cells50[0][q]][cells50[1][q]] = 50;
                }

                //System.out.println("X: " + x);
                //System.out.println("Y: " + y);


                // Print Grid 
                for (int i = 0; i<Grid.length; i++){
                    int[] rows = Grid[i];
                    for (int z = 0; z<rows.length-1; z++){
                        System.out.print(rows[z] + " ");
                    }
                    System.out.print(rows[rows.length-1] + "\n ");
                }
                
            }
        }
    
    }


    public static int[][] getAdjacentCells(int x, int y) {
        int[][] adjacentCells = new int[9][9];
        
        // Find Adjacent X Coordinates
        for (int i = 0; i<3; i++) {
            adjacentCells[0][i] = x-1;
            if (i == 0) {
                adjacentCells[1][i] = y+1; 
            }
            else if (i == 1) {
                adjacentCells[1][i] = y-1; 
            }
            else {
                adjacentCells[1][i] = y; 
            }
        }
        for (int i = 3; i<6; i++) {
            adjacentCells[0][i] = x+1;
            if (i == 3) {
                adjacentCells[1][i] = y+1; 
            }
            else if (i == 4) {
                adjacentCells[1][i] = y-1; 
            }
            else {
                adjacentCells[1][i] = y; 
            }
        }
        for (int i = 6; i<8; i++) {
            adjacentCells[0][i] = x; 
            if (i == 6) {
                adjacentCells[1][i] = y-1;
            }
            else {
                adjacentCells[1][i] = y+1;
            }
        }
        
       
        
        // Resize the array to remove any unused elements
        //adjacentCells = Arrays.copyOf(adjacentCells, index);
        
        return adjacentCells;
    }
    
    
}
