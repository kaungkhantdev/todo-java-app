package org.astronity.config;

import org.astronity.controller.router.ScreenRouter;
import org.astronity.shared.constants.AppConstants;
import org.astronity.view.screens.DashboardPanel;

import javax.swing.*;
import java.awt.*;

public class NavigationRouter extends ScreenRouter {

    private DashboardPanel dashboardPanel;
    public NavigationRouter(CardLayout layout, JPanel container)
    {
        super(layout, container);
    }

    public void setDashboardPanel(DashboardPanel panel)
    {
        this.dashboardPanel = panel;
    }

    @Override
    public void navigateTo(String screen)
    {
        super.navigateTo(screen);
    }
}
