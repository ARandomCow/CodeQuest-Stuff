import java.util.*;




public class betterProb28
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String anag = delimiters.delimit(line, 0, "|");
                String result = delimiters.delimit(line, "|", line.length());

                String newAnag = alphbetical(anag);
                String newResult = alphbetical(result);
//                System.out.println(newAnag);
//                System.out.println(newResult);

                System.out.print(line + " = ");
                if (newAnag.equals(newResult) && !anag.equals(result)){
                    System.out.print("ANAGRAM");
                } else {
                    System.out.print("NOT AN ANAGRAM");
                }

                System.out.println("");
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


    public static class delimiters
    {
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
    }


}



