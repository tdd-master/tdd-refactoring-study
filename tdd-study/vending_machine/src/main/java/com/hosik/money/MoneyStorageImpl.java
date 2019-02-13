package com.hosik.money;

import com.hosik.items.Product;

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
    public void calculate(Product product, int coin) {
        long change = coin - product.getPrice();
        balance -= change;
    }
}
