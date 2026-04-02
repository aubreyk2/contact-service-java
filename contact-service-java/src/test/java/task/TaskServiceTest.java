package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService();
        service.addTask(new Task("001", "TaskOne", "This is task one."));
    }

    // Add Task test
    @Test
    void testAddTaskUniqueId() {
        Task newTask = new Task("002", "TaskTwo", "This is task two.");
        assertTrue(service.addTask(newTask), "Adding a task with a unique ID should succeed");
    }

    @Test
    void testAddTaskDuplicateId() {
        Task duplicateTask = new Task("001", "NewTaskOne", "Duplicate ID task");
        assertFalse(service.addTask(duplicateTask), "Adding a task with a duplicate ID should fail");
    }

    // Delete Task test
    @Test
    void testDeleteTask() {
        assertTrue(service.deleteTask("001"), "Deleting an existing task should return true");
    }

    @Test
    void testDeleteTaskNotFound() {
        assertFalse(service.deleteTask("999"), "Deleting a non-existent task should return false");
    }

    //Update task TEst
    @Test
    void testUpdateTaskName() {
        assertTrue(service.updateTaskName("001", "Updated Task One"), "Updating existing task name should succeed");
    }

    @Test
    void testUpdateTaskDescription() {
        assertTrue(service.updateTaskDescription("001", "Updated task one."), "Updating existing task description should succeed");
    }

    @Test
    void testUpdateTaskNameNotFound() {
        assertFalse(service.updateTaskName("999", "New Task"), "Updating name of a non-existent task should fail");
    }

    @Test
    void testUpdateTaskDescriptionNotFound() {
        assertFalse(service.updateTaskDescription("999", "New description"), "Updating description of a non-existent task should fail");
    }

    @Test
    void testUpdateTaskNameNull() {
        assertTrue(service.updateTaskName("001", null), "Updating task name with null should not throw error but keep original name");
        assertEquals("TaskOne", service.getAllTasks().get(0).getName(), "Task name should remain unchanged when updated with null");
    }

    @Test
    void testUpdateTaskDescriptionNull() {
        assertTrue(service.updateTaskDescription("001", null), "Updating task description with null should not throw error but keep original description");
        assertEquals("This is task one.", service.getAllTasks().get(0).getDescription(), "Task description should remain unchanged when updated with null");
    }
}
