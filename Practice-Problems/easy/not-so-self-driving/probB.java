import java.util.*;

public class probB
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String speedString = delimit(line, 0, ":");
                String distString = delimit(line, ":", line.length());

//                System.out.println(speedString);
//                System.out.println(distString);

                 double speed = Double.parseDouble(speedString);
                  double dist = Double.parseDouble(distString);

                if (dist <= speed){
                    System.out.println("SWERVE");
                } else if (dist <= speed * 5){
                    System.out.println("BRAKE");
                } else{
                    System.out.println("SAFE");
                }
                
            }
        }
    }




        /*
        returns whatever is in between the start and end (can use either delimiter strings or indexes)
        */
    
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