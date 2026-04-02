package task;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID. Must be non-null and at most 10 characters.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid task name. Must be non-null and at most 20 characters.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid task description. Must be non-null and at most 50 characters.");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }
    //Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setName(String name) {
        if (name != null && name.length() <= 20) {
            System.out.println("Updating task name from '" + this.name + "' to '" + name + "'");
            this.name = name;
        } else {
            System.out.println("Invalid name. Must be non-null and <= 20 characters..");
        }
    }

    public void setDescription(String description) {
        if (description != null && description.length() <= 50) {
            System.out.println("Updating task description from '" + this.description + "' to '" + description + "'");
            this.description = description;
        } else {
            System.out.println("Invalid description. Must be non-null and <= 50 characters.");
        }
    }
}
