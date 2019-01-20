package com.hosik.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String seperator;

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
        List<Integer> numbers = seperate(input);
        int result = 0;
        for (Integer num : numbers) {
            result += num;
        }
        return result;
    }

    private List<Integer> seperate(String input) {
        String [] numString = input.split(seperator);
        List<Integer> numbers = getIntegers(numString);
        return numbers;
    }

    private List<Integer> getIntegers(String[] numString) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : numString) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }
}
