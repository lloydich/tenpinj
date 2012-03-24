package tenpin.game;

public class GameValidator {

    public boolean validateNumberOfPlayers(String noPlayers) {
        return noPlayers != null && noPlayers.matches("^[1-9]+[0-9]*$");
    }

    public boolean validateBallScore(String ballScore) {
        return (ballScore != null && ballScore.matches("^[0-9]|10"));
    }

    public boolean validateName(String name) {
        if (name != null) {
            name = name.trim();
            return name.matches("^[a-zA-Z0-9 ]+$");
        }
        return false;
    }
}
