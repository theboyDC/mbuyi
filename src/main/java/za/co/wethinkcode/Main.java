package za.co.wethinkcode;

import za.co.wethinkcode.model.*;
import za.co.wethinkcode.service.GymManager;

public class Main {

    public static void main(String[] args) {

        GymManager gym = new GymManager("WeThinkFitness");

        // Members
        gym.addMember(new BasicMember("Alice",   "Dlamini", "alice@email.com",  "071 000 0001", "M001"));
        gym.addMember(new PremiumMember("Bob",   "Nkosi",   "bob@email.com",    "071 000 0002", "M002"));
        gym.addMember(new StudentMember("Carol", "Botha",   "carol@email.com",  "071 000 0003", "M003", "STU12345"));

        // Staff
        gym.addStaff(new Trainer("Dave",  "Sithole", "dave@gym.com",  "071 000 0004", "E001", 3, "Strength", "HFPA Level 3"));
        gym.addStaff(new Receptionist("Eve", "Khumalo", "eve@gym.com","071 000 0005", "E002", 1, "Morning"));

        System.out.println("=== " + gym.gymName() + " ===");
        System.out.println("\n-- All Roles --");
        gym.printAllRoles();

        System.out.println("\nTotal monthly member revenue: R" + gym.totalMonthlyMemberRevenue());
        System.out.println("Total monthly staff cost:     R" + gym.totalMonthlyStaffCost());

        System.out.println("\n-- Active Members: " + gym.activeMembers().size() + " --");
        for (Member m : gym.activeMembers()) {
            System.out.println("  " + m.fullName() + " | " + m.role() + " | R" + m.monthlyFee() + "/month");
            System.out.println("  Access: " + m.accessLevel());
        }
    }
}