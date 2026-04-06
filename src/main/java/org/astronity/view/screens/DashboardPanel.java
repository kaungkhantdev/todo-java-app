package org.astronity.view.screens;

import org.astronity.controller.controllers.TaskController;
import org.astronity.model.entities.Task;
import org.astronity.model.services.TaskService;
import org.astronity.view.components.PrimaryButton;
import org.astronity.view.components.TaskTable;
import org.astronity.view.dialogs.TaskFormDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private final Frame ownerFrame;
    private final JTable table;
    private final JLabel welcomeLabel = new JLabel();

    private final TaskTable taskTable;
    private final TaskService taskService;

    private final TaskController taskController;

    public DashboardPanel(
            Frame ownerFrame,
            TaskService taskService,
            TaskController taskController
    )
    {
        this.ownerFrame = ownerFrame;
        this.taskService = taskService;
        this.taskController = taskController;
        taskTable = new TaskTable(taskService.getAllTasks());
        table = buildTable();
        initUi();
        observeModel();
    }

    private void initUi()
    {
        this.setLayout(new BorderLayout());

        // Header bar
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        header.setBackground(new Color(30, 41, 59));

        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.add(welcomeLabel, BorderLayout.WEST);

        JLabel appTitle = new JLabel("User Manager");
        appTitle.setForeground(new Color(148, 163, 184));
        appTitle.setFont(new Font("SansSerif", Font.PLAIN, 13));
        header.add(appTitle, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // Table
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Toolbar
        add(buildToolbar(), BorderLayout.SOUTH);
    }

    private JTable buildTable()
    {
        JTable t = new JTable(taskTable);
        t.setRowHeight(28);
        t.setFont(new Font("SansSerif", Font.PLAIN, 13));
        t.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        t.setFillsViewportHeight(true);
        t.setGridColor(new Color(230, 230, 230));

        // Center-align ID column
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);
        t.getColumnModel().getColumn(0).setCellRenderer(center);
        t.getColumnModel().getColumn(0).setMaxWidth(60);

        return t;
    }

    private JPanel buildToolbar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 10));
        bar.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(220, 220, 220)));

        PrimaryButton addBtn    = new PrimaryButton("+ Add User");
        JButton       editBtn   = new PrimaryButton("Edit");
        editBtn.setBackground(Color.white);
        editBtn.setForeground(Color.black);
        JButton       deleteBtn = new PrimaryButton("Delete");
        deleteBtn.setBackground(Color.white);
        deleteBtn.setForeground(new Color(185, 28, 28));

        addBtn.addActionListener(e    -> openAddDialog());
        editBtn.addActionListener(e   -> openEditDialog());
        deleteBtn.addActionListener(e -> deleteSelected());

        bar.add(addBtn);
        bar.add(editBtn);
        bar.add(deleteBtn);
        return bar;
    }

    private void observeModel() {
        taskService.addPropertyChangeListener(evt -> {
            if ("tasks".equals(evt.getPropertyName())) {
                taskTable.setData(taskService.getAllTasks());
            }
        });
    }

    private void openAddDialog()
    {
        TaskFormDialog dlg = new TaskFormDialog(ownerFrame, "Add Task");
        dlg.setVisible(true);
        if (dlg.isConfirmed())
            taskController.handleCreate(this, dlg.getTaskNameInput());
    }

    private void openEditDialog()
    {
        int row = table.getSelectedRow();
        if (row < 0)
        {
            JOptionPane.showMessageDialog(this, "Select a user to edit.");
            return;
        }
        Task selected = taskTable.getTaskAt(row);
        TaskFormDialog dlg = new TaskFormDialog(ownerFrame, "Edit Task");
        dlg.populate(selected);

        dlg.setVisible(true);
        if (dlg.isConfirmed())
            taskController.handleUpdate(this, selected.getId(), dlg.getTaskNameInput());
    }

    private void deleteSelected()
    {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select a user to delete."); return; }
        Task selected = taskTable.getTaskAt(row);
        taskController.handleDelete(this, selected.getId());
    }
}
