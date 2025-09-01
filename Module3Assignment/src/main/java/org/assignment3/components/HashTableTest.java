package org.assignment3.components;


import java.util.Hashtable;
import java.util.Random;

/**
 * Handles adding and removing integers from a Hashtable.
 */
public class HashTableTest {

    /**
     * Adds 2,000,000 random integers into a Hashtable and then removes each one.
     */
    public static void run() {
        System.out.println("\nHashtable creating 2,000,000 integers...");
        long start = System.currentTimeMillis();

        Hashtable<Integer, Integer> table = new Hashtable<>();
        Random rand = new Random();

        // Add 2,000,000 random integers to the Hashtable
        for (int i = 0; i < 2_000_000; i++) {
            table.put(i, rand.nextInt());
        }

        System.out.println("Hashtable removing 2,000,000 integers...");

        // Remove all integers from the Hashtable
        for (int i = 0; i < 2_000_000; i++) {
            table.remove(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Hashtable test completed in " + (end - start) + " ms");
    }

}
