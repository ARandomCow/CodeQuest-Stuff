import java.util.*;

public class prob48
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String name = delimiters.delimit(line, 0, ":");
                line = line.substring(line.indexOf(":")+1);
                List<String> bats = new ArrayList<String>();
                while(line.indexOf(",") != -1){
                    bats.add(delimiters.delimit(line, 0, ","));
                    line = line.substring(line.indexOf(",")+1);
                }
                bats.add(line);

                int b1Count = 0;
                int b2Count = 0;
                int b3Count = 0;
                int hRCount = 0;

                int totalBats = bats.size();
/*                
                for (String bat: bats){
                    System.out.print(bat);
                }
                System.out.println("");
/* */
                for (String bat: bats)
                {
                    if (bat.equals("1B")){
                        b1Count++;
                    } else
                    if (bat.equals("2B")){
                        b2Count++;
                    } else
                    if (bat.equals("3B")){
                        b3Count++;
                    } else
                    if (bat.equals("HR")){
                        hRCount++;
                    } else
                    if (bat.equals("BB")){
                        totalBats--;
                    }
                }
                if (totalBats == 0){
                    System.out.println(name + "=" + "0.000");
                    continue;
                }

                double SLG = (double) ((b1Count) + (b2Count*2) + (b3Count*3) + (hRCount*4))/totalBats;
//                System.out.println(SLG);
                String SLGstring = round(SLG,3);

                System.out.println(name + "=" + SLGstring);
            }
        }
    }





    private static String round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        String thing = String.valueOf((double) Math.round(value * scale) / scale);
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