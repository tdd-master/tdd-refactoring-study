package com.hosik.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private List<String> separators;

    public Calculator() {
        separators = Arrays.asList(",");
    }

    public Calculator(List<String> separators) {
        this.separators = separators == null ? Arrays.asList(",") : separators;
    }

    public List<String> getSeparators() {
        return separators;
    }

    public Integer calc(String input, String operator) {
        if (isEmpty(input))
            throw new IllegalArgumentException();

        String [] seperated = input.split(getRegex());
        List<Integer> numbers = new ArrayList<>();
        for (String str : seperated) {
            numbers.add(Integer.parseInt(str));
        }

        if ("sum".equals(operator)) {
            return getSum(numbers);
        } else if ("multiply".equals(operator)) {
            return getMultiply(numbers);
        }
        return 0;
    }

    private Integer getMultiply(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).reduce((left, right) -> left * right).getAsInt();
    }

    private int getSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    public String getRegex() {
        StringBuilder regex = new StringBuilder();
        for (String str : separators) {
            String addRegexText;
            if(str == "|") {
                addRegexText = "\\|";
            } else {
                addRegexText = String.valueOf(str);
            }
            if(regex.length() == 0) {
                regex.append(addRegexText);
            } else {
                regex.append("|").append(addRegexText);
            }
        }

        return regex.toString();
    }

    private boolean isEmpty(String input) {
        return input.isEmpty() || input == null;
    }
}
