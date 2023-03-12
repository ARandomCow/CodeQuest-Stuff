import java.util.*;

public class prob13 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int years = input.nextInt();
                for (int y = 0; y< years; y++){
                    double year = input.nextDouble();
                    if (year < 1582 || year%4 != 0){
                        System.out.println("No");
                    } else 
                    if (year%100 != 0){
                        System.out.println("Yes");
                    } else
                    if (year%400 != 0){
                        System.out.println("No");
                    } else{
                        System.out.println("Yes");
                    }
                }

            }
        }
    }
}