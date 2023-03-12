import java.util.*;
import java.util.stream.Stream;

public class prob4 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());
    

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double totalSavings = 0;
                int charges = input.nextInt();
                for (int charge = 0; charge< charges; charge++){
                    double money = input.nextDouble();
                    double saving = 0;
                    if (money%1!=0){
                        saving = ((money%1) -1) * -1;
                    }

//                    System.out.println(saving);
                    totalSavings += saving;
                    int moneyInt = (int) Math.round(money+0.499);
                    System.out.println(moneyInt);

                }
                System.out.println(decRoundString(totalSavings, 2));
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