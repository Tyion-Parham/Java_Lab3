package GUI;

import Data.Game_Stats;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class Stats_Model extends AbstractTableModel {
    private List<Game_Stats> data;
    private static String[] columnNames = {"Name", "Playtime", "PTS", "REB", "AST", "STL", "BLK", "TO",
            "FGM", "FGA", "FG%", "3PM", "3PA", "3P%", "FTM", "FTA", "FT%", "PF", "+/-", "GmSc", "Team", "Date"};

    public Stats_Model(List<Game_Stats> data) {
        this.data = data;
    }


    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public static int getColumnIndex(String col) {
        for (int i = 0; i < columnNames.length; i++) {
            if (columnNames[i].equals(col)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Game_Stats stats = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stats.getPlayerName();
            case 1:
                return stats.getMinutesPlayed();
            case 2:
                return stats.getPoints();
            case 3:
                return stats.getRebounds();
            case 4:
                return stats.getAssist();
            case 5:
                return stats.getSteals();
            case 6:
                return stats.getBlocks();
            case 7:
                return stats.getTurnovers();
            case 8:
                return stats.getFieldGoals();
            case 9:
                return stats.getFieldGoalsAtt();
            case 10:
                if(stats.getDidNotPlay())
                    return "DNP";
                else
                    return (stats.getFieldGoalPercentage() + "%");
            case 11:
                return stats.getThreePointFG();
            case 12:
                return stats.getThreePointFGA();
            case 13:
                if(stats.getDidNotPlay())
                    return "DNP";
                else
                    return (stats.getThreePointPercentage() + "%");
            case 14:
                return stats.getFreeThrows();
            case 15:
                return stats.getFreeThrowsAtt();
            case 16:
                if(stats.getDidNotPlay())
                    return "DNP";
                else
                    return (stats.getFreeThrowPercentage() + "%");
            case 17:
                return stats.getPersonalFouls();
            case 18:
                return stats.getPlusMinus();
            case 19:
                return stats.getGameScore();
            case 20:
                return stats.getTeamName();
            case 21:
                return stats.getGameDate();
            default:
                return null;


        }
    }
}