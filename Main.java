import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentController appointmentManager = new AppointmentController();

        
        List<Treatment> schedule1 = new ArrayList<>();
        Physiotherapist therapist1 = new Physiotherapist(1, "Dr. Mira Patel", "101 Wellness Blvd", "555-1111",
                new String[]{"Postural Correction", "Spinal Therapy"}, schedule1);
        schedule1.add(new Treatment("Cervical Release", "Monday 8-9 AM", therapist1));
        schedule1.add(new Treatment("Lower Back Strengthening", "Wednesday 11-12 PM", therapist1));
        schedule1.add(new Treatment("Postural Alignment", "Friday 10-11 AM", therapist1));

        List<Treatment> schedule2 = new ArrayList<>();
        Physiotherapist therapist2 = new Physiotherapist(2, "Dr. Leo Kim", "202 Care Circle", "555-2222",
                new String[]{"Neuromuscular Therapy", "Sports Rehab"}, schedule2);
        schedule2.add(new Treatment("Trigger Point Release", "Tuesday 9-10 AM", therapist2));
        schedule2.add(new Treatment("Rehab Conditioning", "Thursday 12-1 PM", therapist2));
        schedule2.add(new Treatment("Mobility Enhancement", "Saturday 2-3 PM", therapist2));

        List<Treatment> schedule3 = new ArrayList<>();
        Physiotherapist therapist3 = new Physiotherapist(3, "Dr. Alina Chow", "303 Vitality Way", "555-3333",
                new String[]{"Orthopaedics", "Joint Therapy"}, schedule3);
        schedule3.add(new Treatment("Joint Mobilization", "Monday 2-3 PM", therapist3));
        schedule3.add(new Treatment("Knee Recovery", "Wednesday 3-4 PM", therapist3));
        schedule3.add(new Treatment("Post-Fracture Care", "Friday 1-2 PM", therapist3));

        List<Physiotherapist> therapists = Arrays.asList(therapist1, therapist2, therapist3);

        appointmentManager.addPatient(new Patient("Noah Clark", "700 Ivy St", "555-4444"));
        appointmentManager.addPatient(new Patient("Luna Adams", "800 Spruce Ln", "555-5555"));
        appointmentManager.addPatient(new Patient("Ethan Cooper", "900 Ash Ave", "555-6666"));
        appointmentManager.addPatient(new Patient("Zara Lin", "123 Pearl Rd", "555-7777"));
        appointmentManager.addPatient(new Patient("Mason Reed", "456 Opal Dr", "555-8888"));
        appointmentManager.addPatient(new Patient("Isla Shaw", "789 Jade Pl", "555-9999"));
        appointmentManager.addPatient(new Patient("Logan Wu", "321 Coral St", "555-0000"));
        appointmentManager.addPatient(new Patient("Aria Bell", "654 Quartz Ln", "555-1010"));
        appointmentManager.addPatient(new Patient("Caleb Ross", "987 Ruby Ave", "555-2020"));
        appointmentManager.addPatient(new Patient("Mila Ray", "741 Topaz St", "555-3030"));
        appointmentManager.addPatient(new Patient("Jude Kim", "852 Garnet Rd", "555-4040"));
        appointmentManager.addPatient(new Patient("Nina Fox", "963 Sapphire Ct", "555-5050"));

        appointmentManager.bookAppointment(new AppointmentBooking(appointmentManager.getPatients().get(1), schedule2.get(1), "booked"));
        appointmentManager.bookAppointment(new AppointmentBooking(appointmentManager.getPatients().get(2), schedule2.get(2), "booked"));
        appointmentManager.bookAppointment(new AppointmentBooking(appointmentManager.getPatients().get(0), schedule1.get(0), "booked"));
        appointmentManager.bookAppointment(new AppointmentBooking(appointmentManager.getPatients().get(3), schedule3.get(1), "booked"));
        appointmentManager.bookAppointment(new AppointmentBooking(appointmentManager.getPatients().get(4), schedule1.get(1), "booked"));
        appointmentManager.bookAppointment(new AppointmentBooking(appointmentManager.getPatients().get(5), schedule2.get(0), "booked"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Physiotherapy Booking System ===");
            System.out.println("1. List all patients");
            System.out.println("2. List all bookings");
            System.out.println("3. List all physiotherapists");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.println("=== Patients ===");
                    appointmentManager.getPatients().forEach(p -> System.out.println(p.getId() + ": " + p.getName()));
                }
                case 2 -> {
                    System.out.println("=== Bookings ===");

                    for (Physiotherapist physiotherapist : therapists) {
                        System.out.println("\nPhysiotherapist: " + physiotherapist.getName());
                        for (Treatment treatment : physiotherapist.getTimetable()) {
                            String status = "No patient";  // Default to "No patient"
                            String patientName = "";

                            for (AppointmentBooking booking : appointmentManager.getBookings()) {
                                if (booking.getTreatment().equals(treatment)) {
                                    patientName = booking.getPatient().getName();
                                    status = "booked";
                                    break;
                                }
                            }

                            System.out.println(treatment.getName() + " - " + treatment.getDateTime() 
                                + " - " + status + (status.equals("booked") ? " (Patient: " + patientName + ")" : ""));
                        }
                    }
                    break;
                }

                case 3 -> {
                    System.out.println("=== Physiotherapists ===");
                    therapists.forEach(t ->
                            System.out.println(t.getId() + ": " + t.getName() + ", Specialties: " + String.join(", ", t.getExpertise())));
                }
                
        scanner.close();
    }
}
