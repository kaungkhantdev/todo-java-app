package org.astronity;

import org.astronity.controller.controllers.LoginController;
import org.astronity.controller.router.ScreenRouter;
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
        System.out.printf("Hello and welcome!");

        MainFrame frame = new MainFrame();
        CardLayout layout = frame.getCardLayout();
        JPanel container = frame.getContainer();

        // router
        ScreenRouter router = new ScreenRouter(layout, container);

        // controller
        LoginController loginController = new LoginController(router);

        LoginPanel loginPanel = new LoginPanel();
        DashboardPanel dashboardPanel = new DashboardPanel();

        router.register("login", loginPanel);
        router.register("dashboard", dashboardPanel);

        router.navigateTo("login");
    }
}