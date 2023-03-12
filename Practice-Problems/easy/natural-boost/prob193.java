import java.util.*;

public class prob193
{
    public static void main(String[] args)
    {

        final double earthRadius = 6370000;
        final double dayInSeconds = 86400;
        final double earthCirc = earthRadius*2*Math.PI;

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double theta = Math.abs(input.nextDouble());
                theta = Math.toRadians(theta);
                double newCirc = earthCirc*Math.cos(theta);
                double speed = newCirc/dayInSeconds;

                System.out.println((int) Math.floor(speed));
            }
        }
    }
}