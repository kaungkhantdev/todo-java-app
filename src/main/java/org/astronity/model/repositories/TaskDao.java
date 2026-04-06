package org.astronity.model.repositories;

import org.astronity.model.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDao {
    List<Task> findAll();
    Optional<Task> findById(int id);
    Task save(Task task);
    void deleteById(int id);
}
