package org.assignment4.modules;

import java.util.Scanner;

/**
 * Handles removing a task from the database.
 */
public class DeleteTask {

    private TaskDao taskDao;

    /**
     * Creates a DeleteTask object.
     *
     * @param taskDao the TaskDao used to interact with the database
     */
    public DeleteTask(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * Prompts the user to enter a task ID and deletes it from the database.
     */
    public void handleDeleteTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID of the task to delete: ");
        int id = sc.nextInt();
        if (taskDao.deleteTask(id)) {
            System.out.println("Task removed from database.");
        } else {
            System.out.println("No task found with that ID.");
        }
    }
}
