import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class AppointmentControllerTest {
    private AppointmentController controller;
    private Patient patient;
    private Physiotherapist physiotherapist;
    private Treatment treatment;
    private AppointmentBooking booking;

    @BeforeEach
    public void setUp() {
        physiotherapist = new Physiotherapist(1, "Dr. Smith", "123 Clinic St", "555-5678", new String[]{"Physiotherapy"}, new ArrayList<>());
        patient = new Patient("John Doe", "123 Street", "555-1234");
        treatment = new Treatment("Massage", "2025-06-15 10:00", physiotherapist);
        booking = new AppointmentBooking(patient, treatment, "booked");
        controller = new AppointmentController();
    }

    @Test
    public void testBookAppointment() {
        controller.bookAppointment(booking);
        assertEquals(1, controller.getBookings().size(), "Booking should be added to the list.");
    }

    @Test
    public void testAddPatient() {
        controller.addPatient(patient);
        assertTrue(controller.getPatients().contains(patient), "Patient should be added to the list.");
    }

    @Test
    public void testRemovePatient() {
        controller.addPatient(patient);
        controller.removePatientById(patient.getId());
        assertFalse(controller.getPatients().contains(patient), "Patient should be removed from the list.");
    }

    @Test
    public void testCancelBooking() {
        controller.bookAppointment(booking);
        boolean cancelled = controller.cancelBooking(booking.getBookingId());
        assertTrue(cancelled, "Booking should be cancelled.");
        assertEquals(0, controller.getBookings().size(), "Booking list should be empty.");
    }

    @Test
    public void testAttendAppointment() {
        controller.bookAppointment(booking);
        controller.attendAppointment(booking.getBookingId());
        assertEquals("attended", booking.getStatus(), "Booking status should be 'attended'.");
    }

    @Test
    public void testChangeBooking() {
        controller.bookAppointment(booking);
        Treatment newTreatment = new Treatment("Chiropractic", "2025-06-16 14:00", physiotherapist);
        boolean changed = controller.changeBooking(booking.getBookingId(), newTreatment);
        assertTrue(changed, "Booking should be successfully changed.");
        assertEquals(newTreatment, booking.getTreatment(), "New treatment should be assigned.");
    }

    @Test
    public void testIsTreatmentAvailable() {
        controller.bookAppointment(booking);
        Treatment newTreatment = new Treatment("Yoga", "2025-06-20 10:00", physiotherapist);
        boolean available = controller.isTreatmentAvailable(newTreatment);
        assertTrue(available, "Treatment should be available.");
    }

    @Test
    public void testPrintReport() {
        controller.bookAppointment(booking);
        controller.printReport();
    }
}
