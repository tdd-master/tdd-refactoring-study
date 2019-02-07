import java.util.Map;

public interface Operator {

    String ADDITION = "ADDITION";
    String SUBTRACTION = "SUBTRACTION";
    String MULTIPLICATION = "MULTIPLICATION";
    String DIVISION = "DIVISION";

    int ADDITION_PRIORITY = 1;
    int SUBTRACTION_PRIORITY = 1;
    int MULTIPLICATION_PRIORITY = 2;
    int DIVISION_PRIORITY = 2;

    Map<String, String> getOperator();

    Map<String, Integer> getPriority();

}
