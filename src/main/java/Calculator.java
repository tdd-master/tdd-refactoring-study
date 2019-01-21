public class Calculator {

    private String separator;

    public Calculator() {
        this.separator = ",";
    }

    public Calculator(String separator) {
        this.separator = separator;
    }

    public int calculate(String input) {

        int output = 0;
        String[] splitedInput = input.split(this.separator);

        for (String s : splitedInput) {
            output += Integer.parseInt(s.trim());
        }

        return output;
    }


}
