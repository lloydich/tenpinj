package tenpin.playerscore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tenpin.frame.Frame;

import java.util.List;

public class PlayerScoreCalculator {

    private final Logger logger = LoggerFactory.getLogger(PlayerScoreCalculator.class);
    private List<Frame> frames;
    private static final int PREVIOUS_FRAME_OFFSET = 2;

    public PlayerScoreCalculator(List<Frame> frames) {
        this.frames = frames;
    }

    public void updatePreviousFrameScores(Frame currentFrame) {
        Frame previousFrame = getPreviousFrame(currentFrame);
        calculateForPreviousFrames(getPreviousFrame(previousFrame), previousFrame, currentFrame);
    }

    private Frame getPreviousFrame(Frame currentFrame) {
        Frame previousFrame = null;
        if (currentFrame != null && currentFrame.getFrameNo() > 1) {
            previousFrame = frames.get(currentFrame.getFrameNo() - PREVIOUS_FRAME_OFFSET);
        }
        return previousFrame;
    }

    public Integer getCurrentScore() {
        Integer currentScore = 0;
        for (Frame frame : frames) {
            logger.debug("getCurrentScore() frame number:{} frame score:{} ", frame.getFrameNo(), frame.getFrameScore());
            if (frame.getFrameScore().getTotalScore() != null) {
                currentScore = currentScore + frame.getFrameScore().getTotalScore();
                logger.debug("getCurrentScore() {} ", currentScore);
            }
        }
        logger.debug("getCurrentScore() total:{}", currentScore);
        return currentScore;
    }

    private void calculateForPreviousFrames(Frame previousPreviousFrame, Frame previousFrame, Frame currentFrame) {
        if (previousPreviousFrame != null && !previousPreviousFrame.isFrameScoreComplete()) {
            calculatePreviousPreviousFrameScore(previousPreviousFrame, previousFrame, currentFrame);
        }

        if (currentFrame.getFrameNo() != 10) {
            if (previousFrame != null && !previousFrame.isFrameScoreComplete()) {
                calculatePreviousFrameScore(previousFrame, currentFrame);
            }
        } else {
            calculatePreviousFrameScoreWhenCurrentFrameIsTenth(previousFrame, currentFrame);
        }


    }

    private void calculatePreviousPreviousFrameScore(Frame previousPreviousFrame, Frame previousFrame, Frame currentFrame) {
        if (previousPreviousFrame.getFrameScore().isAStrike() && previousFrame.getFrameScore().isAStrike()) {
            Integer totalScore = previousPreviousFrame.getFrameScore().addScores() + previousFrame.getFrameScore().addScores() + currentFrame.getFrameScore().getFirstBallScore();
            previousPreviousFrame.getFrameScore().setTotalScore(totalScore);
        }
    }

    private void calculatePreviousFrameScore(Frame previousFrame, Frame currentFrame) {
        if (previousFrame.getFrameScore().isAStrike() && !currentFrame.getFrameScore().isAStrike()) {
            Integer totalScore = previousFrame.getFrameScore().addScores() + currentFrame.getFrameScore().addScores();
            previousFrame.getFrameScore().setTotalScore(totalScore);
        } else if (previousFrame.getFrameScore().isASpare()) {
            Integer totalScore = previousFrame.getFrameScore().addScores() + currentFrame.getFrameScore().getFirstBallScore();
            previousFrame.getFrameScore().setTotalScore(totalScore);
        }
    }

    private void calculatePreviousFrameScoreWhenCurrentFrameIsTenth(Frame previousFrame, Frame currentFrame) {
        if (previousFrame.getFrameScore().isAStrike()) {
            Integer totalScore = previousFrame.getFrameScore().addScores() + currentFrame.getFrameScore().getFirstBallScore() + currentFrame.getFrameScore().getSecondBallScore();
            previousFrame.getFrameScore().setTotalScore(totalScore);
        } else if (previousFrame.getFrameScore().isASpare()) {
            Integer totalScore = previousFrame.getFrameScore().addScores() + currentFrame.getFrameScore().getFirstBallScore();
            previousFrame.getFrameScore().setTotalScore(totalScore);
        }
    }
}
