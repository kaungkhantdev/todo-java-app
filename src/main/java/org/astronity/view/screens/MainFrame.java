package org.astronity.view.screens;

import org.astronity.shared.constants.AppConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final CardLayout layout = new CardLayout();
    private final JPanel container = new JPanel(layout);

    public MainFrame()
    {
        super(AppConstants.APP_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(AppConstants.WINDOW_WIDTH, AppConstants.WINDOW_HEIGHT));
        setContentPane(container);
        pack();
        setVisible(true);
    }

    public CardLayout getCardLayout() { return layout; }
    public JPanel getContainer() { return container; }
}
