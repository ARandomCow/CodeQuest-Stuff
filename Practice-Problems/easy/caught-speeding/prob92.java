import java.util.*;

public class prob92
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int speed = input.nextInt();
                boolean bday = input.nextBoolean();

                if (bday){
                    speed -= 5;
                }

                if (speed >= 81){
                    System.out.println("big ticket");
                } else 
                if (speed >= 61){
                    System.out.println("small ticket");
                } else 
                {System.out.println("no ticket");}

            }
        }
    }
}