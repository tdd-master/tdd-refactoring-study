package payment;

public class Cash implements Payment {

    int change;

    Cash(int change) {
        this.change = change;
    }

    @Override
    public void pay(int productPrice) {
        int expectBalance = this.change - productPrice;
        if (expectBalance < 0) {
            throw new IllegalArgumentException();
        } else {
            this.change = expectBalance;
        }
    }

    public void setChange(int change) {
        this.change = change;
    }

    @Override
    public int getChange() {
        return change;
    }

    public void addAdditionalCash(int additionalCash) {
        this.change += additionalCash;
    }

}
