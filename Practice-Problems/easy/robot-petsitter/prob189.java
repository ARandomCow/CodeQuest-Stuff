import java.util.*;

public class prob189
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String[] directions = stringToArray(line);
                int x =0;
                int y = 0; 

                for (String dir: directions){
                    if (dir.equals("L")){
                        x--;
                    } else 
                    if (dir.equals("R")){
                        x++;
                    } else 
                    if (dir.equals("U")){
                        y++;
                    } else 
                    if (dir.equals("D")){
                        y--;
                    }   
                }
                if (x==0 && y==0){
                    System.out.println("TRUE");
                } else{
                    System.out.println("FALSE");
                }
            }
        }
    }

    public static String[] stringToArray(String string)
    {
        String[] result = new String[string.length()];
        for (int i = 0; i< string.length(); i++){
            result[i] = string.substring(i, i+1);
        }
        return result;
    }

}