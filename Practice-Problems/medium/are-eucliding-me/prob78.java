import java.util.*;

public class prob78
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                int int1 = Integer.parseInt(Delimiters.delimit(line, 0, ","));
                int int2 = Integer.parseInt(Delimiters.delimit(line, ",", line.length()));
                int larger = int2;
                int smaller = int1;
                if (int1 > int2){
                    larger = int1;
                    smaller = int2;
                }


                while (smaller != larger)
                {
                    System.out.println(larger+ "-" + smaller + "=" + (larger - smaller));
                    int temp = larger - smaller;
                    if (temp > smaller){
                        larger = temp;
                    } else {
                        larger = smaller;
                        smaller = temp;
                    }
                }
                System.out.println(larger+ "-" + smaller + "=" + (larger - smaller));
                if (smaller == 1){
                    System.out.println("COPRIME");
                } else{
                    System.out.println("NOT COPRIME");
                }
            }
        }
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
        public static int[] delimitAllInts(String line, String spacer){
            List<Integer> resultList = new ArrayList<Integer>();
    
            while(line.contains(spacer)){
                resultList.add(Integer.parseInt(delimit(line, 0, spacer)));
                line = line.substring(line.indexOf(spacer)+spacer.length());
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
    
    
        public static String[] delimitAllStrings(String line, String spacer){
            List<String> resultList = new ArrayList<String>();
    
            while(line.contains(spacer)){
                resultList.add(delimit(line, 0, spacer));
                line = line.substring(line.indexOf(spacer)+spacer.length());
            }
            resultList.add(line);
    
            String[] resultArray = new String[resultList.size()];
            int i = 0;
            for (String result: resultList){
                resultArray[i] = result;
                i++;
            }
            return resultArray;
        }
    }
    
}