package tenpin.player;

import junit.framework.Assert;
import org.junit.Test;
import tenpin.frame.Frame;
import tenpin.frame.TenthFrame;

import java.util.ArrayList;
import java.util.List;

public class PlayerScoreCalculatorUTest {

    private PlayerScoreCalculator testObject;

    @Test
    public void testUpdateScoreNoStrikesorSpares() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);
        testObject = new PlayerScoreCalculator(frames);

        Frame currentFrame = createNewFrame(1, 3, 1);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 4;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(2, 0, 3);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 7;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(3, 1, 8);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 16;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(4, 1, 8);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 25;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(5, 1, 5);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 31;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(6, 1, 5);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 37;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(7, 1, 5);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 43;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(8, 1, 5);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 49;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(9, 1, 5);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 55;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(10, 1, 5, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 61;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }


    @Test
    public void testUpdateScoreWithSpare() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);

        testObject = new PlayerScoreCalculator(frames);
        Frame currentFrame = createNewFrame(1, 3, 1);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 4;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        testObject = new PlayerScoreCalculator(frames);
        currentFrame = createNewFrame(2, 5, 5);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 4;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        testObject = new PlayerScoreCalculator(frames);
        currentFrame = createNewFrame(3, 2, 0);
        frames.add(currentFrame);
        expectedScore = 18;
        testObject.updatePreviousFrameScores(currentFrame);
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    @Test
    public void testUpdateScoreWithStrike() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);

        testObject = new PlayerScoreCalculator(frames);
        Frame currentFrame = createNewFrame(1, 3, 1);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 4;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(2, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 4;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(3, 2, 7);
        frames.add(currentFrame);
        expectedScore = 32;
        testObject.updatePreviousFrameScores(currentFrame);
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    @Test
    public void testUpdateScoreWithSpareStrike() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);
        testObject = new PlayerScoreCalculator(frames);

        Frame currentFrame = createNewFrame(1, 4, 6);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(2, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 20;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(3, 2, 7);
        frames.add(currentFrame);
        expectedScore = 48;
        testObject.updatePreviousFrameScores(currentFrame);
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    @Test
    public void testUpdateScoreWithStrikeSpare() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);
        testObject = new PlayerScoreCalculator(frames);

        Frame currentFrame = createNewFrame(1, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(2, 2, 8);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 20;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(3, 2, 7);
        frames.add(currentFrame);
        expectedScore = 41;
        testObject.updatePreviousFrameScores(currentFrame);
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    @Test
    public void testUpdateScoreWithTwoStrikes() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);
        testObject = new PlayerScoreCalculator(frames);

        Frame currentFrame = createNewFrame(1, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(2, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(3, 2, 7);
        frames.add(currentFrame);
        expectedScore = 50;
        testObject.updatePreviousFrameScores(currentFrame);
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    @Test
    public void testUpdateScoreWithThreeStrikes() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);
        testObject = new PlayerScoreCalculator(frames);

        Frame currentFrame = createNewFrame(1, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(2, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(3, 10, null);
        frames.add(currentFrame);
        expectedScore = 30;
        testObject.updatePreviousFrameScores(currentFrame);
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());

        currentFrame = createNewFrame(4, 3, 6);
        frames.add(currentFrame);
        expectedScore = 81;
        testObject.updatePreviousFrameScores(currentFrame);
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    @Test
    public void testUpdateScoreWithThreeSpares() throws Exception {
        List<Frame> frames = new ArrayList<Frame>(10);
        testObject = new PlayerScoreCalculator(frames);

        Frame currentFrame = createNewFrame(1, 3, 7);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(2, 5, 5);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 15;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());


        currentFrame = createNewFrame(3, 6, 4);
        frames.add(currentFrame);

        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 31;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());

        currentFrame = createNewFrame(4, 3, 6);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 53;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    @Test
    public void testTenthFrame() {

        List<Frame> frames = new ArrayList<Frame>(10);
        testObject = new PlayerScoreCalculator(frames);

        Integer numberOfFrames = 6;
        Integer firstBowl = 2;
        Integer secondBowl = 3;

        createPreviouslyBowledFrames(frames, numberOfFrames, firstBowl, secondBowl);
        Integer expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());

        Frame currentFrame = createNewFrame(7, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());

        currentFrame = createNewFrame(8, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());

        currentFrame = createNewFrame(9, 10, null);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 60;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());

        currentFrame = createNewFrame(10, 10, 10, 10);
        frames.add(currentFrame);
        testObject.updatePreviousFrameScores(currentFrame);
        expectedScore = 150;
        Assert.assertEquals(expectedScore, testObject.getCurrentScore());
    }

    private void createPreviouslyBowledFrames(List<Frame> frames, Integer numberOfFrames, Integer firstBowl, Integer secondBowl) {

        for (int i = 1; i <= numberOfFrames; i++) {
            Frame currentFrame = createNewFrame(i, firstBowl, secondBowl);
            frames.add(currentFrame);
            testObject.updatePreviousFrameScores(currentFrame);
        }
    }

    private Frame createNewFrame(Integer frameNumber, Integer firstBall, Integer secondBall) {
        Frame currentFrame = new Frame(frameNumber);
        currentFrame.submitBallScore(firstBall);
        if (secondBall != null) {
            currentFrame.submitBallScore(secondBall);
        }
        return currentFrame;
    }

    private Frame createNewFrame(Integer frameNumber, Integer firstBall, Integer secondBall, Integer thirdBall) {
        if (frameNumber != 10) {
            throw new IllegalArgumentException("wrong frame number");
        }

        Frame currentFrame = new TenthFrame();
        currentFrame.submitBallScore(firstBall);
        currentFrame.submitBallScore(secondBall);
        if (thirdBall != null) {
            currentFrame.submitBallScore(thirdBall);
        }
        return currentFrame;
    }
}
