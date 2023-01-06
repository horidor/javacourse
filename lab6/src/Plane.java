public class Plane {
    private int id;

    private String model;

    private float flightDistance;

    private float fuelConsumptionPerKm;

    private float weightCapacity;

    private int passengerCapacity;
    public Plane(int id, String model, float flightDistance, float weightCapacity, int passengerCapacity,
                 float fuelConsumptionPerKm) {
        this.id = id;
        this.model = model;
        this.flightDistance = flightDistance;
        this.weightCapacity = weightCapacity;
        this.passengerCapacity = passengerCapacity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public float getFlightDistance() {
        return flightDistance;
    }

    public float getWeightCapacity() {
        return weightCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public float getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }


    public String showInfo() {
        return String.format("""
                Report:
                
                Plane id: %d, model: %s;
                
                Flight distance (in km): %f;
                
                Weight capacity (in km): %f;
                
                Passenger capacity: %d;
                
                Fuel consumption (kg/km): %f.
                
                End report
                
                
                """, id, model, flightDistance, weightCapacity, passengerCapacity, fuelConsumptionPerKm);
    }
}

