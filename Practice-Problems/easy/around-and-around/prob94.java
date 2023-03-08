import java.util.*;

public class prob94
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int distance = input.nextInt();
                final double PI = 3.1415926535;

                double result = 40075+(2*PI*distance);
                result = round(result, 1);
                System.out.println(result);
            }
        }
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }


}