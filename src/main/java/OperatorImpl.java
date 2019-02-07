import java.util.HashMap;
import java.util.Map;

public class OperatorImpl implements Operator {

    Map<String, String> operator = new HashMap<>();
    Map<String, Integer> priority = new HashMap<>();

    public OperatorImpl() {
        putOperatorMaps(",", ADDITION, ADDITION_PRIORITY);
    }

    public OperatorImpl(Map<String, String> inputOperators) {
        inputOperators.forEach((inputOperatorSign, inputOperatorString) -> {
            if (compareOperatorString(inputOperatorString, ADDITION)) {
                putOperatorMaps(inputOperatorSign, ADDITION, ADDITION_PRIORITY);
            } else if (compareOperatorString(inputOperatorString, SUBTRACTION)) {
                putOperatorMaps(inputOperatorSign, SUBTRACTION, SUBTRACTION_PRIORITY);
            } else if (compareOperatorString(inputOperatorString, MULTIPLICATION)) {
                putOperatorMaps(inputOperatorSign, MULTIPLICATION, MULTIPLICATION_PRIORITY);
            } else if (compareOperatorString(inputOperatorString, DIVISION)) {
                putOperatorMaps(inputOperatorSign, DIVISION, DIVISION_PRIORITY);
            } else {
                throw new IllegalArgumentException();
            }
        });
    }

    private boolean compareOperatorString(String inputOperatorString, String operatorString) {
        return operatorString.equals(inputOperatorString.toUpperCase());
    }

    private void putOperatorMaps(String operatorSign, String operatorString, int operatorPriority) {
        operator.put(operatorSign, operatorString);
        priority.put(operatorString, operatorPriority);
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
