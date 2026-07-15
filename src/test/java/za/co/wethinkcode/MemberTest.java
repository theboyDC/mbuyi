package za.co.wethinkcode;

import za.co.wethinkcode.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    private BasicMember   basic;
    private PremiumMember premium;
    private StudentMember student;

    @BeforeEach
    void setUp() {
        basic   = new BasicMember("Alice", "Dlamini", "alice@email.com", "071 000 0001", "M001");
        premium = new PremiumMember("Bob", "Nkosi",   "bob@email.com",   "071 000 0002", "M002");
        student = new StudentMember("Carol","Botha",  "carol@email.com", "071 000 0003", "M003", "STU12345");
    }

    @Test
    void memberDefaultsActiveToTrue() {
        assertTrue(basic.isActive(),   "BasicMember should default to active");
        assertTrue(premium.isActive(), "PremiumMember should default to active");
        assertTrue(student.isActive(), "StudentMember should default to active");
    }

    @Test
    void makeActiveUpdatesValue() {
        basic.makeActive(false);
        assertFalse(basic.isActive());
        basic.makeActive(true);
        assertTrue(basic.isActive());
    }

    @Test
    void memberIdReturnsCorrectId() {
        assertEquals("M001", basic.memberId());
        assertEquals("M002", premium.memberId());
        assertEquals("M003", student.memberId());
    }

    @Test
    void memberIsSubclassOfPerson() {
        assertInstanceOf(Person.class, basic);
        assertInstanceOf(Person.class, premium);
        assertInstanceOf(Person.class, student);
    }

    @Test
    void basicMemberMonthlyFeeCorrect() {
        assertEquals(BasicMember.MONTHLY_FEE, basic.monthlyFee(), 0.001);
    }

    @Test
    void basicMemberAccessLevelCorrect() {
        assertEquals("Gym floor and cardio area only", basic.accessLevel());
    }

    @Test
    void basicMemberRoleCorrect() {
        assertEquals("Basic Member", basic.role());
    }

    @Test
    void basicMemberToStringContainsRole() {
        assertTrue(basic.toString().contains("Basic Member"),
                "BasicMember toString() should mention the role");
    }

    @Test
    void premiumMemberMonthlyFeeCorrect() {
        assertEquals(PremiumMember.MONTHLY_FEE, premium.monthlyFee(), 0.001);
    }

    @Test
    void premiumMemberAccessLevelCorrect() {
        assertEquals("Full access: gym floor, cardio, classes, and pool",
                premium.accessLevel());
    }

    @Test
    void premiumMemberRoleCorrect() {
        assertEquals("Premium Member", premium.role());
    }

    @Test
    void premiumMemberDefaultsTrainerAssignedFalse() {
        assertFalse(premium.isPersonalTrainerAssigned(),
                "personalTrainerAssigned should default to false");
    }

    @Test
    void premiumMemberAssignPersonalTrainerUpdatesValue() {
        premium.assignPersonalTrainer(true);
        assertTrue(premium.isPersonalTrainerAssigned());
    }

    @Test
    void premiumMemberToStringContainsTrainerStatus() {
        String result = premium.toString();
        assertTrue(result.contains("Premium Member"),
                "PremiumMember toString() should mention the role");
    }

    @Test
    void studentMemberMonthlyFeeCorrect() {
        assertEquals(StudentMember.MONTHLY_FEE, student.monthlyFee(), 0.001);
    }

    @Test
    void studentMemberAccessLevelCorrect() {
        assertEquals("Gym floor only", student.accessLevel());
    }

    @Test
    void studentMemberRoleCorrect() {
        assertEquals("Student Member", student.role());
    }

    @Test
    void studentMemberStudentNumberCorrect() {
        assertEquals("STU12345", student.studentNumber());
    }

    @Test
    void studentMemberToStringContainsStudentNumber() {
        assertTrue(student.toString().contains("STU12345"),
                "StudentMember toString() should include the student number");
    }

    @Test
    void monthlyFeesAreDistinctAcrossTypes() {
        assertNotEquals(BasicMember.MONTHLY_FEE,   PremiumMember.MONTHLY_FEE);
        assertNotEquals(BasicMember.MONTHLY_FEE,   StudentMember.MONTHLY_FEE);
        assertNotEquals(PremiumMember.MONTHLY_FEE, StudentMember.MONTHLY_FEE);
    }
}