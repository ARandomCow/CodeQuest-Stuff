import java.util.*;

public class prob1
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double num = input.nextDouble();
                String str = "";
                if (num%3==0){
                    str +=("LOCKHEED");
                }
                if (num%7 ==0){
                    str +=("MARTIN");
                }
                if (str.equals("")){
                    str += (int)num;
                }
                System.out.println(str);
            }
        }
    }
}