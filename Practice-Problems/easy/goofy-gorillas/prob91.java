import java.util.*;

public class prob91 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                boolean smile1 = input.nextBoolean();
                boolean smile2 = input.nextBoolean();

                if ((smile1 && smile2) || (!smile1 && !smile2)){
                    System.out.println("true");
                } else{
                    System.out.println("false");
                }
            }
        }
    }
}