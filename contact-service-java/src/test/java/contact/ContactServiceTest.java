package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
        System.out.println("Setup: New ContactService instance created");
    }

    //Adding contact
    @Test
    public void testAddContact() {
        service.addContact("001", "John", "Doe", "1234567890", "1234 Street");
        assertEquals(1, service.getContactList().size());
        System.out.println("testAddContact passed");
    }

    
    @Test
    public void testAddDuplicateContactId() {
        service.addContact("001", "John", "Doe", "1234567890", "1234 Street");
        service.addContact("001", "Aubrey", "Karczewski", "0987654321", "4321 Drive");
        assertEquals(1, service.getContactList().size());
        System.out.println("testAddDuplicateContactId passed");
    }

    //Delete contact
    @Test
    public void testDeleteContact() {
        service.addContact("002", "Aubrey", "Karczewski", "0987654321", "4321 Drive");
        service.deleteContact("002");
        assertEquals(0, service.getContactList().size());
        System.out.println("testDeleteContact passed");
    }

    
    @Test
    public void testDeleteNonexistentContact() {
        service.deleteContact("999");
        assertEquals(0, service.getContactList().size());
        System.out.println("testDeleteNonexistentContact passed");
    }

    //Update contact infromation below
    @Test
    public void testUpdateFirstName() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updateFirstName("003", "Michael");
        assertEquals("Michael", service.getContact("003").getFirstName());
        System.out.println("testUpdateFirstName passed");
    }

    
    @Test
    public void testUpdateLastName() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updateLastName("003", "Jackson");
        assertEquals("Jackson", service.getContact("003").getLastName());
        System.out.println("testUpdateLastName passed");
    }

    
    @Test
    public void testUpdatePhone() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updatePhone("003", "1231231231");
        assertEquals("1231231231", service.getContact("003").getPhone());
        System.out.println("testUpdatePhone passed");
    }

    
    @Test
    public void testUpdateAddress() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updateAddress("003", "321 Blvd");
        assertEquals("321 Blvd", service.getContact("003").getAddress());
        System.out.println("testUpdateAddress passed");
    }

    
    @Test
    public void testUpdateFirstNameNull() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updateFirstName("003", null);
        assertEquals("Billy", service.getContact("003").getFirstName());
        System.out.println("testUpdateFirstNameNull passed");
    }

    
    @Test
    public void testUpdateLastNameTooLong() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updateLastName("003", "abcdefghijklmnopqrstuvwxyz");
        assertEquals("Bob", service.getContact("003").getLastName());
        System.out.println("testUpdateLastNameTooLong passed");
    }

    
    @Test
    public void testUpdatePhoneWrongLength() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updatePhone("003", "1234");
        assertEquals("9999999999", service.getContact("003").getPhone());
        System.out.println("testUpdatePhoneWrongLength passed");
    }

    
    @Test
    public void testUpdateAddressTooLong() {
        service.addContact("003", "Billy", "Bob", "9999999999", "003 Billy Bob Rd");
        service.updateAddress("003", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        assertEquals("003 Billy Bob Rd", service.getContact("003").getAddress());
        System.out.println("testUpdateAddressTooLong passed");
    }

    
    @Test
    public void testAddMultipleContacts() {
        service.addContact("004", "Alice", "Smith", "1111111111", "Street 1");
        service.addContact("005", "Bob", "Jones", "2222222222", "Street 2");
        assertEquals(2, service.getContactList().size());
        System.out.println("testAddMultipleContacts passed");
    }
}
