import java.math.BigInteger;
import java.math.BigDecimal;
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

                BigInteger num1 = BigInteger.valueOf(0);
                BigInteger num2 = BigInteger.valueOf(1);
                BigInteger temp = num1;
                int count = 2;
                if (step <= 1){
                    System.out.println(step + " = 0");
                    continue;
                }
                while (count < step)
                {

                    temp = num2;
                    num2 = num2.add(num1);
                    num1 = temp;
                    count++;
                }
                
//                System.out.println(num2);

                System.out.println(step + " = "+ num2);
/* */
            }
        }
    }

}
