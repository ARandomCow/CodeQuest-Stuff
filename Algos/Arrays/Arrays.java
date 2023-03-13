package Algos.Arrays;

import java.util.stream.Stream;

public class Arrays {

    /*
    input = array of doubles
    output = index of the smallest double

    just use arr[index] or arr[minIndex(arr)] to find the actual smallest number
    you can also just switch double[] to int[] or float[] or whatever you need. it all works.

*/

    public static int minIndex(double[] arr){
        double temp = arr[0];
        int index = 0;
        for (int i =0; i< arr.length; i++){
            if (temp > arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }


    /*
    input = array of doubles
    output = index of the largest double

    just use arr[index] or arr[minIndex(arr)] to find the actual smallest number
    you can also just switch double[] to int[] or float[] or whatever you need. it all works.

*/
    public static int maxIndex(double[] arr){
        double temp = arr[0];
        int index = 0;
        for (int i =0; i< arr.length; i++){
            if (temp < arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }

/*
 * @param stringArray array of Strings
 * @return str a new String[], but ordered alphabetically now
 * MUST HAVE import java.util.stream.*;
 */
    public static String[] alphOrder(String[] stringArray){
        String[] str = Stream.of(stringArray)
        .sorted()
        .toArray(String[]::new);

        return str;
    }


    /*
     * @param intArray - array where you want all the numbers in a certain interval
     * assumes intArray is sorted
     * @param startIndex - the index that the result array will start on
     * @param interval - the interval that the method will find all the numbers in
     * aka from intArray[startIndex] to intArray[startIndex]+10
     * @result a new array containing only all the number inside that specific interval
     */
    public static int[] numsInAnInterval(int[] intArray, int startIndex, int interval){
        int lastIndex = startIndex;
        while (intArray[lastIndex] <= intArray[startIndex]+interval){
            if (lastIndex == intArray.length-1){
                return Arrays.copyOfRange(intArray, startIndex, intArray.length);
            }
            lastIndex++;
        }
        return Arrays.copyOfRange(intArray, startIndex, lastIndex);
    }



/*
 * @param arr - array of stuff
 * @param spacer - thing you want in between stuff
 * @return console line of all the things in the stuff in the form a,b,c,d. . .
 */ 
    public static void printIntArr(int[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
        System.out.println("");
    }


    public static void printStringArr(String[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
        System.out.println("");
    }
}


