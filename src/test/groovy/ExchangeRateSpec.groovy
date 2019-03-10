import spock.lang.Specification

class ExchangeRateSpec  extends Specification {

    def "기본 생성자로 설정한 달러 구매 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()

        when:
        def buyRate = exchangeRate.getBuyRate()

        then:
        buyRate == 1300.0

    }

    def "기본 생성자로 설정한 달러 판매 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()

        when:
        def sellRate = exchangeRate.getSellRate()

        then:
        sellRate == 1200.0

    }

    def "기본 생성자로 설정한 달러 송금 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()

        when:
        def sendRate = exchangeRate.getSendRate()

        then:
        sendRate == 1250.0

    }

    def "기본 생성자로 설정한 달러 입금 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()

        when:
        def receiveRate = exchangeRate.getReceiveRate()

        then:
        receiveRate ==  1230.0

    }

    def "생성자로 설정한 구매 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)

        when:
        def buyRate = exchangeRate.getBuyRate()

        then:
        buyRate == 1556.89

    }

    def "생성자로 설정한 판매 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)

        when:
        def sellRate = exchangeRate.getSellRate()

        then:
        sellRate == 1117.11

    }

    def "생성자로 설정한 송금 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)

        when:
        def sendRate = exchangeRate.getSendRate()

        then:
        sendRate == 1148.10

    }

    def "생성자로 설정한 입금 환율 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)

        when:
        def receiveRate = exchangeRate.getReceiveRate()

        then:
        receiveRate ==  1125.90

    }


}
