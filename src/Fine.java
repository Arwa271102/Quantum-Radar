import java.util.ArrayList;

public class Fine {
    private String plateNumber;
    private ArrayList<Violation> violations;
    public Fine(String plateNumber) {
        this.plateNumber = plateNumber;
        violations = new ArrayList<>();
    }

    public void addViolation(Violation violation) {
        violations.add(violation);
    }

    public ArrayList<Violation> getViolations() {
        return violations;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getTotalAmount() {
        int total = 0;
        for (Violation violation : violations) {
            total += violation.getFee();
        }
        return total;
    }

    public void printFine() {
        System.out.println("Traffic for car " + plateNumber);
        System.out.println("Total amount: " + getTotalAmount() + " EGP");
        System.out.println("Violations:");
        for (Violation violation : violations) {
            System.out.println("- " + violation.getDescription()
                    + " : " + violation.getFee() + " EGP");
        }
        System.out.println();
    }
}