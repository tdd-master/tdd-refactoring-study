package com.hosik.calculator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*

문자열 계산기
- 문자열에 구분자와 숫자를 넘겨 숫자의 합을 계산하여 반환다.
    구분자(seperator)는 생성자로 설정 가능
        구분자는 숫자가 포함될 수 없다.
        문자(char type)만 가능하다.
    기본 구분자는 ","로 설정

INPUT, OUTPUT
    0 => 0
    1,2 => 3
    ==================
요구사항이 변경되어, 여러 seperator를 받아야함.
 */

public class CalculatorTest {

    @Test
    public void default_constructor_test() {
        Calculator calculator = new Calculator();
        assertEquals(",", calculator.getSeparators().get(0));
    }

    @Test
    public void if_seperator_null_then_defaul_sep() {
        Calculator calculator = new Calculator(null);
        assertEquals(",", calculator.getSeparators().get(0));
    }

    @Test
    public void diff_seperator_test() {
        List<String> separators = new ArrayList<>();
        separators.add(":");
        separators.add("\n");
        Calculator calculator = new Calculator(separators);
        List<String> sep = calculator.getSeparators();
        assertEquals(":", sep.get(0));
        assertEquals("\n", sep.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void input_empty_test() {
        Calculator calculator = new Calculator();
        calculator.calc("");
    }

    @Test
    public void regex_test() {
        List<String> sep = Arrays.asList(":", "m");
        Calculator calculator = new Calculator(sep);
        System.out.println(calculator.getRegex());
        String s = "1:2442m3";
        String [] ss = s.split(calculator.getRegex());
        for (String sss : ss) {
            System.out.println(sss);
        }
    }

    @Test
    public void sum_test() {
        List<String> sep = Arrays.asList(":", "m");
        Calculator calculator = new Calculator(sep);
        int result = calculator.calc("1:2:3m4");
        assertEquals(10, result);
    }
}

















