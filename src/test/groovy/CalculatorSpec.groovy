import spock.lang.Specification

/*
문자열 계산기
: 문자열에 구분자와 숫자를 넘겨 숫자의 합을 계산하여 반환다.
    - 구분자(separator)는 생성자로 설정 가능하다.
    - 구분자는 숫자가 포함될 수 없다.
    - 문자(char type)만 가능하다.
    - 기본 구분자는 ","로 설정한다.
    - 구분자는 하나의 문자이다.
 */

class CalculatorSpec extends Specification {

    def "기본 구분자(,)를 사용했을 때의 계산 결과 검증"() {

        setup:
        def calculator = new Calculator()

        expect:
        calculator.calculate(input) == output

        where:
        input   | output
        "0"     | 0
        "1,2"   | 3
        "1,2,3" | 6

    }

    def "기본 구분자 이외의 구분자를 사용했을 때의 계산 결과 검증"() {

        setup:
        Calculator calculator = new Calculator("\\+")

        expect:
        calculator.calculate(input) == output

        where:
        input   | output
        "0"     | 0
        "1+2"   | 3
        "1+2+3" | 6

    }

    def "구분자 이외의 문자가 입력된 경우의 예외처리"() {
        // Integer Parsing중에 Exception 발생

        setup:
        Calculator calculator = new Calculator()

        when:
        calculator.calculate("1|2")

        then:
        def e = thrown(Exception.class)
        e.class == NumberFormatException
//        e.message == "Error Message"

    }


}
