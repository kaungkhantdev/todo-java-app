package org.astronity;

import org.astronity.config.AppContext;
import org.astronity.controller.controllers.TaskController;
import org.astronity.controller.router.ScreenRouter;
import org.astronity.model.repositories.TaskDao;
import org.astronity.model.repositories.impl.TaskDaoImpl;
import org.astronity.model.services.TaskService;
import org.astronity.model.services.impl.TaskServiceImpl;
import org.astronity.shared.utils.SwingUtils;
import org.astronity.view.screens.DashboardPanel;
import org.astronity.view.screens.LoginPanel;
import org.astronity.view.screens.MainFrame;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SwingUtils.applySystemLaf();
        SwingUtilities.invokeLater(() -> {
            AppContext ctx = new AppContext();
            ctx.mainFrame.setVisible(true);
        });
    }
}