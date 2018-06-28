    import java.util.Set;

    /**
     *
     * Interface for national Election. The country is divided into constituencies, also known as seats, which are separate geographical areas.
     *
     * You should provide a contructor which takes a String name as a parameter.
     *
     * @author Steven Bradley
     * @version January 2018
     */
    public interface ElectionInterface
    {
        Set<ConstituencyInterface> getConstituencies();

        void addConstituency(ConstituencyInterface constituency);

        String getName();

        /**
         * @return all the parties that have put up candidates for the election in any constituency.
         **/
        Set<PartyInterface> getParties();

        /** 
         * @return the number of seats (constituencies) won by the given party
         **/
        int seatCount(PartyInterface party);



        /**
         * @return the part with the most seats
         **/
        PartyInterface winner();

        /**
         * @return If the winning party has more than 50% of the seats then return that party's leader, otherwise return null
         **/
        CandidateInterface leader();

        /** EXTRA **/

        /**
         * Set all constituencies to have the same candidates, as might be used for directly electing a president
         * @param candidates the set of candidates to be used by all constituencies
         **/
        void setPresidentialCandidates(Set<CandidateInterface> candidates);


        /**
         * @return the total number of female voters that voted in the election
         **/
        int femaleVoters();

        /** @return the set of all candidates in the election who are female **/
        Set<CandidateInterface> femaleCandidates();

        /**
         * @return the constituency with the fewest polling stations 
         * (or null if none of them have any polling stations) */
        ConstituencyInterface fewestPollingStations();
        
        /**
         * @return the party that won the popular vote 
         * i.e. the party that received the most votes in total
         **/
        PartyInterface popularVoteWinner();

    }
    

    