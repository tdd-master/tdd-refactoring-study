package payment

import spock.lang.Specification

class CashSpec extends Specification {

    def "생성자로 설정한 잔액 확인"() {

        setup:
        Cash cash = new Cash(10000)

        when:
        def change = cash.getChange()

        then:
        change == 10000

    }


    def "돈을 추가로 넣을 때 잔액 확인"() {

        setup:
        Cash cash = new Cash(10000)

        when:
        cash.addAdditionalCash(10000)
        def change = cash.getChange()

        then:
        change == 20000

    }


    def "pay 메서드 결과 확인"() {

        setup:
        Cash cash = new Cash(10000)

        expect:
        cash.pay(productPrice)
        change == cash.getChange()

        where:
        productPrice | change
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
