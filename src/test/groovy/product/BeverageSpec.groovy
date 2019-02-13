package product

import spock.lang.Specification

class BeverageSpec extends Specification {

    def "생성자로 설정한 제품명, 제품 가격 확인"() {

        setup:
        Beverage beverage = new Beverage("실론티", 800)

        when:
        def productName = beverage.getName()
        def productPrice = beverage.getPrice()

        then:
        productName == "실론티"
        productPrice == 800

    }


}
