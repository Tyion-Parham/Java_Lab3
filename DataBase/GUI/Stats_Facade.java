package GUI;

//Facade Pattern

import Data.Game_Stats;
import Data.Main;

import java.awt.*;
import java.util.List;

public class Stats_Facade {

    private Stats_Table statsTable;
    private Sort_Panel sortPanel;

    public Stats_Facade() {
        String statsFile = "Game_Stat_Example.txt";
        List<Game_Stats> playerStats = Main.processRawStatsFile(statsFile);

        statsTable = new Stats_Table(playerStats);
        statsTable.setPreferredSize(new Dimension(1276, 650));

        this.statsTable = new Stats_Table(playerStats);
        this.sortPanel = new Sort_Panel(statsTable);
    }

    public Stats_Table getStatsTable() {
        return statsTable;
    }

    public Sort_Panel getSortPanel() {
        return sortPanel;
    }
}
