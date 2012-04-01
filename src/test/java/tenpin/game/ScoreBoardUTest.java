package tenpin.game;

import org.junit.Before;
import org.junit.Test;
import tenpin.player.Player;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreBoardUTest {

    private static final int PLAYER_1 = 0;
    private static final int PLAYER_2 = 1;
    private static final int PLAYER_3 = 2;
    private static final String PLAYER_1_NAME = "Roy Munson";
    private static final String PLAYER_2_NAME = "Ernie McCracken";
    private static final String PLAYER_3_NAME = "Ishmael";
    private ScoreBoard testObject;

    private String expectedScoreBoard_player1 = "\n" +
            "PLAYER Roy Munson\n" +
            "___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________\n" +
            "|    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    |\n" +
            "|  1 |  1 | |  1 |  1 | |  1 |  1 | |  1 |  1 | |  1 |  1 | |  1 |  1 | |  1 |  1 | |  1 |  1 | |  1 |  1 | |  1 |  1 |\n" +
            "|    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____|\n" +
            "|         | |         | |         | |         | |         | |         | |         | |         | |         | |         |\n" +
            "|     2   | |     4   | |     6   | |     8   | |    10   | |    12   | |    14   | |    16   | |    18   | |    20   |\n" +
            "|_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________|\n" +
            "\n";

    private String expectedScoreBoard_player2 = "\n" +
            "PLAYER Ernie McCracken\n" +
            "___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________\n" +
            "|    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    |\n" +
            "|  1 |  3 | |  5 |  / | | 10 |  X | |  5 |  4 | |  2 |  1 | |  6 |  / | | 10 |  X | |  2 |  4 | |  5 |  1 | |  8 |  1 |\n" +
            "|    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____|\n" +
            "|         | |         | |         | |         | |         | |         | |         | |         | |         | |         |\n" +
            "|     4   | |    24   | |    43   | |    52   | |    55   | |    75   | |    91   | |    97   | |   103   | |   112   |\n" +
            "|_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________|\n" +
            "\n";

    private String expectedScoreBoard_player3 = "\n" +
            "PLAYER Ishmael\n" +
            "___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________\n" +
            "|    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    |\n" +
            "| 10 |  X | | 10 |  X | | 10 |  X | | 10 |  X | | 10 |  X | | 10 |  X | | 10 |  X | | 10 |  X | | 10 |  X | | 10 |  X |\n" +
            "|    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____|\n" +
            "|         | |         | |         | |         | |         | |         | |         | |         | |         | |         |\n" +
            "|    30   | |    60   | |    90   | |   120   | |   150   | |   180   | |   210   | |   240   | |   270   | |   300   |\n" +
            "|_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________|\n" +
            "\n";

    @Before
    public void setUp() throws Exception {
        testObject = new ScoreBoard();
    }

    @Test
    public void testGetScoreBoardsSameLowScores() throws Exception {
        Player player1 = new Player(PLAYER_1, PLAYER_1_NAME);
        addScores(player1, 1);

        assertEquals(expectedScoreBoard_player1, testObject.getScoreBoard(player1));
    }

    @Test
    public void testGetScoreBoardsMixedScores() throws Exception {
        Player player2 = new Player(PLAYER_2, PLAYER_2_NAME);
        addScores(player2, Arrays.asList(1, 3, 5, 5, 10, 5, 4, 2, 1, 6, 4, 10, 2, 4, 5, 1, 8, 1));

        assertEquals(expectedScoreBoard_player2, testObject.getScoreBoard(player2));
    }

    @Test
    public void testGetScoreBoardsHighestScore() throws Exception {
        Player player3 = new Player(PLAYER_3, PLAYER_3_NAME);
        addScores(player3, Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));

        assertEquals(expectedScoreBoard_player3, testObject.getScoreBoard(player3));
    }


    private void addScores(Player player, List<Integer> scores) {
        for (Integer score : scores) {
            player.addBowl(score);
        }
    }

    private void addScores(Player player, int ballScore) {
        for (int i = 1; i <= 20; i++) {
            player.addBowl(ballScore);
        }
    }
}

