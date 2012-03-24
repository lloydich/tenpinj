package tenpin.frame;

public class FrameScore {

    private Integer firstBallScore;
    private Integer secondBallScore;
    private Integer totalScore;

    public Integer addScores(){
        Integer total = firstBallScore;
        if(secondBallScore!=null){
            total = total + secondBallScore;
        }
        return total;
    }

    public Integer getFirstBallScore() {
        return firstBallScore;
    }

    public Integer getSecondBallScore() {
        return secondBallScore;
    }


    public Integer getTotalScore() {
        return totalScore;
    }

    public void setFirstBallScore(Integer firstBallScore) {
        this.firstBallScore = firstBallScore;
    }

    public void setSecondBallScore(Integer secondBallScore) {
        this.secondBallScore = secondBallScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isAStrike(){
        return firstBallScore!=null &&  firstBallScore==10;
    }

    public boolean isASpare(){
        return firstBallScore!=null &&  secondBallScore!=null && ((firstBallScore + secondBallScore)==10);
    }

    @Override
    public String toString() {
        return "FrameScore{" +
                "firstBallScore=" + firstBallScore +
                ", secondBallScore=" + secondBallScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
