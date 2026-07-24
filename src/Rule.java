public class Rule {

    private String ruleName;
    private CarType carType;
    private int maxSpeed;
    private int fineAmount;
    private boolean seatbeltRule;

    public Rule(String ruleName, CarType carType, int maxSpeed, int fineAmount, boolean seatbeltRule) {
        this.ruleName = ruleName;
        this.carType = carType;
        this.maxSpeed = maxSpeed;
        this.fineAmount = fineAmount;
        this.seatbeltRule = seatbeltRule;
    }

    public Violation check(Observation observation) {

        if (seatbeltRule) {

            if (!observation.isSeatbelt()) {
                return new Violation(
                        ruleName,
                        "Seatbelt not fastened",
                        fineAmount
                );
            }

        } else {

            if (observation.getCarType() == carType &&
                    observation.getSpeed() > maxSpeed) {

                return new Violation(
                        ruleName,
                        "speed of " + observation.getSpeed()
                                + " exceeded max allowed " + maxSpeed,
                        fineAmount
                );
            }
        }

        return null;
    }
}