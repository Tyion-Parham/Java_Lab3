package GUI;

import Data.Game_Stats;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.List;

public class Stats_Table extends JPanel {
    private final JTable table;
    private TableRowSorter<Stats_Model> sorter;

    public Stats_Table(List<Game_Stats> data) {
        setLayout(new BorderLayout());

        Stats_Model model = new Stats_Model(data);
        table = new JTable(model);

        table.setAutoCreateRowSorter(true);

        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void applySorting(String columnName, String value) {
        int columnIndex = Stats_Model.getColumnIndex(columnName);
        if (columnIndex == -1) {
            return; // Invalid column name
        }

        sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + value, columnIndex));
    }
}