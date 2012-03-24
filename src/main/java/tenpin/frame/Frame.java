package tenpin.frame;

public class Frame {
    private final Integer frameNo;
    private final FrameScore frameScore = new FrameScore();

    public Frame(Integer frameNo) {
        this.frameNo = frameNo;
    }

    public boolean isFrameScoreComplete() {
        return frameScore.getTotalScore() != null;
    }

    public Integer getFrameNo() {
        return frameNo;
    }

    public void submitBallScore(int ballScore) {
        if (frameNo < 10) {
            updateScore(ballScore);
        } else {
            throw new IllegalArgumentException("frame number > 9 - frameNo:" + frameNo);
        }
    }

    public boolean isFrameInPlay() {
        return !frameScore.isAStrike() && frameScore.getSecondBallScore() == null;
    }


    public FrameScore getFrameScore() {
        return this.frameScore;
    }

    public boolean isFrameFinished() {
        return !isFrameInPlay();
    }

    private void updateScore(int ballScore) {
        if (frameScore.getTotalScore() == null && frameScore.getFirstBallScore() == null) {
            frameScore.setFirstBallScore(ballScore);


        } else if (!isFrameScoreComplete() && frameScore.getSecondBallScore() == null) {
            Integer totalScore = frameScore.getFirstBallScore() + ballScore;
            validateTotalScoreForTwoPins(totalScore);
            frameScore.setSecondBallScore(ballScore);

            if (totalScore < 10) {
                frameScore.setTotalScore(totalScore);
            }

        } else {
            throw new IllegalArgumentException("submitBallScore when frame finished");
        }
    }

    private void validateTotalScoreForTwoPins(int totalScore) {
        if (totalScore > 10) {
            throw new FrameScoreException("Total score greater than maximum possible i.e. 10 - totalScore:" + totalScore);
        }
    }

    @Override
    public String toString() {
        return "Frame{" +
                "frameNo=" + frameNo +
                ", frameScore=" + frameScore +
                ", isFrameInPlay=" + isFrameInPlay() +
                '}';
    }
}
