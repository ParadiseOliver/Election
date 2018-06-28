/**
 *
 * Interface for candidate in an election. Each candidate can belong to a party, or not (in which case they are referred to as an independent candidate).
 *
 * You should provide a constructor with a String name parameter
 *
 * @author Steven Bradley
 * @version January 2018
 **/

    public interface CandidateInterface
    {
        PartyInterface getParty();

        void setParty(PartyInterface party);

        String getName();

        /**
         * @return true if and only if the candidate is not associated with a party
         **/
        boolean isIndependent();

        /** EXTRA **/

        /**
         * @return true if the candidate is female
         **/
        boolean isFemale();

        /**
         * @param female true if the candidate is female, otherwise false
         **/
        void setFemale(boolean isFemale);

    }
    