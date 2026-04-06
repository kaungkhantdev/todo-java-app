package org.astronity.model.repositories.impl;

import org.astronity.model.entities.Task;
import org.astronity.model.repositories.TaskDao;
import org.astronity.model.services.impl.TaskServiceImpl;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskDaoImpl implements TaskDao {

    private final Map<Integer, Task> store = new LinkedHashMap<>();
    private final AtomicInteger idSeq = new AtomicInteger(1);

    public TaskDaoImpl()
    {
        save(new Task(0, "Task 1"));
        save(new Task(0, "Task 2"));

    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    };

    @Override
    public Optional<Task> findById(int id)
    {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Task save(Task task)
    {
        if (task.getId() == 0) task.setId(idSeq.getAndIncrement());
        store.put(task.getId(), task);
        return task;
    }

    @Override
    public void deleteById(int id)
    {
        store.remove(id);
    }
}
