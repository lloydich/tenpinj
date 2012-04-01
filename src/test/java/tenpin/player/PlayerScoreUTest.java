package tenpin.player;

import org.junit.Assert;
import org.junit.Test;

public class PlayerScoreUTest {

    private Player testObject;

    @Test
    public void testAddScores() throws Exception {
        testObject = new Player(1, "Ernie McCracken");

        //frame 1
        testObject.addBowl(1);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());
        testObject.addBowl(0);
        expectedScore = 1;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 2
        testObject.addBowl(1);
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());
        testObject.addBowl(5);
        expectedScore = 7;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 3
        testObject.addBowl(5);
        testObject.addBowl(5);
        expectedScore = 7;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 4
        testObject.addBowl(4);
        testObject.addBowl(5);
        expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 5
        testObject.addBowl(10);
        expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 6
        testObject.addBowl(4);
        testObject.addBowl(6);
        expectedScore = 50;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());


        //frame 7
        testObject.addBowl(10);
        expectedScore = 70;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 8
        testObject.addBowl(3);
        testObject.addBowl(5);
        expectedScore = 96;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 9
        testObject.addBowl(10);
        expectedScore = 96;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 10
        testObject.addBowl(3);
        testObject.addBowl(4);
        expectedScore = 120;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());
    }

    @Test
    public void testAddScoreWithExtraBowlInTenthFrame() throws Exception {
        testObject = new Player(1, "Ernie McCracken");

        //frame 1
        testObject.addBowl(1);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());
        testObject.addBowl(0);
        expectedScore = 1;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 2
        testObject.addBowl(1);
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());
        testObject.addBowl(5);
        expectedScore = 7;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 3
        testObject.addBowl(5);
        testObject.addBowl(5);
        expectedScore = 7;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 4
        testObject.addBowl(4);
        testObject.addBowl(5);
        expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 5
        testObject.addBowl(10);
        expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 6
        testObject.addBowl(4);
        testObject.addBowl(6);
        expectedScore = 50;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());


        //frame 7
        testObject.addBowl(10);
        expectedScore = 70;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 8
        testObject.addBowl(3);
        testObject.addBowl(5);
        expectedScore = 96;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 9
        testObject.addBowl(5);
        testObject.addBowl(4);
        expectedScore = 105;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 10
        testObject.addBowl(6);
        testObject.addBowl(4);
        testObject.addBowl(6);
        expectedScore = 121;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

    }

    @Test
    public void testAddScoreMaxScore() throws Exception {
        testObject = new Player(1, "Ishmael");

        //frame 1
        testObject.addBowl(10);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 2
        testObject.addBowl(10);
        expectedScore = 0;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 3
        testObject.addBowl(10);
        expectedScore = 30;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 4
        testObject.addBowl(10);
        expectedScore = 60;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 5
        testObject.addBowl(10);
        expectedScore = 90;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 6
        testObject.addBowl(10);
        expectedScore = 120;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());


        //frame 7
        testObject.addBowl(10);
        expectedScore = 150;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 8
        testObject.addBowl(10);
        expectedScore = 180;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 9
        testObject.addBowl(10);
        expectedScore = 210;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

        //frame 10
        testObject.addBowl(10);
        testObject.addBowl(10);
        testObject.addBowl(10);
        expectedScore = 300;
        Assert.assertEquals(expectedScore, testObject.getTotalPoints());

    }
}
