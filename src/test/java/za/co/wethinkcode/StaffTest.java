package za.co.wethinkcode;

import za.co.wethinkcode.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    private Trainer      trainer;
    private Receptionist receptionist;

    @BeforeEach
    void setUp() {
        trainer= new Trainer("Dave", "Sithole", "dave@gym.com", "071 000 0004",
                "E001", 3, "Strength", "HFPA Level 3");
        receptionist = new Receptionist("Eve", "Khumalo", "eve@gym.com", "071 000 0005",
                "E002", 1, "Morning");
    }

    @Test
    void staffIsSubclassOfPerson() {
        assertInstanceOf(Person.class, trainer);
        assertInstanceOf(Person.class, receptionist);
    }

    @Test
    void employeeIdReturnsCorrectId() {
        assertEquals("E001", trainer.employeeId());;
        assertEquals("E002", receptionist.employeeId());
    }

    @Test
    void yearsOfServiceReturnsCorrectValue() {
        assertEquals(3, trainer.yearsOfService());
        assertEquals(1, receptionist.yearsOfService());
    }

    @Test
    void updateYearsOfServiceUpdatesValue() {
        trainer.updateYearsOfService(5);
        assertEquals(5, trainer.yearsOfService());
    }

    @Test
    void updateYearsOfServiceThrowsForNegativeValue() {
        assertThrows(IllegalArgumentException.class,
                () -> trainer.updateYearsOfService(-1),
                "yearsOfService must not be negative");
    }

    @Test
    void updateYearsOfServiceAllowsZero() {
        assertDoesNotThrow(() -> receptionist.updateYearsOfService(0));
        assertEquals(0, receptionist.yearsOfService());
    }

    @Test
    void staffToStringContainsEmployeeId() {
        assertTrue(trainer.toString().contains("E001"),
                "Staff toString() should include the employee ID");
    }

    @Test
    void trainerIsSubclassOfStaff() {
        assertInstanceOf(Staff.class, trainer);
    }

    @Test
    void trainerMonthlySalaryIncludesYearsOfServiceBonus() {
        double expected = Trainer.BASE_SALARY + (3 * Trainer.SALARY_PER_YEAR);
        assertEquals(expected, trainer.monthlySalary(), 0.001);
    }

    @Test
    void trainerMonthlySalaryUpdatesWithYearsOfService() {
        trainer.updateYearsOfService(10);
        double expected = Trainer.BASE_SALARY + (10 * Trainer.SALARY_PER_YEAR);
        assertEquals(expected, trainer.monthlySalary(), 0.001);
    }

    @Test
    void trainerDutiesCorrect() {
        assertEquals("Personal training sessions and fitness assessments",
                trainer.duties());
    }

    @Test
    void trainerRoleIncludesSpecialisation() {
        assertEquals("Trainer (Strength)", trainer.role());
    }

    @Test
    void trainerSpecialisationCorrect() {
        assertEquals("Strength", trainer.specialisation());
    }

    @Test
    void trainerAddSpecialisationUpdatesValue() {
        trainer.addSpecialisation("Yoga");
        assertEquals("Yoga", trainer.specialisation());
        assertEquals("Trainer (Yoga)", trainer.role());
    }

    @Test
    void trainerCertificationCorrect() {
        assertEquals("HFPA Level 3", trainer.certification());
    }

    @Test
    void trainerToStringContainsSpecialisationAndCertification() {
        String result = trainer.toString();
        assertTrue(result.contains("Strength"),      "toString() should contain specialisation");
        assertTrue(result.contains("HFPA Level 3"),  "toString() should contain certification");
    }

    @Test
    void receptionistIsSubclassOfStaff() {
        assertInstanceOf(Staff.class, receptionist);
    }

    @Test
    void receptionistMonthlySalaryIsFixed() {
        assertEquals(Receptionist.MONTHLY_SALARY, receptionist.monthlySalary(), 0.001);
    }

    @Test
    void receptionistMonthlySalaryDoesNotChangeWithYearsOfService() {
        receptionist.setYearsOfService(10);
        assertEquals(Receptionist.MONTHLY_SALARY, receptionist.monthlySalary(), 0.001,
                "Receptionist salary should be fixed regardless of years of service");
    }

    @Test
    void receptionistDutiesCorrect() {
        assertEquals("Member check-in, phone enquiries, and administrative tasks",
                receptionist.duties());
    }

    @Test
    void receptionistRoleIncludesShift() {
        assertEquals("Receptionist (Morning shift)", receptionist.role());
    }

    @Test
    void receptionistShiftCorrect() {
        assertEquals("Morning", receptionist.shift());
    }

    @Test
    void receptionistUpdateShiftUpdatesValue() {
        receptionist.updateShift("Evening");
        assertEquals("Evening", receptionist.shift());
        assertEquals("Receptionist (Evening shift)", receptionist.role());
    }

    @Test
    void receptionistToStringContainsShift() {
        assertTrue(receptionist.toString().contains("Morning"),
                "Receptionist toString() should mention the shift");
    }

    @Test
    void salaries_areDifferentAcrossTypes() {
        assertNotEquals(trainer.monthlySalary(), receptionist.monthlySalary());
    }
}