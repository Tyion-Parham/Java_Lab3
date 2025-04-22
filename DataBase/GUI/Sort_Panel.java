package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sort_Panel extends JPanel {
    private Stats_Table statsTable;
    private JComboBox<String> columnComboBox;
    private JComboBox<String> operatorComboBox; // Added operator combo box
    private JTextField filterTextField;
    private JButton applyButton;

    public Sort_Panel(Stats_Table statsTable) {
        this.statsTable = statsTable;

        setLayout(new FlowLayout(FlowLayout.LEFT));

        String[] columns = {"Name", "Playtime", "PTS", "REB", "AST", "STL", "BLK", "TO", "FGM", "FGA", "FG%", "3PM",
                "3PA", "3P%", "FTM", "FTA", "FT%", "PF", "+/-", "GmSc", "Team", "Date"};
        String[] operators = {"=", ">", "<", ">=", "<="}; // Added operators

        columnComboBox = new JComboBox<>(columns);
        columnComboBox.setPreferredSize(new Dimension(150, 30));

        operatorComboBox = new JComboBox<>(operators); // Initialize operator combo box
        operatorComboBox.setPreferredSize(new Dimension(80, 30));

        filterTextField = new JTextField(15);

        applyButton = new JButton("Filter");
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColumn = (String) columnComboBox.getSelectedItem();
                String selectedOperator = (String) operatorComboBox.getSelectedItem();
                String filterValue = filterTextField.getText();

                // Command Pattern
                Command sortCommand = new Sort_Command(statsTable, selectedColumn, selectedOperator, filterValue);
                sortCommand.execute();
            }
        });

        add(new JLabel("Sort by:"));
        add(columnComboBox);
        add(new JLabel("Operator:"));
        add(operatorComboBox);
        add(new JLabel("Value:"));
        add(filterTextField);
        add(applyButton);
    }
}