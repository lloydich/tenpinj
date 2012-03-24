package tenpin.frame;

public class TenthFrameScore extends FrameScore {

    private  Integer thirdBallScore;

    public Integer getThirdBallScore() {
        return thirdBallScore;
    }

    public void setThirdBallScore(Integer thirdBallScore) {
        this.thirdBallScore = thirdBallScore;
    }

    public boolean hasDoubleStrike() {
        return getFirstBallScore() == 10 && getSecondBallScore() == 10;
    }

     public boolean hasSpare() {
        return ((getFirstBallScore() + getSecondBallScore() == 10) && !isFirstBallAStrike());
    }

     public boolean isFirstBallAStrike() {
        return getFirstBallScore() == 10 ;
    }


    public Integer addScores() {

        Integer totalScore = getFirstBallScore();
        if (getSecondBallScore() != null) {
            totalScore = totalScore + getSecondBallScore();
        }
        if (thirdBallScore != null) {
            totalScore = totalScore + thirdBallScore;
        }
        return totalScore;
    }

    public boolean hasSecondBallStrike() {
        return getSecondBallScore()!=null && getSecondBallScore()==10;
    }
}
