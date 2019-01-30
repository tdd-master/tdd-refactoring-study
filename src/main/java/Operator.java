import java.util.Map;

public interface Operator {

    String ADDITION = "ADDITION";
    String SUBTRACTION = "SUBTRACTION";
    String MULTIPLICATION = "MULTIPLICATION";
    String DIVISION = "DIVISION";

    Map<String, String> getOperator();

    Map<String, Integer> getPriority();

}
