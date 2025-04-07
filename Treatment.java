public class Treatment {
    private String name;
    private String dateTime; // Using String for simplicity, can be replaced with LocalDateTime for better handling
    private Physiotherapist physiotherapist;

    // Constructor
    public Treatment(String name, String dateTime, Physiotherapist physiotherapist) {
        this.name = name;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
    }
}
