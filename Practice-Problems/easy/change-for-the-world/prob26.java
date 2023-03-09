import java.util.*;

public class prob26
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                double money = Double.parseDouble(delimiters.delimit(line, "$", line.length()));
                int q = 0;
                int d = 0;
                int n = 0;
                int p = 0;

                double originalMoney = money;

                while (money >= 0.25){
                    money -= 0.25;
                    money = decRound(money, 2);
                    q++;
                }
//                System.out.println(money);
                while (money >= 0.10){
                    money -= 0.10;
                    money = decRound(money, 2);
                    d++;
                }
//                System.out.println(money);
                while (money >= 0.05){
                    money -= 0.05;
                    money = decRound(money, 2);
                    n++;
                }
//                System.out.println(money);
                while (money > 0.00){
                    money -= 0.01;
                    money = decRound(money, 2);
                    p++;
                }

                System.out.println("$" + decRoundString(originalMoney, 2));
                System.out.println("Quarters=" + q);
                System.out.println("Dimes=" + d);
                System.out.println("Nickels=" + n);
                System.out.println("Pennies=" + p);
            }
        }
    }

    public static double decRound (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
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


}