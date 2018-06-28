
/**
 * Write a description of class Candidate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Candidate implements CandidateInterface
{
    private PartyInterface party;
    private String name;
    private boolean female;
    
    public Candidate(String name)
    {
        this.name = name;
    }

    public PartyInterface getParty(){
        return party;
    }
    
    public void setParty(PartyInterface party){
        this.party = party;
    }
    
    public String getName(){
        return name;
    }
    
    /**
     * @return true if and only if the candidate is not associated with a party
     **/
    public boolean isIndependent(){
        if (party == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isFemale(){
        if (female){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setFemale(boolean isFemale){
        if (isFemale){
            female = true;
        }
        else{
            female = false;
        }
    }
}
