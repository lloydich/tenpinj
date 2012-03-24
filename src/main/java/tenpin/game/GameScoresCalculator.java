package tenpin.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tenpin.playerscore.Player;

import java.util.ArrayList;
import java.util.List;

public class GameScoresCalculator {
    private final Logger logger = LoggerFactory.getLogger(GameScoresCalculator.class);
    private List<Player> players;

    public GameScoresCalculator(List<Player> players) {
        this.players = players;
    }

    public List<String> determineWinner() {
        Integer highestPlacedScore = findHighestScore();
        return findPlayersWithHighestScore(highestPlacedScore);
    }

    private List<String> findPlayersWithHighestScore(Integer highestPlacedScore) {
        List<String> winningPlayers = new ArrayList<String>();
        for (Player player : players) {
                logger.debug("findWinner() playerId: {} Total: {} ", player.getName(), player.getTotalPoints());
                if (player.getTotalPoints().equals(highestPlacedScore)) {
                    winningPlayers.add("Player " + player.getId() + ": " + player.getName());
                }

        }
        return winningPlayers;
    }

    private Integer findHighestScore() {
        Integer highestPlacedScore = -1;
        for (Player player : players) {
            logger.debug("findWinner() playerId: {} Total: {} ", player.getName(), player.getTotalPoints());
            if (player.getTotalPoints() >= highestPlacedScore) {
                highestPlacedScore = player.getTotalPoints();
            }
        }
        return highestPlacedScore;
    }

    public Integer determineTeamScore() {
        Integer teamScore = 0;
        for (Player player : players) {
            teamScore = teamScore + player.getTotalPoints();
        }
        return teamScore;
    }
}
