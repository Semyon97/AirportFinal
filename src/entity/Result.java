package entity;

public class Result {

    private String flightNumber;
    private String data;
    private String time;
    private int tailNumber;
    private String brand;
    private String model;
    private int passengerCapacity;
    private String name;
    private String lastName;
    private String pilotCode;
    private Rank pRank;

    public Result(String flightNumber, String data, String time, int tailNumber, String brand, String model, int passengerCapacity, String name, String lastName, String pilotCode, Rank pRank) {
        this.flightNumber = flightNumber;
        this.data = data;
        this.time = time;
        this.tailNumber = tailNumber;
        this.brand = brand;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.name = name;
        this.lastName = lastName;
        this.pilotCode = pilotCode;
        this.pRank = pRank;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public int getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(int tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
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

    public String getPilotCode() {
        return pilotCode;
    }

    public void setPilotCode(String pilotCode) {
        this.pilotCode = pilotCode;
    }

    public Rank getpRank() {
        return pRank;
    }

    public void setpRank(Rank pRank) {
        this.pRank = pRank;
    }

    @Override
    public String toString() {
        return "Result{" +
                ", flightNumber='" + flightNumber + '\'' +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                ", tailNumber=" + tailNumber +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pilotCode='" + pilotCode + '\'' +
                ", rank='" + pRank + '\'' +
                '}';
    }
}
