import product.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    List<Product> products;

    VendingMachine() {
        this.products = new ArrayList<>();
    }

    VendingMachine(List<Product> products) {
        this.products = products;
    }

    // todo 구매, 결제방식 고르는거 - Cash, Card 등



}
