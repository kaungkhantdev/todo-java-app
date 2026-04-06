package org.astronity.model.services.impl;

import org.astronity.model.entities.Task;
import org.astronity.model.repositories.TaskDao;
import org.astronity.model.services.TaskService;
import org.astronity.shared.exceptions.AppException;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener l) { pcs.addPropertyChangeListener(l);}
    public void removePropertyChangeListener(PropertyChangeListener l) { pcs.removePropertyChangeListener(l);}

    public TaskServiceImpl(TaskDao taskDao)
    {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getAllTasks()
    {
        return taskDao.findAll();
    }

    @Override
    public Optional getTaskById(int id)
    {
        return taskDao.findById(id);
    }

    @Override
    public Task createTask(String taskName)
    {
        validateFields(taskName);
        Task saved = taskDao.save(new Task(0, taskName));
        pcs.firePropertyChange("tasks", null, taskDao.findAll());
        return saved;
    }

    @Override
    public Task updateTask(int id, String taskName)
    {
        validateFields(taskName);
        Task existing = taskDao.findById(id)
                .orElseThrow(() -> new AppException("Task not found: " + id));
        existing.setTaskName(taskName);
        Task saved = taskDao.save(existing);
        pcs.firePropertyChange("tasks", null, taskDao.findAll());
        return saved;
    }

    @Override
    public void deleteTask(int id)
    {
        taskDao.deleteById(id);
        pcs.firePropertyChange("tasks", null, taskDao.findAll());
    }

    private void validateFields(String taskName) {
        if (taskName == null || taskName.isBlank()) throw new AppException("Email is required.");
    }
}
