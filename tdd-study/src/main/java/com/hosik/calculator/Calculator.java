package com.hosik.calculator;

import java.util.List;

public class Calculator {
    private Numbers numbers;
    private Seperate seperate;

    public Calculator() {
        seperate = new Seperate();
    }

    public Calculator(List<String> separators) {
        this.seperate = separators == null ?
                seperate = new Seperate() : new Seperate(separators);
    }

    public double calc(String input, String operator) {
        if (isEmpty(input))
            throw new IllegalArgumentException();
        String[] target = getTarget(input);
        numbers = new Numbers(target);

        if ("+".equals(operator)) {
            return sum(numbers.getNumbers());
        } else if ("*".equals(operator)) {
            return multiply(numbers.getNumbers());
        } else if ("-".equals(operator)) {
            return minus(numbers.getNumbers());
        } else if ("%".equals(operator)) {
            return division(numbers.getNumbers());
        }
        return 0;
    }

    private double division(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::doubleValue).reduce((left, right) -> left % right).getAsDouble();
    }

    public String[] getTarget(String input) {
        return input.split(seperate.getRegex());
    }

    private double minus(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::intValue).reduce((left, right) -> left - right).getAsDouble();
    }

    private double multiply(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::intValue).reduce((left, right) -> left * right).getAsDouble();
    }

    private double sum(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::intValue).sum();
    }

    private boolean isEmpty(String input) {
        return input.isEmpty() || input == null;
    }
}
