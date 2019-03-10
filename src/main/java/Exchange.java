public interface Exchange {

    double buy(double moneyToExchange);

    double sell(double moneyToExchange);

    double send(double moneyToExchange);

    double receive(double moneyToExchange);

}
