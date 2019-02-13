import payment.Payment;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    List<Product> products;
    long watingTimeMillis = 5000;

    List<Product> selectedProducts; // polling

    VendingMachine(List<Product> products) {
        this.products = products;
    }

    public void purchase(Payment payment) {



    }

    public void selectProduct(int productIndex) {

    }

    public int selectGiveChangeButton() {

    }


    public int getChange(Payment payment) {
        return 0;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



}

