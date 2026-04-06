package org.astronity.shared.utils;

import javax.swing.*;
import java.awt.*;

public class SwingUtils {
    public static void showError(Component parent, String message)
    {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfo(Component parent, String message)
    {
        JOptionPane.showMessageDialog(parent, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component parent, String message)
    {
        return JOptionPane.showConfirmDialog(parent, message, "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION;
    }

    public static void applySystemLaf()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
    }

    public static JTextField addLabeledField(JPanel panel, GridBagConstraints gbc,
                                             int row, String label) {
        gbc.gridx = 0; gbc.gridy = row; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel(label), gbc);
        JTextField field = new JTextField(20);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(field, gbc);
        return field;
    }
}
