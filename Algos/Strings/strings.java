package Algos.Strings;

import java.util.ArrayList;
import java.util.List;

public class strings {

/**
 * @param thing String object meant to be single char
 * @return boolean - (for this case, its checking if its anywhere in the alphabet or is a number)
 * If you need even more variability, you can make it isLetter(String thing, String checker) and just say alph = checker.
 */
    public static boolean isLetter(String thing){
        String alph = "qwertyuiopasdfghjklzxcvbnm";
        if (alph.contains(thing)){
            return true;
        }
        return false;
    }


/**
 * @param str - String that you need to find all the letters in
 * @param letter - String, the letter you're trying to find the frequency of
 * @return count - int, the number of times 'letter' appears in str
 */
    public static int letterCount(String str, String letter){
        int count = 0;
        while (str.contains(letter)){
            count++;
            str = str.substring(0, str.indexOf(letter)) + str.substring(str.indexOf(letter)+1);
        }
        return count;
    }


/**
 * @param string any nonempty string
 * @return `string` but all the letters are rearranged to make it alphabetical
 * example: trouble -> belortu
 */
    public static String alphbetical(String string){
        String result = string;
        for (int i = 0; i<string.length(); i++){
            for (int y = i; y<string.length(); y++){
                if ((int) result.charAt(i) > (int)(result.charAt(y))){
                    String temp1 = String.valueOf(result.charAt(i));
                    String temp2 = String.valueOf(result.charAt(y));

                    result = result.substring(0, i) + temp2 +
                            result.substring(i+1, y) + temp1 +
                            result.substring(y+1, result.length());
                }
            }
        }
        return result;
    }

/**
 * @param string - any string, nonempty
 * @return ArrayList<String>(), with each element being a letter in that input string
 */
    public static List<String> stringToList(String string){
        List<String> result = new ArrayList<String>();
        for (int i = 0; i< string.length(); i++){
            result.add(string.substring(i, i+1));
        }
        return result;
    }

/**
 * @param string - any string, nonempty
 * @return String[], with each element being a letter in that input string
 */
    public static String[] stringToArray(String string)
    {
        String[] result = new String[string.length()];
        for (int i = 0; i< string.length(); i++){
            result[i] = string.substring(i, i+1);
        }
        return result;
    }

}
