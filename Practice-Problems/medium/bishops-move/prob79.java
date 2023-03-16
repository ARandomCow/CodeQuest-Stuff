import java.util.*;

public class prob79 {
    public static void main(String[] args) {


        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());


            for (int testcase = 0; testcase < testCases; testcase++) {
                String line = input.nextLine();
                int rows = Integer.parseInt(Delimiters.delimit(line, 0, ","));
                int columns = Integer.parseInt(Delimiters.delimit(line, ",", line.length()));
                line = input.nextLine();
                int row1 = Integer.parseInt(Delimiters.delimit(line, 0, ","))-1;
                int col1 = Integer.parseInt(Delimiters.delimit(line, ",", line.length()))-1;
                line = input.nextLine();
                int row2 = Integer.parseInt(Delimiters.delimit(line, 0, ","))-1;
                int col2 = Integer.parseInt(Delimiters.delimit(line, ",", line.length()))-1;

                boolean[][] chessBoard = new boolean[rows][columns];
                for (int rowNum = 0; rowNum<rows; rowNum++){
                    for (int colNum = 0; colNum<columns; colNum++){
                        if ((rowNum%2 ==0 && colNum%2 ==1)|| (colNum%2 == 0 && rowNum%2==1)){
                            chessBoard[rowNum][colNum] = true;
                        }
                    }
                }


                if (row1 >= rows ||
                    row2 >= rows ||
                    col1 >= columns ||
                    col2 >= columns ||
                    row1< 0 ||
                    row2 < 0||
                    col1 < 0 ||
                    col2 < 0){
                    System.out.println("No");
                    continue;
                }

                if (chessBoard[row1][col1] == chessBoard[row2][col2]){
                    System.out.println("Yes");
                } else{
                    System.out.println("No");
                }

            }
        }
    }



    public static class Delimiters {


    /*
    returns whatever is in between the start and end (can use either delimiter strings or indexes)
    */

        public static String delimit(String string, String start, String end) {
            int startIndex = string.indexOf(start);
            int endIndex = string.indexOf(end);
            return string.substring(startIndex + 1, endIndex);
        }

        public static String delimit(String string, int startIndex, String end) {
            int endIndex = string.indexOf(end);
            return string.substring(startIndex, endIndex);
        }

        public static String delimit(String string, String start, int endIndex) {
            int startIndex = string.indexOf(start);
            return string.substring(startIndex + 1, endIndex);
        }

        /*
    returns all the things separated by a space but the string probably has to be of a certain format
    string cannot have a delimiter at the very beginning or very end (i think)
    for example:
    B1,B2,BB,K returns ["B1", "B2", "BB", "K"] and all is good
    if it looks like ,B1,B2, then youre probably not as happy

    change it from int[] to String or whatever just by getting rid of all the parseInts and making resultList List<String> and resultArray String[].
    */
        public static int[] delimitAllInts(String line, String spacer) {
            List<Integer> resultList = new ArrayList<Integer>();

            while (line.contains(spacer)) {
                resultList.add(Integer.parseInt(delimit(line, 0, spacer)));
                line = line.substring(line.indexOf(spacer) + spacer.length());
            }
            resultList.add(Integer.parseInt(line));

            int[] resultArray = new int[resultList.size()];
            int i = 0;
            for (Integer result : resultList) {
                resultArray[i] = result;
                i++;
            }
            return resultArray;
        }
    }


}