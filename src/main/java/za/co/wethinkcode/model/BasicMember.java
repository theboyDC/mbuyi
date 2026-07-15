package za.co.wethinkcode.model;

public class BasicMember {

    public static final double MONTHLY_FEE = 299.00;

    // TODO: implement constructor

    // TODO: override monthlyFee()

    // TODO: override accessLevel()

    // TODO: override role()

    // TODO: override toString()
}



///////////////
package za.co.wethinkcode.model;

public class BasicMember extends Member {
    private static final double BASE_FEE = 200.0;

    public BasicMember(String name, String email, String memberId) {
        super(name, email, memberId);
    }

    @Override
    public double getMonthlyFee() {
        return BASE_FEE;
    }
}