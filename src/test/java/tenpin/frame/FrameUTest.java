package tenpin.frame;

import junit.framework.Assert;
import org.junit.Test;

public class FrameUTest {
    @Test
    public void testSubmitCorrectBallScore() throws Exception {

        Frame frame = new Frame(1);
        frame.submitBallScore(0);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(0);
         Integer expectedFrameScore = 0;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());


         frame = new Frame(1);
        frame.submitBallScore(1);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          expectedFrameScore = 2;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());


        frame = new Frame(1);
        frame.submitBallScore(2);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          expectedFrameScore = 3;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());

        frame = new Frame(1);
        frame.submitBallScore(3);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
         expectedFrameScore = 4;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());

        frame = new Frame(1);
        frame.submitBallScore(4);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          expectedFrameScore = 5;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());

        frame = new Frame(1);
        frame.submitBallScore(5);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          expectedFrameScore = 6;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());

        frame = new Frame(1);
        frame.submitBallScore(6);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          expectedFrameScore = 7;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());

        frame = new Frame(1);
        frame.submitBallScore(7);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          expectedFrameScore = 8;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());

        frame = new Frame(1);
        frame.submitBallScore(8);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          expectedFrameScore = 9;
        Assert.assertEquals(expectedFrameScore, frame.getFrameScore().getTotalScore());

        frame = new Frame(1);
        frame.submitBallScore(9);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(1);
          Assert.assertTrue(frame.getFrameScore().isASpare());

        frame = new Frame(1);
        frame.submitBallScore(1);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(9);
        Assert.assertTrue(frame.getFrameScore().isASpare());

        frame = new Frame(1);
        frame.submitBallScore(5);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(5);
        Assert.assertTrue(frame.getFrameScore().isASpare());

        frame = new Frame(1);
        frame.submitBallScore(0);
        Assert.assertNull(frame.getFrameScore().getTotalScore());
        frame.submitBallScore(10);
        Assert.assertTrue(frame.getFrameScore().isASpare());

        frame = new Frame(1);
        frame.submitBallScore(10);
        Assert.assertTrue(frame.getFrameScore().isAStrike());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubmitIncorrectLowBallScore() throws Exception {

        Frame frame = new Frame(1);
        frame.submitBallScore(1);
        frame.submitBallScore(1);
        frame.submitBallScore(1);
    }
    
    @Test(expected = FrameScoreException.class)
    public void testSubmitIncorrectHighBallScore() throws Exception {
        Frame  frame = new Frame(1);
        frame.submitBallScore(5);
        frame.submitBallScore(7);
    }

    @Test
    public void isFrameInPlay() {
        Frame frame = new Frame(1);
        frame.submitBallScore(1);
        Assert.assertTrue(frame.isFrameInPlay());
        frame.submitBallScore(1);
        Assert.assertFalse(frame.isFrameInPlay());

        frame = new Frame(1);
        frame.submitBallScore(5);
        frame.submitBallScore(5);
        Assert.assertFalse(frame.isFrameInPlay());

        frame = new Frame(1);
        frame.submitBallScore(10);
        Assert.assertFalse(frame.isFrameInPlay());

        frame = new Frame(1);
        frame.submitBallScore(0);
        frame.submitBallScore(10);
        Assert.assertFalse(frame.isFrameInPlay());
    }

}
