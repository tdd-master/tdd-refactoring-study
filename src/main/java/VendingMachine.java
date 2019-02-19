import payment.Payment;
import product.Product;

import java.util.List;

public class VendingMachine {

    Payment payment;
    List<Product> products;

    VendingMachine(List<Product> products) {
        this.products = products;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int returnChange() {
        int change = this.payment.getChange();
        Payment payment = null;
        return change;
    }

    public void purchaseProducts(int... productIndexes) {
        for (int productIndex : productIndexes) {
            Product selectedProduct = products.get(productIndex);
            if (isStockAvaliable(selectedProduct)) {
                purchaseOne(selectedProduct);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private void purchaseOne(Product selectedProduct) {
        payment.pay(selectedProduct.getPrice());
        selectedProduct.addStock(-1);
    }

    private boolean isStockAvaliable(Product selectedProduct) {
        return selectedProduct.getStock() > 0;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}



