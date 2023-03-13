import java.util.Scanner;

public class bradySolution {

    public static int[][] calculateRenderingQuality(int x, int y) {
        int[][] rendering = new int[20][20];
        // full quality at the center block
        rendering[x][y] = 100;
        // half quality for the surrounding blocks
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if (i >= 0 && i < 20 && j >= 0 && j < 20 && rendering[i][j] == 0) {
                    rendering[i][j] = 50;
                }
            }
        }
        // quarter quality for the blocks surrounding the half quality blocks
        for (int i = x-2; i <= x+2; i++) {
            for (int j = y-2; j <= y+2; j++) {
                if (i >= 0 && i < 20 && j >= 0 && j < 20 && rendering[i][j] == 0) {
                    rendering[i][j] = 25;
                }
            }
        }
        // minimum quality for all other blocks
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (rendering[i][j] == 0) {
                    rendering[i][j] = 10;
                }
            }
        }
        return rendering;
    }
    



    public static void main(String[] args) {

        int x = 0, y = 0;


        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());

            //System.out.println("Test Cases: " + testCases);

            for(int testcase = 0; testcase < testCases; testcase++) {
                //System.out.println("\nTest Case: " + testcase);
                
                // Point 
                x = input.nextInt();
                y = input.nextInt();

                int[][] rendering = calculateRenderingQuality(x, y);

                // Print Grid
                for (int i = 0; i<rendering.length; i++){
                    int[] rows = rendering[i];
                    for (int z = 0; z<rows.length-1; z++){
                        System.out.print(rows[z] + " ");
                    }
                    System.out.print(rows[rows.length-1]);
                    System.out.println("");
                }
            }
        }

    }
}
