public class AppointmentBooking {
    private String bookingId;
    private Patient patient;
    private Treatment treatment;
    private String status; // "booked", "attended", "cancelled"

    // Constructor
    public AppointmentBooking(String bookingId, Patient patient, Treatment treatment, String status) {
        this.bookingId = bookingId;
        this.patient = patient;
        this.treatment = treatment;
        this.status = status;
    }
}
