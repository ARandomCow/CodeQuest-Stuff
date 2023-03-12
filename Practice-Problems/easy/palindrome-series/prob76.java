import java.util.*;

public class prob76
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int words = Integer.parseInt(input.nextLine());
                List<Integer> notPalindromes = new ArrayList<Integer>();
                boolean isPalindrome = true;

                for (int i = 0; i< words; i++)
                {
                    boolean temp = true;
                    String line = input.nextLine().toLowerCase();
                    String first = "";
                    String second = "";
                    if (line.length()%2==0){
                        first = line.substring(0, line.length()/2);
                        second = line.substring(line.length()/2, line.length());
                    } else {
                        first = line.substring(0, (line.length()/2) +1);
                        second = line.substring( line.length()/2, line.length());
                    }
//                    String[] firstArray = stringToArray(first);
//                    String []secondArray = stringToArray(second);


                    for (int letter = 0; letter<first.length(); letter++){
                        int sLetter = second.length() - letter-1;
                        if (first.charAt(letter) != (second.charAt(sLetter))){
                            isPalindrome = false;
                            notPalindromes.add(i+1);
                            break;
                        }
                    }
                    
                }
                if (isPalindrome){
                    System.out.println("True");
                } else{
                    System.out.print("False - ");
                    String indexList = "";
                    for (int index = 0; index < notPalindromes.size(); index++){
                        indexList += notPalindromes.get(index);
                        if (index != notPalindromes.size() -1){
                            indexList += ", ";
                        }
                    }
                    System.out.print(indexList);
                    System.out.println("");
                }
            }
        }
    }

    public static String[] stringToArray(String string)
    {
        String[] result = new String[string.length()];
        for (int i = 0; i< string.length(); i++){
            result[i] = string.substring(i, i+1);
        }
        return result;
    }


}