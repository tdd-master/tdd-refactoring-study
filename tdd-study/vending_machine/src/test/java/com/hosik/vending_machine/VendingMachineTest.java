package com.hosik.vending_machine;

import com.hosik.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.fillUpMoney(100000);
        assertThat(100000L, is(vendingMachine.getBalance()));
    }

    @Test
    public void should_get_product_with_name() throws Exception {
        Product product = vendingMachine.getProduct("coke");
        assertThat(product.getName(), is("coke"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_IllegeralArgumenException_when_no_matching_product() throws Exception {
        Product product = vendingMachine.getProduct("drpepper");
    }

    @Test
    public void could_not_buy_when_enough_money() throws Exception{
        vendingMachine.insertCoin(1000);
        Product product = vendingMachine.getProduct("coke");
        vendingMachine.isPossible(product);
    }

}