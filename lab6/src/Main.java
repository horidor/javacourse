public class Main {
    public static void main(String[] args) {
        Plane[] planes = new Plane[4];

        planes[0] = new CargoPlane(1, "Litak-11", 8040.500f, 200000.0f,40,
                5.6f);

        planes[1] = new PassengerPlane(2, "Napoleon-4552312", 5043.52f,150000.5f,
                800, 5.1f);

        planes[2] = new CargoPlane(3, "Litak-21", 8540.600f, 240550.325f, 50, 5.5f);

        planes[3] = new CommuterPlane(4, "TheCommuter-1", 396.2f, 6575.2f, 20, 0.9f);

        Airline superairline = new Airline(planes);

        System.out.print(superairline.showPlaneParkData());

        float overallWeightCapacity = superairline.getOverallWeightCapacity();
        System.out.format("Overall weight capacity - %f\n", overallWeightCapacity);

        float overallPassengerCapacity = superairline.getOverallPassengerCapacity();
        System.out.format("Overall weight capacity - %f\n", overallPassengerCapacity);

        System.out.print("""
                
                
                Sorting by flight distance in ascending order
                
                """);
        superairline.sortByFlightDistance(true);

        System.out.print(superairline.showPlaneParkData());

        System.out.println("""
                
                Sorting by flight distance in descending order
                
                """);
        superairline.sortByFlightDistance(false);

        System.out.print(superairline.showPlaneParkData());

        System.out.println("Finding planes by fuel consumption in range from 5 to 5.5");

        Plane[] planesInRange = superairline.findSelectRangeOfFuelConsumption(5.0f, 5.5f).toArray(new Plane[0]);

        System.out.println("Planes found: \n");
        for (Plane plane: planesInRange) {
            System.out.print(plane.showInfo());
        }

    }
}