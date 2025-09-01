package org.assignment3.components;

import java.util.LinkedList;
import java.util.Random;

/**
 * Handles adding and removing integers from a LinkedList.
 */
public class LinkedListTest {

    /**
     * Adds 2,000,000 random integers into a LinkedList and then removes each one.
     */
    public static void run() {
        System.out.println("\nLinkedList creating 2,000,000 integers...");
        long start = System.currentTimeMillis();

        LinkedList<Integer> list = new LinkedList<>();
        Random rand = new Random();

        // Add 2,000,000 random integers to the LinkedList
        for (int i = 0; i < 2_000_000; i++) {
            list.add(rand.nextInt());
        }

        System.out.println("LinkedList removing 2,000,000 integers...");

        // Remove all integers from the LinkedList
        for (int i = 0; i < 2_000_000; i++) {
            list.removeFirst();
        }

        long end = System.currentTimeMillis();
        System.out.println("LinkedList test completed in " + (end - start) + " ms");
    }

}
