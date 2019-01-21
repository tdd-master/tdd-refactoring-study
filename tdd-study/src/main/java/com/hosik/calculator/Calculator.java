package com.hosik.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String seperator;
    private List<Integer> numbers = new ArrayList<>();

    public Calculator() {
        seperator = ",";
    }

    public Calculator(String seperator) {
        this.seperator = seperator;
    }

    public String getSeperator() {
        return seperator;
    }

    public Integer calc(String input) {
        seperate(input);
        int result = 0;
        for (Integer num : numbers) {
            result += num;
        }
        return result;
    }

    private void seperate(String input) {
        String [] numString = input.split(seperator);
        getIntegers(numString);
    }

    private void getIntegers(String[] numString) {
        for (String num : numString) {
            numbers.add(Integer.parseInt(num));
        }
    }
}
