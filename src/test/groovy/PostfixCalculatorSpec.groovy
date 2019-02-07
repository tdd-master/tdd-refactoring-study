import spock.lang.Specification

/*
문자열 계산기
: 문자열에 구분자와 숫자를 넘겨 숫자의 합을 계산하여 반환다.
    - 구분자(separator)는 생성자로 설정 가능하다.
    - 구분자는 숫자가 포함될 수 없다.
    - 문자(char type)만 가능하다.
    - 기본 구분자는 ","로 설정한다.
    - 구분자는 하나의 문자이다. --> (변경) 구분자를 여러 개로 지정할 수 있다.
    - (추가) 사칙연산 가능
    - (추가) 연산 순서 주의
    - (참고) 나누기는 반올림하게 작성

 */

class PostfixCalculatorSpec extends Specification {


    def "기본 구분자(,)를 사용했을 때의 infixToPostfix 결과 검증"() {

        setup:
        PostfixCalculator postfixCalculator = new PostfixCalculator()

        expect:
        postfixCalculator.infixToPostfix(infix) == postfix

        where:
        infix   | postfix
        "0"     | ['0']
        "1,2"   | ['1', '2', ',']
        "1,2,3" | ['1', '2', ',', '3', ',']
        "12,3"  | ['12', '3', ',']

    }

    def "구분자를 여러 개 사용했을 때의 infixToPostfix 결과 검증"() {

        setup:
        def inputOperator = ['+': 'Addition', '-': 'Subtraction', '*': 'Multiplication', '/': 'Division']
        Operator operator = new OperatorImpl(inputOperator)
        PostfixCalculator postfixCalculator = new PostfixCalculator(operator)

        expect:
        postfixCalculator.infixToPostfix(infix) == output

        where:
        infix      | output
        "0"        | ['0']
        "1+2"      | ['1', '2', '+']
        "2-1"      | ['2', '1', '-']
        "1*2"      | ['1', '2', '*']
        "2/1"      | ['2', '1', '/']
        "1+2+3"    | ['1', '2', '+', '3', '+']
        "1*2+3"    | ['1', '2', '*', '3', '+']
        "1+2*3"    | ['1', '2', '3', '*', '+']
        "12+3"     | ['12', '3', '+']
        "12+3-1*3" | ['12', '3', '+', '1', '3', '*', '-']
        "12+6/2-1" | ['12', '6', '2', '/', '1', '-', '+']

    }


    def "기본 구분자(,)를 사용했을 때의 계산 결과 검증"() {

        setup:
        Calculator calculator = new PostfixCalculator()

        expect:
        calculator.calculate(input) == output

        where:
        input   | output
        "0"     | 0
        "1,2"   | 3
        "1,2,3" | 6
        "12,3"  | 15

    }

    def "기본 구분자 이외의 구분자를 사용했을 때의 계산 결과 검증"() {

        setup:
        def inputOperator = ['+': 'Addition']
        Operator operator = new OperatorImpl(inputOperator)
        Calculator calculator = new PostfixCalculator(operator)

        expect:
        calculator.calculate(input) == output

        where:
        input   | output
        "0"     | 0
        "1+2"   | 3
        "1+2+3" | 6
        "12+3"  | 15

    }

    def "구분자를 여러 개 사용했을 때의 계산 결과 검증"() {

        setup:
        def inputOperator = ['+': 'Addition', '-': 'Subtraction', '*': 'Multiplication', '/': 'Division']
        Operator operator = new OperatorImpl(inputOperator)
        Calculator calculator = new PostfixCalculator(operator)

        expect:
        calculator.calculate(input) == output

        where:
        input      | output
        "0"        | 0
        "1+2"      | 3
        "2-1"      | 1
        "1*2"      | 2
        "2/1"      | 2
        "1+2+3"    | 6
        "1*2+3"    | 5
        "1+2*3"    | 7
        "12+3"     | 15
        "12+3-1*3" | 12
        "12+6/2-1" | 14

    }

    def "기본 구분자만 사용했을 때 구분자 이외의 문자 입력 예외처리"() {
        // Integer Parsing중에 Exception 발생

        setup:
        Calculator calculator = new PostfixCalculator()

        when:
        calculator.calculate("1|2")

        then:
        def e = thrown(Exception.class)
        e.class == NumberFormatException

    }

    def "0으로 나누는 경우 에러 처리"() {
        // Integer Parsing중에 Exception 발생

        setup:
        def inputOperator = ['/': 'Division']
        Operator operator = new OperatorImpl(inputOperator)
        Calculator calculator = new PostfixCalculator(operator)

        when:
        calculator.calculate("1/0")

        then:
        def e = thrown(Exception.class)
        e.class == ArithmeticException

    }

    def "구분자를 여러 개 사용했을 때 구분자 이외의 문자 입력 예외처리"() {
        // Integer Parsing중에 Exception 발생

        setup:
        def inputOperator = ['+': 'Addition', '-': 'Subtraction', '*': 'Multiplication', '/': 'Division']
        Operator operator = new OperatorImpl(inputOperator)
        Calculator calculator = new PostfixCalculator(operator)


        when:
        calculator.calculate("1,2+3|4")

        then:
        def e = thrown(Exception.class)
        e.class == NumberFormatException

    }

}
