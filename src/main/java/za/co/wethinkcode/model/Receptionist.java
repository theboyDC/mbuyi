package za.co.wethinkcode.model;

public class Receptionist {

    public static final double MONTHLY_SALARY = 12000.00;

    // TODO: declare private field(s)

    // TODO: implement constructor

    // TODO: implement getter and setter for shift

    // TODO: override monthlySalary()

    // TODO: override duties()

    // TODO: override role()

    // TODO: override toString()
}




//////////////////\
package za.co.wethinkcode.model;

public class Receptionist extends Staff {
    private final double salary;

    public Receptionist(String name, String email, String staffId, double salary) {
        super(name, email, staffId);
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}