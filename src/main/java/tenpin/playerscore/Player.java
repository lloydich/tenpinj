package tenpin.playerscore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tenpin.game.GameValidator;
import tenpin.frame.Frame;
import tenpin.frame.FrameFactory;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Integer id;
    private List<Frame> frames = new ArrayList<Frame>(10);
    private PlayerScoreCalculator playerScoreCalculator;
    private FrameFactory frameFactory = new FrameFactory();
    private GameValidator validator = new GameValidator();
    private static final int CURRENT_FRAME_OFFSET = 1;
    private final Logger logger = LoggerFactory.getLogger(Player.class);
    private String name;

    public Player(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean addBowl(Integer score) {
        logger.debug("addBowl() score:{} id:{}",score, id);
        validateScore(score);
        Integer existingFrameNumber = frames.size();

            Frame currentFrame = null;
            Integer newFrameNumber = existingFrameNumber + 1;


            if (newFrameNumber == 1) {
                currentFrame = frameFactory.createFrame(newFrameNumber);
                currentFrame.submitBallScore(score);
                frames.add(currentFrame);

            } else {
                currentFrame = frames.get(existingFrameNumber - CURRENT_FRAME_OFFSET);
                if (currentFrame.isFrameInPlay()) {
                    currentFrame.submitBallScore(score);
                    updatePreviousFrameScores(currentFrame);
                
                } else {
                    currentFrame = frameFactory.createFrame(newFrameNumber);
                    currentFrame.submitBallScore(score);
                    frames.add(currentFrame);
                    updatePreviousFrameScores(currentFrame);

                }

            }
         logger.debug("addBowl() currentFrame.isFrameFinished():{} id:{}",currentFrame.isFrameFinished(), id);
        return currentFrame.isFrameFinished();
    }

    private void validateScore(Integer score) {
        if (score==null || !validator.validateBallScore(score.toString())){
              throw new PlayerScoreException("player score invalid - score:" + score);
        }
    }


    private void updatePreviousFrameScores(Frame currentFrame) {
        if (currentFrame.isFrameFinished()) {
            playerScoreCalculator = new PlayerScoreCalculator(frames);
            playerScoreCalculator.updatePreviousFrameScores(currentFrame);
        }
    }

    public Integer getTotalPoints() {
        playerScoreCalculator = new PlayerScoreCalculator(frames);
        return playerScoreCalculator.getCurrentScore();
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", frames=" + frames +
                '}';
    }
}
