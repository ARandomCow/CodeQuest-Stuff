import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class prob2 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int num = input.nextInt();
                double result = factorial(num);
                BigDecimal thing = BigDecimal.valueOf(result);
                String str = thing.toPlainString();
                if (str.contains(".")){
                    str = str.substring(0, str.indexOf("."));
                }
                System.out.println(str);
            }
        }
    }

    public static double factorial(int n){
        double result = n;
        for (int i = n-1; i>0; i--){
            result *= i;
        }
        return result;
    }


}



