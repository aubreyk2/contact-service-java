package task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> taskList = new ArrayList<>();
    public boolean addTask(Task task) {
        //Check for duplicates
        for (Task t : taskList) {
            if (t.getTaskId().equals(task.getTaskId())) {
                System.out.println("Add failed: Duplicate task ID '" + task.getTaskId() + "'");
                return false;
            }
        }
        taskList.add(task);
        System.out.println("Task added: " + task.getTaskId());
        return true;
    }

    public boolean deleteTask(String taskId) {
        boolean removed = taskList.removeIf(t -> t.getTaskId().equals(taskId));
        if (removed) {
            System.out.println("Task deleted: " + taskId);
        } else {
            System.out.println("Delete failed: Task ID '" + taskId + "' not found");
        }
        return removed;
    }
    //Updates task below
    public boolean updateTaskName(String taskId, String name) {
        for (Task t : taskList) {
            if (t.getTaskId().equals(taskId)) {
                t.setName(name);
                System.out.println("Task name updated for ID: " + taskId);
                return true;
            }
        }
        System.out.println("Update failed: Task ID '" + taskId + "' not found");
        return false;
    }

    public boolean updateTaskDescription(String taskId, String description) {
        for (Task t : taskList) {
            if (t.getTaskId().equals(taskId)) {
                t.setDescription(description);
                System.out.println("Task description updated for ID: " + taskId);
                return true;
            }
        }
        System.out.println("Update failed: Task ID '" + taskId + "' not found");
        return false;
    }

      public List<Task> getAllTasks() {
        return taskList;
    }
}