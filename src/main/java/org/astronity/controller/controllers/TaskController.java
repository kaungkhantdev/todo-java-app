package org.astronity.controller.controllers;

import org.astronity.controller.router.ScreenRouter;
import org.astronity.model.services.TaskService;
import org.astronity.shared.constants.AppConstants;
import org.astronity.shared.exceptions.AppException;
import org.astronity.shared.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class TaskController {
   private final TaskService taskService;

   public TaskController(TaskService taskService)
   {
       this.taskService = taskService;
   }

   public void handleCreate(Component parent, String taskName)
   {
       try {
           taskService.createTask(taskName);
           SwingUtils.showInfo(parent, "Task Created Successfully.");
       }
       catch (AppException e)
       {
           SwingUtils.showError(parent, e.getMessage());
       }
   }

   public void handleUpdate(Component parent, int id, String taskName)
   {
       try {
           taskService.updateTask(id, taskName);
           SwingUtils.showInfo(parent, "Task Updated Successfully");
       }
       catch (AppException e)
       {
           SwingUtils.showError(parent, e.getMessage());
       }
   }

    public void handleDelete(Component parent, int id)
    {
        if (SwingUtils.confirm(parent, "Delete task \"" + id + "\"?" ))
            try {
                taskService.deleteTask(id);
            }
            catch (AppException e)
            {
                SwingUtils.showError(parent, e.getMessage());
            }
    }
}
