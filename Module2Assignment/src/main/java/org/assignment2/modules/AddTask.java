package org.assignment2.modules;

import java.util.Scanner;

/**
 * Handles adding new tasks to the to-do list.
 * Uses the StoreTasks class to save tasks.
 */
public class AddTask {

    private StoreTasks store;

    /**
     * Creates an AddTask object.
     *
     * @param store the StoreTasks object used to manage the list of tasks
     */
    public AddTask(StoreTasks store) {
        this.store = store;
    }

    /**
     * Prompts the user to enter a new task and adds it to the list.
     */
    public void handleAddTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add a task to your list: ");
        String item = sc.nextLine();
        store.addTask(item);
        System.out.println("Task added to list.");
    }
}
