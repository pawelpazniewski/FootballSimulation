package Game;

import Resources.Team;

public class Main {
    static MatchEngine engine = new MatchEngine();


    public static void main(String[] args) {
        for (int i =0; i <700000 ; i ++) {
            engine.play();
        }
        engine.printOverallResults();


    }
}
