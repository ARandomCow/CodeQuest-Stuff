import java.util.*;

public class prob46
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line1 = input.nextLine();
                String line2 = input.nextLine();
                String[] lastYear = Delimiters.delimitAll(line1, ",");
                String[] thisYear = Delimiters.delimitAll(line2, ",");
                boolean temp = false;
                String print = "";

                lastYear = alphSort(lastYear);
                thisYear = alphSort(thisYear);
/* 
                for (String last: lastYear){
                    System.out.print(last + " | ");
                }
                System.out.println("");
                for (String current: thisYear){
                    System.out.print(current + " | ");
                }
                System.out.println("");
/* */ 
                for(String last: lastYear){
                temp = true;
                    for (String current: thisYear){
                        if (last.equals(current)){
                            temp = false;
                        }
                    }
                    if (temp){
                        print += last + ",";
                    }
                }
                if (!print.equals("")){
                print = print.substring(0, print.length()-1);
                }
                System.out.println(print);
                
                print = "";
                for(String last: lastYear){
                    temp = true;
                        for (String current: thisYear){
                            if (last.equals(current)){
                                temp = false;
                            }
                        }
                        if (!temp){
                            print += last + ",";
                        }
                    }
                    if (!print.equals("")){
                        print = print.substring(0, print.length()-1);
                        }
                    System.out.println(print);

                    print = "";
                    for(String last: thisYear){
                        temp = true;
                            for (String current: lastYear){
                                if (last.equals(current)){
                                    temp = false;
                                }
                            }
                            if (temp){
                                print += last + ",";
                            }
                        }
                        if (!print.equals("")){
                            print = print.substring(0, print.length()-1);
                            }
                        System.out.println(print);
            }
        }
    }

    public static String[] alphSort(String[] strings){
        String[] result = strings;
        for (int i = 0; i<strings.length; i++){
            for (int y = i; y<strings.length; y++){
                if ((int) strings[i].charAt(0) > (int)(strings[y].charAt(0))){
                    String temp1 = strings[i];
                    String temp2 = strings[y];

                        result[y] = temp1;
                        result[i] = temp2;
                }
            }
        }
        return result;
        
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
        public static String[] delimitAll(String line, String spacer){
            List<String> resultList = new ArrayList<String>();
    
            while(line.contains(spacer)){
                resultList.add(delimit(line, 0, spacer));
                line = line.substring(line.indexOf(spacer)+1);
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