import java.util.*;

public class prob192
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String[] nums = stringToArray(line);
                if (line.length() != 10){
                    System.out.println("INVALID");
                    continue;
                }
/*
                for (String num: nums){
                    System.out.print(num + ", ");
                }
                System.out.println("");
*/
                int result = 0;

                for (int num = 0; num < nums.length-1; num++)
                {
                    int number = 0;
                    if (nums[num].equals("X")){
                        number = 10;
                    } else {
                        number = Integer.parseInt(nums[num]);
                    }
                    result += number * (10 - num);
                }

//                System.out.println(result);
                if (result % 11 == 0){
                    result = 0;
                } else {
                result = ((result%11)-11) * -1;
                }
                
                if (nums[nums.length-1].equals("X")){
                    if (result == 10){
                        System.out.println("VALID");
                    } else {
                        System.out.println("INVALID");
                    }
                } else
                if (result == Integer.parseInt(nums[nums.length -1])){
                    System.out.println("VALID");
                } else{
                    System.out.println("INVALID");
                }

            }
        }
    }



    /*
input = any string, probably nonempty
output = String[], with each element being a letter in that input string
*/
    
public static String[] stringToArray(String string)
{
    String[] result = new String[string.length()];
    for (int i = 0; i< string.length(); i++){
        result[i] = string.substring(i, i+1);
    }
    return result;
}

}