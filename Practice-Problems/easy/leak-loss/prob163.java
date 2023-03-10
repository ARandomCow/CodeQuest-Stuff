
import java.util.*;


public class prob163 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double volume = input.nextDouble();
                double enter = input.nextDouble();
                double exit = input.nextDouble();

                double result = ((volume)/(enter-exit)) * exit;
                System.out.println((int) decRound(result, 0));

            }
        }
    }

    public static double decRound (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}