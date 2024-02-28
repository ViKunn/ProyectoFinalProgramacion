package business;
import business.Fruit;

public class Score {

    /*
    Todas las frutas valen lo mismo
        banana: 50
        uva: 50
        sandía: 50
    */
    private String name;
    private int totalScore;


    public int getTotalScore(){
        return this.totalScore = 0;
    }
    public Score(){
    }

    public int increaseScore() {
        return totalScore += Fruit.getScoreFruit();
    }

    public void showScore() {

    }
}



