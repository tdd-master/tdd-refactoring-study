package payment;

public class Cash implements Payment {

    int balance;

    Cash(int balance) {
        this.balance = balance;
    }

    @Override
    public void pay(int productPrice) {
        int expectBalance = this.balance - productPrice;
        if (expectBalance < 0) {
            throw new IllegalArgumentException();
        } else {
            this.balance = expectBalance;
        }
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    public void addAdditionalCash(int additionalCash) {
        this.balance += additionalCash;
    }

}
