import java.util.*;

public class prob165
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String[] sentence = Delimiters.delimitAllStrings(line, " ");
                List<String> sentenceList = new ArrayList<String>();
                
                for (String word: sentence){
                    List<String> wordList = stringToList(word);
                    for (int letter = 0; letter< wordList.size(); letter++){
                        if (!isLetter(wordList.get(letter))){
                            wordList.remove(letter);
                        }
                    }
                    String niceWord = "";
                    for (String letter: wordList){
                        niceWord+=letter;
                    }
                    sentenceList.add(niceWord);
                }
                for (int i = 0; i<sentenceList.size(); i++){
                    System.out.print(sentenceList.get(i));
                    if (i != sentenceList.size()-1){
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
    }

    public static void printStringArr(String[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
        System.out.println("");
    }


    public static boolean isLetter(String thing){
        String alph = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890 ";
        boolean temp = false;
        for (int i = 0; i < alph.length(); i++){
            if(thing.contains(alph.substring(i, i+1))){
                temp = true;
            }
        }
        if (temp == true){
            return true;
        }
        return false;
    }

    public static List<String> stringToList(String string){
        List<String> result = new ArrayList<String>();
        for (int i = 0; i< string.length(); i++){
            result.add(string.substring(i, i+1));
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
        public static int[] delimitAllInts(String line, String spacer){
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


        public static String[] delimitAllStrings(String line, String spacer){
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