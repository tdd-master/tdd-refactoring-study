import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixCalculator implements Calculator {

    Operator operator;

    public PostfixCalculator() {
        operator = new OperatorImpl();
    }

    public PostfixCalculator(Operator customOperator) {
        operator = customOperator;
    }

    @Override
    public int calculate(String input) {

        List<String> postfix = infixToPostfix(input);
        if (postfix.size() == 1) {
            return Integer.parseInt(postfix.get(0));
        }

        Stack<Integer> operandStack = new Stack<>();
        postfix.forEach(elements -> {
            if (isOperator(elements)) {
                calculateAndPushOperandStack(operandStack, elements);
            } else {
                operandStack.push(Integer.parseInt(elements));
            }
        });

        return operandStack.pop();
    }

    private void calculateAndPushOperandStack(Stack<Integer> operandStack, String operatorSign) {
        String operatorString = operator.getOperator(operatorSign);
        int operand_2 = operandStack.pop();
        int operand_1 = operandStack.pop();

        if (operator.ADDITION.equals(operatorString)) {
            operandStack.push(operand_1 + operand_2);
        } else if (operator.SUBTRACTION.equals(operatorString)) {
            operandStack.push(operand_1 - operand_2);
        } else if (operator.MULTIPLICATION.equals(operatorString)) {
            operandStack.push(operand_1 * operand_2);
        } else if (operator.DIVISION.equals(operatorString)) {
            operandStack.push(Math.round(operand_1 / operand_2));
        }
    }

    public List<String> infixToPostfix(String infix) {

        List<String> postfix = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        Stack<String> operatorStack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (isOperator(Character.toString(c))) {
                String operatorSign = Character.toString(c);
                if (sb.length() > 0) {
                    postfix.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                pushOperatorStack(postfix, operatorStack, operatorSign);
            } else {
                sb.append(c);
            }
        }

        postfix.add(sb.toString());
        while (!operatorStack.empty()) {
            postfix.add(operatorStack.pop());
        }

        return postfix;
    }

    private void pushOperatorStack(List<String> postfix, Stack<String> operatorStack, String operatorSign) {
        if (operatorStack.empty()) {
            operatorStack.push(operatorSign);
        } else if (operator.getPriority(operator.getOperator(operatorSign)) > operator.getPriority(operator.getOperator(operatorStack.peek()))) {
            operatorStack.push(operatorSign);
        } else {
            postfix.add(operatorStack.pop());
            operatorStack.push(operatorSign);
        }
    }

    private boolean isOperator(String s) {
        return operator.getOperatorMap().keySet().contains(s);
    }

}
