package entity;

public class Pilots {

    private int id;
    private String name;
    private String lastName;
    private Rank pilotRank;
    private String pilotCode;

    public Pilots(int id, String name, String lastName, Rank pilotRank, String pilotCode) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pilotRank = pilotRank;
        this.pilotCode = pilotCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Rank getPilotRank() {
        return pilotRank;
    }

    public void setPilotRank(Rank pilotRank) {
        this.pilotRank = pilotRank;
    }

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    @Override
    public String toString() {
        return "Pilots{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Last_Name='" + lastName + '\'' +
                ", Pilot_Rank=" + pilotRank +
                ", Pilot_Code='" + pilotCode + '\'' +
                '}';
    }}
