import java.util.HashMap;
import java.util.Map;

public class Operator {

    public String PLUS = "plus";
    public String MINUS = "minus";
    public String MULTIPLY = "multiply";
    public String DIVISION = "division";

    Map<String, String> operators = new HashMap<>();
    Map<String, Integer> operatorPriority = new HashMap<>();

    public Operator() {
        operators.put(",", PLUS);
        operatorPriority.put(",", 1);
    }

    public Operator(Map<String, String> inputOperators) {
        for (String s : inputOperators.keySet()) {
            switch (operators.get(s).toLowerCase()) {
                case "plus":
                    operators.put(s, PLUS);
                    operatorPriority.put(s, 1);
                    break;
                case "minus":
                    operators.put(s, MINUS);
                    operatorPriority.put(s, 1);
                    break;
                case "multiply":
                    operators.put(s, MULTIPLY);
                    operatorPriority.put(s, 2);
                    break;
                case "division":
                    operators.put(s, DIVISION);
                    operatorPriority.put(s, 2);
                    break;
            }
        }
    }

    public Map<String, String> getOperators() {
        return operators;
    }

    public void setOperators(Map<String, String> operators) {
        this.operators = operators;
    }

    public Map<String, Integer> getOperatorPriority() {
        return operatorPriority;
    }

    public void setOperatorPriority(Map<String, Integer> operatorPriority) {
        this.operatorPriority = operatorPriority;
    }
}
