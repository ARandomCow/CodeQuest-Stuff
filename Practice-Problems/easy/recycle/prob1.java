import java.util.*;

public class prob1
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double cans = input.nextDouble();
                double plastic = input.nextDouble();
                double glass = input.nextDouble();

                cans *= 31 * 0.05;
                plastic *= 15 * 0.10;
                glass *= 0.10;

                System.out.println("$" + decRoundString(cans + plastic + glass, 2));  

            }
        }
    }

    private static String decRoundString (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        String thing = String.valueOf((double) Math.round(value * scale) / scale);
        if (!thing.contains(".")){
            return thing;
        } else
        if (thing.indexOf(".") < thing.length()+precision){

            while (thing.length() - precision < thing.indexOf(".")+1){
                thing += "0";
            }
        }
        return thing;
    }
}