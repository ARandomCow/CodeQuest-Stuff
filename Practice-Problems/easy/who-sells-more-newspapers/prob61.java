import java.util.*;

public class prob61
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double times = input.nextDouble();
                double herald = input.nextDouble();

                if (times - herald > 0){
                    System.out.println("Times has " + (int)(times-herald) + " more subscribers");
                } else
                if (times - herald < 0){
                    System.out.println("Herald has " + (int)(herald - times) + " more subscribers");
                } else{
                    System.out.println("Times and Herald have the same number of subscribers");
                }

            }
        }
    }
}