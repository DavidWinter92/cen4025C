package org.assignment2.modules;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores and manages the list of tasks for the to-do list program.
 * Handles adding, removing, and retrieving tasks.
 */
public class StoreTasks {

    private List<String> items;

    /**
     * Creates a StoreTasks object and initializes an empty list of tasks.
     */
    public StoreTasks() {
        items = new ArrayList<>();
    }

    /**
     * Adds a new task to the list.
     *
     * @param item the task to be added
     */
    public void addTask(String item) {
        items.add(item);
    }

    /**
     * Removes a task from the list based on its index.
     *
     * @param index the position of the task in the list
     * @return true if the task was successfully removed, false if the index is invalid
     */
    public boolean removeTask(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a specific task by its index.
     *
     * @param index the position of the task in the list
     * @return the task at the given index, or null if the index is invalid
     */
    public String getTasks(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    /**
     * Returns the total number of tasks stored.
     *
     * @return the number of tasks in the list
     */
    public int getTasks() {
        return items.size();
    }
}
