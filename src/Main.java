public class Main {

    public static void main(String[] args) {
        QuRadar radar = new QuRadar();

        // Add Rules
        radar.addRule(new Rule(
                "Seatbelt",
                null,
                0,
                100,
                true));

        radar.addRule(new Rule(
                "Truck Speed",
                CarType.TRUCK,
                60,
                300,
                false));

        radar.addRule(new Rule(
                "Private Speed",
                CarType.PRIVATE,
                80,
                300,
                false));

        // Observations
        Observation car1 = new Observation(
                "ABC1234",
                "22/07/2026",
                CarType.PRIVATE,
                94,
                false);

        Observation car2 = new Observation(
                "XYZ9999",
                "22/07/2026",
                CarType.TRUCK,
                55,
                true);

        Observation car3 = new Observation(
                "TRK1111",
                "22/07/2026",
                CarType.TRUCK,
                70,
                false);

        radar.observe(car1);
        radar.observe(car2);
        radar.observe(car3);

        System.out.println();

        System.out.println("All Fines:");
        radar.getAllPossibleFines();

        System.out.println();

        System.out.println("Violated Rules:");
        radar.getAllViolatedRules();
    }
}