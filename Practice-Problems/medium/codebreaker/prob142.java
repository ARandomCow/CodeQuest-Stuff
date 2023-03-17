import java.sql.SQLOutput;
import java.util.*;

public class prob142 {
    public static void main(String[] args) {

        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());


            for (int testcase = 0; testcase < testCases; testcase++)
            {
                int lineNum = Integer.parseInt(input.nextLine());
                String sentence = "";
                for (int i = 0; i< lineNum; i++){
                    String line = input.nextLine().toLowerCase();
                    sentence += line;
                }
                int totalLetters = 0;
                for (int i = 0; i< sentence.length(); i++){
                    char letter = sentence.charAt(i);
                    if (isLetter(String.valueOf(letter))){
                        totalLetters++;
                    }
                }
                for (int i = 0; i<alphabet.length(); i++){
                    String letter = String.valueOf(alphabet.charAt(i));
                    int amountOfLetter = letterCount(sentence, letter);

                    double letterFrequency = ((double) amountOfLetter/(double) totalLetters) * 100.0;

                    String letterFreqString = trailingAndLeadingZeroes(letterFrequency, 2, 0);

                    System.out.println(letter.toUpperCase() + ": " + letterFreqString + "%");
                }
            }
        }
    }

    public static boolean isLetter(String thing){
        String alph = "qwertyuiopasdfghjklzxcvbnm";
        if (alph.contains(thing)){
            return true;
        }
        return false;
    }

    public static int letterCount(String str, String letter){
        int count = 0;
        while (str.contains(letter)){
            count++;
            str = str.substring(0, str.indexOf(letter)) + str.substring(str.indexOf(letter)+1);
        }
        return count;
    }


    public static String trailingAndLeadingZeroes(double num, int trailing, int leading){
        int scale = (int) Math.pow(10, trailing);
        String result = String.valueOf((double) Math.round(num * scale) / scale);
        if (trailing == 0){
            result = result.substring(0, result.length()-2);
        } else
        {
            while (result.length() - trailing< result.indexOf(".")+1){
                result += "0";
            }
        }
        while (leading> result.indexOf(".")){
            result = "0" + result;
        }
        return result;
    }
}
