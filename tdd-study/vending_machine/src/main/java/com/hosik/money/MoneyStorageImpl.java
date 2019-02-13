package com.hosik.money;

import com.hosik.product.Product;

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

    @Override
    public void addMoney(int money) {
        this.balance += money;
    }

}
