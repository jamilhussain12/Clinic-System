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


}
