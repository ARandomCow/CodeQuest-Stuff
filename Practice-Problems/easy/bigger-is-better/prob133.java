import java.util.*;

public class prob133{

    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                
                int[] scoresArray = delimiters.delimitAll(line, " ");
                
                System.out.println(scoresArray[maxIndex(scoresArray)]);
            }
        }
    }

    public static int maxIndex(int[] arr){
        int temp = arr[0];
        int index = 0;
        for (int i =0; i< arr.length; i++){
            if (temp < arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static class delimiters{

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

        public static int[] delimitAll(String line, String spacer){
            List<Integer> resultList = new ArrayList<Integer>();

            while(line.indexOf(spacer) != -1){
                resultList.add(Integer.parseInt(delimiters.delimit(line, 0, spacer)));
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