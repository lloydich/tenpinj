package tenpin.game;

import tenpin.frame.FrameScore;
import tenpin.player.Player;

import java.util.List;

public class ScoreBoard {
    
    public String getScoreBoard(List<Player> players) {
            String scoreBoard = "";
            for (Player player : players) {
                scoreBoard += ("\nPLAYER " + player.getName());
                scoreBoard += ("\n___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________ ___________");
                scoreBoard += ("\n|    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    | |    |    |");
                scoreBoard += ("\n| " + getBallScore(player, 0, 1) + " | " +  getBallScore(player, 0, 2) + " | | " +  getBallScore(player, 1, 1) + " | " +  getBallScore(player, 1, 2) + " | | " +  getBallScore(player, 2, 1) + " | " +  getBallScore(player, 2, 2) + " | | " +  getBallScore(player, 3, 1) + " | " +  getBallScore(player, 3, 2) + " | | " +  getBallScore(player, 4, 1) + " | " +  getBallScore(player, 4, 2) + " | | " +  getBallScore(player, 5, 1) + " | " +  getBallScore(player, 5, 2) + " | | " +  getBallScore(player, 6, 1) + " | " +  getBallScore(player, 6, 2) + " | | " +  getBallScore(player, 7, 1) + " | " +  getBallScore(player, 7, 2) + " | | " +  getBallScore(player, 8, 1) + " | " +  getBallScore(player, 8, 2) + " | | " +  getBallScore(player, 9, 1) + " | " +  getBallScore(player, 9, 2) + " |");
                scoreBoard += ("\n|    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____| |    |____|");
                scoreBoard += ("\n|         | |         | |         | |         | |         | |         | |         | |         | |         | |         |");
                scoreBoard += ("\n|    " + getFrameScore(player, 0) + "   | |    " + getFrameScore(player, 1) + "   | |    " + getFrameScore(player, 2) + "   | |    " + getFrameScore(player, 3) + "   | |    " + getFrameScore(player, 4) + "   | |    " + getFrameScore(player, 5) + "   | |    " + getFrameScore(player, 6) + "   | |    " + getFrameScore(player, 7) + "   | |    " + getFrameScore(player, 8) + "   | |    " + getFrameScore(player, 9) + "   |  "+player.getTotalPoints());
                scoreBoard += ("\n|_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________| |_________|\n\n");
            }
            return scoreBoard;
    
        }
    
    private String getBallScore(Player player, Integer frameNumber, Integer ballNumber) {
            Integer ballscore = null;
            FrameScore frameScore = player.getFrameScore(frameNumber);
            if (ballNumber == 1) {
               
                if(frameScore!=null) {
                     ballscore = frameScore.getFirstBallScore();
                }
            } else if (ballNumber == 2) {
                if(frameScore!=null) {
                     ballscore = player.getFrameScore(frameNumber).getSecondBallScore();
                }
            }
            
          return format(ballNumber, ballscore, frameScore);
        }

    private String format(Integer ballNumber, Integer ballscore,  FrameScore frameScore) {
        String score = "";
        if (ballNumber == 1) {
            if (ballscore == null) {
                score += "-";
            }
            else {
                score += ballscore.toString();
            }
        }
         else if(ballNumber == 2){
            if (frameScore.isAStrike()) {
                score += "X";
            } else if (frameScore.isASpare()) {
                score += "/";
            } else {
                score += ballscore.toString();
            }
        }
        if(score.length()==1){
            score+=" ";
        }
        return score;
    }

    private String getFrameScore(Player player, int frameNumber) {
        String score = "";
        Integer totalScore = null;
        FrameScore frameScore = player.getFrameScore(frameNumber);
        if (frameScore != null) {
            totalScore = frameScore.getTotalScore();
        }

        if (totalScore != null) {
            score = totalScore.toString();
        } else {
            score = "-";
        }
        if (score.length() == 1) {
            score += " ";
        }
        return score;
    }

}
