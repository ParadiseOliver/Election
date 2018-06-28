
/**
 * Write a description of class Party here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Party implements PartyInterface
{
    private String name;
    private CandidateInterface leader;
    
    public Party(String name){
        this.name = name;
    }
    
    public CandidateInterface getLeader(){
        return leader;
    }
    
    public void setLeader(CandidateInterface leader){
        this.leader = leader;
    }
    
    public String getName(){
        return name;
    }
}
