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
            if (products.get(productIndex).getStock() > 0) {
                payment.pay(products.get(productIndex).getPrice());
                products.get(productIndex).addStock(-1);
            } else {
                throw new IllegalArgumentException();
            }
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



