package presentationEnConsola;
import business.Score;

import java.util.ArrayList;

public class ScoreState {
    private static ArrayList<Score> listScores = new ArrayList<>();
    public static void  saveScore(ArrayList<Score> score) {
        listScores = score;
    }

    public void showScore() {
        for(Score scores: listScores){
            System.out.println(scores);
        }
    }

}