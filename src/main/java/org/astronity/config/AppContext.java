package org.astronity.config;

import org.astronity.controller.controllers.TaskController;
import org.astronity.model.repositories.TaskDao;
import org.astronity.model.repositories.impl.TaskDaoImpl;
import org.astronity.model.services.TaskService;
import org.astronity.model.services.impl.TaskServiceImpl;
import org.astronity.shared.constants.AppConstants;
import org.astronity.view.screens.DashboardPanel;
import org.astronity.view.screens.MainFrame;

public class AppContext {
    public final MainFrame mainFrame;

    public AppContext()
    {
        TaskDao taskDao = new TaskDaoImpl();
        TaskService taskService = new TaskServiceImpl(taskDao);

        mainFrame = new MainFrame();

        NavigationRouter router = new NavigationRouter(mainFrame.getCardLayout(), mainFrame.getContainer());

        TaskController  taskController = new TaskController(taskService);

        DashboardPanel dashboardPanel = new DashboardPanel(
                mainFrame,
                taskService,
                taskController
        );

        router.setDashboardPanel(dashboardPanel);
        router.register(AppConstants.SCREEN_DASHBOARD, dashboardPanel);
        router.navigateTo(AppConstants.SCREEN_DASHBOARD);
    }
}
