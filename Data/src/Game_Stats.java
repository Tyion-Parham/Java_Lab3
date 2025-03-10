import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Game_Stats {
    String playerName, minutesPlayed, teamName, fieldGoals, fieldGoalsAtt, threePointFG, threePointFGA, freeThrows,
            freeThrowsAtt, rebounds, assist, steals, blocks, turnovers, personalFouls, points, plusMinus, gameScore;
    double fieldGoalPercentage, threePointPercentage, freeThrowPercentage;
    boolean DidNotPlay = false;
    LocalDate gameDate;

    Game_Stats(String pname, String mp, String fg, String fga, String treP, String trePa, String ft,
               String fta, String reb, String ast, String stl, String blk, String tov, String pf, String pts,
               String gs, String pm, String tname, LocalDate gdate) {
        playerName = pname;
        minutesPlayed = mp;
        fieldGoals = fg;
        fieldGoalsAtt = fga;
        threePointFG = treP;
        threePointFGA = trePa;
        freeThrows = ft;
        freeThrowsAtt = fta;
        rebounds = reb;
        assist = ast;
        steals = stl;
        blocks = blk;
        turnovers = tov;
        personalFouls = pf;
        points = pts;
        gameScore = gs;
        plusMinus = pm;
        teamName = tname;
        gameDate = gdate;
        if (!fieldGoals.equals("DNP"))
        {
            setFieldGoalPercentage();
            setThreePointPercentage();
            setFreeThrowPercentage();
        }
        else
            DidNotPlay = true;
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String pname) {
        playerName = pname;
    }

    public String getMinutesPlayed() {
        return minutesPlayed;
    }
    public void setMinutesPlayed(String mp) {
        minutesPlayed = mp;
    }

    public String getFieldGoals() {
        return fieldGoals;
    }
    public void setFieldGoals(String fg) {
        fieldGoals = fg;
    }

    public String getFieldGoalsAtt() {
        return fieldGoalsAtt;
    }
    public void setFieldGoalsAtt(String fga) {
        fieldGoalsAtt = fga;
    }

    public Double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }
    public void setFieldGoalPercentage() {
        int tempnum1, tempnum2;
        if (!fieldGoals.equals("DNP") && !fieldGoalsAtt.equals("DNP"))
        {
            tempnum1 = Integer.parseInt(fieldGoals);
            tempnum2 = Integer.parseInt(fieldGoalsAtt);
            if (tempnum2 != 0)
            {
                fieldGoalPercentage = ((double) tempnum1 /tempnum2)*100;
                fieldGoalPercentage = BigDecimal.valueOf(fieldGoalPercentage)
                        .setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            else
                fieldGoalPercentage = 0;
        }
    }

    public String getThreePointFG() {
        return threePointFG;
    }
    public void setThreePointFG(String treP) {
        threePointFG = treP;
    }

    public String getThreePointFGA() {
        return threePointFGA;
    }
    public void setThreePointFGA(String trePa) {
        threePointFGA = trePa;
    }

    public Double getThreePointPercentage() {
        return threePointPercentage;
    }
    public void setThreePointPercentage() {
        int tempnum1, tempnum2;
        if (!threePointFG.equals("DNP") && !threePointFGA.equals("DNP"))
        {
            tempnum1 = Integer.parseInt(threePointFG);
            tempnum2 = Integer.parseInt(threePointFGA);
            if (tempnum2 != 0)
            {
                threePointPercentage = ((double) tempnum1 /tempnum2)*100;
                threePointPercentage = BigDecimal.valueOf(threePointPercentage)
                        .setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            else
                threePointPercentage = 0;
        }
    }

    public String getFreeThrows() {
        return freeThrows;
    }
    public void setFreeThrows(String ft) {
        freeThrows = ft;
    }

    public String getFreeThrowsAtt() {
        return freeThrowsAtt;
    }
    public void setFreeThrowsAtt(String fta) {
        freeThrowsAtt = fta;
    }

    public Double getFreeThrowPercentage() {
        return freeThrowPercentage;
    }
    public void setFreeThrowPercentage() {
        int tempnum1, tempnum2;
        if (!freeThrows.equals("DNP") && !freeThrowsAtt.equals("DNP"))
        {
            tempnum1 = Integer.parseInt(freeThrows);
            tempnum2 = Integer.parseInt(freeThrowsAtt);
            if (tempnum2 != 0)
            {
                freeThrowPercentage = ((double) tempnum1 /tempnum2)*100;
                freeThrowPercentage = BigDecimal.valueOf(freeThrowPercentage)
                        .setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            else
                freeThrowPercentage = 0;
        }
    }

    public String getRebounds() {
        return rebounds;
    }
    public void setRebounds(String reb) {
        rebounds = reb;
    }

    public String getAssist() {
        return assist;
    }
    public void setAssist(String assist) {
        this.assist = assist;
    }

    public String getSteals() {
        return steals;
    }
    public void setSteals(String steals) {
        this.steals = steals;
    }

    public String getBlocks() {
        return blocks;
    }
    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getTurnovers() {
        return turnovers;
    }
    public void setTurnovers(String turnovers) {
        this.turnovers = turnovers;
    }

    public String getPersonalFouls() {
        return personalFouls;
    }
    public void setPersonalFouls(String personalFouls) {
        this.personalFouls = personalFouls;
    }

    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }

    public String getGameScore() {
        return gameScore;
    }
    public void setGameScore(String gameScore) {
        this.gameScore = gameScore;
    }

    public String getPlusMinus() {
        return plusMinus;
    }
    public void setPlusMinus(String plusMinus) {
        this.plusMinus = plusMinus;
    }

    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }
    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public boolean getDidNotPlay() {
        return DidNotPlay;
    }
    public void setDidNotPlay(boolean DNP) {
        DidNotPlay = DNP;
    }

    @Override
    public String toString() {
        if (DidNotPlay == true) {
            return playerName + "\t\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP"
                    + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t"
                    + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP" + "\t" + "DNP"
                    + "\t" + teamName + "\t" + gameDate;
        }

        return playerName + "\t\t" + minutesPlayed + "\t" + points + "\t" + rebounds + "\t" + assist + "\t" + steals
                + "\t" + blocks + "\t" + turnovers + "\t" + fieldGoals + "\t" + fieldGoalsAtt + "\t"
                + fieldGoalPercentage + "%\t" + threePointFG + "\t" + threePointFGA + "\t" + threePointPercentage
                + "%\t" + freeThrows + "\t" + freeThrowsAtt + "\t" + freeThrowPercentage + "%\t" + personalFouls
                + "\t" + plusMinus + "\t" + gameScore + "\t" + teamName + "\t" + gameDate;
    }
}