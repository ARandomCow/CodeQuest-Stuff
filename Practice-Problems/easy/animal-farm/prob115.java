import java.util.*;




public class prob115
{

public static class delimiters{
    public static String delimit(String string, String start, String end){
        int startIndex = string.indexOf(start);
        int endIndex = string.indexOf(end);
        return string.substring(startIndex+1, endIndex);
    }
    
    public static String delimit(String string, int startIndex, String end){
        int endIndex = string.indexOf(end);
        return string.substring(startIndex, endIndex);
    }
    
    public static String delimit(String string, String start, int endIndex){
        int startIndex = string.indexOf(start);
        return string.substring(startIndex+1, endIndex);
    }
}
    


public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
//                System.out.println(line);
                int turkeys = input.nextInt();
                int goats = input.nextInt();
                int horses = input.nextInt();

                System.out.println((turkeys*2) + ((goats+horses)*4));

            }
        }
    }
}




