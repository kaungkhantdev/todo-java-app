package org.astronity.view.components;

import javax.swing.*;
import java.awt.*;

public class PrimaryButton extends JButton {
    public PrimaryButton(String text)
    {
        super(text);
        setBackground(new Color(59, 130, 246));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(getFont().deriveFont(Font.BOLD, 13f));
        setPreferredSize(new Dimension(getPreferredSize().width + 1, 34));
    }
}
