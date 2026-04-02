package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;


public class AppointmentServiceTest {

    private AppointmentService service;
    private Date futureDate;

    @BeforeEach
    void setUp() {
        service = new AppointmentService();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2); //I have set date 2 days in the future for testing
        futureDate = cal.getTime();
    }

    
    //Add Appointment 
    @Test
    void testAddAppointment() {
        Appointment appt = new Appointment("ID123", futureDate, "Appointment");
        service.addAppointment(appt);
        assertEquals(appt, service.getAppointment("ID123"), 
            "Appointment should be retrievable after adding");
    }

    @Test
    void testAddDuplicateAppointment() {
        Appointment appt1 = new Appointment("ID222", futureDate, "Appointment 2");
        Appointment appt2 = new Appointment("ID222", futureDate, "Duplicate Appointment");

        service.addAppointment(appt1);

        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appt2),
            "Adding an appointment with a duplicate ID should throw an exception");
    }

    
    //Delete Appointment Tests
    @Test
    void testDeleteAppointment() {
        Appointment appt = new Appointment("ID333", futureDate, "Appointment 3");
        service.addAppointment(appt);

        service.deleteAppointment("ID333");
        assertNull(service.getAppointment("ID333"), 
            "Deleted appointment should not be retrievable");
    }

    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("FAKEID"),
            "Deleting a non-existent appointment should throw an exception");
    }

    @Test
    void testAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null),
            "Adding a null appointment should throw an exception");
    }
}
