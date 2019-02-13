import payment.Cash
import product.Beverage
import product.Product
import spock.lang.Specification

class VendingMachineSpec extends Specification {

    def "생성자로 설정한 음료 제품 리스트 확인"() {

        setup:
        def beverages = [new Beverage("ldh", 600), new Beverage("coffee", 700)]
        VendingMachine vendingMachine = new VendingMachine(beverages)

        when:
        def products = vendingMachine.getProducts()
        for (Product p : products) {
            println(p.getName() + " : " + p.getPrice())
        }

        then:
        beverages == products

    }


    def "자판기에 현금투입, 음료 하나 구매 후 잔액 확인"() {

        setup:
        def beverages = [new Beverage("ldh", 600), new Beverage("coffee", 700)]
        VendingMachine vendingMachine = new VendingMachine(beverages)

        expect:
        Cash cash = new Cash(inputAmount)
        vendingMachine.selectProduct(index)
        change == vendingMachine.purchase(cash)

        where:
        inputAmount | index | change
        1000        | 0     | 400
        600         | 0     | 0
        1000        | 1     | 300
        700         | 1     | 0

    }

    def "자판기에 현금투입, 음료 하나 이상 구매 후 잔액 확인"() {

        setup:
        def beverages = [new Beverage("ldh", 600), new Beverage("coffee", 700)]
        VendingMachine vendingMachine = new VendingMachine(beverages)

        when:
        Cash cash = new Cash(2000)
        vendingMachine.selectProduct(0)
        vendingMachine.selectProduct(1)
        def change = vendingMachine.purchase(cash)

        then:
        change == 700


    }

//    def "자판기에 현금투입, 음료구매 후 일정시간이 지나도 입력이 없어서 거스름돈 주는거 확인"() {
//
//        setup:
//        def beverages = [new Beverage("ldh", 600), new Beverage("coffee", 700)]
//        VendingMachine vendingMachine = new VendingMachine(beverages)
//
//        when:
//        Cash cash = new Cash(1000)
//        vendingMachine.purchase(cash)
//        vendingMachine.selectProduct(0)
//        sleep(vendingMachine.getWatingTimeMillis() + 1000)
//
//        then:
//        def e = thrown(Exception.class)
//        e.class == TimeoutException
//        Integer.parseInt(e.getMessage()) == 400
//
//    }


}
