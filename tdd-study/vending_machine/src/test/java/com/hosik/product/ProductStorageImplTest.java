package com.hosik.product;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProductStorageImplTest {
    ProductStorage productStorage = new ProductStorageImpl();
    @Before
    public void setting() {
        Product product = new Product("coke", 1000, 10);
        Product product2 = new Product("coffee", 1200, 10);
        Product product3 = new Product("fanta", 1300, 10);
        Product product4 = new Product("cider", 1400, 10);
        productStorage.fillUpProduct(product);
        productStorage.fillUpProduct(product2);
        productStorage.fillUpProduct(product3);
        productStorage.fillUpProduct(product4);
    }

    @Test
    public void should_get_product_with_name() throws Exception {
        Product product = productStorage.getProduct("coke");
        assertThat(product.getName(), is("coke"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_IllegeralArgumenException_when_no_matching_product() throws Exception {
        Product product = productStorage.getProduct("drpepper");
    }


}