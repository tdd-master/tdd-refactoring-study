import payment.Payment;
import product.Product;

import java.util.List;

public class VendingMachine {

    Payment payment;
    List<Product> products;

    VendingMachine(List<Product> products) {
        this.products = products;
    }

    public void purchaseProducts(int... productIndexes) {
        for (int productIndex : productIndexes) {
            payment.pay(products.get(productIndex).getPrice());
        }
    }

    public int returnChange() {
        return this.payment.getChange();
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}



