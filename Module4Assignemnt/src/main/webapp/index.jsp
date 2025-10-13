<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.assignment4.Task" %>
<%
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>
<html>
<head>
    <title>To-Do List</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>To-Do App</h1>

<form method="post" action="tasks">
    <input type="text" name="description" placeholder="New task"/>
    <input type="submit" value="Add Task"/>
</form>

<ul>
    <% for (Task task : tasks) { %>
    <li>
        <span contenteditable="true"
              onblur="updateTask(<%=task.getId()%>, this.textContent)"
              onkeypress="if(event.key==='Enter'){this.blur();}">
            <%= task.getDescription() %>
        </span>
        <form method="post" action="tasks" style="margin:0;">
            <input type="hidden" name="action" value="complete">
            <input type="hidden" name="id" value="<%= task.getId() %>">
            <button type="submit" class="complete-btn">Complete</button>
        </form>
    </li>
    <% } %>
</ul>

<script src="js/tasks.js"></script>

</body>
</html>
