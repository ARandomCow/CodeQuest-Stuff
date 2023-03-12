import java.util.*;

public class prob72
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String onesDigit = line.substring(line.length()-3, line.length()-2);
                String edgeCase = "filler";
                if (line.length() >= 4){
                    edgeCase = line.substring(line.length()-4, line.length()-2);
                }

//                System.out.println(onesDigit);

                if (onesDigit.equals("1") &&
                    !edgeCase.equals("11")){
                    System.out.println(line.substring(0, line.length()-2) + "st");
                } else
                if (onesDigit.equals("2") &&
                !edgeCase.equals("12")){
                    System.out.println(line.substring(0, line.length()-2) + "nd");
                } else
                if (onesDigit.equals("3") &&
                    !edgeCase.equals("13")){
                    System.out.println(line.substring(0, line.length()-2) + "rd");
                } else{
                    System.out.println(line);
                }

            }
        }
    }
}