package org.astronity.controller.controllers;

import org.astronity.controller.router.ScreenRouter;
import org.astronity.shared.constants.AppConstants;

import javax.swing.*;
import java.awt.*;

public class LoginController {
    private final ScreenRouter router;

    public LoginController(ScreenRouter router)
    {
        this.router = router;
    }

    public void handleLogin(Component parent)
    {
        try {
            router.navigateTo(AppConstants.SCREEN_DASHBOARD);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
