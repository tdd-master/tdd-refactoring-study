package com.hosik.items;

import com.hosik.product.Product;

public interface Item {
    Product getProduct();
    long getChange();
    void setProduct(Product product);
    void setChange(long change);
}
