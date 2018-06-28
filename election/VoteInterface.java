/**
 *
 * Interface for a vote in an election. When the vote is cast zero or more candidates are selected. A vote is only counted if exaclty one candidate is selected, otherwise the vote is 'spoiled'.
 *
 * You should provide a constructor with no parameters.
 *
 * @author Steven Bradley
 * @version December 2017
 **/

public interface VoteInterface
{
    /**
     * @param candidate to be added to the candidates selected in this vote
     **/
    void addCandidate(CandidateInterface candidate);

    /**
     * @return false if and only if there is exactly one candidate selected
     */
    boolean isSpoiled();

    /**
     * @return the selected candidate if the vote is not spoiled, otherwise return null
     **/
    CandidateInterface getCandidate();
}
