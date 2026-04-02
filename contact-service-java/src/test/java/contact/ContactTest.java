package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    @BeforeEach
    void setUp() {
        //Sample contacts tests
        contact1 = new Contact("001", "John", "Doe", "1234567890", "1234 Street");
        contact2 = new Contact("002", "Aubrey", "Karczewski", "0987654321", "4321 Drive");
        contact3 = new Contact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
    }

 
    //Getters Tests
    @Test
    void testContactId() {
        assertEquals("001", contact1.getContactId(), "Contact ID should match the initialized value");
    }

    @Test
    void testFirstName() {
        assertEquals("John", contact1.getFirstName(), "First name should match the initialized value");
    }

    @Test
    void testLastName() {
        assertEquals("Doe", contact1.getLastName(), "Last name should match the initialized value");
    }

    @Test
    void testPhone() {
        assertEquals("1234567890", contact1.getPhone(), "Phone number should match the initialized value");
    }

    @Test
    void testAddress() {
        assertEquals("1234 Street", contact1.getAddress(), "Address should match the initialized value");
    }

    
    //Setters
    @Test
    void testSetFirstName() {
        contact2.setFirstName("Michael");
        assertEquals("Michael", contact2.getFirstName(), "First name should update correctly");
    }

    @Test
    void testSetLastName() {
        contact2.setLastName("Jackson");
        assertEquals("Jackson", contact2.getLastName(), "Last name should update correctly");
    }

    @Test
    void testSetPhone() {
        contact2.setPhone("1231231231");
        assertEquals("1231231231", contact2.getPhone(), "Phone should update correctly");
    }

    @Test
    void testSetAddress() {
        contact2.setAddress("321 Blvd");
        assertEquals("321 Blvd", contact2.getAddress(), "Address should update correctly");
    }


    //Invalid Input Tests 
    @Test
    void testSetFirstNameNull() {
        contact3.setFirstName(null);
        assertEquals("Billy", contact3.getFirstName(), "Null first name should not be accepted");
    }

    @Test
    void testSetLastNameTooLong() {
        contact3.setLastName("abcdefghijklmnopqrstuvwxyz");
        assertEquals("Bob", contact3.getLastName(), "Last name exceeding 10 chars should not be accepted");
    }

    @Test
    void testSetPhoneWrongLength() {
        contact3.setPhone("1234");
        assertEquals("9999999999", contact3.getPhone(), "Phone number with invalid length should not be accepted");
    }

    @Test
    void testSetAddressTooLong() {
        contact3.setAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        assertEquals("003 Billy Bob Rd", contact3.getAddress(), "Address exceeding 30 chars should not be accepted");
    }
}
