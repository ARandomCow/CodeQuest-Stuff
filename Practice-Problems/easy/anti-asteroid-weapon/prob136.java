import java.util.*;

public class prob136
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int asteroids = input.nextInt();
                int[][] coords = new int[asteroids][];
                double[] distances = new double[asteroids];

                for (int asteroid = 0; asteroid< asteroids; asteroid++){


                    int x = input.nextInt();
                    int y = input.nextInt();
                    int[] xy = {x, y};

                    coords[asteroid] = xy;
                    distances[asteroid] = Math.sqrt((x*x) + (y*y));
                }
                for (int i =0; i<asteroids; i++){
                    int index = minIndex(distances);
                    int[] coord = coords[index];

                    System.out.println(coord[0] + " " + coord[1]);
                    distances[index] = Double.MAX_VALUE;
                }
                

            }
        }
    }

    public static int minIndex(double[] arr){
        double temp = arr[0];
        int index = 0;
        for (int i =0; i< arr.length; i++){
            if (temp > arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }
}