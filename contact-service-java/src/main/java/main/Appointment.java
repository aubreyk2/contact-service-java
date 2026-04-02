package main;

import java.util.Date;
public class Appointment {

    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException(
                "Appointment ID must be 1 to 10 characters and cannot be null. Provided: " + appointmentId
            );
        }

        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException(
                "Appointment date must be in the future. Provided: " + appointmentDate
            );
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException(
                "Description must be 1 to 50 characters." + 
                (description == null ? "null" : description.length())
            );
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
        System.out.println("Created Appointment: " + appointmentId);
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException(
                "Appointment date must be in the future." + appointmentDate
            );
        }
        this.appointmentDate = appointmentDate;
        System.out.println("Updated Appointment Date for " + appointmentId + " to " + appointmentDate);
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException(
                "Description must be 1-50 characters." + 
                (description == null ? "null" : description.length())
            );
        }
        this.description = description;
        System.out.println("Updated Description for " + appointmentId + ": " + description);
    }

    public String getDetails() {
        return "ID: " + appointmentId + ", Date: " + appointmentDate + ", Description: " + description;
    }
}
