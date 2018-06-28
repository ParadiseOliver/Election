/**
 *
 * Interface for a voter in an election. 
 *
 * You should provide a constructor with a String name parameter
 *
 * @author Steven Bradley
 * @version January 2018
 **/

    public interface VoterInterface
{
    String getPostcode();

    void setPostcode(String postcode);

    String getName();

    void setName(String name);

    /** EXTRA **/

    /**
     * @param age the age (in years) of the voter
     **/
    void setAge(int age);

    /**
     * @return the age (in years) of the voter
     **/
    int getAge();

    /**
     * @return true if the voter is young (under 25 years)
     **/
    boolean isYoung();

    /**
     * @return true if the voter is female
     **/
    boolean isFemale();

    /**
     * @param female true if the voter is female, otherwise false
     **/
    void setFemale(boolean female);

}
    