package business;

public class Score {

    private int totalScore;

    public Score(){
        this.totalScore = 0;
    }

    public Score(int totalScore){
        this.totalScore = totalScore;
    }

    public void increaseScore(int fruitScore) {
        totalScore += fruitScore;
    }
    public int getTotalScore(){
        return this.totalScore;
    }


}