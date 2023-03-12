import java.util.*;

public class prob62 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());
    

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                for (int i = line.length(); i>0; i--){
                    System.out.print(line.substring(i-1, i));
                }
                System.out.println("");

            }
        }
    }
}