import java.util.*;

public class random
{

    public static void main(String[] args)
    {
        double test = 151235;
        double rounded = decRound(test, 1);
        String roundString = trailingAndLeadingZeroes(test, 4, 10);


        System.out.println(rounded + " is a rounded double");
        System.out.println(roundString + " is a double rounded and made to a string");

        System.out.println("The greatest common factor of 144 and 168 is " + greatestCommonFactor(144, 168));
        System.out.println("The greatest common factor of 144 and 167 is " + greatestCommonFactor(144, 167));

        int[][] testGrid = new int[20][10];
        testGrid = addSquare(testGrid, 1, 9, 5, 9);
//        printGrid(testGrid);

        double numToFrac = 1.571428571;
        System.out.println(fraction(numToFrac, 0.001));


        System.out.println(isLetter("b"));
        System.out.println(isLetter("B"));
        System.out.println(isLetter("$"));


        int[][] testGridSort = new int[7][];
        testGridSort[0] = new int[]{4, 7, 1, 3 ,7};
        testGridSort[1] = new int[]{4, 7, 0, 3};
        testGridSort[2] = new int[]{19, 1, 0, 31 ,71, 11};
        testGridSort[3] = new int[]{1, 1, 1, 1, 1, 1, 1};
        testGridSort[4] = new int[]{4, 7, 1, 3 ,0};
        testGridSort[5] = new int[]{4, 7, 1, 3 ,7};
        testGridSort[6] = new int[]{4, 7, 1, 3 ,7};

        printGrid(testGridSort);
        System.out.println("------------------------------------------------------");
        testGrid = gridSort(testGridSort);

        printGrid(testGrid);
        System.out.println("hopefully the second grid has been sorted");

        Integer[][] testGridInteger = new Integer[testGrid.length][];
        for (int i = 0; i<testGridInteger.length; i++){
            testGridInteger[i] = new Integer[testGrid[i].length];
            for (int y = 0; y<testGridInteger[i].length; y++){
                testGridInteger[i][y] = Integer.valueOf(testGrid[i][y]);
            }
        }

        printGridInteger(testGridInteger);
        System.out.println("the Integer Array works");
        System.out.println("------------------------------------------------------");
        testGrid = removeAllRepeats(testGrid);
        printGrid(testGrid);
        System.out.println("hopefully the third grid has no repeats");




//        int[] combinationTest = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        int[][] allCombos = combinations(4, combinationTest);
//
//        printGrid(allCombos);
    }









    public static boolean isLetter(String thing)
    {
        String alph = "qwertyuiopasdfghjklzxcvbnm";
        if (alph.contains(thing)){
            return true;
        }
        return false;
    }
//input = double and amount of decimal places
//output = string that looks like the double rounded to the amount of decimals (with trailing zeros)
    public static double decRound (double value, int precision)
    {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
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


   /*
 * @param num - double you want in a specified format
 * @param leading - number of digits before decimal place. Can be any number greater than or equal to 0
 * @param trailing - number of digits after decimal place. 
 * Should be as big as the number of digits in your largest number (if that's 999, then trailing should equal 3)
 * if trailing = 0, then it just will not add
 * @result a string of your number with the specified number of leading and trailing zeros
 */
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

/*
 * @param self explanatory
 * @result the smallest number that divides the two integers
 */
    public static int greatestCommonFactor(int num1, int num2){
        int larger = num2;
        int smaller = num1;
        if (num1 > num2){
            larger = num1;
            smaller = num2;
        }

        while (smaller != larger)
        {
    //            System.out.println(larger+ "-" + smaller + "=" + (larger - smaller));
            int temp = larger - smaller;
            if (temp > smaller){
                larger = temp;
            } else {
                larger = smaller;
                smaller = temp;
            }
        }
        return larger;
    }


/*
 * @param im lazy theyre all self explanatory
 * it better be a rectangular grid
 * @result the same Grid but a square at [rowNum][colNum] and a radius of radius around that point now have the value of value
 * does not break if at an edge
 */
    public static int[][] addSquare(int[][] Grid, int rowNum, int colNum, int radius, int value){
        int[][] result = Grid;
        int columns = Grid[0].length;
        for (int row = rowNum - radius; row<= rowNum+radius; row++){
            for (int col = colNum - radius; col <= colNum+radius; col++){
                if (row >= 0 && row < Grid.length && col >= 0 && col < columns) {
                    Grid[row][col] = value;
                }
            }
        }
        return result;
    }

/*
* a print method that abides by codeQuest's stupid rules like no spaces at the end of lines
*/
    public static void printGrid(int[][]Grid){
        for (int i = 0; i<Grid.length; i++){
            int[] rows = Grid[i];
            for (int z = 0; z<rows.length-1; z++){
                System.out.print(rows[z] + " ");
            }
            System.out.print(rows[rows.length-1]);
            System.out.println("");
        }
    }


    public static void printGridInteger(Integer[][]Grid){
        for (int i = 0; i<Grid.length; i++){
            Integer[] rows = Grid[i];
            for (int z = 0; z<rows.length-1; z++){
                System.out.print(rows[z] + " ");
            }
            System.out.print(rows[rows.length-1]);
            System.out.println("");
        }
    }

    public static String fraction(double decimal, double tolerance) {
        int sign = (decimal < 0.0) ? -1 : 1;
        decimal = Math.abs(decimal);

        if (decimal == (int) decimal) {
            return (sign * (int) decimal + "");
        }

        double res = decimal, num = 0.0, denom = 1.0, lastdenom = 0.0, temp;
        do {
            res = 1.0 / (res - (int) res);
            temp = denom;
            denom = denom * (int) res + lastdenom;
            lastdenom = temp;

            num = Math.round(decimal * denom);
        } while (res != (int) res && Math.abs(decimal - (num / denom)) > tolerance);

        return (sign * (int) num + "/" + (int) denom);
    }





    public static class Delimiters {


        /*
        returns whatever is in between the start and end (can use either delimiter strings or indexes)
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

            /*
        returns all the things separated by a space but the string probably has to be of a certain format
        string cannot have a delimiter at the very beginning or very end (i think)
        for example:
        B1,B2,BB,K returns ["B1", "B2", "BB", "K"] and all is good
        if it looks like ,B1,B2, then youre probably not as happy

        change it from int[] to String or whatever just by getting rid of all the parseInts and making resultList List<String> and resultArray String[].
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


    public static int[][] gridSort(int[][] inputGrid){
        int[][] grid = inputGrid;
        for (int firstIndex = 0; firstIndex< grid.length; firstIndex++){
            for (int sortIndex = firstIndex+1; sortIndex< grid.length; sortIndex++){
                int smallestGridLength = grid[firstIndex].length;
                if (grid[firstIndex].length > grid[sortIndex].length){
                    smallestGridLength = grid[sortIndex].length;
                }
                for (int element = 0; element< smallestGridLength; element++){
                    if (grid[sortIndex][element] < grid[firstIndex][element]){
//                        System.out.print("swapping grid [");
//                        printIntArr(grid[firstIndex], ",");
//                        System.out.print("] and grid [");
//                        printIntArr(grid[sortIndex], ",");
//                        System.out.println("]");
                        int[] temp = grid[firstIndex];
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



    public static void printIntArr(int[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
//        System.out.println("");
    }


    public static void printIntegerArr(Integer[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
//        System.out.println("");
    }



    public static int[][] removeAllRepeats(int[][] intGrid)
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


    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
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
}