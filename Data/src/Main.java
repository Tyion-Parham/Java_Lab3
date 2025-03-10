import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String statsFile = "Game_Stat_Example.txt";
        List<Game_Stats> playerStats = processRawStatsFile(statsFile);

        for (Game_Stats player : playerStats) {
            System.out.println(player);
        }

    }

    public static List<Game_Stats> processRawStatsFile(String filePath) {
        List<Game_Stats> playerStats = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("DNP"))
                {

                }
                String[] parts = line.split("\t"); // Assuming tab-separated values
                if (parts.length == 19) { // Make sure it's formated correctly
                    String name = parts[0].trim();
                    String playtime = parts[1].trim();
                    String fg = parts[2].trim();
                    String fga = parts[3].trim();
                    String threeg = parts[4].trim();
                    String threega = parts[5].trim();
                    String ft = parts[6].trim();
                    String fta = parts[7].trim();
                    String rebounds = parts[8].trim();
                    String assists = parts[9].trim();
                    String stls = parts[10].trim();
                    String blocks = parts[11].trim();
                    String turnovrs = parts[12].trim();
                    String fouls = parts[13].trim();
                    String points = parts[14].trim();
                    String gamescore = parts[15].trim();
                    String plusminus = parts[16].trim();
                    String teamName = parts[17].trim();
                    String dateTemp = parts[18].trim();
                    Date date = sdf.parse(dateTemp);
                    LocalDate correctedDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    playerStats.add(new Game_Stats(name, playtime, fg, fga, threeg, threega, ft, fta, rebounds,
                            assists, stls, blocks, turnovrs, fouls, points, gamescore, plusminus, teamName, correctedDate));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return playerStats;
    }
}