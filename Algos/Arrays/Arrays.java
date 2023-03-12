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


