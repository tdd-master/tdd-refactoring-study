package com.hosik.product;

public interface ProductStorage {
    void fillUpProduct(Product product);
    Product getProduct(String productName);
    Product takeOutProduct(String produceName);
}
