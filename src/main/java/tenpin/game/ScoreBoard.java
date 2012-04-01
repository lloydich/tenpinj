package tenpin.game;

import tenpin.frame.FrameScore;
import tenpin.player.Player;

public class ScoreBoard {
    private  Integer gameScore= 0;
    
    public String getScoreBoard(Player player) {
            String scoreBoard = "";
                scoreBoard += ("\nPLAYER " + player.getName());
                scoreBoard += ("\n___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________");
                scoreBoard += ("\n|    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    |");
                scoreBoard += ("\n| " + getBallScore(player, 0, 1) + " | " +  getBallScore(player, 0, 2) + " | | " +  getBallScore(player, 1, 1) + " | " +  getBallScore(player, 1, 2) + " | | " +  getBallScore(player, 2, 1) + " | " +  getBallScore(player, 2, 2) + " | | " +  getBallScore(player, 3, 1) + " | " +  getBallScore(player, 3, 2) + " | | " +  getBallScore(player, 4, 1) + " | " +  getBallScore(player, 4, 2) + " | | " +  getBallScore(player, 5, 1) + " | " +  getBallScore(player, 5, 2) + " | | " +  getBallScore(player, 6, 1) + " | " +  getBallScore(player, 6, 2) + " | | " +  getBallScore(player, 7, 1) + " | " +  getBallScore(player, 7, 2) + " | | " +  getBallScore(player, 8, 1) + " | " +  getBallScore(player, 8, 2) + " | | " +  getBallScore(player, 9, 1) + " | " +   getBallScore(player, 9, 2) + " |");
                scoreBoard += ("\n|    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____|");
                scoreBoard += ("\n|         | |         | |         | |         | |         | |         | |         | |         | |         | |         |");
                scoreBoard += ("\n|   " + getGameScore(0, player) + "   | |   " + getGameScore(1, player) + "   | |   " + getGameScore(2, player) + "   | |   " + getGameScore(3, player) + "   | |   " + getGameScore(4, player) + "   | |   " + getGameScore(5, player) + "   | |   " + getGameScore(6, player) + "   | |   " + getGameScore(7, player) + "   | |   " + getGameScore(8, player) + "   | |   " + getGameScore(9, player) + "   |");
                scoreBoard += ("\n|_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________|\n\n");
            return scoreBoard;
        }

    private String getBallScore(Player player, Integer frameNumber, Integer ballNumber) {
        Integer ballscore = null;
        FrameScore frameScore = player.getFrameScore(frameNumber);
        if (ballNumber == 1) {
            ballscore = frameScore.getFirstBallScore();
        } else if (ballNumber == 2) {
            ballscore = player.getFrameScore(frameNumber).getSecondBallScore();
        }

        return formatBallScore(ballNumber, ballscore, frameScore);
    }



    private String formatBallScore(Integer ballNumber, Integer ballscore, FrameScore frameScore) {
        String score = "";
        if (ballNumber == 1) {
            score = createScoreString(ballscore, score);
        } else if (ballNumber == 2) {
            if (frameScore.isAStrike()) {
                score += "X";
            } else if (frameScore.isASpare()) {
                score += "/";
            } else score = createScoreString(ballscore, score);
        }
        score=String.format("%2s", score);
        return score;
    }

    private String createScoreString(Integer ballscore, String score) {
        if (ballscore == null) {
            score += "-";
        }
        else {
            score += ballscore.toString();
        }
        return score;
    }


    private String getGameScore(int frameNumber, Player player) {
        String score = "";
        Integer totalScore = null;
        FrameScore frameScore = player.getFrameScore(frameNumber);
        if (frameScore != null) {
            totalScore = frameScore.getTotalScore();
        }

        if (totalScore != null) {
            gameScore+=totalScore;
            score = gameScore.toString();
        } else {
            score = "-";
        }
        score=String.format("%3s", score);
        return score;
    }

}
