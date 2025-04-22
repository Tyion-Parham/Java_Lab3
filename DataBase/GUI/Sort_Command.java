package GUI;

public class Sort_Command implements Command {
    private Stats_Table statsTable;
    private String column;
    private String operator;
    private String filterValue;

    public Sort_Command(Stats_Table statsTable, String column, String operator, String filterValue) {
        this.statsTable = statsTable;
        this.column = column;
        this.operator = operator;
        this.filterValue = filterValue;
    }

    @Override
    public void execute() {
        statsTable.applySorting(column, operator, filterValue); // Pass operator and value
    }
}