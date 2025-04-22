package GUI;

import Data.Game_Stats;
import Data.Main;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class Main_Frame extends JFrame {
    private Stats_Facade statsFacade;

    public Main_Frame() {
        this.statsFacade = new Stats_Facade();

        JFrame statsFrame = new JFrame("NBA Stats");
        statsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1313, 700));
        mainPanel.setBackground(Color.GRAY);

        // Use facade to get the SortPanel and StatsTable
        Sort_Panel sortPanel = statsFacade.getSortPanel();
        Stats_Table statsTable = statsFacade.getStatsTable();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(sortPanel, BorderLayout.NORTH);
        mainPanel.add(statsTable, BorderLayout.CENTER);


        statsFrame.getContentPane().add(mainPanel);
        statsFrame.pack();
        statsFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main_Frame();
    }
}
