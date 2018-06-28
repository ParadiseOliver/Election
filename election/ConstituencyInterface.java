    import java.util.Set;

    /**
     *
     * Interface for constituency in an election. Each constituency has many polling stations where voters can vote.
     *
     * You should provide a constructor with a String name parameter
     *
     * @author Steven Bradley
     * @version January 2018
     **/
    public interface ConstituencyInterface
    {
        Set<CandidateInterface> getCandidates();

        void addCandidate(CandidateInterface candidate);

        Set<PollingStationInterface> getPollingStations();

        void addPollingStation(PollingStationInterface pollingStation);

        String getName();

        void setName(String name);

        /** 
         * @return the total number of votes cast for the given candidate in this constituency at any polling station
         **/
        int voteCount(CandidateInterface candidate);

        /**
         * @return the candidate with the most votes in this constituency
         */
        CandidateInterface winner();

        /** EXTRA **/

        /**
         * Set the size of the constituency population
         * @param population how many people live in the constituency
         */
        void setPopulation(int population);

        /**
         * @return the size of the population of the constituency 
         * (or 0 if the population has not been set)
         **/
        int getPopulation();

        /**
         * @return true if publicthe population size has been set (population is greater than 0)
         **/
        boolean hasDefinedPopulation();

        /**
         * @return the number of people registered to vote in any polling station of the constituency
         **/
        int registeredVoters();

        /**
         * @return all votes cast in any polling station of the constituency
         **/
        Set<VoteInterface> allVotes();

        /**
         * @return the total number of votes cast in any polling station of the constituency
         **/
        int votesCast();
        /**
         * @return the total number of votes cast in any polling station of the constituency for the specified party
         **/
        int votesCastParty(PartyInterface party);

        /**
         * @return the total number of female voters registered in any polling station of the constituency
         **/
        int femaleVoters();
}
