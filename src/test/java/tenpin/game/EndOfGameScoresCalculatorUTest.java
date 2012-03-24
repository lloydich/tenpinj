package tenpin.game;

import org.junit.Assert;
import org.junit.Test;
import tenpin.playerscore.Player;

import java.util.ArrayList;
import java.util.List;

public class EndOfGameScoresCalculatorUTest {
    private static final int PLAYER_1_ID = 1;
    private static final int PLAYER_2_ID = 2;
    private static final int PLAYER_3_ID = 3;
    private static final String PLAYER_1_NAME = "Roy Munson";
    private static final String PLAYER_2_NAME = "Ernie McCracken";
    private static final String PLAYER_3_NAME = "Ishmael";
    private GameScoresCalculator testObject;

    @Test
    public void testDetermineOneWinner() {
        List<Player> players = setUpPlayersForFinishedGameWherePlayer2IsWinner();
        testObject = new GameScoresCalculator(players);

        String expectedWinner = "Player " + PLAYER_2_ID + ": " + PLAYER_2_NAME;
        Assert.assertEquals(expectedWinner, testObject.determineWinner().get(0));

    }

    @Test
    public void testDetermineTwoWinners() {
        List<Player> players = setUpPlayersForFinishedGameWherePlayer1Player3JointFirst();
        testObject = new GameScoresCalculator(players);

        List<String> expectedWinners = new ArrayList<String>();
        String expectedWinner1 = "Player " + PLAYER_1_ID + ": " + PLAYER_1_NAME;
        String expectedWinner2 = "Player " + PLAYER_3_ID + ": " + PLAYER_3_NAME;
        expectedWinners.add(expectedWinner1);
        expectedWinners.add(expectedWinner2);


        Assert.assertEquals(expectedWinners, testObject.determineWinner());

    }

    @Test
    public void determineTeamScore() {
        List<Player> players = setUpPlayersForFinishedGame();
        testObject = new GameScoresCalculator(players);
        Integer expectedScore =120;
        Assert.assertEquals(expectedScore, testObject.determineTeamScore());

    }

    private List<Player> setUpPlayersForFinishedGameWherePlayer2IsWinner() {
        List<Player> players = new ArrayList<Player>();
        Player player1 = new Player(PLAYER_1_ID, PLAYER_1_NAME);
        addScores(player1, 1);
        Player player2 = new Player(PLAYER_2_ID, PLAYER_2_NAME);
        addScores(player2, 4);
        Player player3 = new Player(PLAYER_3_ID, PLAYER_3_NAME);
        addScores(player3, 3);

        players.add(player1);
        players.add(player2);
        players.add(player3);
        return players;

    }

    private List<Player> setUpPlayersForFinishedGameWherePlayer1Player3JointFirst() {
        List<Player> players = new ArrayList<Player>();
        Player player1 = new Player(PLAYER_1_ID, PLAYER_1_NAME);
        addScores(player1, 4);
        Player player2 = new Player(PLAYER_2_ID, PLAYER_2_NAME);
        addScores(player2, 1);
        Player player3 = new Player(PLAYER_3_ID, PLAYER_3_NAME);
        addScores(player3, 4);

        players.add(player1);
        players.add(player2);
        players.add(player3);
        return players;
    }

    private List<Player> setUpPlayersForFinishedGame() {

        List<Player> players = new ArrayList<Player>();
        Player player1 = new Player(PLAYER_1_ID, PLAYER_1_NAME);
        addScores(player1, 1);
        Player player2 = new Player(PLAYER_2_ID, PLAYER_2_NAME);
        addScores(player2, 2);
        Player player3 = new Player(PLAYER_3_ID, PLAYER_3_NAME);
        addScores(player3, 3);

        players.add(player1);
        players.add(player2);
        players.add(player3);
        return players;
    }

    private void addScores(Player player, int ballScore) {
        if (ballScore <= 4) {
            for (int i = 1; i <= 20; i++) {
                player.addBowl(ballScore);
            }
        }
    }
}
