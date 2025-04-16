public class AppointmentBooking {
    private static int bookingIdCounter = 1; 
    private String bookingId;
    private Patient patient;
    private Treatment treatment;
    private String status; 

    public AppointmentBooking(Patient patient, Treatment treatment, String status) {
        this.bookingId = "B#" + String.format("%03d", bookingIdCounter++);  
        this.patient = patient;
        this.treatment = treatment;
        this.status = status;
    }

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

    public void cancelBooking() {
        this.status = "cancelled";
    }

    public boolean changeBooking(Treatment newTreatment) {
        if (newTreatment != null) {
            this.treatment = newTreatment;
            this.status = "booked"; 
            return true;
        }
        return false; 
    }
}
