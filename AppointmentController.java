import java.util.*;

public class AppointmentController {
    private List<AppointmentBooking> bookings;
    private List<Patient> patients;

    public AppointmentController() {
        bookings = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void bookAppointment(AppointmentBooking booking) {
        bookings.add(booking);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<AppointmentBooking> getBookings() {
        return bookings;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient " + patient.getName() + " added successfully.");
    }

    public void removePatientById(int patientId) {
        Patient toRemove = null;
        for (Patient p : patients) {
            if (p.getId() == patientId) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            patients.remove(toRemove);
            System.out.println("Patient " + toRemove.getName() + " removed successfully.");
        } else {
            System.out.println("Patient with ID " + patientId + " not found.");
        }
    }

    public boolean cancelBooking(String bookingId) {
        boolean removed = bookings.removeIf(booking -> booking.getBookingId().equals(bookingId));
        
        if (removed) {
            System.out.println("Booking " + bookingId + " has been cancelled.");
            return true;
        } else {
            System.out.println("Booking ID " + bookingId + " not found.");
            return false;
        }
    }
    
    

}
