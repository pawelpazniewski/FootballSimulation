package Game;

import Resources.Team;

import java.util.Random;

public class MatchEngine {
    public Team homeTeam = new Team("Arsenal",11);
    public Team awayTeam = new Team("Brighton",10);
    public double luckFactor;
    public int homeStadiumFactor = 1;
    public int homeTeamOverallStrength;
    public int awayTeamOverallStrength;
    public double rangeMin = 0.80;
    public double rangeMax = 1.30;
    public int homeWin,awayWin,draw;



    public double getLuckFactor(){
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        luckFactor = randomValue;
        return luckFactor;
    }

    public int countHomeTeamOverallStrength(){

        homeTeamOverallStrength = (int) ((this.homeTeam.getTeamStrength() * getLuckFactor()) + homeStadiumFactor);
        return homeTeamOverallStrength;
    }
    public double countAwayTeamOverallStrength(){

        awayTeamOverallStrength = (int) (this.awayTeam.getTeamStrength() * getLuckFactor());
        return awayTeamOverallStrength;
    }


    public void play (){
        countHomeTeamOverallStrength();
        countAwayTeamOverallStrength();
        if (homeTeamOverallStrength > awayTeamOverallStrength){
            System.out.println("Home Team Strength: " + homeTeamOverallStrength);
            System.out.println("Away Team Strength: " + awayTeamOverallStrength);
            System.out.println("Home team won!");
            homeWin++;
        }
        else if(homeTeamOverallStrength < awayTeamOverallStrength){
            System.out.println("Home Team Strength: " + homeTeamOverallStrength);
            System.out.println("Away Team Strength: " + awayTeamOverallStrength);
            System.out.println("Away team won!");
            awayWin++;
        }
        else {
            System.out.println("Home Team Strength: " + homeTeamOverallStrength);
            System.out.println("Away Team Strength: " + awayTeamOverallStrength);
            System.out.println("Draw!");
            draw ++;

        }
    }

    public void printOverallResults(){
        System.out.println("Homewins: " + homeWin);
        System.out.println("Awaywins: " + awayWin);
        System.out.println("Draws: " + draw);
    }

}
