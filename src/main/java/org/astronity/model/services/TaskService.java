package org.astronity.model.services;

import org.astronity.model.entities.Task;

import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    public List<Task> getAllTasks();
    public Optional getTaskById(int id);
    public Task createTask(String taskName);
    public Task updateTask(int id, String taskName);
    public void deleteTask(int id);
    public void addPropertyChangeListener(PropertyChangeListener l);
    public void removePropertyChangeListener(PropertyChangeListener l);
}
