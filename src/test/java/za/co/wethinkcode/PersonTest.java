package za.co.wethinkcode;

import za.co.wethinkcode.model.BasicMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private BasicMember person;

    @BeforeEach
    void setUp() {
        person = new BasicMember("Alice", "Dlamini", "alice@email.com", "071 000 0001", "M001");
    }

    @Test
    void constructorSetsAllFields() {
        assertEquals("Alice",           person.firstName());
        assertEquals("Dlamini",         person.lastName());
        assertEquals("alice@email.com", person.email());
        assertEquals("071 000 0001",    person.phoneNumber());
    }

    @Test
    void getFullNameReturnsCombinedName() {
        assertEquals("Alice Dlamini", person.fullName());
    }

    @Test
    void setEmailUpdatesValue() {
        person.addEmail("newalice@email.com");
        assertEquals("newalice@email.com", person.email());
    }

    @Test
    void setPhoneNumberUpdatesValue() {
        person.addPhoneNumber("082 111 2222");
        assertEquals("082 111 2222", person.phoneNumber());
    }

    @Test
    void getRoleIsImplementedByConcreteClass() {
        assertNotNull(person.role(),
                "role() must return a non-null value");
        assertFalse(person.role().isBlank(),
                "role() must return a non-empty string");
    }

    @Test
    void toStringContainsFullNameAndEmail() {
        String result = person.toString();
        assertTrue(result.contains("Alice"),           "toString() should contain first name");
        assertTrue(result.contains("Dlamini"),         "toString() should contain last name");
        assertTrue(result.contains("alice@email.com"), "toString() should contain email");
    }
}