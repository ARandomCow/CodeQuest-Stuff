package Algos.Testing;

import Algos.Lists.stringListAlgos;

import java.util.*;

import static Algos.Lists.intListAlgos.permutations;

public class listAlgoTesting {


    public static void main(String[] args) {

        intListPermutations();
    }

    // Example usage of the permutations shit
    public static void intListPermutations() {

        List<Integer> s = new ArrayList<>(); // It's no longer a hashmap - no more LIFO :(
        s.add(1);
        s.add(2);
        s.add(2);
        s.add(3);

        System.out.println("Original List: " + s);

        System.out.println("\nPermutations:");
        permutations(s, new ArrayList<>(), s.size());
    }

    public static void stringListPermutations() {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("B");
        items.add("C");

        System.out.println("Original List: " + items);

        System.out.println("\nPermutations:");
        stringListAlgos.permutations(items, new ArrayList<>(), items.size());

    }
}
