import java.util.*;

public class prob194
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double radius = input.nextDouble();
                double width = input.nextDouble();
                double height = input.nextDouble();

                for (int columns = 0; columns<=width; columns++){
                    for (int rows = 0; rows<=height; rows++){
                        if (Math.sqrt((columns*columns)+ (rows*rows)) > radius){
                            System.out.println(columns + "," + rows);
                        }
                    }
                }

            }
        }
    }
}