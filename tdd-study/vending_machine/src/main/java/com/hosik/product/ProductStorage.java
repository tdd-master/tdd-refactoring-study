package com.hosik.product;

import java.util.Optional;

public interface ProductStorage {
    void fillUpProduct(Product product);
    Product getProduct(String productName);
    Optional<Product> takeOutProduct(String produceName);
}
