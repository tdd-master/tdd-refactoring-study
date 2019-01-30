import java.util.HashMap;
import java.util.Map;

public class OperatorImpl implements Operator {

//    public String ADDITION = "ADDITION";
//    public String SUBTRACTION = "SUBTRACTION";
//    public String MULTIPLICATION = "MULTIPLICATION";
//    public String DIVISION = "DIVISION";

    int ADDITION_PRIORITY = 1;
    int SUBTRACTION_PRIORITY = 1;
    int MULTIPLICATION_PRIORITY = 2;
    int DIVISION_PRIORITY = 2;

    Map<String, String> operator = new HashMap<>();
    Map<String, Integer> priority = new HashMap<>();

    public OperatorImpl() {
        operator.put(",", ADDITION);
        priority.put(ADDITION, ADDITION_PRIORITY);
    }

    public OperatorImpl(Map<String, String> inputOperators) {
        inputOperators.forEach((k, v) -> {
            if (ADDITION.equals(v.toUpperCase())) {
                operator.put(k, ADDITION);
                priority.put(ADDITION, ADDITION_PRIORITY);
            } else if (SUBTRACTION.equals(v.toUpperCase())) {
                operator.put(k, SUBTRACTION);
                priority.put(SUBTRACTION, SUBTRACTION_PRIORITY);
            } else if (MULTIPLICATION.equals(v.toUpperCase())) {
                operator.put(k, MULTIPLICATION);
                priority.put(MULTIPLICATION, MULTIPLICATION_PRIORITY);
            } else if (DIVISION.equals(v.toUpperCase())) {
                operator.put(k, DIVISION);
                priority.put(DIVISION, DIVISION_PRIORITY);
            } else {
                throw new IllegalArgumentException();
            }
        });

    }

    public Map<String, String> getOperator() {
        return operator;
    }

    public void setOperator(Map<String, String> operator) {
        this.operator = operator;
    }

    public Map<String, Integer> getPriority() {
        return priority;
    }

    public void setPriority(Map<String, Integer> priority) {
        this.priority = priority;
    }

}
