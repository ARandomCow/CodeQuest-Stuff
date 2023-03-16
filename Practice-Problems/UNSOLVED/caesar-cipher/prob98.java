import java.util.*;

public class prob98 {
    public static void main(String[] args) {


        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());
            String alph = "zyxwvutsrqponmlkjihgfedcba";


            for (int testcase = 0; testcase < testCases; testcase++) {
                int key = Integer.parseInt(input.nextLine());
                if (key < 0){
                    alph = "abcdefghijklmnopqrstuvwxyz";
                    key *= -1;
                }
                String line = input.nextLine();
                StringBuilder newSentence = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ' ') {
                        int charNum = alph.indexOf(line.charAt(i));
                        charNum += key;
                        charNum = charNum % 26;
                        newSentence.append(alph.charAt(charNum));
                    } else {
                        newSentence.append(" ");
                    }
                }
                System.out.println(newSentence);
            }
        }
    }
}