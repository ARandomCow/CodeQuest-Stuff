import java.util.*;

public class prob37{
    public static void main(String[] args) {


        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());


            for (int testcase = 0; testcase < testCases; testcase++) {
                String line = input.nextLine();
                int sum = Integer.parseInt(Delimiters.delimit(line, "=", line.length()));
                line = input.nextLine();
                int[] numbers = Delimiters.delimitAllInts(line, ",");

                List<Integer> numberList = new ArrayList<Integer>();
                for (int num: numbers) {
                    numberList.add(num);
                }



            }
        }
    }


    public static void printGrid(int[][]Grid){
        for (int i = 0; i<Grid.length; i++){
            int[] rows = Grid[i];
            for (int z = 0; z<rows.length-1; z++){
                System.out.print(rows[z] + ", ");
            }
            System.out.print(rows[rows.length-1]);
            System.out.println("");
        }
    }


    public static int[][] removeAllRepeats(Integer[][] intGrid)
    {

        List<Integer[]> intGridList = new ArrayList<Integer[]>(Arrays.asList(intGrid));
//        System.out.println("Current grid size: " + intGridList.size());
        for (int i = 0; i<intGridList.size(); i++){
            for (int y = i+1; y< intGridList.size(); y++){
                if(Arrays.equals(intGridList.get(i), intGridList.get(y))){
                    intGridList.remove(y);
                    y--;
                }
            }
        }
//        System.out.println("New grid size: " + intGridList.size());
        int[][] resultGrid = new int[intGridList.size()][];
        for (int i = 0; i<resultGrid.length; i++){
            resultGrid[i] = new int[intGridList.get(i).length];
            for (int y = 0; y<resultGrid[i].length;y++){
//                printIntArr(intList, ", ");
                resultGrid[i][y] = intGridList.get(i)[y].intValue();
            }
        }
        return resultGrid;
    }
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





    public static void printIntArr(Integer[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
        System.out.println("");
    }
}