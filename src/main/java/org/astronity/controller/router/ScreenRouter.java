package org.astronity.controller.router;

import javax.swing.*;
import java.awt.*;

public class ScreenRouter {
    private final CardLayout layout;
    private final JPanel container;

    public ScreenRouter(CardLayout layout, JPanel container)
    {
        this.layout = layout;
        this.container = container;
    }

    public void register(String name, JPanel panel)
    {
        container.add(panel, name);
    }

    public void navigateTo(String screen)
    {
        layout.show(container, screen);
    }
}
