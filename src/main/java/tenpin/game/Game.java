package tenpin.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tenpin.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Logger logger = LoggerFactory.getLogger(Game.class);
    public GameScoresCalculator gameScoresCalculator = null;

    private List<Player> players = new ArrayList<Player>();

    public Game() {
    }

    public void addPlayer(Integer playerId, String playerName) {
        logger.debug("addPlayer() playerId:{} playerName:{}", playerId, playerName);
        Player player = new Player(playerId, playerName);
        players.add(player);
    }

    public String getPlayerName(Integer playerId) {
        Player player = players.get(playerId);
        return player.getName();
    }


    public boolean submitScore(Integer playerId, Integer score) {
        logger.debug("submitScore() score:{} playerId:{}", score, playerId);
        Player player = players.get(playerId);
        logger.debug("submitScore() player: {}", player);
        return player.addBowl(score);
    }


    public Integer findScore(Integer playerId) {
        logger.debug("findScore() playerId:  {}", playerId);
        if (players.size() >= (playerId)) {
            Player player = players.get(playerId);
            logger.debug("findScore() playerId:  {} score:{}", playerId, player.getTotalPoints());
            return player.getTotalPoints();
        }
        return null;
    }

    public List<String> findWinner() {
        logger.debug("findWinner()");
        gameScoresCalculator = new GameScoresCalculator(players);
        return gameScoresCalculator.determineWinner();
    }

    public Integer getTeamScore() {
        logger.debug("getTeamScore()");
        gameScoresCalculator = new GameScoresCalculator(players);
        return gameScoresCalculator.determineTeamScore();
    }

    public boolean checkNameIsUnique(String name) {
        for (Player player : players) {
                if (player.getName().equalsIgnoreCase(name)) {
                    return false;
                }
        }
        return true;
    }

    public String getScoreBoard() {
        String playerScoreBoards="";
        for (Player player : players) {
            playerScoreBoards += new ScoreBoard().getScoreBoard(player);
        }
         return playerScoreBoards;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
