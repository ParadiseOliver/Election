/**
 * Write a description of class Voter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Voter implements VoterInterface
{
    private String name;
    private String postcode;
    private int age;
    private boolean female;
    
    public Voter(String name){
        this.name = name;
    }
    
    public String getPostcode(){
        return postcode;
    }
    
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    }
    
    public boolean isYoung(){
        if (age < 25){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isFemale(){
        if (female == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setFemale(boolean isFemale){
        if (isFemale == true){
            female = true;
        }
        else{
            female = false;
        }
    }
}
