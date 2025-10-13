package org.assignment4.modules;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.assignment4.Task;

import java.util.List;

/**
 * Handles database operations for Task entities using Hibernate.
 * Supports adding, deleting, and retrieving tasks from the MySQL database.
 */
public class TaskDao {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("todoPU");

    /**
     * Adds a new task to the database.
     *
     * @param description the description of the task
     */
    public void addTask(String description) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Task task = new Task();
        task.setDescription(description);
        em.persist(task);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Deletes a task from the database.
     *
     * @param id the ID of the task to delete
     * @return true if the task was deleted, false if not found
     */
    public boolean deleteTask(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        if (task != null) {
            em.remove(task);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        em.getTransaction().rollback();
        em.close();
        return false;
    }

    /**
     * Retrieves all tasks from the database.
     *
     * @return a list of Task objects
     */
    public List<Task> getAllTasks() {
        EntityManager em = emf.createEntityManager();
        List<Task> tasks = em.createQuery("FROM Task", Task.class).getResultList();
        em.close();
        return tasks;
    }

    /**
     * Updates the description of a task.
     *
     * @param id the ID of the task
     * @param newDescription the new description to set
     */
    public void updateTask(int id, String newDescription) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Task task = em.find(Task.class, id);
        if (task != null) {
            task.setDescription(newDescription);
            em.merge(task);
        }
        em.getTransaction().commit();
        em.close();
    }
}
