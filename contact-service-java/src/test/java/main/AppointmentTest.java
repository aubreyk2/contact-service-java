package main;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;


public class AppointmentTest {

    //Valid test
    @Test
    void testValidAppointment() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();

        Appointment appt = new Appointment("ID111", futureDate, "One Appointment");

        assertEquals("ID111", appt.getAppointmentId(), "Appointment ID should match");
        assertEquals(futureDate, appt.getAppointmentDate(), "Appointment date should match");
        assertEquals("One Appointment", appt.getDescription(), "Description should match");
    }


    //Invalid tests
    @Test
    void testAppointmentIdTooLong() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("12345678900", cal.getTime(), "Test"),
            "Creating an appointment with ID longer than 10 characters should throw an exception"
        );
    }

    @Test
    void testNullAppointmentId() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment(null, cal.getTime(), "Test"),
            "Creating an appointment with null ID should throw an exception"
        );
    }

  

    @Test
    void testAppointmentDateInPast() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1); //date for yesterday

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("ID000", cal.getTime(), "Old Date Test"),
            "Creating an appointment in the past should throw an exception"
        );
    }

   
    
    @Test
    void testDescriptionTooLong() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);

        String longDescription = "This description is way too longggggggggggggggggggggggggggggggggggggggggggggg";

        assertThrows(IllegalArgumentException.class, () -> 
            new Appointment("ID001", cal.getTime(), longDescription),
            "Creating an appointment with a description over 50 characters should throw an exception"
        );
    }

    @Test
    void testSettersWork() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        Date futureDate1 = cal.getTime();
        cal.add(Calendar.DATE, 2);
        Date futureDate2 = cal.getTime();

        Appointment appt = new Appointment("ID002", futureDate1, "First Description");
        appt.setAppointmentDate(futureDate2);
        appt.setDescription("Updated Description");

        assertEquals(futureDate2, appt.getAppointmentDate(), "Updated appointment date should match");
        assertEquals("Updated Description", appt.getDescription(), "Updated description should match");
    }

    @Test
    void testSetDescriptionNull() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        Date futureDate = cal.getTime();

        Appointment appt = new Appointment("ID003", futureDate, "Initial Description");
        appt.setDescription(null);

        assertEquals("Initial Description", appt.getDescription(),
            "Setting description to null should not change the current description");
    }
}
