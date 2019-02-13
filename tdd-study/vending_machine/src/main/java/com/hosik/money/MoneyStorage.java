package com.hosik.money;

import com.hosik.items.Product;

public interface MoneyStorage {
    void fillUpMoney(long money);
    long getBalance();
    void calculate(Product product, int coin);
}
