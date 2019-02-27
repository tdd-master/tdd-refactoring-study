package com.hosik.vending_machine;

import com.hosik.items.Item;
import com.hosik.items.ItemImpl;
import com.hosik.money.MoneyStorage;
import com.hosik.money.MoneyStorageImpl;
import com.hosik.product.Product;
import com.hosik.product.ProductStorage;
import com.hosik.product.ProductStorageImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
1. 물건 넣기
2. 물건 계산
3. 물건 뺴기
4. 돈 받기
 */
public class VendingMachine {
    private MoneyStorage moneyStorage;
    private ProductStorage productStorage;
    private int coin = 0;

    public VendingMachine() {
        moneyStorage = new MoneyStorageImpl();
        productStorage = new ProductStorageImpl();
    }

    public void addProduct(Product product) {
        productStorage.fillUpProduct(product);
    }

    public void fillUpMoney(int money) {
        moneyStorage.fillUpMoney(money);
    }

    public long getBalance() {
        return moneyStorage.getBalance();
    }

    public void insertCoin(int coin) {
        this.coin = coin;
    }

    public Optional<Item> buy(String name) {
        Optional<Product> productOptional = productStorage.takeOutProduct(name);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            int change = moneyStorage.getChangeMoney(coin, product);
            return Optional.ofNullable(checkItem(product, change)).orElseThrow(IllegalArgumentException::new);
        }
        return Optional.empty();
    }

    private Optional<Item> checkItem(Product product, int change) {
        if (change >= 0) {
            Item item = new ItemImpl();
            item.setProduct(product);
            item.setChange(change);
            product.setQuantity(product.getQuantity() - 1);
            productStorage.fillUpProduct(product);
            moneyStorage.addMoney(product.getPrice());
            return Optional.of(item);
        }
        return Optional.empty();
    }
}
