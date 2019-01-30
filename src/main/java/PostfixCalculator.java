import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PostfixCalculator implements Calculator {

    Operator operator;

    public PostfixCalculator() {
        operator = new OperatorImpl();
    }

    public PostfixCalculator(Map<String, String> separators) {
        operator = new OperatorImpl(separators);
    }

    @Override
    public int calculate(String input) {

//        List<String> postfixList = infixToPostfix(input);
//
//        if (postfixList.size() < 3) {
//            return Integer.parseInt(postfixList.get(0));
//        }
//
//        Stack<String> postfixStack = new Stack<>();
//
//        for (String s : postfixList) {
//            if (op.getOperators().keySet().contains(s)) {
//                String tmpOp = op.getOperators().get(s);
//                if (op.PLUS.equals(tmpOp)) {
//                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) + Integer.parseInt(postfixStack.pop())));
//                } else if (op.MINUS.equals(tmpOp)) {
//                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) - Integer.parseInt(postfixStack.pop())));
//                } else if (op.MULTIPLY.equals(tmpOp)) {
//                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) * Integer.parseInt(postfixStack.pop())));
//                } else if (op.DIVISION.equals(tmpOp)) { // 나누기는 수정해야 함
//                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) / Integer.parseInt(postfixStack.pop())));
//                }
//            } else {
//                postfixStack.push(s);
//            }
//        }
//
//        return Integer.parseInt(postfixStack.pop());
        return 0;
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
            System.out.println("Now Character=" + c + ", postfix=" + postfix + ", operatorStack=" + operatorStack);
        }

        postfix.add(sb.toString());
        while (!operatorStack.empty()) {
            postfix.add(operatorStack.pop());
        }
        System.out.println("Result=" + postfix);
        return postfix;
    }


}
