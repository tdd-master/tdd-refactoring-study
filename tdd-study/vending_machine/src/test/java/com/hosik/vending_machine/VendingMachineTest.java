package com.hosik.vending_machine;

import com.hosik.items.Item;
import com.hosik.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VendingMachineTest {
    VendingMachine vendingMachine = new VendingMachine();

    @Before
    public void setting() {
        Product product = new Product("coke", 1000, 10);
        Product product2 = new Product("coffee", 1200, 10);
        Product product3 = new Product("fanta", 1300, 10);
        Product product4 = new Product("cider", 1400, 10);
        vendingMachine.addProduct(product);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(product3);
        vendingMachine.addProduct(product4);
    }

    @Test
    public void should_fillUpMoney() throws Exception {
        vendingMachine.fillUpMoney(100000);
        assertThat(100000L, is(vendingMachine.getBalance()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void could_not_buy_when_enough_money() throws Exception{
        vendingMachine.insertCoin(900);
        vendingMachine.buy("coke");
    }

    @Test
    public void could_buy_product() throws Exception {
        vendingMachine.insertCoin(1000);
        Item item = vendingMachine.buy("coke");
        assertThat(item.getProduct().getName(), is("coke"));
    }

    @Test
    public void should_get_change_zero() throws Exception {
        vendingMachine.insertCoin(1000);
        Item item = vendingMachine.buy("coke");
        assertThat(item.getChange(), is(0L));
    }

    @Test
    public void should_get_change_600() throws Exception {
        vendingMachine.insertCoin(2000);
        Item item = vendingMachine.buy("cider");
        assertThat(item.getChange(), is(600L));
    }

    @Test
    public void should_gain_money() throws Exception {
        vendingMachine.fillUpMoney(10000);
        vendingMachine.insertCoin(10000);
        Item item = vendingMachine.buy("coke");
        assertThat(vendingMachine.getBalance(), is(11000L));
    }

}