import java.math.BigInteger;
import java.util.*;

public class prob12{

    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());
            BigInteger sum = BigInteger.valueOf(0);

            for(int testcase = 0; testcase < testCases; testcase++) 
            {
                sum = BigInteger.valueOf(0);
                int numberCases = Integer.parseInt(input.nextLine());

                for (int i =0 ; i<numberCases; i++){
                BigInteger num = new BigInteger(input.nextLine());
                    sum = sum.add(num);
                }
                System.out.println(sum);
            }

        }
    }
}
