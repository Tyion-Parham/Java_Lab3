package GUI;

import Data.Game_Stats;
import Data.Main;

import java.awt.*;
import java.util.List;
import javax.swing.*;

public class Main_Frame extends JFrame {
    public static void main(String[] args) {
        JFrame statsFrame = new JFrame("NBA Stats");
        statsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1313, 700));
        mainPanel.setBackground(Color.GRAY);

        String statsFile = "Game_Stat_Example.txt";
        List<Game_Stats> playerStats = Main.processRawStatsFile(statsFile);

        Stats_Table statsTable = new Stats_Table(playerStats);
        statsTable.setPreferredSize(new Dimension(1276, 650));

        Sort_Panel sortPanel = new Sort_Panel(statsTable);

        mainPanel.add(sortPanel, BorderLayout.NORTH);
        mainPanel.add(statsTable, BorderLayout.CENTER);


        statsFrame.getContentPane().add(mainPanel);
        statsFrame.pack();
        statsFrame.setVisible(true);
    }
}