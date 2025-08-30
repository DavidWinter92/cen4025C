package org.assignment2.modules;

/**
 * Handles showing the current tasks in the to-do list.
 * Uses the StoreTasks class to read stored tasks.
 */
public class ViewTasks {

    private StoreTasks store;

    /**
     * Creates a ViewTasks object.
     *
     * @param store the StoreTasks object used to access the list of tasks
     */
    public ViewTasks(StoreTasks store) {
        this.store = store;
    }

    /**
     * Displays the tasks in the to-do list.
     * If no tasks exist, shows a message encouraging the user to add some.
     */
    public void handleView() {
        System.out.println("=== To-Do List ===");
        if (store.getTasks() == 0) {
            System.out.println("There aren't any tasks on the list yet. Add a few to get started!");
            return;
        }

        for (int i = 0; i < store.getTasks(); i++) {
            System.out.println((i + 1) + ". " + store.getTasks(i));
        }
    }
}
