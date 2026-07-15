package za.co.wethinkcode.model;

public class PremiumMember {

    public static final double MONTHLY_FEE = 699.00;

    // TODO: declare private field(s)

    // TODO: implement constructor

    // TODO: implement getter and setter for personalTrainerAssigned

    // TODO: override monthlyFee()

    // TODO: override accessLevel()

    // TODO: override role()

    // TODO: override toString()
}



////////////////
package za.co.wethinkcode.model;

public class PremiumMember extends Member {
    private static final double PREMIUM_FEE = 500.0;

    public PremiumMember(String name, String email, String memberId) {
        super(name, email, memberId);
    }

    @Override
    public double getMonthlyFee() {
        return PREMIUM_FEE;
    }
}