package contact;
public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                "Contact ID must be 1-10 characters." + contactId
            );
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must be 1 to 10 characters." + 
                (firstName == null ? "null" : firstName.length())
            );
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must be 1 o 10 characters." + 
                (lastName == null ? "null" : lastName.length())
            );
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException(
                "Phone number must be exactly 10 digts." + phone
            );
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must be 1 to 30 characters." + 
                (address == null ? "null" : address.length())
            );
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;

        System.out.println("Created Contact: " + contactId);
    }

    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "First name must be 1 to 10 characters." + 
                (firstName == null ? "null" : firstName.length())
            );
        }
        this.firstName = firstName;
        System.out.println("Updated first name for " + contactId + " to " + firstName);
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "Last name must be 1 to 10 characters." + 
                (lastName == null ? "null" : lastName.length())
            );
        }
        this.lastName = lastName;
        System.out.println("Updated last name for " + contactId + " to " + lastName);
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException(
                "Phone number must be exactly 10 digits." + phone
            );
        }
        this.phone = phone;
        System.out.println("Updated phone for " + contactId + " to " + phone);
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                "Address must be 1 to  30 characters." + 
                (address == null ? "null" : address.length())
            );
        }
        this.address = address;
        System.out.println("Updated address for " + contactId + " to " + address);
    }

    public String getDetails() {
        return "ID: " + contactId + ", Name: " + firstName + " " + lastName + 
               ", Phone: " + phone + ", Address: " + address;
    }
}
