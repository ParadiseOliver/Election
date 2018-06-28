    import java.util.Set;

    /**
     *
     * Interface for polling station in an election. Each polling station has a list of registered voters, each of which can cast votes for candidates
     *
     * You should provide a constructor with a String name parameter
     *
     * @author Steven Bradley
     * @version January 2018
     **/

    public interface PollingStationInterface
    {
        /**
         * @return all of the votes that have been cast so far
         **/
        Set<VoteInterface> getVotes();

        /** 
         *@return true if and only if the given voter is registered has not voted yet
         **/
        boolean canVote(VoterInterface voter);

        /**
         * @param vote the vote to be cast
         * @param voter the voter who is casting this vote
         **/
        void vote(VoteInterface vote, VoterInterface voter);

        /** 
         * @return the voters that have registered
     **/
        Set<VoterInterface> getVoters();

        /**
         * register a voter
         **/
        void addVoter(VoterInterface voter);

        String getAddress();

        void setAddress(String address);

        String getName();

        void setName(String name);

        /**
         * @return the number of votes that have been cast for the given candidate
         **/
        int voteCount(CandidateInterface candidate);

        /** EXTRA **/

        /**
         * @return the number of people registered to vote at the polling station
         **/
        int registeredVoters();

        /**
         * @return the total number of votes cast at the polling station
         **/
        int votesCast();

        /**
         * @return the total number of female voters registered at the polling station
         **/
        int femaleVoters();
    }
  