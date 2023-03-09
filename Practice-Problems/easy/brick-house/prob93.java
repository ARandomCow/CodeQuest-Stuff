import java.util.*;

public class prob93
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int inch1 = input.nextInt();
                int inch5 = input.nextInt();
                int wall = input.nextInt();

                if ((wall <= (inch1) + (inch5 * 5)) && (wall%5 <= inch1)){
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }


            }
        }
    }

    
}