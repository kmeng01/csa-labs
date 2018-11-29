/**
 * The SportsReport Class provides functionality to parse the winner,
 * loser, winning score, and losing score from a natural text string
 * and display it in an aligned format.
 *
 * @author Kevin Meng
 * Collaborators: None
 * Teacher Name: Mrs. Ishman
 * Period: 7
 * Due Date: 12/03/2018
 */

public class SportsReport
{
	/** Names of the winning and losing teams */
	private String winner;
	private String loser;

	/** the winning and losing scores */
	private int winningScore;
	private int losingScore;

	/** Constructs a SportsReport using the information in score
	 *  @param score contains winner, loser, and scores in the format:
	 *  <winner> beat <loser> by a score of <winning score> to <losing score>
	 */
	public SportsReport(String score)
	{
		extractInformation(score);
	}

	/** Changes the sports scoring information
	 *  @param score contains winner, loser, and scores in the format:
	 *  <winner> beat <loser> by a score of <winning score> to <losing score>
	 */
	public void changeScoringInfo(String score)
	{
		extractInformation(score);
	}

    /**
     * Returns name of winner
     * @return name of winner
     */
	public String getWinner()
	{
        return winner;
	}

    /**
     * Returns name of loser
     * @return name of loser
     */
	public String getLoser()
	{
	    return loser;
	}

    /**
     * Returns score of winner
     * @return score of winner
     */
	public int getWinningScore()
	{
	    return winningScore;
	}

    /**
     * Returns score of loser
     * @return score of loser
     */
	public int getLosingScore()
	{
	    return losingScore;
	}

    /**
     * Returns difference of winning and losing scores
     * @return difference of scores
     */
	public int getScoreDifference()
    {
        return winningScore - losingScore;
    }

	@Override
	public String toString()
	{
		return String.format("%-25s %4d, %-25s %4d", winner, winningScore, loser, losingScore);
	}

    /**
     * Extracts winner, loser, winningScore, losingScore from a natural text string
     * @param score natural text string
     */
    private void extractInformation(String score)
    {
        String[] tokens = score.split(" beat ");

        winner = tokens[0];

        tokens = tokens[1].split(" by a score of ");
        loser = tokens[0];

        winningScore = Integer.parseInt(tokens[1].split(" to ")[0]);
        losingScore = Integer.parseInt(tokens[1].split(" to ")[1]);
    }

}