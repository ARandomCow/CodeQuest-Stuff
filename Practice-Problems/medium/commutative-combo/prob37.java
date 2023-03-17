import java.util.*;

public class prob37{
    public static void main(String[] args) {


        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());


            for (int testcase = 0; testcase < testCases; testcase++) {
                List<Integer[]> allAnswers = new ArrayList<>();
                String line = input.nextLine();
                int sum = Integer.parseInt(Delimiters.delimit(line, "=", line.length()));
                line = input.nextLine();
                int[] numbers = Delimiters.delimitAllInts(line, ",");
//                printIntArr(numbers, " | ");

                for (int i = 1; i< numbers.length; i++){
//                    System.out.println("now testing for i=" + i);
                    int[][] combosArray = combinations(i, numbers);
                    for (int[] ints : combosArray) {
                        Arrays.sort(ints);
                    }
                    List<Integer[]> combos = removeAllRepeatsArray(combosArray);

                    for (Integer[] combo: combos){
//                        printIntArr(combo, "+");
                        if (sum(combo) == sum){
//                            printIntArr(combo, "+");
//                            System.out.println("=10");
                            intListAlgos intPerms = new intListAlgos(combo.length);
                            List<Integer> comboList = new ArrayList<>(Arrays.asList(combo));
                            intPerms.permutations(comboList, new ArrayList<>());
                            List<Integer[]> allcomboPerms = intPerms.getAllPerms();

//                            allcomboPerms = removeAllRepeats(allcomboPerms);

                            allAnswers.addAll(allcomboPerms);


                        }
                    }
                }

//                int[][] answerArray = new int[allAnswers.size()][];
//                for (int i = 0; i<answerArray.length; i++){
//                    answerArray[i] = allAnswers.get(i);
//                }


                removeAllRepeats(allAnswers);
                Integer[][] answerArray = gridSort(allAnswers);

                for(Integer[] answer: answerArray){
                    printIntegerArr(answer, "+");
                }
//                System.out.println("--------------------------------");
            }
        }
    }


    public static int sum(Integer[] numbers){
        int result = 0;
        for (Integer num: numbers){
            result += num;
        }
        return result;
    }

    public static int[][] combinations(int k, int[] arr) {
        int n = arr.length;
        int numCombinations = (int) (factorial(n) / (factorial(k) * factorial(n - k)));
        int[][] result = new int[numCombinations][k];
        int[] indices = new int[k];

        for (int i = 0; i < k; i++) {
            indices[i] = i;
            result[0][i] = arr[i];
        }

        for (int i = 1; i < numCombinations; i++) {
            int j = k - 1;
            while (j >= 0 && indices[j] == n - k + j) {
                j--;
            }
            indices[j]++;
            for (int l = j + 1; l < k; l++) {
                indices[l] = indices[l - 1] + 1;
            }
            for (int l = 0; l < k; l++) {
                result[i][l] = arr[indices[l]];
            }
        }

        return result;
    }


    public static void printGrid(int[][]Grid){
        for (int[] rows: Grid){
            for (int z = 0; z<rows.length-1; z++){
                System.out.print(rows[z] + ", ");
            }
            System.out.println(rows[rows.length-1]);
        }
    }


    public static void removeAllRepeats(List<Integer[]> integerGrid)
    {
//        Integer[][] integerGrid = new Integer[intGrid.length][];
//        for (int row = 0; row<integerGrid.length; row++){
//            integerGrid[row] = new Integer[intGrid[row].length];
//            for (int col = 0; col < integerGrid[row].length; col++){
//                integerGrid[row][col] = intGrid[row][col];
//            }
//        }


        //        System.out.println("Current grid size: " + intGridList.size());
        for (int i = 0; i< integerGrid.size(); i++){
            for (int y = i+1; y< integerGrid.size(); y++){
                if(Arrays.equals(integerGrid.get(i), integerGrid.get(y))){
                    integerGrid.remove(y);
                    y--;
                }
            }
        }
//        System.out.println("New grid size: " + intGridList.size());
//        int[][] resultGrid = new int[intGridList.size()][];
//        for (int i = 0; i<resultGrid.length; i++){
//            resultGrid[i] = new int[intGridList.get(i).length];
//            for (int y = 0; y<resultGrid[i].length;y++){
//                printIntArr(intList, ", ");
//                resultGrid[i][y] = intGridList.get(i)[y].intValue();
//            }
//        }

    }
    public static class Delimiters {


        /**
         * @param string - full string that you only need a part of
         * @param start - string that denotes the beginning of what you actually want
         * @param end - string that denotes the end of what you want
         * @return - a string the stuff in between start and end
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
            List<Integer> resultList = new ArrayList<>();

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





    public static void printIntArr(int[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
        System.out.println("");
    }


    public static void printIntegerArr(Integer[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
        System.out.println("");
    }


    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }




    /**
     * input = ArrayList of items that you want all permutations of
     * output = int[][] of all possible permutations of your input
     * WARNING: don't use too big of lists or your computer will explode
     *
     * how to use:
     * intListAlgos intPerms = new intListAlgos(intsList.size());
     *
     * intPerms.permutations(intsList, new ArrayList<Integer>());
     *
     * Integer[][] allIntPerms = intPerms.getAllPerms();
     */

    public static class intListAlgos
    {
        int number;
        Integer[][] allPerms;
        int size;

        List<Integer[]> allPermResultList = new ArrayList<Integer[]>();
        //input = integer n
        //output = n!

        public static int factorial(int n)
        {
            int result = n;
            for (int i = n-1; i>0; i--)
            {
                result *= i;
            }
            return result;
        }


        public intListAlgos(int size)
        {
            allPerms = new Integer[factorial(size)][];
            this.size = size;
            number = 0;
        }
        // Generates all permutations -- EXAMPLE IN listAlgoTesting.java
        public void permutations(List<Integer> items, List<Integer> permutation)
        {
            /* permutation stack has become equal to size that we require */
            if(permutation.size() == size)
            {
                /* adds the permutation to the eventual return array */
//                allPerms[number] = permutation.toArray(new Integer[0]);
//                number++;
                allPermResultList.add(permutation.toArray(new Integer[0]));
            }

            /* items available for permutation */
            Integer[] availableItems = items.toArray(new Integer[0]);
            for(Integer i : availableItems)
            {
                /* add current item */
                permutation.add(i);

                /* remove item from available item set */
                items.remove(i);

                /* pass it on for next permutation */
                permutations(items, permutation);

                /* pop and put the removed item back */
                items.add(permutation.remove(permutation.size()-1));
            }
        }

        public List<Integer[]> getAllPerms()
        {
//            int[][] allPermInts = new int[allPerms.length][];
//            for (int row = 0; row<allPermInts.length; row++){
//                allPermInts[row] = new int[allPerms[row].length];
//                for (int col = 0; col < allPermInts[row].length; col++){
//                    allPermInts[row][col] = allPerms[row][col].intValue();
//                }
//            }
            return allPermResultList;

        }
    }




    public static Integer[][] gridSort(List<Integer[]> inputGrid){
        Integer[][] grid = new Integer[inputGrid.size()][];
        for (int rowNum = 0; rowNum < grid.length; rowNum++){
            grid[rowNum] = inputGrid.get(rowNum);
        }
        for (int firstIndex = 0; firstIndex< grid.length; firstIndex++){
            for (int sortIndex = firstIndex+1; sortIndex< grid.length; sortIndex++){
                int smallestGridLength = grid[firstIndex].length;
                if (grid[firstIndex].length > grid[sortIndex].length){
                    smallestGridLength = grid[sortIndex].length;
                }
                for (int element = 0; element< smallestGridLength; element++){
                    if (grid[sortIndex][element] < grid[firstIndex][element]){
                        Integer[] temp = grid[firstIndex];
                        grid[firstIndex] = grid[sortIndex];
                        grid[sortIndex] = temp;
                        break;
                    } else if (grid[sortIndex][element] > grid[firstIndex][element]){
                        break;
                    }
                }

            }
        }
        return grid;
    }






    public static List<Integer[]> removeAllRepeatsArray(int[][] intGrid)
    {
        Integer[][] integerGrid = new Integer[intGrid.length][];
        for (int row = 0; row<integerGrid.length; row++){
            integerGrid[row] = new Integer[intGrid[row].length];
            for (int col = 0; col < integerGrid[row].length; col++){
                integerGrid[row][col] = intGrid[row][col];
            }
        }


        List<Integer[]> intGridList = new ArrayList<Integer[]>(Arrays.asList(integerGrid));
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
//        int[][] resultGrid = new int[intGridList.size()][];
//        for (int i = 0; i<resultGrid.length; i++){
//            resultGrid[i] = new int[intGridList.get(i).length];
//            for (int y = 0; y<resultGrid[i].length;y++){
//                printIntArr(intList, ", ");
//                resultGrid[i][y] = intGridList.get(i)[y].intValue();
//            }
//        }

        return intGridList;
    }
}