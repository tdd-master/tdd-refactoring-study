package payment

import spock.lang.Specification

class CashSpec extends Specification {

    def "생성자로 설정한 잔액 확인"() {

        setup:
        Cash cash = new Cash(10000)

        when:
        def balance = cash.getChange()

        then:
        balance == 10000

    }


    def "pay 메서드 결과 확인"() {

        setup:
        Cash cash = new Cash(10000)

        expect:
        cash.pay(productPrice)
        balance == cash.getChange()

        where:
        productPrice | balance
        500          | 9500
        1000         | 9000
        10000        | 0

    }


    def "잔액을 초과하는 pay 입력 값에 대한 Exception 발생 확인"() {

        setup:
        Cash cash = new Cash(10000)

        when:
        cash.pay(50000)

        then:
        def e = thrown(Exception.class)
        e.class == IllegalArgumentException

    }


}
