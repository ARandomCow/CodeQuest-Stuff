import java.util.*;

public class prob29 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                double bill = Double.parseDouble(Delimiters.delimit(line, "$", line.length()));

                System.out.println("Total of the bill: $" + decRoundString(bill, 2));

                System.out.println("15% = $" + decRoundString(bill*0.15, 2));
                System.out.println("18% = $" + decRoundString(bill*0.18, 2));
                System.out.println("20% = $" + decRoundString(bill*0.20, 2));

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


    
    public static class Delimiters {

        /*
        returns whatever is in between the start and end (can use either delimiter strings or indexes)
        */
    
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
    
            /*
        returns all the things separated by a space but the string probably has to be of a certain format
        string cannot have a delimiter at the very beginning or very end (i think)
        for example:
        B1,B2,BB,K returns ["B1", "B2", "BB", "K"] and all is good
        if it looks like ,B1,B2, then youre probably not as happy
        change it from int[] to String or whatever just by getting rid of all the parseInts and making resultList List<String> and resultArray String[].
        */
        public static int[] delimitAll(String line, String spacer){
            List<Integer> resultList = new ArrayList<Integer>();
    
            while(line.contains(spacer)){
                resultList.add(Integer.parseInt(delimit(line, 0, spacer)));
                line = line.substring(line.indexOf(spacer)+1);
            }
            resultList.add(Integer.parseInt(line));
    
            int[] resultArray = new int[resultList.size()];
            int i = 0;
            for (Integer result: resultList){
                resultArray[i] = result;
                i++;
            }
            return resultArray;
        }
    }

}