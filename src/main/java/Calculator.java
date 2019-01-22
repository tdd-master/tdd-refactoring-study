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
            output += Integer.parseInt(s.trim());
        }

        return output;
    }

    private List<String> splitWithSeparators(String input) {
        List<String> result = new ArrayList<>();

        String tmp = "";
        for (char c : input.toCharArray()) {
            if (separators.contains(c)) {
                if (tmp != "") {
                    result.add(tmp);
                }
                tmp = "";
            } else {
                tmp += c;
            }
        }
        if (tmp != "") {
            result.add(tmp);
        }
        return result;
    }


}
