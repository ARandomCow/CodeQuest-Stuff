import java.util.*;

public class prob77
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double x = input.nextDouble();
                double y = input.nextDouble();
                double z = input.nextDouble();

                String xStr = trailingAndLeadingZeroes(((x+180)%360), 2, 3);
                String yStr= trailingAndLeadingZeroes(((y+180)%360), 2, 3);
                String zStr = trailingAndLeadingZeroes(((z+180)%360), 2, 3);

                System.out.println(xStr + " " + yStr +" " + zStr);

            }
        }
    }

    public static double decRound (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

/*
 * @param num - double you want in a specified format
 * @param leading - number of digits before decimal place. Can be any number greater than or equal to 0
 * @param trailing - number of digits after decimal place. 
 * Should be as big as the number of digits in your largest number (if that's 999, then trailing should equal 3)
 * @result a string of your number with the specified number of leading and trailing zeros
 */
    public static String trailingAndLeadingZeroes(double num, int trailing, int leading){
        int scale = (int) Math.pow(10, trailing);
        String result = String.valueOf((double) Math.round(num * scale) / scale);
        if (trailing == 0){
            result = result.substring(0, result.length()-2);
        } else 
        {
            while (result.length() - trailing< result.indexOf(".")+1){
                result += "0";
            }
        }
        while (leading> result.indexOf(".")){
            result = "0" + result;
        }
        return result;
    }
}