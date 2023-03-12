import java.util.*;

public class prob168
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double diameter = input.nextDouble();
                double gearRatio = input.nextDouble();
                double wattsPerRev = input.nextDouble();
                double rpm = input.nextDouble();
                double capacity = input.nextDouble();
                double voltage = input.nextDouble();
                double distance = input.nextDouble();

                double circumfirence = diameter * Math.PI/100;
                double wheelRotations = distance/circumfirence;

                double totalRevs = wheelRotations * gearRatio;

                double totalWatts = totalRevs * wattsPerRev;

                double totalAmps = totalWatts/voltage;

                double minutes = totalRevs/rpm;

                double ampHours = (totalAmps*minutes)/60;

                if (ampHours < capacity){
                    System.out.println("Success " + decRoundString(minutes, 4));
                } else{
                    System.out.println("Fail");
                }







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