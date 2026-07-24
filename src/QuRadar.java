import java.util.ArrayList;
import java.util.HashMap;

public class QuRadar {

    private ArrayList<Rule> rules;
    private ArrayList<Fine> fines;

    public QuRadar() {
        rules = new ArrayList<>();
        fines = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void observe(Observation observation) {

        Fine fine = new Fine(observation.getPlateNumber());

        for (Rule rule : rules) {

            Violation violation = rule.check(observation);

            if (violation != null) {
                fine.addViolation(violation);
            }
        }

        if (!fine.getViolations().isEmpty()) {
            fines.add(fine);
            fine.printFine();
        }
    }

    public void getAllPossibleFines() {

        for (Fine fine : fines) {
            System.out.println(
                    fine.getPlateNumber()
                            + " : "
                            + fine.getTotalAmount()
                            + " EGP"
            );
        }
    }

    public void getAllViolatedRules() {

        HashMap<String, Integer> rulesCount = new HashMap<>();

        for (Fine fine : fines) {

            for (Violation violation : fine.getViolations()) {

                String rule = violation.getRuleName();

                if (rulesCount.containsKey(rule)) {
                    rulesCount.put(rule, rulesCount.get(rule) + 1);
                } else {
                    rulesCount.put(rule, 1);
                }
            }
        }

        for (String rule : rulesCount.keySet()) {
            System.out.println(rule + " : " + rulesCount.get(rule));
        }
    }
}