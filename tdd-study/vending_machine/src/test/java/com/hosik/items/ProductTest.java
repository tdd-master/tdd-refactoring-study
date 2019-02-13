package com.hosik.items;

import org.junit.Test;

public class ProductTest {

    @Test
    public void should_make_product_using_constructor() {
        Product product = new Product("coke", 1000, 5);
        System.out.println(product.toString());
    }


}