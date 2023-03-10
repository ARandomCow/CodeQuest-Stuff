import java.util.*;

public class prob96 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int row = input.nextInt();
                int column = input.nextInt();
                int Grid[][] = new int[20][20];
                int[] thing = new int[20];

                for (int i = 0; i<20; i++){
                    thing[i] = 10;
                }
                for (int i = 0; i<Grid.length; i++){
                    Grid[i] = thing;
                }

                int[] bing = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,};
                int[] bingUp = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,};
                int[] bingDown = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,};
                int[] bingUpUp = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,};
                int[] bingDownDown = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,};

                
 


                for (int i = column-1; i<=column+1; i++){
                    if (i>=0 && i <= 19){
                        bing[i] = 50;
                        bingUp[i] = 50;
                        bingDown[i] = 50;
                    }
                }
                
                for (int i = column-2; i<= column+2; i+=4){
                if (i>=0 && i<=19){
                    bing[i] = 25;
                    bingUp[i] = 25;
                    bingDown[i] = 25;    
                }
                }

                for (int i = column -2; i<=column +2; i++){
                    if (i>=0 && i <= 19){
                        bingUpUp[i] = 25;
                        bingDownDown[i]= 25;
                    }
                }

                bing[column] = 100;

                if (row-2 >= 0 && row-2 <=19){Grid[row-2] = bingUpUp;};
                if (row-1 >= 0 && row-1 <=19){Grid[row-1] = bingUp;};
                if (row >= 0 && row <=19){Grid[row] = bing;};
                if (row+1 >= 0 && row+1 <=19){Grid[row+1] = bingDown;};
                if (row+2 >= 0 && row+2 <=19){Grid[row+2] = bingDownDown;};
                
                
                



                for (int i = 0; i<Grid.length; i++){
                    int[] rows = Grid[i];
                    for (int num: rows){
                        System.out.print(num + " ");
                    }
                    System.out.println("");
                }



            }
        }
    }
}