import java.util.*;

public class prob65
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int grade = input.nextInt();
                if (grade >= 70){
                    System.out.println("PASS");
                } else{
                    System.out.println("FAIL");
                }

            }
        }
    }
}