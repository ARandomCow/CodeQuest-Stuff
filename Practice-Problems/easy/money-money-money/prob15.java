import java.util.*;

public class prob15 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String name = input.nextLine();
                int years = Integer.parseInt(input.nextLine());
                int[] yearArray = new int[years];
                double[] gdpArray = new double[years];

                System.out.println(name + ":");

                for (int y = 0; y< years; y++){
                    String line = input.nextLine();
                    double gdp = Double.parseDouble(Delimiters.delimit(line, 0, " "));
                    int year = Integer.parseInt(Delimiters.delimit(line, " ", line.length()));

                    gdpArray[y] = gdp;
                    yearArray[y] = year;

                }
                for (int i = 0; i<years; i++){
                    int index = minIndex(yearArray);
                    System.out.print(yearArray[index] + " ");
                    for (int k = 0; k< Math.round(gdpArray[index]/1000); k++){
                        System.out.print("*");
                    }
                    yearArray[index] = Integer.MAX_VALUE;
                    
                    System.out.println("");


                }

            }
        }
    }

    public static int minIndex(int[] arr){
            int temp = arr[0];
            int index = 0;
            for (int i =0; i< arr.length; i++){
                if (temp > arr[i]){
                    temp = arr[i];
                    index = i;
                }
            }
            return index;
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