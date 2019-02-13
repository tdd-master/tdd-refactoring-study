package com.hosik.items;

import com.hosik.product.Product;

public class ItemImpl implements Item {
    private Product product;
    private long change;

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public long getChange() {
        return change;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void setChange(long change) {
        this.change = change;
    }
}
