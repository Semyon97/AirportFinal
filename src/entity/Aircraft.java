package entity;

public class Aircraft {

    private int Id;
    private String brand;
    private String model;
    private int passengerCapacity;
    private int tailNumber;

    public Aircraft(int id, String brand, String model, int passengerCapacity, int tailNumber) {
        Id = id;
        this.brand = brand;
        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.tailNumber = tailNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public int getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(int tailNumber) {
        this.tailNumber = tailNumber;
    }

    @Override
    public String toString() {
        return "aircraft{" +
                "id=" + Id+
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", passenger_capacity=" + passengerCapacity +
                ", tail_number=" + tailNumber +
                '}';
    }
}
