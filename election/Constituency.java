import java.util.HashSet;

/**
 * Write a description of class Constituency here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Constituency implements ConstituencyInterface
{
    private String name;
    private int population;
    private HashSet<CandidateInterface> candidates;
    private HashSet<PollingStationInterface> pollingStations;
    private HashSet<VoteInterface> allVotes;
    
    public Constituency(String name)
    {
        this.name = name;
        candidates = new HashSet<CandidateInterface>();
        pollingStations = new HashSet<PollingStationInterface>();
        allVotes = new HashSet<VoteInterface>();
        population = 0;
    }

    public HashSet<CandidateInterface> getCandidates(){
        return candidates;
    }
    
    public void addCandidate(CandidateInterface candidate){
        candidates.add(candidate);
    }
    
    public HashSet<PollingStationInterface> getPollingStations(){
        return pollingStations;
    }
    
    public void addPollingStation(PollingStationInterface pollingStation){
        pollingStations.add(pollingStation);
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int voteCount(CandidateInterface candidate){
        int counter = 0; 
        for (PollingStationInterface station: pollingStations){
            counter += station.voteCount(candidate);
        }
        return counter;
    }
    
    public CandidateInterface winner(){
        int max = 0;
        CandidateInterface win = null;
        for (CandidateInterface cand : candidates){
            if (voteCount(cand)>max){
                max = voteCount(cand);
                win = cand;
            }
        }
        return win;
    }
    
    public void setPopulation(int population){
        this.population = population;
    }
    
    public int getPopulation(){
        return population;
    }
    
    public boolean hasDefinedPopulation(){
        if (population != 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int registeredVoters(){
        int counter = 0;
        for (PollingStationInterface station : pollingStations){
            counter+= station.registeredVoters();
        }       
        return counter;
    }
    
    public HashSet<VoteInterface> allVotes(){
        for (PollingStationInterface station : pollingStations){
            for(VoteInterface vots : station.getVotes()){
                allVotes.add(vots);
            }
        }
        return allVotes;
    }
    
    public int votesCast(){
        return allVotes.size();
    }
    
    public int votesCastParty(PartyInterface party){
        int counter = 0;
        for (PollingStationInterface stations : pollingStations){
            for (VoteInterface vots: stations.getVotes()){
                if(party == vots.getCandidate().getParty()){
                    counter += 1;
                }
            }
        }
        return counter;
    }
    
    public int femaleVoters(){
        int counter = 0;
        for (PollingStationInterface stations : pollingStations){
            counter += stations.femaleVoters();
        }
        return counter;
    }
}
