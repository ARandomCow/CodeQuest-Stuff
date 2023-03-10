import java.util.*;

public class prob25 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int square = input.nextInt();
                for (int i = 0; i< square; i++){
                    for (int y =0; y<square; y++){
                        System.out.print("#");
                        if (y != square-1){
                            System.out.print(" ");
                        }
                    }

                        System.out.println("");

                }
            }
        }
    }
}