import spock.lang.Specification

class ExchangeImplSpec extends Specification {

    def "기본 생성자로 설정한 달러 구매 환율 결과 확인"() {

        setup:
        Exchange exchange = new ExchangeImpl()

        expect:
        buyCurrency == exchange.buy(moneyToExchange)

        where:
        moneyToExchange | buyCurrency
        0               | 0
        1300            | 1
        1500            | 1.15

    }

    def "기본 생성자로 설정한 달러 판매 환율 결과 확인"() {

        setup:
        Exchange exchange = new ExchangeImpl()

        expect:
        sellCurrency == exchange.sell(moneyToExchange)

        where:
        moneyToExchange | sellCurrency
        0               | 0
        1200            | 1
        1500            | 1.25

    }

    def "기본 생성자로 설정한 달러 송금 환율 결과 확인"() {

        setup:
        Exchange exchange = new ExchangeImpl()

        expect:
        sendCurrency == exchange.send(moneyToExchange)

        where:
        moneyToExchange | sendCurrency
        0               | 0
        1250            | 1
        1500            | 1.2

    }

    def "기본 생성자로 설정한 달러 입금 환율 결과 확인"() {

        setup:
        Exchange exchange = new ExchangeImpl()

        expect:
        recieveCurrency == exchange.recieve(moneyToExchange)

        where:
        moneyToExchange | recieveCurrency
        0               | 0
        1230            | 1
        1500            | 1.22

    }

    def "생성자로 설정한 구매 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        expect:
        buyCurrency == exchange.buy(moneyToExchange)

        where:
        moneyToExchange | buyCurrency
        0               | 0
        155689          | 100.00
        150000          | 96.35

    }

    def "생성자로 설정한 판매 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        expect:
        sellCurrency == exchange.sell(moneyToExchange)

        where:
        moneyToExchange | sellCurrency
        0               | 0
        111711          | 100.00
        150000          | 134.28

    }

    def "생성자로 설정한 송금 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        expect:
        sendCurrency == exchange.send(moneyToExchange)

        where:
        moneyToExchange | sendCurrency
        0               | 0
        114810          | 100.00
        150000          | 130.65

    }

    def "생성자로 설정한 입금 환율 결과 확인"() {

        setup:
        ExchangeRate exchangeRate = new ExchangeRate("USD"
                , 1.00, 1556.89, 1117.11, 1148.10, 1125.90)
        Exchange exchange = new ExchangeImpl(exchangeRate)

        expect:
        recieveCurrency == exchange.recieve(moneyToExchange)

        where:
        moneyToExchange | recieveCurrency
        0               | 0
        112590          | 100
        150000          | 133.27

    }


}
