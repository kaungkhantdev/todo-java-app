package org.astronity.view.screens;

import org.astronity.view.components.PrimaryButton;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private final JTextField emailField = new JTextField(22);
    private final JPasswordField passwordField = new JPasswordField(22);

    public LoginPanel()
    {
        initUi();
    }

    private void initUi()
    {
        setLayout(new GridBagLayout());

        JPanel card = new JPanel(new GridBagLayout());
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(32, 40, 32, 40)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Login");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        card.add(title, gbc);

        JLabel hint = new JLabel("Sign in to continue");
        hint.setForeground(Color.GRAY);
        hint.setFont(new Font("SansSerif", Font.PLAIN, 13));
        hint.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        card.add(hint, gbc);

        gbc.gridwidth = 1;

        addLabelField(card, gbc, 2, "Email:", emailField);
        addLabelField(card, gbc, 3, "Password:", passwordField);

        JLabel demo = new JLabel("Demo: any email above, any password");
        demo.setFont(new Font("SansSerif", Font.ITALIC, 11));
        demo.setForeground(Color.GRAY);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        card.add(demo, gbc);

        PrimaryButton loginBtn = new PrimaryButton("Sign in");
        loginBtn.setPreferredSize(new Dimension(200, 36));
        gbc.gridy = 5;
        card.add(loginBtn, gbc);

        this.add(card);
    }

    private void addLabelField(JPanel p, GridBagConstraints gbc, int row, String label, JComponent field)
    {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        p.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        p.add(field, gbc);
    }
}
