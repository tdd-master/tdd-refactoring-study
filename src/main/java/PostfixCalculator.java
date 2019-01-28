import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class PostfixCalculator implements Calculator {

    Operator op;

    public PostfixCalculator() {
        op = new Operator();
    }

    public PostfixCalculator(Map<String, String> separators) {
        op = new Operator(separators);
    }

    @Override
    public int calculate(String input) {

        List<String> postfixList = infixToPostfix(input);

        if(postfixList.size()<3){
            return Integer.parseInt(postfixList.get(0));
        }

        Stack<String> postfixStack = new Stack<>();

        for (String s : postfixList) {
            if (op.getOperators().keySet().contains(s)) {
                String tmpOp = op.getOperators().get(s);
                if (op.PLUS.equals(tmpOp)) {
                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) + Integer.parseInt(postfixStack.pop())));
                } else if (op.MINUS.equals(tmpOp)) {
                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) - Integer.parseInt(postfixStack.pop())));
                } else if (op.MULTIPLY.equals(tmpOp)) {
                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) * Integer.parseInt(postfixStack.pop())));
                } else if (op.DIVISION.equals(tmpOp)) { // 나누기는 수정해야 함
                    postfixStack.push(Integer.toString(Integer.parseInt(postfixStack.pop()) / Integer.parseInt(postfixStack.pop())));
                }
            } else {
                postfixStack.push(s);
            }
        }

        return Integer.parseInt(postfixStack.pop());
    }

    private List<String> infixToPostfix(String input) {
        List<String> result = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : input.toCharArray()) {
            System.out.println("c=" + c);
            if (op.getOperators().keySet().contains(Character.toString(c))) {

                System.out.println("put int stack, stack=" + operatorStack);

                if(sb.length()>0){
                    result.add(sb.toString());
                }
                sb.delete(0, sb.length());

                if (operatorStack.empty()) {
                    operatorStack.push(c);
                } else if (op.getOperatorPriority().get(c) > op.getOperatorPriority().get(operatorStack.peek())) {
                    operatorStack.push(c);
                } else {
                    result.add(operatorStack.pop().toString());
                    operatorStack.push(c);
                }
            } else {
                sb.append(c);
            }
        }

        result.add(sb.toString());
        while (!operatorStack.empty()){
            result.add(operatorStack.pop().toString());
        }

        System.out.println("RESULT: " +result);
        return result;
    }


}
