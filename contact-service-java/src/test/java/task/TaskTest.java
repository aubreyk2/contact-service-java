package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    void testTaskId() {
        Task task = new Task("001", "TaskOne", "This is task one.");
        assertEquals("001", task.getTaskId(), "Task ID should match what was set in constructor");
    }

    @Test
    void testName() {
        Task task = new Task("001", "TaskOne", "This is task one.");
        assertEquals("TaskOne", task.getName(), "Task name should match what was set in constructor");
    }

    @Test
    void testDescription() {
        Task task = new Task("001", "TaskOne", "This is task one.");
        assertEquals("This is task one.", task.getDescription(), "Task description should match what was set in constructor");
    }

    @Test
    void testSetNameValid() {
        Task task = new Task("002", "TaskTwo", "This is task two.");
        task.setName("UpdatedTaskTwo");
        assertEquals("UpdatedTaskTwo", task.getName(), "Setting a valid task name should update the name");
    }

    @Test
    void testSetDescriptionValid() {
        Task task = new Task("002", "TaskTwo", "This is task two.");
        task.setDescription("Updated description");
        assertEquals("Updated description", task.getDescription(), "Setting a valid task description should update the description");
    }
    
    @Test
    void testSetNameTooLong() {
        Task task = new Task("003", "TaskThree", "This is task three.");
        task.setName("ThisNameIsWayTooLongToBeValid1234567890");
        assertEquals("TaskThree", task.getName(), "Setting a task name too long should NOT change the original name");
    }

    @Test
    void testSetDescriptionTooLong() {
        Task task = new Task("004", "TaskFour", "This is task four.");
        task.setDescription("This description is way too long and exceeds fifty characters limit");
        assertEquals("This is task four.", task.getDescription(), "Setting a task description too long should NOT change the original description");
    }

    @Test
    void testSetNameNull() {
        Task task = new Task("005", "TaskFive", "Fifth task description.");
        task.setName(null);
        assertEquals("TaskFive", task.getName(), "Setting task name to null should not change original name");
    }

    @Test
    void testSetDescriptionNull() {
        Task task = new Task("006", "TaskSix", "Sixth task description.");
        task.setDescription(null);
        assertEquals("Sixth task description.", task.getDescription(), "Setting task description to null should not change original description");
    }
}
