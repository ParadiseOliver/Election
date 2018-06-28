/**
 *
 * Interface for a political party in an election. 
 *
 * You should provide a constructor with a String name parameter.
 *
 * @author Steven Bradley
 * @version December 2017
 **/


public interface PartyInterface
{
    CandidateInterface getLeader();
    
    void setLeader(CandidateInterface leader);
    
    String getName();
}
