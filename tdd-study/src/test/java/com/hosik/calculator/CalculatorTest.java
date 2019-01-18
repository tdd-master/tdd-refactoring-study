package com.hosik.calculator;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.Assert.*;

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
    1,2\n3 => 6
 */

public class CalculatorTest {
    @Test
    public void default_seperator_test() {
        Calculator calculator = new Calculator();
        assertThat(calculator.getSeperator(), CoreMatchers.is(","));
    }
    @Test
    public void diff_seperator_test() {
        Calculator calculator = new Calculator(":");
        assertThat(calculator.getSeperator(), CoreMatchers.is(":"));
    }

    @Test
    public void seperate_input() {
        Calculator calculator = new Calculator();

        
    }

    @Test
    public void sum_test() {
        Calculator calculator = new Calculator();
        calculator.calc("1,2,3");
    }

}