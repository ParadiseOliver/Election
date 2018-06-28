/**
 * Write a description of class Vote here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vote implements VoteInterface
{
    private CandidateInterface candidate;
    private int counter;
    
    public Vote()
    {
        counter = 0;
    }
    
    public void addCandidate(CandidateInterface candidate){
        this.candidate = candidate;
        counter +=1;
    }
    
    public boolean isSpoiled(){
        if (counter == 1){
            return false;
        }
        else{
            return true;
        }
    }
    
    public CandidateInterface getCandidate(){
        if (isSpoiled() == true){
            return null;
        }
        else{
            return candidate;
        }
    }
}
