import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;

public class Airline {
    private Plane[] planepark;

    public Airline(Plane... planepark) {
        this.planepark = planepark;
    }

    public Plane[] getPlanepark() {
        return planepark;
    }

    public float getOverallWeightCapacity() {
        float sum = 0;

        for (Plane plane : planepark) {
            sum += plane.getWeightCapacity();
        }

        return sum;
    }

    public float getOverallPassengerCapacity() {
        float sum = 0;

        for (Plane plane : planepark) {
            sum += plane.getPassengerCapacity();
        }

        return sum;
    }

    public void sortByFlightDistance(boolean ascending) {

        Comparator<Plane> flightDistanceCompare = Comparator.comparing(Plane::getFlightDistance);

        if (!ascending) flightDistanceCompare = flightDistanceCompare.reversed();

        Arrays.sort(planepark, flightDistanceCompare);

    }

    public ArrayList<Plane> findSelectRangeOfFuelConsumption(float first, float second) {
        ArrayList<Plane> inRange = new ArrayList<Plane>();

        if (first > second) return inRange;

        for (Plane plane : planepark) {
            float fuelFind = plane.getFuelConsumptionPerKm();

            if (fuelFind >= first && fuelFind <= second) {
                inRange.add(plane);
            }
        }

        return inRange;
    }

    public String showPlaneParkData() {
        String info = "";
        for (Plane plane: planepark) {
            info += plane.showInfo();
        }
        return info;
    }

}
