import java.util.*;

public class prob74
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int start = input.nextInt();
                System.out.print(start);
                int count = 1;
                while (start != 1){
                    count++;
                    if (start%2 == 0){
                        start /= 2;
                    } else{
                        start = (start * 3)+1;
                    }
                    
                }
                System.out.print(":" + count);
                System.out.println("");

            }
        }
    }
}