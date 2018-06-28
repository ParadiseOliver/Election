
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class ElectionTest.
 *
 * @author  Steven Bradley
 * @version January 2018
 */
public class ElectionTest
{
    ElectionInterface e;
    PartyInterface p1, p2;
    CandidateInterface c1, c2, c3, c4;
    ConstituencyInterface con1, con2;
    PollingStationInterface pol1, pol2;
    ArrayList<VoterInterface> voters;
    ArrayList<VoteInterface> votes;

    /**
     * Default constructor for test class ElectionTest
     */
    public ElectionTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        e = new Election("Magnus Bordewich popularity contest");
        c1 = new Candidate("MB");
        c2 = new Candidate("RP");
        c3 = new Candidate("SB");
        c4 = new Candidate("JT");

        p1 = new Party("Muggle");
        p2 = new Party("Wizard");
        c1.setParty(p1);
        c2.setParty(p2);
        c3.setParty(p1);
        c4.setParty(p2);

        con1 = new Constituency("Wakefield");
        con2 = new Constituency("Manchester");
        e.addConstituency(con1);
        e.addConstituency(con2);

        con1.addCandidate(c1);
        con1.addCandidate(c2);
        con2.addCandidate(c3);
        con2.addCandidate(c4);

        pol1 = new PollingStation("Wakefield High Street");
        pol2 = new PollingStation("Manchester Town Hall");
        con1.addPollingStation(pol1);
        con2.addPollingStation(pol1);

        voters = new ArrayList<>();
        for(int i = 0; i<10; i++){
            VoterInterface v = new Voter ("Voter " + i);
            voters.add(v);
            if(i<5){
                pol1.addVoter(v);
            }
            else{
                pol2.addVoter(v);
            }
        }

        votes = new ArrayList<>();
        for(int j = 0; j<10; j++){
            votes.add(new Vote ());
        }
        votes.get(0).addCandidate(c1);
        votes.get(1).addCandidate(c1);
        votes.get(2).addCandidate(c1);
        votes.get(3).addCandidate(c2);
        votes.get(4).addCandidate(c2);
        votes.get(5).addCandidate(c3);
        votes.get(6).addCandidate(c3);
        votes.get(7).addCandidate(c4);
        votes.get(8).addCandidate(c1);
        votes.get(8).addCandidate(c2);
        // no candidates for vote 9

        for(int i = 0; i<9; i++){ // no Voter 9
            if(i<5){
                pol1.vote(votes.get(i), voters.get(i));
            }
            else{
                pol2.vote(votes.get(i), voters.get(i));
            }
        }   
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void countConstituencies()
    {
        assertEquals(2, e.getConstituencies().size());
    }

    @Test
    public void countCandidates()
    {
        assertEquals(2, con1.getCandidates().size());
    }

    @Test
    public void countPollingStations()
    {
        assertEquals(1, con1.getPollingStations().size());
    }

    @Test
    public void spoiled()
    {
        Vote vote8 = (Vote)votes.get(8);
        assertEquals(true, vote8.isSpoiled());
        Vote vote9 = (Vote)votes.get(9);
        assertEquals(true, vote9.isSpoiled());
        Vote vote0 = (Vote)votes.get(0);
        assertEquals(false, vote0.isSpoiled());
    }

    @Test
    public void canVote()
    {
        Voter voter0 = (Voter)voters.get(0);
        assertEquals(false, pol1.canVote(voter0));
        assertEquals(false, pol2.canVote(voter0));
        Voter voter9 = (Voter)voters.get(9);
        assertEquals(true, pol2.canVote(voter9));
    }

    @Test
    public void constituencyWinner()
    {
        CandidateInterface winner = con1.winner();
        System.out.println(winner);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        assertEquals(c1, winner);
    }

    @Test
    public void candidatePollingStationVotes()
    {
        assertEquals(3, pol1.voteCount(c1));
        assertEquals(2, pol1.voteCount(c2));
    }
    
    @Test
    public void candidateConstituencyVotes()
    {
        assertEquals(3, con1.voteCount(c1));
        assertEquals(2, con1.voteCount(c2));
    }
}




