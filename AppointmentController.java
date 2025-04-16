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
    public void attendAppointment(String bookingId) {
        for (AppointmentBooking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                booking.setStatus("attended");
                System.out.println("Booking " + bookingId + " has been marked as attended.");
                return;
            }
        }
        System.out.println("Booking ID " + bookingId + " not found.");
    }
    
    

    public boolean isTreatmentAvailable(Treatment treatment) {
        for (AppointmentBooking booking : bookings) {
            if (booking.getTreatment().equals(treatment) && "booked".equalsIgnoreCase(booking.getStatus())) {
                return false; 
            }
        }
        return true; 
    }

    public boolean changeBooking(String bookingId, Treatment newTreatment) {
        for (AppointmentBooking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking.changeBooking(newTreatment);
            }
        }
        return false;
    }

    public void printReport() {
        Map<Physiotherapist, Integer> physiotherapistAttendance = new HashMap<>();
    
        System.out.println("=======================================================");
        System.out.println("             TREATMENT REPORT SUMMARY");
        System.out.println("=======================================================\n");
    
        if (bookings.isEmpty()) {
            System.out.println("No treatment records found.\n");
            return;
        }
    
        for (AppointmentBooking booking : bookings) {
            Physiotherapist physio = booking.getTreatment().getPhysiotherapist();
            String patient = booking.getPatient().getName();
            String treatment = booking.getTreatment().getName();
            String time = booking.getTreatment().getDateTime();
            String status = booking.getStatus();
            String bookingId = booking.getBookingId();
    
            System.out.println("Booking [" + bookingId + "]: On " + time + ", " + patient + " was scheduled for '" +
                    treatment + "' with Physiotherapist " + physio.getName() + ". Status: " + status + ".");
    
            if ("attended".equalsIgnoreCase(status)) {
                physiotherapistAttendance.put(physio, physiotherapistAttendance.getOrDefault(physio, 0) + 1);
            }
        }
    
        System.out.println("\n-------------------------------------------------------");
        System.out.println("             PHYSIOTHERAPIST ATTENDANCE");
        System.out.println("-------------------------------------------------------");
    
        if (physiotherapistAttendance.isEmpty()) {
            System.out.println("No appointments were marked as 'attended'.");
        } else {
            List<Map.Entry<Physiotherapist, Integer>> sorted = new ArrayList<>(physiotherapistAttendance.entrySet());
            sorted.sort((a, b) -> b.getValue() - a.getValue());
    
            for (Map.Entry<Physiotherapist, Integer> entry : sorted) {
                String physioName = entry.getKey().getName();
                int count = entry.getValue();
                System.out.println(physioName + " attended to " + count + " patient(s).");
            }
        }
    
        System.out.println("\n=======================================================\n");
    }
    
}
