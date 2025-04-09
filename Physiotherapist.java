import java.util.List;

public class Physiotherapist {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String[] expertise; // Array of expertise areas
    private List<Treatment> timetable;

    public Physiotherapist(int id, String name, String address, String phone, String[] expertise, List<Treatment> timetable) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.expertise = expertise;
        this.timetable = timetable;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String[] getExpertise() { return expertise; }
    public void setExpertise(String[] expertise) { this.expertise = expertise; }

    public List<Treatment> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Treatment> timetable) {
        this.timetable = timetable;
    }
}
