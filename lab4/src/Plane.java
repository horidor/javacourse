public class Plane {
    //plane id
    private int id;

    //plane model
    private String model;

    // plane status (in flight, on standby, preparing for flight, on repair etc.)
    private String status;

    // total flight hours
    private float totalFlightHours;

    //plane average fuel consumption (kilogram/kilometre)
    private float averageFuelConsumptionPerKM;

    //fuel capacity in tonnes
    private float fuelCapacity;

    // number of first/business/economy class seats
    private int firstClassCapacity;
    private int businessClassCapacity;
    private int economyClassCapacity;


    public String showData() {
        return String.format("""
                Report:
                ID: %d, model - %s;
                
                status - %s;
                
                Total flight hours: %f;
                Average fuel consumption (kg/km): %f;
                Fuel capacity (t): %f;
                
                First class passenger seats: %d,
                
                Business class passenger seats: %d,
                
                Economy class passenger seats: %d,
                
                End report
                
                """, id, model, status, totalFlightHours, averageFuelConsumptionPerKM, fuelCapacity,
                firstClassCapacity, businessClassCapacity, economyClassCapacity);
    }

    public float getAverageFuelConsumptionPerHour() {
        return averageFuelConsumptionPerKM;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    //Plane constructor
    public Plane(int id, String model, String status, float totalFlightHours,
                 float averageFuelConsumptionPerKM, float fuelCapacity, int firstClassCapacity, int businessClassCapacity,
                 int economyClassCapacity) {

        this.id = id;
        this.model = model;
        this.status = status;
        this.totalFlightHours = totalFlightHours;
        this.averageFuelConsumptionPerKM = averageFuelConsumptionPerKM;
        this.fuelCapacity = fuelCapacity;
        this.firstClassCapacity = firstClassCapacity;
        this.businessClassCapacity = businessClassCapacity;
        this.economyClassCapacity = economyClassCapacity;

    }
}
