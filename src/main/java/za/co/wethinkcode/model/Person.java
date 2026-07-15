package za.co.wethinkcode.model;

/**
 * Abstract base class representing any person associated with the gym,
 * whether a member or a staff member.
 *
 * <p>This is the root of the entire class hierarchy. It holds state and
 * behaviour that is truly common to every person in the system.
 *
 * <p>TODO: Implement this abstract class with proper encapsulation.
 *
 * <p>Requirements:
 * <ul>
 *   <li>Fields (all private):
 *     <ul>
 *       <li>firstName (String)  – immutable after construction</li>
 *       <li>lastName  (String)  – immutable after construction</li>
 *       <li>email     (String)  – mutable</li>
 *       <li>phoneNumber (String) – mutable</li>
 *     </ul>
 *   </li>
 *   <li>Constructor: accepts firstName, lastName, email, phoneNumber</li>
 *   <li>Getters for all four fields; NO setters for firstName or lastName</li>
 *   <li>Setters for email and phoneNumber</li>
 *   <li>getFullName() – convenience method returning firstName + " " + lastName</li>
 *   <li>toString() – returns a readable summary including full name and email</li>
 *   <li>Abstract method: getRole() – every subclass must describe its own role</li>
 * </ul>
 */
public abstract class Person {

    // TODO: declare private fields
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    // TODO: implement constructor

    public Person(String firstName,String lastName,String email,String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    // TODO: implement getters (no setters for firstName / lastName)
    public  String firstName(){return firstName;}
    public String lastName() {return lastName;}
    public  String email(){return email;}
    public String fullName(){return  firstName + " " + lastName;}
    public String phoneNumber(){return phoneNumber;}
    // TODO: implement setters for email and phoneNumber
    void  addEmail(String email){this.email = email;}

    void  addPhoneNumber(){this.phoneNumber = phoneNumber;}
    // TODO: implement getFullName
    //public String role(String role){
      //  if(role == role) {
        //    throw new IllegalArgumentException(" Not null");
          //  return "role() must return a non-empty string";
        //}
    // TODO: override toString()
    @Override
    public String toString(){
        return "The name of the person: "+lastName +"Lastne"+"";
    }

    /**
     * Returns a short description of this person's role in the gym.
     * Example return values: "Basic Member", "Senior Trainer", "Front-Desk Receptionist"
     *
     * @return role description
     */

    public abstract String getRole();

}}


///////////////////////////////
        package za.co.wethinkcode.model;

public abstract class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}
