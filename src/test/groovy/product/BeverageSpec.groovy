package product

import spock.lang.Specification

class BeverageSpec extends Specification {

    def "생성자로 설정한 제품명, 제품 가격, 재고 확인"() {

        setup:
        Beverage beverage = new Beverage("실론티", 800, 10)

        when:
        def name = beverage.getName()
        def price = beverage.getPrice()
        def stock = beverage.getStock()

        then:
        name == "실론티"
        price == 800
        stock == 10

    }

    def "Setter로 설정한 제품명, 제품 가격, 재고 확인"() {

        setup:
        Beverage beverage = new Beverage("실론티", 800, 10)

        when:
        beverage.setName("Cold 실론티")
        def name = beverage.getName()
        beverage.setPrice(900)
        def price = beverage.getPrice()
        beverage.setStock(15)
        def stock = beverage.getStock()

        then:
        name == "Cold 실론티"
        price == 900
        stock == 15

    }

    def "재고 추가 확인"() {

        setup:
        Beverage beverage = new Beverage("실론티", 800, 10)

        when:
        beverage.addStock(5)
        def stock = beverage.getStock()

        then:
        stock == 15

    }


}
