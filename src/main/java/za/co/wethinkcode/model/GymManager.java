package za.co.wethinkcode.model;

public class GymManager {
}


/////////////////
package za.co.wethinkcode.service;

import za.co.wethinkcode.model.Member;
import za.co.wethinkcode.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class GymManager {
    private final List<Member> members;
    private final List<Staff> staffMembers;

    public GymManager() {
        this.members = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        // Avoid duplicate IDs
        for (Member m : members) {
            if (m.getMemberId().equalsIgnoreCase(member.getMemberId())) {
                throw new IllegalArgumentException("Member with this ID already exists");
            }
        }
        members.add(member);
    }

    public void addStaff(Staff staff) {
        if (staff == null) {
            throw new IllegalArgumentException("Staff member cannot be null");
        }
        // Avoid duplicate IDs
        for (Staff s : staffMembers) {
            if (s.getStaffId().equalsIgnoreCase(staff.getStaffId())) {
                throw new IllegalArgumentException("Staff member with this ID already exists");
            }
        }
        staffMembers.add(staff);
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members); // Return defense copy
    }

    public List<Staff> getStaff() {
        return new ArrayList<>(staffMembers); // Return defense copy
    }

    /**
     * Calculates total income generated from all active members' fees.
     */
    public double calculateTotalMembershipFees() {
        double total = 0;
        for (Member m : members) {
            total += m.getMonthlyFee();
        }
        return total;
    }

    /**
     * Calculates total expenditure paid out to staff salaries.
     */
    public double calculateTotalSalaries() {
        double total = 0;
        for (Staff s : staffMembers) {
            total += s.getSalary();
        }
        return total;
    }

    /**
     * Net revenue = Member Fees - Salaries
     */
    public double getNetRevenue() {
        return calculateTotalMembershipFees() - calculateTotalSalaries();
    }
}