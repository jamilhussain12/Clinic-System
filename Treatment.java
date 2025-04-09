public class Treatment {
    private String name;
    private String dateTime;
    private Physiotherapist physiotherapist;

    public Treatment(String name, String dateTime, Physiotherapist physiotherapist) {
        this.name = name;
        this.dateTime = dateTime;
        this.physiotherapist = physiotherapist;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    public Physiotherapist getPhysiotherapist() { return physiotherapist; }
    public void setPhysiotherapist(Physiotherapist physiotherapist) { this.physiotherapist = physiotherapist; }

}
