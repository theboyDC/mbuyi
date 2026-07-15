package za.co.wethinkcode.model;

public class Member extends Person {

    // TODO: declare private fields
    private String memberId;
    private  boolean active;

    // TODO: implement constructor
    public Member(String memberId,boolean active,String firstName,String lastName, String email,String phoneNumber){
        super(firstName,lastName,email,phoneNumber);
        this.memberId = memberId;
        this.active = active = true;
    }
    // TODO: implement getter for memberId
    public String memberId(){return memberId;}
    public boolean active(){return active;}
    // TODO: implement getter and setter for active
    void isActive(boolean isActive){this.active = isActive;}

    void makeActive(boolean isActive){
        isActive = false;
        this.active = isActive;
    }
    // TODO: override toString()
    @Override
    public String toString(){
        return "";
    }
    /**
     * Returns the monthly membership fee in Rands.
     *
     * @return monthly fee
     */
//    TODO: declare monthlyFee()
        public
    /**
     * Returns a description of the gym areas this member may access.
     * Example: "Gym floor and cardio area only"
     *
     * @return access level description
     */
//    TODO: declare getAccessLevel()
    public abstract String role(){

    }
}