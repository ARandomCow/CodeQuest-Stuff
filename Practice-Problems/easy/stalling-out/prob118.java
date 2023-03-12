import java.util.*;

public class prob118
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double criticalAngle = input.nextDouble();
                double portAngle = input.nextDouble();
                double starAngle = input.nextDouble();

                double avgAngle = (portAngle+starAngle)/2;

                if (Math.abs(portAngle - starAngle) > 5){
                    System.out.println("WARNING");
                } else
                if (avgAngle >= criticalAngle+2){
                    System.out.println("ALARM");
                } else 
                {
                    System.out.println("OK");
                }

            }
        }
    }
}