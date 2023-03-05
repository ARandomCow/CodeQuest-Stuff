import java.util.*;

public class prob5{

    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());
        

            for(int testcase = 0; testcase < testCases; testcase++) 
            {
                int fib = input.nextInt();
                int num1 =1;
                int num2 =1;
                int temp = num1;
                boolean in = false;

                while (num2 <= fib || fib == 0)
                {
                    if (fib == num2){
                        in = true;
                        break;
                    } else{
                        temp = num2;
                        num2 += num1;
                        num1 = temp;
                    }
                }
                if (in == true){
                    System.out.println("TRUE");
                } else{
                    System.out.println("FALSE");
                }
            }
        }
    }
}
