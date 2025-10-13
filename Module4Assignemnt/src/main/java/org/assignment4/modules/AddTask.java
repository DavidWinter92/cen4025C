package org.assignment4.modules;

import java.util.Scanner;

/**
 * Handles adding a new task to the database.
 */
public class AddTask {

    private TaskDao taskDao;

    /**
     * Creates an AddTask object.
     *
     * @param taskDao the TaskDao used to interact with the database
     */
    public AddTask(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * Prompts the user to enter a task and adds it to the database.
     */
    public void handleAddTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Add a task to your list: ");
        String description = sc.nextLine();
        taskDao.addTask(description);
        System.out.println("Task added to database.");
    }
}
