package za.co.wethinkcode.model;

public class Trainer {

    public static final double BASE_SALARY       = 18000.00;
    public static final double SALARY_PER_YEAR   = 500.00;

    // TODO: declare private field(s)

    // TODO: implement constructor

    // TODO: implement getters and setter for specialisation

    // TODO: implement getter for certification

    // TODO: override monthlySalary()

    // TODO: override duties()

    // TODO: override role()

    // TODO: override toString()
}


////////////////////
package za.co.wethinkcode.model;

public class Trainer extends Staff {
    private final double salary;

    public Trainer(String name, String email, String staffId, double salary) {
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