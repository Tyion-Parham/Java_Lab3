package GUI;

import Data.Game_Stats;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
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

    public void applySorting(String columnName, String operator, String filterValue) {
        int columnIndex = Stats_Model.getColumnIndex(columnName);
        if (columnIndex == -1) return;

        // Define numerical columns
        Set<String> numericColumns = new HashSet<>(Arrays.asList(
                "PTS", "REB", "AST", "STL", "BLK", "TO", "FGM", "FGA", "FG%",
                "3PM", "3PA", "3P%", "FTM", "FTA", "FT%", "PF", "+/-", "GmSc"
        ));

        if (numericColumns.contains(columnName)) {
            try {
                double filterNumber = Double.parseDouble(filterValue);
                sorter.setRowFilter(new RowFilter<Stats_Model, Integer>() // single digits kinda break the row sorter
                {
                    @Override
                    public boolean include(Entry<? extends Stats_Model, ? extends Integer> entry) {
                        Game_Stats stats = ((Stats_Model) entry.getModel()).getGameStats(entry.getIdentifier());
                        Double value = getNumericValue(stats, columnName);
                        if (value == null) return false;

                        switch (operator) {
                            case ">": return value > filterNumber;
                            case "<": return value < filterNumber;
                            case ">=": return value >= filterNumber;
                            case "<=": return value <= filterNumber;
                            case "=": return value.equals(filterNumber);
                            default: return false;
                        }
                    }
                });
            } catch (NumberFormatException e) {
                // Invalid filter value
            }
        } else {
            // For non-numeric columns, use regex for "="
            sorter.setRowFilter(RowFilter.regexFilter("^" + filterValue, columnIndex));
        }
    }

    private Double getNumericValue(Game_Stats stats, String columnName) {
        if (stats.getDidNotPlay()) return null;

        try {
            switch (columnName) {
                case "PTS": return Double.parseDouble(stats.getPoints());
                case "REB": return Double.parseDouble(stats.getRebounds());
                case "AST": return Double.parseDouble(stats.getAssist());
                case "STL": return Double.parseDouble(stats.getSteals());
                case "BLK": return Double.parseDouble(stats.getBlocks());
                case "TO": return Double.parseDouble(stats.getTurnovers());
                case "FGM": return Double.parseDouble(stats.getFieldGoals());
                case "FGA": return Double.parseDouble(stats.getFieldGoalsAtt());
                case "FG%": return stats.getFieldGoalPercentage();
                case "3PM": return Double.parseDouble(stats.getThreePointFG());
                case "3PA": return Double.parseDouble(stats.getThreePointFGA());
                case "3P%": return stats.getThreePointPercentage();
                case "FTM": return Double.parseDouble(stats.getFreeThrows());
                case "FTA": return Double.parseDouble(stats.getFreeThrowsAtt());
                case "FT%": return stats.getFreeThrowPercentage();
                case "PF": return Double.parseDouble(stats.getPersonalFouls());
                case "+/-": return Double.parseDouble(stats.getPlusMinus());
                case "GmSc": return Double.parseDouble(stats.getGameScore());
                default: return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}