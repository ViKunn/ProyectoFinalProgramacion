package business;
import business.Fruit;

public class Score {

    /*
    Todas las frutas valen lo mismo
        banana: 50
        uva: 50
        sandía: 50
    */
    private int totalScore;

    public Score(){
        this.totalScore = 0;
    }
    public void icreaseScore(Score scoreFruit) {
        totalScore += scoreFruit.getTotalScore();
    }
    public int getTotalScore(){
        return this.totalScore;
    }


}