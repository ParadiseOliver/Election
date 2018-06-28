import java.util.HashSet;

/**
 * Write a description of class PollingStation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PollingStation implements PollingStationInterface
{
    private String address;
    private String name;
    private HashSet<VoteInterface> votes;
    private HashSet<VoterInterface> voters;
    private HashSet<VoterInterface> registered;
    
    public PollingStation(String name)
    {
        this.name = name;
        votes = new HashSet<VoteInterface>();
        voters = new HashSet<VoterInterface>();
        registered = new HashSet<VoterInterface>();  
    }
    
    public HashSet<VoteInterface> getVotes(){
        return votes;
    }
    
    public boolean canVote(VoterInterface voter){
        for (VoterInterface vots: registered){
            if (vots == voter){
                return true;
            }
        }
        return false;
    }
    
    public void vote(VoteInterface vote, VoterInterface voter){
        votes.add(vote);
        registered.remove(voter);
    }
    
    public HashSet<VoterInterface> getVoters(){
        return voters;
    }
    
    public void addVoter(VoterInterface voter){
        voters.add(voter);
        registered.add(voter);
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int voteCount(CandidateInterface candidate){
        int counter = 0;        
        for (VoteInterface vote : votes){
            if(candidate == vote.getCandidate()){
                counter+=1;
            }           
        }
        return counter;
    }
    
    public int registeredVoters(){
        return voters.size();
    }
    
    public int votesCast(){
        return votes.size();
    }
    
    public int femaleVoters(){
        int counter = 0;
        for (VoterInterface vots : voters){
            if(vots.isFemale()){
                counter +=1;
            }
        }
        return counter;
    }
}
