import spock.lang.Specification

class OperatorImplSpec extends Specification {

    def "기본 생성자로 생성한 결과 확인"() {

        setup:
        Operator o = new OperatorImpl()

        when:
        def operator = o.getOperator()
        def priority = o.getPriority()

        then:
        operator == [',': 'ADDITION']
        priority == ['ADDITION': 1]

    }


    def "Operator를 입력한 생성자로 생성한 결과 확인"() {

        setup:
        def inputOperator = ['+': 'Addition', '-': 'Subtraction', '*': 'Multiplication', '/': 'Division']
        Operator o = new OperatorImpl(inputOperator)

        when:
        def operator = o.getOperator()
        def priority = o.getPriority()

        then:
        operator == ['+': 'ADDITION', '-': 'SUBTRACTION', '*': 'MULTIPLICATION', '/': 'DIVISION']
        priority == ['ADDITION': 1, 'SUBTRACTION': 1, 'MULTIPLICATION': 2, 'DIVISION': 2]


    }

    def "생성자에 정의되지 않은 Operator를 입력한 경우 에러 확인"() {

        setup:
        def inputOperator = ['+': 'unknown']

        when:
        Operator o = new OperatorImpl(inputOperator)

        then:
        def e = thrown(Exception.class)
        e.class == IllegalArgumentException

    }


}
