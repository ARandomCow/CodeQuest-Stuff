package Algos.Arrays;

public class Arrays {

    /*
    input = array of doubles
    output = index of the smallest double

    just use arr[index] or arr[minIndex(arr)] to find the actual smallest number
    you can also just switch double[] to int[] or float[] or whatever you need. it all works.

    if you need max instead of min, just change temp > arr[i] to temp < arr[i] and you're golden
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
}
