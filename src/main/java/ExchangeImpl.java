public class ExchangeImpl implements Exchange {

    ExchangeRate exchangeRate;

    public ExchangeImpl() {
        this.exchangeRate = new ExchangeRate();
    }

    public ExchangeImpl(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public double buy(double moneyToExchange) {
        return calculateMoneyExchange(moneyToExchange, exchangeRate.getBuyRate());
    }

    @Override
    public double sell(double moneyToExchange) {
        return calculateMoneyExchange(moneyToExchange, exchangeRate.getSellRate());
    }

    @Override
    public double send(double moneyToExchange) {
        return calculateMoneyExchange(moneyToExchange, exchangeRate.getSendRate());
    }

    @Override
    public double receive(double moneyToExchange) {
        return calculateMoneyExchange(moneyToExchange, exchangeRate.getReceiveRate());
    }

    private double calculateMoneyExchange(double moneyToExchange, double rate) {
        double result = moneyToExchange / rate;
        return Math.round(result * 100d) / 100d;
    }
}
