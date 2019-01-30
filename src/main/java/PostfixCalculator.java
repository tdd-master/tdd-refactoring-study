import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PostfixCalculator implements Calculator {

    Operator operator;

    public PostfixCalculator() {
        operator = new OperatorImpl();
    }

    public PostfixCalculator(Operator customOperator){
        operator = customOperator;
    }

    @Override
    public int calculate(String input) {

        List<String> postfix = infixToPostfix(input);
        if (postfix.size() == 1) {
            return Integer.parseInt(postfix.get(0));
        }

        Stack<String> operandStack = new Stack<>();
        postfix.forEach(elements -> {

            if (operator.getOperator().keySet().contains(elements)) {
                String nowOperator = operator.getOperator().get(elements);
                int operand_2 = Integer.parseInt(operandStack.pop());
                int operand_1 = Integer.parseInt(operandStack.pop());

                if (operator.ADDITION.equals(nowOperator)) {
                    operandStack.push(Integer.toString(operand_1 + operand_2));
                } else if (operator.SUBTRACTION.equals(nowOperator)) {
                    operandStack.push(Integer.toString(operand_1 - operand_2));
                } else if (operator.MULTIPLICATION.equals(nowOperator)) {
                    operandStack.push(Integer.toString(operand_1 * operand_2));
                } else if (operator.DIVISION.equals(nowOperator)) {
                    operandStack.push(Integer.toString(Math.round(operand_1 / operand_2)));
                }

            } else {
                operandStack.push(elements);
            }


        });

        return Integer.parseInt(operandStack.pop());
    }

    public List<String> infixToPostfix(String infix) {

        List<String> postfix = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        Stack<String> operatorStack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (operator.getOperator().keySet().contains(Character.toString(c))) {
                if (sb.length() > 0) {
                    postfix.add(sb.toString());
                    sb.delete(0, sb.length());
                }

                if (operatorStack.empty()) {
                    operatorStack.push(Character.toString(c));
                } else if (operator.getPriority().get(operator.getOperator().get(Character.toString(c))) > operator.getPriority().get(operator.getOperator().get(operatorStack.peek()))) {
                    operatorStack.push(Character.toString(c));
                } else {
                    postfix.add(operatorStack.pop());
                    operatorStack.push(Character.toString(c));
                }

            } else {
                sb.append(c);
            }
//            System.out.println("Now Character=" + c + ", postfix=" + postfix + ", operatorStack=" + operatorStack);
        }

        postfix.add(sb.toString());
        while (!operatorStack.empty()) {
            postfix.add(operatorStack.pop());
        }
        System.out.println("Postfix" + postfix);
        return postfix;
    }


}
