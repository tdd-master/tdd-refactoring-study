package com.hosik.money;

import com.hosik.items.Product;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyStorageImplTest {

    @Test
    public void should_get_zero() {
        MoneyStorageImpl moneyStorage = new MoneyStorageImpl();
        moneyStorage.fillUpMoney(10000);
        int coin = 1000;
        Product p = new Product("coke", 1000, 5);
        moneyStorage.calculate(p, coin);
        assertThat(10000L, is(moneyStorage.getBalance()));
    }

}