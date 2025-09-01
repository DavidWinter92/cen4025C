package org.assignment3.components;

import java.util.ArrayList;
import java.util.Random;

/**
 * Handles adding and removing integers from an ArrayList.
 */

public class ArrayListTest {

    /**
     * Adds 2,000,000 random integers into an ArrayList and then removes each one.
     */
    public static void run() {
        System.out.println("\nArrayList creating 2,000,000 integers...");
        long start = System.currentTimeMillis();

        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();

        // Add 2,000,000 random integers to the ArrayList
        for (int i = 0; i < 2_000_000; i++) {
            list.add(rand.nextInt());
        }

        System.out.println("ArrayList removing 2,000,000 integers...");

        // Remove all integers from the ArrayList
        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("ArrayList test completed in " + (end - start) + " ms");
    }
}
