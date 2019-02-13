package com.hosik.money;

import com.hosik.product.Product;

public interface MoneyStorage {
    void fillUpMoney(long money);
    long getBalance();
    void addMoney(int price);
}
