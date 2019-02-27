package com.hosik.product;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ProductStorageImpl implements ProductStorage {
    private Set<Product> stack;

    public ProductStorageImpl() {
        stack = new HashSet<>();
    }

    @Override
    public void fillUpProduct(Product product) {
        stack.add(product);
    }

    @Override
    public Optional<Product> takeOutProduct(String produceName) {
        Product product = getProduct(produceName);
        return Optional.ofNullable(checkStack(product)).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Product getProduct(String productName) {
        return stack.stream()
                .filter(p -> p.getName().equals(productName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private Optional<Product> checkStack(Product product) {
        if (product.getQuantity() > 0) {
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
