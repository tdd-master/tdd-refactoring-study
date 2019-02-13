package com.hosik.items;

import com.hosik.product.Product;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductTest {

    @Test
    public void should_make_product_using_constructor() {
        Product product = new Product("coke", 1000, 5);
        System.out.println(product.toString());
    }

}