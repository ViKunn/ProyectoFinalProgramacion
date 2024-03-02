package presentation;
import business.Score;

import java.util.ArrayList;

public class ScoreState {
    private static ArrayList<Score> listScores = new ArrayList<Score>();
    public static void  saveScore(ArrayList<Score> score) {
        listScores = score;
    }

    public void showScore() {
        for(Score scores: listScores){
            System.out.println(scores);
        }
    }
}
