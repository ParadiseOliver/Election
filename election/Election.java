import java.util.HashSet;

/**
 * Write a description of class Election here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Election implements ElectionInterface
{
    private String name;
    private HashSet<PartyInterface> parties;
    private HashSet<ConstituencyInterface> constituencies;
    private HashSet<CandidateInterface> femaleCandidates;
    private HashSet<CandidateInterface> presidential;
    public Election(String name){
        this.name = name;
        parties = new HashSet<PartyInterface>();        
        constituencies = new HashSet<ConstituencyInterface>();
        femaleCandidates = new HashSet<CandidateInterface>();
        presidential = new HashSet<CandidateInterface>();
    }

    public HashSet<ConstituencyInterface> getConstituencies(){
        return constituencies;
    }
    
    public void addConstituency(ConstituencyInterface constituency){
        constituencies.add(constituency);
    }
        
    public String getName(){
        return name;
    }
    
    public HashSet<PartyInterface> getParties(){
        for (ConstituencyInterface cons : constituencies){
            for (CandidateInterface cands: cons.getCandidates()){
                if(!cands.isIndependent()){
                    parties.add(cands.getParty());
                }
            }
        }
        return parties;
    }
    
    public int seatCount(PartyInterface party){
        int counter = 0;
        for (PartyInterface partys : parties){
            for (ConstituencyInterface cons : constituencies){
                if (partys.equals(cons.winner().getParty())){
                    counter +=1;
                }
            }
        }
        return counter;
    }
    
    public PartyInterface winner(){
        int counter = 0;
        int maximum = 0;
        PartyInterface maxConsts = null;
        for (PartyInterface party : parties){
            for (ConstituencyInterface cons: constituencies){
                if (party.equals(cons.winner().getParty())){
                    counter +=1;
                }
            }
            if(counter>maximum){
                maximum = counter;
                maxConsts = party;
            }
            counter=0;
        }
        return maxConsts;
    }

    public CandidateInterface leader(){
        int counter = 0;
        for (ConstituencyInterface cons : constituencies){
            counter+=1;
        }
        if (seatCount(winner()) > 0.5*counter){
            return winner().getLeader();
        }
        else {
            return null;
        }     
    }
    
    public void setPresidentialCandidates(HashSet<CandidateInterface> candidates){
       presidential = candidates;
             
    }
    
    public int femaleVoters(){
        int counter = 0;
        for (ConstituencyInterface cons: constituencies){
            counter += cons.femaleVoters();
        }
        return counter;
    }
    
    public HashSet<CandidateInterface> femaleCandidates(){
        for (ConstituencyInterface cons : constituencies){
            for(CandidateInterface cands : cons.getCandidates()){
                if(cands.isFemale()){
                    femaleCandidates.add(cands);
                }
            }
        }
        return femaleCandidates;
    }
    
    public ConstituencyInterface fewestPollingStations(){
        int min = 0;
        int counter = 0;
        ConstituencyInterface minCon = null;
        for(ConstituencyInterface cons: constituencies){
            min = cons.getPollingStations().size();
        }
        for(ConstituencyInterface cons: constituencies){
            counter = cons.getPollingStations().size();
            if(counter < min){
                min = counter;
                minCon = cons;
            }            
        }
        return minCon;
    }
    
    public PartyInterface popularVoteWinner(){
        int max = 0;
        int counter = 0;
        PartyInterface maxPart = null;
        for(PartyInterface party:parties){
            for (ConstituencyInterface cons: constituencies){
                counter += cons.votesCastParty(party);
            }
            if(counter >max){
                max = counter;
                maxPart = party;
            }
        }
        if (max != 0){
            return maxPart;
        }
        else{
            return null;
        }
    }
}
