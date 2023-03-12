import java.util.*;

public class prob70
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int int1 = input.nextInt();
                int int2 = input.nextInt();

                if (int1 == int2){
                    System.out.println(int1*4);
                } else{
                    System.out.println(int1+int2);
                }

            }
        }
    }
}