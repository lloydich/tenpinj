package tenpin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tenpin.game.Game;
import tenpin.game.GameValidator;
import tenpin.frame.FrameScoreException;

import java.io.Console;
import java.util.List;

public class GameConsole {
    private final static Logger logger = LoggerFactory.getLogger(GameConsole.class);
    private static final String LINE_BREAK = "\n";
    private final Game game;
    private Console console;
    private GameValidator validator;
    private static final String NO_OF_PLAYERS_VALIDATION_ERROR = "Error: your entry for Number Of Players wasn't a number greater than 0. Please try again." + LINE_BREAK;
    private static final String BALL_SCORE_VALIDATION_ERROR = "Error: your entry for Ball Score wasn't a number between 1 and 10. Please try again." + LINE_BREAK;
    private static final String NAME_UNIQUE_VALIDATION_ERROR = "Error: your name has already been chosen. Please choose another." + LINE_BREAK;
    private static final String NAME_INVALID_ERROR = "Error: your name has is invalid. Please choose another which has letters and/or numbers." + LINE_BREAK;


    public GameConsole() {
        game = new Game();
        console = System.console();
        validator = new GameValidator();
    }

    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();
        gameConsole.play();
    }


    public void play() {
        Integer numberOfPlayers = getNumberOfPlayers();
        setupPlayers(numberOfPlayers);
        playFrames(numberOfPlayers);
        printWinners();
        printScores();
        printTeamScore();

    }

    private void printScores() {
        console.printf(game.getScoreBoard());
    }

    private void printTeamScore() {
        logger.debug("printTeamScore");
        Integer teamScore = game.getTeamScore();
        console.printf("Team Score is: %s %n", teamScore);
    }

    private void setupPlayers(Integer numberOfPlayers) {
        for (int playerId = 1; playerId <= numberOfPlayers; playerId++) {

            boolean isNameUnique = false;
            boolean isInvalidName = false;
            String errorMessage = "";
            String name = null;
            while (!isInvalidName || !isNameUnique) {
                name = console.readLine("%s", errorMessage + "Name for player " + playerId + "?");
                isInvalidName = validator.validateName(name);
                isNameUnique = game.checkNameIsUnique(name);
                errorMessage = determineErrorMessage(isInvalidName,isNameUnique);
            }
            game.addPlayer(playerId, name);
        }
    }

    private String determineErrorMessage(boolean invalidName, boolean isNameUnique) {
        if(!invalidName){
            return  NAME_INVALID_ERROR;
        }
        else if(!isNameUnique){
            return  NAME_UNIQUE_VALIDATION_ERROR;
        }
        return "";

    }

    private void playFrames(Integer numberOfPlayers) {
        for (int frameNumber = 1; frameNumber <= 10; frameNumber++) {
            console.printf("Frame: %s %n", frameNumber);
            logger.debug("frame: {}", frameNumber);
            playFrame(numberOfPlayers);
        }
    }

    private void playFrame(Integer numberOfPlayers) {
        for (int playerId = 0; playerId < numberOfPlayers; playerId++) {
            String playerName = game.getPlayerName(playerId);
            logger.debug("playerId: {}", playerId);
            console.printf("Player %s - %s's turn....", playerId+1,playerName);
            takeTurn(playerId, playerName);
            console.printf("%s %n %n", playerName + " has " + game.findScore(playerId) + " points");
        }
    }

    private void takeTurn(int playerId, String playerName) {
        logger.debug("takeTurn() playerId:{}", playerId);
        boolean playerFrameFinished = false;
        while (!playerFrameFinished) {
            Integer ballScore = getBallScore(playerName);
            logger.debug("ballScore:{}", ballScore);
            try {
                playerFrameFinished = game.submitScore(playerId, ballScore);
            } catch (FrameScoreException frameScoreException) {
                logger.error("frameScoreException:"+frameScoreException.getMessage());
                console.printf("%s",frameScoreException.getMessage());
            }
            logger.debug("player completed turn - playerId:{}", playerId);
        }
    }

    private void printWinners() {
        logger.debug("printWinners");
        List<String> winners = game.findWinner();
        if (winners.size() > 1) {
            console.printf("Joint winners are: %n");
            for (String winner : winners) {
                console.printf("%s %n", winner);
            }
        } else if (winners.size() == 1) {
            console.printf("The winner is: %n");
            console.printf("%s %n", winners.get(0));
        }
    }

    private Integer getNumberOfPlayers() {
        logger.debug("getNumberOfPlayers()");
        boolean validNumberOfPlayers = false;
        String errorMessage = "";
        String noPlayers = null;
        while (!validNumberOfPlayers) {
            noPlayers = console.readLine("%s", errorMessage + "Number of players? ");
            validNumberOfPlayers = validator.validateNumberOfPlayers(noPlayers);
            errorMessage = NO_OF_PLAYERS_VALIDATION_ERROR;
        }
        return Integer.valueOf(noPlayers);
    }

    private Integer getBallScore(String playerName) {
        logger.debug("getBallScore() playerName:{} errorMessage:{}", playerName);
        boolean validBallScore = false;
        String errorMessage = "";
        String ballScore = null;
        while (!validBallScore) {
            ballScore = console.readLine("%s", errorMessage + LINE_BREAK+"How many pins did " + playerName + " knock down:");
            validBallScore = validator.validateBallScore(ballScore);
            errorMessage = BALL_SCORE_VALIDATION_ERROR;
        }
        return Integer.valueOf(ballScore);
    }

}

