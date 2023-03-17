package Algos.Delimiters;

import java.util.ArrayList;
import java.util.List;

public static class Delimiters {


/**
 * @param string - full string that you only need a part of
 * @param start - string that denotes the beginning of what you actually want
 * @param end - string that denotes the end of what you want
 * @result - a string the stuff in between start and end
 *
 * startIndex and endIndex are just the indexes of the things you need if there's no string
 * most of the time startIndex will be 0 and endIndex will be string.length()
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

/**
 * returns all the things separated by a space but the string probably has to be of a certain format
 * string cannot have a delimiter at the very beginning or very end (i think)
 * for example:
 * B1,B2,BB,K returns ["B1", "B2", "BB", "K"] and all is good
 * if it looks like ,B1,B2, then youre probably not as happy
 *
 * change it from int[] to String or whatever just by getting rid of all the parseInts and making resultList List<String> and resultArray String[].
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