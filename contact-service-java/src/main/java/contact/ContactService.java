package contact;
import java.util.ArrayList;
public class ContactService {

    private ArrayList<Contact> contactList = new ArrayList<>();

    //Adds and checks for duplicates
    public boolean addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (getContact(contactId) != null) {
            System.out.println("Contact with ID " + contactId + " already exists. Cannot add duplicate.");
            return false;
        }

        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contactList.add(newContact);
        System.out.println("Added Contact: " + contactId);
        return true;
    }

    public Contact getContact(String contactId) {
        for (Contact c : contactList) {
            if (c.getContactId().equals(contactId)) {
                return c;
            }
        }
        return null;
    }

    public boolean deleteContact(String contactId) {
        Contact contactToRemove = getContact(contactId);
        if (contactToRemove != null) {
            contactList.remove(contactToRemove);
            System.out.println("Deleted Contact: " + contactId);
            return true;
        } else {
            System.out.println("Contact ID " + contactId + " not found.");
            return false;
        }
    }

    //Update with  logging
    public boolean updateFirstName(String contactId, String newFirstName) {
        Contact c = getContact(contactId);
        if (c != null) {
            c.setFirstName(newFirstName);
            System.out.println("Updated first name for " + contactId + " to " + newFirstName);
            return true;
        }
        System.out.println("Contact ID " + contactId + " not found.");
        return false;
    }

    public boolean updateLastName(String contactId, String newLastName) {
        Contact c = getContact(contactId);
        if (c != null) {
            c.setLastName(newLastName);
            System.out.println("Updated last name for " + contactId + " to " + newLastName);
            return true;
        }
        System.out.println("Contact ID " + contactId + " not found.");
        return false;
    }

    public boolean updatePhone(String contactId, String newPhone) {
        Contact c = getContact(contactId);
        if (c != null) {
            c.setPhone(newPhone);
            System.out.println("Updated phonefor " + contactId + " to " + newPhone);
            return true;
        }
        System.out.println("Contact ID " + contactId + " not found.");
        return false;
    }

    public boolean updateAddress(String contactId, String newAddress) {
        Contact c = getContact(contactId);
        if (c != null) {
            c.setAddress(newAddress);
            System.out.println("Updated address for " + contactId + " to " + newAddress);
            return true;
        }
        System.out.println("Contact ID " + contactId + " not found.");
        return false;
    }

    public ArrayList<Contact> getAllContacts() {
        return contactList;
    }
 public ArrayList<Contact> getContactList() {
        return contactList;
    }

    //Displays contacts
    public void displayContacts() {
        System.out.println("Contacts List:");
        for (Contact c : contactList) {
            System.out.println("ID: " + c.getContactId());
            System.out.println("Name: " + c.getFirstName() + " " + c.getLastName());
            System.out.println("Phone: " + c.getPhone());
            System.out.println("Address: " + c.getAddress());
            System.out.println("-----");
        }
    }
}
