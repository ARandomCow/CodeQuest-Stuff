import java.util.*;

public class prob45 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int step = input.nextInt();

                int num1 =0;
                int num2 =1;
                int temp = num1;
                int count = 2;
                if (step <= 1){
                    System.out.println(step + " = 0");
                    continue;
                }
                while (count < step)
                {

                    temp = num2;
                    num2 += num1;
                    num1 = temp;
                    count++;
                }
                
                System.out.println(step + " = "+ num2);

            }
        }
    }
}
