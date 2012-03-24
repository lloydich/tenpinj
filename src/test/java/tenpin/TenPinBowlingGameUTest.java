package tenpin;

import org.junit.Assert;
import org.junit.Test;
import tenpin.game.Game;

public class TenPinBowlingGameUTest {
    private static final int PLAYER_1 = 0;
    private static final int PLAYER_2 = 1;
    private static final String PLAYER_1_NAME = "Roy Munson";


    @Test
    public void testCheckNameIsUnique() {
        Game game = new Game();
        game.addPlayer(1, "Roy Munson");
        Assert.assertFalse(game.checkNameIsUnique("Roy Munson"));
        Assert.assertTrue(game.checkNameIsUnique("Ernie McCracken"));
    }

    @Test
    public void testSubmitScore() {
        Game game = new Game();
        game.addPlayer(1, "Roy Munson");
        game.addPlayer(2, "Ernie McCracken");

        //frame 1
        game.submitScore(PLAYER_1, 5);
        Integer expectedScore = 0;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));
        game.submitScore(PLAYER_1, 5);
        expectedScore = 0;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 3);
        game.submitScore(PLAYER_2, 6);
        expectedScore = 9;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));


        //frame 2
        game.submitScore(PLAYER_1, 5);
        game.submitScore(PLAYER_1, 4);
        expectedScore = 24;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 5);
        game.submitScore(PLAYER_2, 2);
        expectedScore = 16;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));

        //frame 3
        game.submitScore(PLAYER_1, 5);
        game.submitScore(PLAYER_1, 3);
        expectedScore = 32;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 10);
        expectedScore = 16;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));

        //frame 4
        game.submitScore(PLAYER_1, 5);
        game.submitScore(PLAYER_1, 3);
        expectedScore = 40;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 5);
        game.submitScore(PLAYER_2, 1);
        expectedScore = 38;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));

        //frame 5
        game.submitScore(PLAYER_1, 0);
        game.submitScore(PLAYER_1, 0);
        expectedScore = 40;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 5);
        game.submitScore(PLAYER_2, 1);
        expectedScore = 44;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));

        //frame 6
        game.submitScore(PLAYER_1, 4);
        game.submitScore(PLAYER_1, 3);
        expectedScore = 47;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 1);
        game.submitScore(PLAYER_2, 3);
        expectedScore = 48;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));

        //frame 7
        game.submitScore(PLAYER_1, 4);
        game.submitScore(PLAYER_1, 4);
        expectedScore = 55;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 3);
        game.submitScore(PLAYER_2, 3);
        expectedScore = 54;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));


        //frame 8
        game.submitScore(PLAYER_1, 0);
        game.submitScore(PLAYER_1, 2);
        expectedScore = 57;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 1);
        game.submitScore(PLAYER_2, 9);
        expectedScore = 54;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));


        //frame 9
        game.submitScore(PLAYER_1, 6);
        game.submitScore(PLAYER_1, 2);
        expectedScore = 65;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 1);
        game.submitScore(PLAYER_2, 6);
        expectedScore = 72;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));


        //frame 10
        game.submitScore(PLAYER_1, 6);
        game.submitScore(PLAYER_1, 2);
        expectedScore = 73;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_1));


        game.submitScore(PLAYER_2, 9);
        game.submitScore(PLAYER_2, 1);
        game.submitScore(PLAYER_2, 3);
        expectedScore = 85;
        Assert.assertEquals(expectedScore, game.findScore(PLAYER_2));

    }
}
