import java.util.*;
import java.util.stream.Collectors;

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
        // appointmentManager.bookAppointment(new AppointmentBooking(appointmentManager.getPatients().get(5), schedule2.get(0), "booked"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Physiotherapy Booking System ===");
            System.out.println("1. List all patients");
            System.out.println("2. List all bookings");
            System.out.println("3. List all physiotherapists");
            System.out.println("4. Add patient");
            System.out.println("5. Remove patient");
            System.out.println("6. Book appointment");
            System.out.println("7. Cancel booking");
            System.out.println("8. Attend appointment");
            System.out.println("9. Change booking");
            System.out.println("10. Print report");
            System.out.println("11. Exit");
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
                case 4 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    Patient newPatient = new Patient(name, address, phone);
                    appointmentManager.addPatient(newPatient);
                    System.out.println("Patient added.");
                }
                case 5 -> {
                    System.out.print("Enter patient ID to remove: ");
                    int id = scanner.nextInt();
                    appointmentManager.removePatientById(id);
                    System.out.println("Patient removed.");
                }

                
                case 6 -> {
                        System.out.print("Enter patient ID: ");
                        int pid = scanner.nextInt();
                        scanner.nextLine();
                    
                        Patient p = appointmentManager.getPatients().stream()
                            .filter(x -> x.getId() == pid)
                            .findFirst()
                            .orElse(null);
                    
                        if (p == null) {
                            System.out.println("Patient not found.");
                            break;
                        }
                    
                        System.out.print("Book by (1) Expertise or (2) Physiotherapist Name? Enter 1 or 2: ");
                        int choice2 = scanner.nextInt();
                        scanner.nextLine(); 
                    
                        List<Treatment> availableTreatments = new ArrayList<>();
                        int tIndex = 1;
                    
                        if (choice2 == 1) {
                            Set<String> expertiseSet = therapists.stream()
                                .flatMap(t -> Arrays.stream(t.getExpertise()))
                                .collect(Collectors.toSet());
                    
                            System.out.println("Available Expertise:");
                            expertiseSet.forEach(System.out::println);
                    
                            System.out.print("Enter expertise: ");
                            String selectedExpertise = scanner.nextLine().trim();
                    
                            for (Physiotherapist physio : therapists) {
                                if (Arrays.asList(physio.getExpertise()).contains(selectedExpertise)) {
                                    for (Treatment tr : physio.getTimetable()) {
                                        if (appointmentManager.isTreatmentAvailable(tr)) {
                                            System.out.println(tIndex++ + ". " + tr.getName() + " - " + tr.getDateTime() + " (Physio: " + physio.getName() + ")");
                                            availableTreatments.add(tr);
                                        }
                                    }
                                }
                            }
                    
                        } else if (choice2 == 2) {
                            System.out.println("Available Physiotherapists:");
                            therapists.forEach(t -> System.out.println("- " + t.getName()));
                    
                            System.out.print("Enter physiotherapist name: ");
                            String physioName = scanner.nextLine().trim();
                    
                            Physiotherapist selected = therapists.stream()
                                .filter(t -> t.getName().equalsIgnoreCase(physioName))
                                .findFirst()
                                .orElse(null);
                    
                            if (selected == null) {
                                System.out.println("Physiotherapist not found.");
                                break;
                            }
                    
                            for (Treatment tr : selected.getTimetable()) {
                                if (appointmentManager.isTreatmentAvailable(tr)) {
                                    System.out.println(tIndex++ + ". " + tr.getName() + " - " + tr.getDateTime());
                                    availableTreatments.add(tr);
                                }
                            }
                    
                        } else {
                            System.out.println("Invalid choice.");
                            break;
                        }
                    
                        if (availableTreatments.isEmpty()) {
                            System.out.println("No available treatments.");
                            break;
                        }
                    
                        System.out.print("Choose treatment number: ");
                        int tidx = scanner.nextInt() - 1;
                        scanner.nextLine(); 
                    
                        if (tidx < 0 || tidx >= availableTreatments.size()) {
                            System.out.println("Invalid treatment.");
                            break;
                        }
                    
                        Treatment tr = availableTreatments.get(tidx);
                        AppointmentBooking booking = new AppointmentBooking(p, tr, "booked");
                        appointmentManager.bookAppointment(booking);
                        System.out.println("Appointment booked.");
                }
                    
                case 7 -> {
                    System.out.print("Enter booking ID to cancel: ");
                    String bid = scanner.nextLine();
                    if (appointmentManager.cancelBooking(bid))
                        System.out.println("Booking canceled.");
                    else
                        System.out.println("Booking not found or already canceled.");
                }
                case 8 -> {
                    System.out.print("Enter booking ID to mark attended: ");
                    String bid = scanner.nextLine();
                    appointmentManager.attendAppointment(bid);
                    System.out.println("Marked as attended.");
                }
                case 9 -> {
                        System.out.print("Enter booking ID to change: ");
                        String bid = scanner.nextLine();
                        System.out.println("Choose new available treatment:");
                    
                        List<Treatment> allAvailableTreatments = new ArrayList<>();
                        int tIndex = 1;
                    
                        for (Physiotherapist t : therapists) {
                            for (Treatment tr : t.getTimetable()) {
                                if (appointmentManager.isTreatmentAvailable(tr)) {
                                    System.out.println(tIndex + ". " + tr.getName() + " - " + tr.getDateTime());
                                    allAvailableTreatments.add(tr);
                                    tIndex++;
                                } 
                            }
                        }
                    
                        if (allAvailableTreatments.isEmpty()) {
                            System.out.println("No available treatments at the moment.");
                            break;
                        }
                    
                        int idx = scanner.nextInt() - 1;
                        scanner.nextLine(); 
                        if (idx >= 0 && idx < allAvailableTreatments.size()) {
                            appointmentManager.changeBooking(bid, allAvailableTreatments.get(idx));
                            System.out.println("Booking changed.");
                        } else {
                            System.out.println("Invalid treatment.");
                        }
                    }
                    
                case 10 -> appointmentManager.printReport();
                case 11 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
