package org.assignment4.modules;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.assignment4.Task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Handles HTTP requests for managing tasks.
 * Supports listing, adding, and deleting tasks using TaskDao.
 */
@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    private final TaskDao taskDao = new TaskDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String idParam = req.getParameter("id");
        if ("delete".equals(action) && idParam != null) {
            int id = Integer.parseInt(idParam);
            taskDao.deleteTask(id);
            resp.sendRedirect("tasks");
            return;
        }

        List<Task> tasks = taskDao.getAllTasks();
        req.setAttribute("tasks", tasks);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        String idParam = req.getParameter("id");

        if ("update".equals(action) && idParam != null) {
            String newDescription = req.getParameter("newDescription");
            int id = Integer.parseInt(idParam);
            taskDao.updateTask(id, newDescription);
        } else if ("complete".equals(action) && idParam != null) {
            int id = Integer.parseInt(idParam);
            taskDao.deleteTask(id);
        } else {
            String description = req.getParameter("description");
            if (description != null && !description.trim().isEmpty()) {
                taskDao.addTask(description);
            }
        }

        resp.sendRedirect("tasks");
    }
}
