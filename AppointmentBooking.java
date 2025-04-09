public class AppointmentBooking {
    private String bookingId;
    private Patient patient;
    private Treatment treatment;
    private String status; 

    public AppointmentBooking(String bookingId, Patient patient, Treatment treatment, String status) {
        this.bookingId = bookingId;
        this.patient = patient;
        this.treatment = treatment;
        this.status = status;
    }

    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Treatment getTreatment() {
        return treatment;
    }
    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
