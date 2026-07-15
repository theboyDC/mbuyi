package za.co.wethinkcode.model;

public class StudentMember {

    public static final double MONTHLY_FEE = 149.00;

    // TODO: declare private field(s)

    // TODO: implement constructor

    // TODO: implement getter for studentNumber

    // TODO: override monthlyFee()

    // TODO: override accessLevel()

    // TODO: override role()

    // TODO: override toString()
}



///////////////////
package za.co.wethinkcode.model;

public class StudentMember extends Member {
    private static final double STUDENT_FEE = 100.0;

    public StudentMember(String name, String email, String memberId) {
        super(name, email, memberId);
    }

    @Override
    public double getMonthlyFee() {
        return STUDENT_FEE;
    }
}