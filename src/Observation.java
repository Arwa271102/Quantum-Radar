public class Observation {

    private String plateNumber;
    private String date;
    private CarType carType;
    private int speed;
    private boolean seatbelt;

    public Observation(String plateNumber, String date, CarType carType, int speed, boolean seatbelt) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbelt = seatbelt;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getDate() {
        return date;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isSeatbelt() {
        return seatbelt;
    }
}