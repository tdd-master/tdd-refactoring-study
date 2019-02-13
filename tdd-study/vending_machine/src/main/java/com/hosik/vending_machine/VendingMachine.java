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

    public Item buy(String name) {
        Product product = productStorage.takeOutProduct(name);
        return Optional.ofNullable(getItem(product)).orElseThrow(IllegalArgumentException::new);
    }

    private Item getItem(Product product) {
        Item item = new ItemImpl();
        int change = coin - product.getPrice();
        if (change >= 0) {
            item.setProduct(product);
            item.setChange(change);
            product.setQuantity(product.getQuantity() - 1);
            productStorage.fillUpProduct(product);
            moneyStorage.addMoney(product.getPrice());
            return item;
        }
        return null;
    }
}
