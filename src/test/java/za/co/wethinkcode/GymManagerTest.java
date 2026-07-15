//package za.co.wethinkcode;
//
//import za.co.wethinkcode.model.*;
//import za.co.wethinkcode.service.GymManager;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GymManagerTest {
//
//    private GymManager    gym;
//    private BasicMember   basic;
//    private PremiumMember premium;
//    private StudentMember student;
//    private Trainer       trainer;
//    private Receptionist  receptionist;
//
//    @BeforeEach
//    void setUp() {
//        gym          = new GymManager("WeThinkCode Fitness");
//        basic        = new BasicMember("Alice",  "Dlamini", "alice@email.com",  "071 000 0001", "M001");
//        premium      = new PremiumMember("Bob",  "Nkosi",   "bob@email.com",    "071 000 0002", "M002");
//        student      = new StudentMember("Carol","Botha",   "carol@email.com",  "071 000 0003", "M003", "STU12345");
//        trainer      = new Trainer("Dave", "Sithole", "dave@gym.com",  "071 000 0004", "E001", 3, "Strength", "HFPA Level 3");
//        receptionist = new Receptionist("Eve","Khumalo", "eve@gym.com",  "071 000 0005", "E002", 1, "Morning");
//    }
//
//    @Test
//    void gymNameReturnsCorrectName() {
//        assertEquals("WeThinkFitness", gym.gymName());
//    }
//
//    @Test
//    void addMemberIncreasesCount() {
//        gym.addMember(basic);
//        assertEquals(1, gym.members().size());
//    }
//
//    @Test
//    void membersReturnsUnmodifiableView() {
//        gym.addMember(basic);
//        assertThrows(UnsupportedOperationException.class,
//                () -> gym.members().add(premium),
//                "members() should return an unmodifiable list");
//    }
//
//    @Test
//    void findMemberReturnsCorrectMember() {
//        gym.addMember(basic);
//        gym.addMember(premium);
//        Member found = gym.findMember("M001");
//        assertNotNull(found);
//        assertEquals("Alice", found.firstName());
//    }
//
//    @Test
//    void findMemberReturnsNullForUnknownId() {
//        assertNull(gym.findMember("UNKNOWN"),
//                "findMember() should return null for an unknown ID");
//    }
//
//    @Test
//    void removeMemberDecreasesCount() {
//        gym.addMember(basic);
//        gym.addMember(premium);
//        gym.removeMember("M001");
//        assertEquals(1, gym.members().size());
//    }
//
//    @Test
//    void removeMember_throwsForUnknownId() {
//        assertThrows(IllegalArgumentException.class,
//                () -> gym.removeMember("UNKNOWN"));
//    }
//
//    @Test
//    void activeMembersReturnsOnlyActiveMembers() {
//        gym.addMember(basic);
//        gym.addMember(premium);
//        premium.makeActive(false);
//        assertEquals(1, gym.activeMembers().size());
//        assertEquals("M001", gym.activeMembers().get(0).memberId());
//    }
//
//    @Test
//    void activeMembersReturnsAllWhenAllActive() {
//        gym.addMember(basic);
//        gym.addMember(premium);
//        gym.addMember(student);
//        assertEquals(3, gym.activeMembers().size());
//    }
//
//    @Test
//    void addStaffIncreasesCount() {
//        gym.addStaff(trainer);
//        assertEquals(1, gym.staffList().size());
//    }
//
//    @Test
//    void staffListReturnsUnmodifiableView() {
//        gym.addStaff(trainer);
//        assertThrows(UnsupportedOperationException.class,
//                () -> gym.staffList().add(receptionist),
//                "staffList() should return an unmodifiable list");
//    }
//
//    @Test
//    void findStaffReturnsCorrectStaff() {
//        gym.addStaff(trainer);
//        gym.addStaff(receptionist);
//        Staff found = gym.findStaff("E002");
//        assertNotNull(found);
//        assertEquals("Eve", found.firstName());
//    }
//
//    @Test
//    void findStaffReturnsNullForUnknownId() {
//        assertNull(gym.findStaff("UNKNOWN"),
//                "findStaff() should return null for an unknown ID");
//    }
//
//    @Test
//    void totalMonthlyMemberRevenueSumsActiveMemberFees() {
//        gym.addMember(basic);
//        gym.addMember(premium);
//        gym.addMember(student);
//        double expected = BasicMember.MONTHLY_FEE
//                + PremiumMember.MONTHLY_FEE
//                + StudentMember.MONTHLY_FEE;
//        assertEquals(expected, gym.totalMonthlyMemberRevenue(), 0.001);
//    }
//
//    @Test
//    void totalMonthlyMemberRevenueExcludesInactiveMembers() {
//        gym.addMember(basic);
//        gym.addMember(premium);
//        premium.makeActive(false);
//        assertEquals(BasicMember.MONTHLY_FEE, gym.totalMonthlyMemberRevenue(), 0.001,
//                "Inactive members should not be included in revenue");
//    }
//
//    @Test
//    void totalMonthlyMemberRevenueIsZeroWithNoMembers() {
//        assertEquals(0.0, gym.totalMonthlyMemberRevenue(), 0.001);
//    }
//
//    @Test
//    void totalMonthlyStaffCostSumsAllStaffSalaries() {
//        gym.addStaff(trainer);
//        gym.addStaff(receptionist);
//        double expected = trainer.monthlySalary() + receptionist.monthlySalary();
//        assertEquals(expected, gym.totalMonthlyStaffCost(), 0.001);
//    }
//
//    @Test
//    void totalMonthlyStaffCostIsZeroWithNoStaff() {
//        assertEquals(0.0, gym.totalMonthlyStaffCost(), 0.001);
//    }
//
//    @Test
//    void printAllRolesDoesNotThrow() {
//        gym.addMember(basic);
//        gym.addMember(premium);
//        gym.addStaff(trainer);
//        assertDoesNotThrow(() -> gym.printAllRoles(),
//                "printAllRoles() should not throw for any combination of Person types");
//    }
//}