import payment.Cash
import product.Beverage
import spock.lang.Specification

class VendingMachineSpec extends Specification {

    def "생성자로 설정한 음료 제품 리스트 확인"() {

        setup:
        def beverages = [new Beverage("ldh", 600, 10), new Beverage("coffee", 700, 10)]
        VendingMachine vendingMachine = new VendingMachine(beverages)

        when:
        def products = vendingMachine.getProducts()

        then:
        beverages == products

    }


    def "자판기에 현금투입, 음료 하나 구매 후 잔액 확인"() {

        setup:
        def beverages = [new Beverage("ldh", 600, 10), new Beverage("coffee", 700, 10)]
        VendingMachine vendingMachine = new VendingMachine(beverages)
        Cash cash = new Cash(inputAmount)

        expect:
        vendingMachine.setPayment(cash)
        vendingMachine.purchaseProducts(index)
        change == vendingMachine.returnChange()

        where:
        inputAmount | index | change
        1000        | 0     | 400
        600         | 0     | 0
        1000        | 1     | 300
        700         | 1     | 0

    }

    def "자판기에 현금투입, 음료 하나 이상 구매 후 잔액 확인"() {

        setup:
        def beverages = [new Beverage("ldh", 600, 10), new Beverage("coffee", 700, 10)]
        VendingMachine vendingMachine = new VendingMachine(beverages)
        Cash cash = new Cash(2000)

        when:
        vendingMachine.setPayment(cash)
        vendingMachine.purchaseProducts(0, 1)
        def change = vendingMachine.returnChange()

        then:
        change == 700

    }

    def "자판기에 현금투입, 음료 하나 이상 구매 도중 잔액 부족"() {

        setup:
        def beverages = [new Beverage("ldh", 600, 10), new Beverage("coffee", 700, 10)]
        VendingMachine vendingMachine = new VendingMachine(beverages)
        Cash cash = new Cash(2000)

        when:
        vendingMachine.setPayment(cash)
        vendingMachine.purchaseProducts(0, 1, 1, 0)

        then:
        def e = thrown(Exception.class)
        e.class == IllegalArgumentException

    }


}
