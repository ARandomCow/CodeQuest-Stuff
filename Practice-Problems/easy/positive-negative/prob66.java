import java.util.*;

public class prob135
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int num = input.nextInt();
                if (num>0){
                    System.out.println("POSITIVE");
                } else{
                    System.out.println("NEGATIVE");
                }


            }
        }
    }
}