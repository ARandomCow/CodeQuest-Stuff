import java.util.*;

public class prob187
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int first = input.nextInt();
                int second = input.nextInt();
                int result = input.nextInt();
                if (first+second == result){
                    System.out.println("Addition");
                } else
                if (first-second == result){
                    System.out.println("Subtraction");
                } else
                if (first*second == result){
                    System.out.println("Multiplication");
                } else
                if ((int)(first/second) == result){
                    System.out.println("Division");
                } else
                if (first%second == result){
                    System.out.println("Modulo");
                } 


            }
        }
    }
}