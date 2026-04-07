package org.astronity.model.entities;

public class Task {
    private int id;
    private String taskName;

    public Task() {}

    public Task(int id, String taskName)
    {
        this.id = id;
        this.taskName = taskName;
    }

    public int getId() { return id; }
    public String getTaskName() { return taskName; }

    public void setId(int id) { this.id = id; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    @Override
    public String toString()
    {
        return id + " - " + taskName;
    }

}
