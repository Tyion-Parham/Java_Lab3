package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sort_Panel extends JPanel {
    private Stats_Table statsTable;
    private JComboBox<String> columnComboBox;
    private JTextField filterTextField;
    private JButton applyButton;

    public Sort_Panel(Stats_Table statsTable) {
        this.statsTable = statsTable;

        setLayout(new FlowLayout(FlowLayout.LEFT));

        String[] columns = {"Name", "Playtime", "PTS", "REB", "AST", "STL", "BLK", "TO", "FGM", "FGA", "FG%", "3PM",
                "3PA", "3P%", "FTM", "FTA", "FT%", "PF", "+/-", "GmSc", "Team", "Date"};

        columnComboBox = new JComboBox<>(columns);
        columnComboBox.setPreferredSize(new Dimension(150, 30));

        filterTextField = new JTextField(15);

        applyButton = new JButton("Sort");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColumn = (String) columnComboBox.getSelectedItem();
                String filterValue = filterTextField.getText();
                statsTable.applySorting(selectedColumn, filterValue);
            }
        });

        add(new JLabel("Sort by:"));
        add(columnComboBox);
        add(new JLabel("Enter value:"));
        add(filterTextField);
        add(applyButton);
    }
}