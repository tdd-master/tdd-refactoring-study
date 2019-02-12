package com.hosik.money;

public class MoneyStorageImpl implements MoneyStorage{
    private long balance;

    @Override
    public void fillUpMoney(long money) {
        this.balance = money;
    }

    @Override
    public long getBalance() {
        return balance;
    }
}
