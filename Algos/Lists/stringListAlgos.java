package Algos.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class stringListAlgos {

    // Generates all permutations -- EXAMPLE IN listAlgoTesting.java
    public static void permutations(List<String> items, List<String> permutation, int size) {

        /* permutation stack has become equal to size that we require */
        if(permutation.size() == size) {
            /* print the permutation */
            System.out.println(Arrays.toString(permutation.toArray(new String[0])));
        }

        /* items available for permutation */
        String[] availableItems = items.toArray(new String[0]);
        for(String s : availableItems) {
            /* add current item */
            permutation.add(s);

            /* remove item from available item set */
            items.remove(s);

            /* pass it on for next permutation */
            permutations(items, permutation, size);

            /* pop and put the removed item back */
            items.add(permutation.remove(permutation.size() - 1));
        }
    }

}
