public class ExchangeImpl implements Exchange{

    ExchangeRate exchangeRate;

    public ExchangeImpl(){
        this.exchangeRate = new ExchangeRate();
    }

    public ExchangeImpl(ExchangeRate exchangeRate){
        this.exchangeRate = exchangeRate;
    }

    @Override
    public double buy(double moneyToExchange){
        return moneyToExchange/exchangeRate.getBuyRate();
    }

    @Override
    public double sell(double moneyToExchange){
        return moneyToExchange/exchangeRate.getSellRate();
    }

    @Override
    public double send(double moneyToExchange){
        return moneyToExchange/exchangeRate.getSendRate();
    }

    @Override
    public double recieve(double moneyToExchange){
        return moneyToExchange/exchangeRate.getRecieveRate();
    }

}
