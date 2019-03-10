public class ExchangeRate {

    String currency;

    double dollarConversionRate;

    double buyRate;
    double sellRate;
    double sendRate;
    double receiveRate;


    public ExchangeRate() {
        this.currency = "USD";
        this.dollarConversionRate = 1;
        this.buyRate = 1300.0;
        this.sellRate = 1200.0;
        this.sendRate = 1250.0;
        this.receiveRate = 1230.0;
    }


    public ExchangeRate(String currency
            , double dollarConversionRate
            , double buyRate, double sellRate, double sendRate, double receiveRate) {

        this.currency = currency;
        this.dollarConversionRate = dollarConversionRate;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
        this.sendRate = sendRate;
        this.receiveRate = receiveRate;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getDollarConversionRate() {
        return dollarConversionRate;
    }

    public void setDollarConversionRate(double dollarConversionRate) {
        this.dollarConversionRate = dollarConversionRate;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(double buyRate) {
        this.buyRate = buyRate;
    }

    public double getSellRate() {
        return sellRate;
    }

    public void setSellRate(double sellRate) {
        this.sellRate = sellRate;
    }

    public double getSendRate() {
        return sendRate;
    }

    public void setSendRate(double sendRate) {
        this.sendRate = sendRate;
    }

    public double getReceiveRate() {
        return receiveRate;
    }

    public void setReceiveRate(double receiveRate) {
        this.receiveRate = receiveRate;
    }

}
