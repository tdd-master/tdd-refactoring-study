package com.hosik.money;

import com.hosik.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyStorageImplTest {
    MoneyStorageImpl moneyStorage = new MoneyStorageImpl();
    @Before
    public void setting() {
        moneyStorage.fillUpMoney(10000);
    }
    @Test
    public void should_get_zero() {
        int coin = 1000;
        moneyStorage.addMoney(coin);
        assertThat(11000L, is(moneyStorage.getBalance()));
    }

}