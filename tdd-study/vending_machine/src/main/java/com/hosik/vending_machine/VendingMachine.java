package com.hosik.vending_machine;

import com.hosik.items.Item;
import com.hosik.items.ItemImpl;
import com.hosik.money.MoneyStorage;
import com.hosik.money.MoneyStorageImpl;
import com.hosik.items.Product;

import java.util.ArrayList;
import java.util.List;

/*
1. 물건 넣기
2. 물건 계산
3. 물건 뺴기
4. 돈 받기
 */
public class VendingMachine {
    private List<Product> productList;
    private MoneyStorage moneyStorage;
    private int coin = 0;

    public VendingMachine() {
        productList = new ArrayList<>();
        moneyStorage = new MoneyStorageImpl();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
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

    public Product getProduct(String name) {
        return productList.stream()
                .filter(p -> p.getName().equals(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isPossible(Product product) {
        Product item = getProduct(product.getName());
        return coin - item.getPrice() >= 0;
    }

    public Item buy(String name) {
        Product product = getProduct(name);
        if (isPossible(product)) {
            coin -= product.getPrice();
            Item item = new ItemImpl();
            item.setProduct(product);
            item.setChange(coin);
            return item;
        } else {
            return null;
        }
    }
}
