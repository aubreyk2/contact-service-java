package main;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        String id = appointment.getAppointmentId();

        if (appointments.containsKey(id)) {
            System.out.println("Add failed: Appointment ID '" + id + "' already exists.");
            throw new IllegalArgumentException("Appointment ID already exists.");
        }

        appointments.put(id, appointment);
        System.out.println("Appointment added: " + id);
    }

    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            System.out.println("Delete failed: Appointment ID '" + appointmentId + "' not found.");
            throw new IllegalArgumentException("Appointment ID not found.");
        }

        appointments.remove(appointmentId);
        System.out.println("Appointment deleted: " + appointmentId);
    }

    public Appointment getAppointment(String appointmentId) {
        Appointment appt = appointments.get(appointmentId);
        if (appt == null) {
            System.out.println("Retrieve failed: Appointment ID '" + appointmentId + "' not found.");
        }
        return appt;
    }

    public Map<String, Appointment> getAllAppointments() {
        return new HashMap<>(appointments);
    }
}
