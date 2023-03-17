package Algos.Lists;

import java.util.*;

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
            allPerms[number] = permutation.toArray(new Integer[0]);
            number++;
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

    public int[][] getAllPerms()
    {
    int[][] allPermInts = new int[allPerms.length][];
        for (int row = 0; row<allPermInts.length; row++){
            allPermInts[row] = new int[allPerms[row].length];
            for (int col = 0; col < allPermInts[row].length; col++){
                allPermInts[row][col] = allPerms[row][col].intValue();
            }
        }
        return allPermInts;
    }
}
