import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Character> separators = new ArrayList<>();

    public Calculator() {
        separators.add(',');
    }

    public Calculator(char[] separator) {
        for (char c : separator) {
            separators.add(c);
        }
    }

    public int calculate(String input) {

        int output = 0;
        List<String> splitedString = splitWithSeparators(input);

        for (String s : splitedString) {
            if (!"".equals(s.trim())) {
                output += Integer.parseInt(s.trim());
            }
        }

        return output;
    }

    private List<String> splitWithSeparators(String input) {
        List<String> result = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        for (char c : input.toCharArray()) {
            if (separators.contains(c)) {
                result.add(sb.toString());
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString());

        return result;
    }


}
