import java.util.*;

public class prob68 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String color = input.nextLine().toLowerCase();
                if (color.contains("orange")){
                    System.out.println("In order to make " + color + ", red and yellow must be mixed.");
                } else 
                if (color.contains("green")){
                    System.out.println("In order to make " + color + ", blue and yellow must be mixed.");
                } else 
                if (color.contains("violet")){
                    System.out.println("In order to make " + color + ", blue and red must be mixed.");
                } else {
                    System.out.println("No colors need to be mixed to make " + color + ".");
                }
            }
        }
    }



}