package Algos.Testing;

import Algos.Lists.stringListAlgos;

import java.util.*;

import static Algos.Lists.intListAlgos.permutations;

public class listAlgoTesting {


    public static void main(String[] args) {

        stringListPermutations();
    }

    // Example usage of the permutations shit
    public static void intListPermutations() {

        double listLength = 15;
        Set<Integer> s = new HashSet<Integer>(); // Yes it's a hashmap fucking fight me
        for (int i = 1; i < listLength+1; i++) {
            s.add(i);
        }

        System.out.println("Original List: " + s);

        System.out.println("\nPermutations:");
        permutations(s, new Stack<Integer>(), s.size());
    }

    // Kill me :)
    public static void stringListPermutations() {
        Set<String> items = new HashSet<>(Arrays.asList("a", "b", "c")); // More hashmaps I know... it hurts me too

        System.out.println("Original List: " + items);

        Stack<String> permutation = new Stack<>();
        System.out.println("\nPermutations:");
        stringListAlgos.permutations(items, permutation, items.size());

    }
}
