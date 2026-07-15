package za.co.wethinkcode.model;

public class Staff {

    // TODO: declare private fields

    // TODO: implement constructor (call super())

    // TODO: implement getter for employeeId (no setter)

    // TODO: implement getter and setter for yearsOfService

    // TODO: override toString()

    /**
     * Returns the monthly gross salary in Rands.
     *
     * @return monthly salary
     */
//    TODO: declare monthlySalary()

    /**
     * Returns a summary of this staff member's key duties.
     * Example: "Personal training sessions and fitness assessments"
     *
     * @return duties description
     */
//    TODO: declare duties()
}



/////////////////
package za.co.wethinkcode.model;

public abstract class Staff extends Person {
    private final String staffId;

    public Staff(String name, String email, String staffId) {
        super(name, email);
        if (staffId == null || staffId.isBlank()) {
            throw new IllegalArgumentException("Staff ID cannot be empty");
        }
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public abstract double getSalary();

    @Override
    public String toString() {
        return super.toString() + " - Staff ID: " + staffId;
    }
}