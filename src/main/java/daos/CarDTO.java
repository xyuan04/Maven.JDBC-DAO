package daos;

public class CarDTO extends DTOClass {
    private Integer id;
    private String make;
    private String model;
    private Integer year;
    private String color;
    private Integer vin;

    public CarDTO() {}

    public CarDTO(String make, String model, Integer year, String color, Integer vin) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    public CarDTO(Integer id, String make, String model, Integer year, String color, Integer vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    public int getID() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(Integer vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return String.format("Make:\t\t\t\t\tModel:\t\t\t\t\tYear:\t\t\t\t\tColor:\t\t\t\t\tVin:\n%s\t\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t\t%s\n", this.make, this.model, this.year, this.color, this.vin);
    }
}
