public interface Exchange {

    double buy(double rate, double moneyToExchange);

    double sell(double rate, double moneyToExchange);

    double send(double rate, double moneyToExchange);

    double recieve(double rate, double moneyToExchange);

}
