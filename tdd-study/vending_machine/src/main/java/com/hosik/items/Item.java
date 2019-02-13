package com.hosik.items;

public interface Item {
    Product getProduct();
    long getChange();
    void setProduct(Product product);
    void setChange(long change);
}
