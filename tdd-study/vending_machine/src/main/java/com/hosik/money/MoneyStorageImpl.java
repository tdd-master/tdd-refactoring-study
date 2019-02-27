package com.hosik.money;

import com.hosik.items.Item;
import com.hosik.items.ItemImpl;
import com.hosik.product.Product;

import java.util.Optional;

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

    @Override
    public int getChangeMoney(int coin, Product product) {
        return coin - product.getPrice();
    }

}
