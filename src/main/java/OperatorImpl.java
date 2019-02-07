import java.util.HashMap;
import java.util.Map;

public class OperatorImpl implements Operator {

    Map<String, String> operatorMap = new HashMap<>();
    Map<String, Integer> priorityMap = new HashMap<>();

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
        operatorMap.put(operatorSign, operatorString);
        priorityMap.put(operatorString, operatorPriority);
    }

    @Override
    public Map<String, String> getOperatorMap() {
        return operatorMap;
    }

    public void setOperatorMap(Map<String, String> operatorMap) {
        this.operatorMap = operatorMap;
    }

    @Override
    public Map<String, Integer> getPriorityMap() {
        return priorityMap;
    }

    public void setPriorityMap(Map<String, Integer> priorityMap) {
        this.priorityMap = priorityMap;
    }

    @Override
    public String getOperator(String operatorSign) {
        return this.operatorMap.get(operatorSign);
    }

    @Override
    public int getPriority(String operatorString) {
        return this.priorityMap.get(operatorString);
    }

}
