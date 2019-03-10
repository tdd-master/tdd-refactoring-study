import spock.lang.Specification

class ExchangeImplSpec extends Specification {

    def "기본 생성자로 설정한 달러 구매 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        buyCurrency = exchange.buy(moneyToExchange)

        then:
        moneyToExchange | buyCurrency
        0               | 0
        1300            | 1
        1500            | 1.15

    }

    def "기본 생성자로 설정한 달러 판매 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        sellCurrency = exchange.sell(moneyToExchange)

        then:
        moneyToExchange | sellCurrency
        0               | 0
        1200            | 1
        1500            | 1.25

    }

    def "기본 생성자로 설정한 달러 송금 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        sendCurrency = exchange.send(moneyToExchange)

        then:
        moneyToExchange | sendCurrency
        0               | 0
        1250            | 1
        1500            | 1.2

    }

    def "기본 생성자로 설정한 달러 입금 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate()
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        recieveCurrency = exchange.recieve(moneyToExchange)

        then:
        moneyToExchange | recieveCurrency
        0               | 0
        1230            | 1
        1500            | 1.219

    }

    def "생성자로 설정한 구매 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        buyCurrency = exchange.buy(moneyToExchange)

        then:
        moneyToExchange | buyCurrency
        0               | 0
        155689          | 100
        150000          | 150000/1556.89

    }

    def "생성자로 설정한 판매 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        sellCurrency = exchange.sell(moneyToExchange)

        then:
        moneyToExchange | sellCurrency
        0               | 0
        111711          | 100
        150000          | 150000/1117.11

    }

    def "생성자로 설정한 송금 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        sendCurrency = exchange.send(moneyToExchange)

        then:
        moneyToExchange | sendCurrency
        0               | 0
        114810          | 100
        150000          | 150000/1148.10

    }

    def "생성자로 설정한 입금 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        when:
        recieveCurrency = exchange.recieve(moneyToExchange)

        then:
        moneyToExchange | recieveCurrency
        0               | 0
        112590          | 100
        150000          | 150000/1125.90

    }


}
