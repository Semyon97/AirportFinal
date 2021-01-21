package entity;

public class Flights {

    private int id;
    private int aircraft;
    private int pilot;
    private String data;
    private String time;
    private int flightNumber;

    public Flights(int id, int aircraft, int pilot, String data, String time, int flightNumber) {
        this.id = id;
        this.aircraft = aircraft;
        this.pilot = pilot;
        this.data = data;
        this.time = time;
        this.flightNumber = flightNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAircraft() {
        return aircraft;
    }

    public void setAircraft(int aircraft) {
        this.aircraft = aircraft;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", aircraft=" + aircraft +
                ", pilot=" + pilot +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                ", flight_number=" + flightNumber +
                '}';
    }
}

