import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Plane[] planepark = new Plane[4];

        planepark[0] = new Plane(1, "Rubicon-11", "flying (Madrid - Tokyo)", 421.54f,
                5.01f, 73.4f, 230, 210, 254);

        planepark[1] = new Plane(2, "Goverla-56", "flying (Kiev - New York)", 104.23f,
                4.83f, 79.4f, 240, 252, 232);

        planepark[2] = new Plane(3, "Boeing 767-200ER", "waiting for passengers in BER (departing on 18:00 CET)",
                            1004.54f, 4.93f, 79.4f, 245, 214, 174);

        planepark[3] = new Plane (4, "Atlanta-233", "on repair", 543.f, 5.43f, 80.3f,
                                    393, 305, 310);

        Comparator<Plane> fuelCapacityAscending = Comparator.comparing(Plane::getFuelCapacity);
        Comparator<Plane> fuelConsumpDesced = Comparator.comparing(Plane::getAverageFuelConsumptionPerHour);


        System.out.print("""
                    ----------------------------------------------------
                    ascending order - fuel capacity
                    ----------------------------------------------------
                    """);
        Arrays.sort(planepark, fuelCapacityAscending);

        for (Plane plane: planepark) {

            System.out.print(plane.showData());
        }

        System.out.print("""
                    ----------------------------------------------------
                    descending order - fuel consumption
                    ----------------------------------------------------
                    """);
        Arrays.sort(planepark, fuelConsumpDesced);

        for (Plane plane: planepark) {

            System.out.print(plane.showData());
        }

    }
}