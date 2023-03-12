import java.util.*;

public class prob70 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());
    

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double density = input.nextDouble();
                double volume = input.nextDouble();

                System.out.println(decRoundString(volume*density, 2));

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