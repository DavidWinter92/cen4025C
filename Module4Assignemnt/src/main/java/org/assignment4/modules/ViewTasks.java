package org.assignment4.modules;

import org.assignment4.Task;
import java.util.List;

/**
 * Handles viewing all tasks in the database.
 */
public class ViewTasks {

    private TaskDao taskDao;

    /**
     * Creates a ViewTasks object.
     *
     * @param taskDao the TaskDao used to get tasks from the database
     */
    public ViewTasks(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     * Displays all tasks stored in the database.
     */
    public void handleView() {
        List<Task> tasks = taskDao.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found in the database.");
            return;
        }

        System.out.println("=== To-Do List ===");
        for (Task task : tasks) {
            System.out.println(task.getId() + ". " + task.getDescription());
        }
    }
}
