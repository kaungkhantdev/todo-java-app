package org.astronity.view.components;

import org.astronity.model.entities.Task;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TaskTable extends AbstractTableModel {
    private static final String[] COLUMNS = {"ID", "Task Name"};
    private List<Task> data;

    public TaskTable(List<Task> data)
    {
        this.data = new ArrayList<>(data);
    }

    public void setData(List<Task> data)
    {
        this.data = new ArrayList<>(data);
        fireTableDataChanged();
    }

    public Task getTaskAt(int row)
    {
        return data.get(row);
    }

    @Override public int    getRowCount()                  { return data.size(); }
    @Override public int    getColumnCount()               { return COLUMNS.length; }
    @Override public String getColumnName(int col)         { return COLUMNS[col]; }
    @Override public boolean isCellEditable(int r, int c)  { return false; }

    @Override
    public Object getValueAt(int row, int col) {
        Task t = data.get(row);
        return switch (col) {
            case 0 -> t.getId();
            case 1 -> t.getTaskName();
            default -> "";
        };
    }
}
