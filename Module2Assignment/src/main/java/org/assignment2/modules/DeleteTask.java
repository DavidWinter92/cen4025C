package org.assignment2.modules;

import java.util.Scanner;

/**
 * Handles removing tasks from the to-do list.
 * Uses the StoreTasks class to manage stored tasks.
 */
public class DeleteTask {

    private StoreTasks store;

    /**
     * Creates a DeleteTask object.
     *
     * @param store the StoreTasks object used to manage the list of tasks
     */
    public DeleteTask(StoreTasks store) {
        this.store = store;
    }

    /**
     * Displays the list of tasks, asks the user to choose a task to delete,
     * and removes the selected task if it exists.
     */
    public void handleDeleteTask() {
        Scanner sc = new Scanner(System.in);
        if (store.getTasks() == 0) {
            System.out.println("It doesn't seem like you have much to do. Try adding some tasks.");
            return;
        }

        System.out.println("These are your current tasks in the To-Do List:");
        for (int i = 0; i < store.getTasks(); i++) {
            System.out.println((i + 1) + ". " + store.getTasks(i));
        }

        System.out.print("Enter an ID to remove a task: ");
        int index = sc.nextInt() - 1;

        if (store.removeTask(index)) {
            System.out.println("Task successfully removed.");
        } else {
            System.out.println("That's odd, we can't find a task with that ID.");
        }

        for (int i = 0; i < store.getTasks(); i++) {
            System.out.println((i + 1) + ". " + store.getTasks(i));
        }
    }
}
