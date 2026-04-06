package org.astronity.view.dialogs;

import org.astronity.model.entities.Task;
import org.astronity.view.components.CancelButton;
import org.astronity.view.components.PrimaryButton;

import javax.swing.*;
import java.awt.*;

public class TaskFormDialog extends JDialog {

    private final JTextField taskNameField = new JTextField(22);
    private boolean confirmed = false;
    private Task editTarget;

    public TaskFormDialog(Frame owner, String title)
    {
        super(owner, title, true);
        initUi();
    }

    private void initUi()
    {
        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(16, 24, 8, 24));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill   = GridBagConstraints.HORIZONTAL;

        addRow(form, gbc, 0, "Task Name:", taskNameField);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        buttons.setBorder(BorderFactory.createEmptyBorder(0, 16, 12, 16));

        CancelButton cancel = new CancelButton("Cancel");
        cancel.addActionListener((e) -> dispose());

        PrimaryButton save = new PrimaryButton("Save");
        save.addActionListener((e) -> { confirmed = true; dispose(); });

        buttons.add(cancel);
        buttons.add(save);

        setLayout(new BorderLayout());
        add(form, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        pack();

        setResizable(false);
        setLocationRelativeTo(getOwner());
    }

    private void addRow(JPanel p, GridBagConstraints gbc, int row, String label, JComponent field)
    {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST;
        p.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        p.add(field, gbc);
    }

    public void populate(Task task)
    {
        this.editTarget = task;
        taskNameField.setText(editTarget.getTaskName());
    }

    public boolean isConfirmed() { return confirmed; }
    public Task    getEditTarget() { return editTarget; }
    public String  getTaskNameInput()  { return taskNameField.getText().trim(); }
}
