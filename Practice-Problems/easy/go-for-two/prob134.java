import java.util.*;

public class prob134 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int yours = input.nextInt();
                int theirs = input.nextInt();
                int diff = theirs - yours;

                if (diff == 15 || diff == 13 || diff == 11 || diff == 10 || diff == 8 || 
                diff == 5 || diff == 4 || diff == 2 || diff == -1 || diff == -5 || diff == -12){
                    System.out.println("2");
                } else{
                    System.out.println("1");
                }

            }
        }
    }
}
