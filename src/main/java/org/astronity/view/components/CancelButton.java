package org.astronity.view.components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CancelButton extends JButton {

    private static final int RADIUS = 8;
    private static final Color BG = new Color(229, 231, 235);

    public CancelButton(String text)
    {
        super(text);
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(getFont().deriveFont(Font.BOLD, 13f));
        setPreferredSize(new Dimension(getPreferredSize().width + 16, 34));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getModel().isPressed() ? BG.darker() : BG);
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), RADIUS, RADIUS));
        g2.dispose();
        super.paintComponent(g);
    }
}
