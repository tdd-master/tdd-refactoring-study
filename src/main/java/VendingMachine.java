import payment.Payment;
import product.Product;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class VendingMachine {

    List<Product> products;
    Queue<Product> selectedProducts; // polling

    VendingMachine(List<Product> products) {
        this.products = products;
        this.selectedProducts = new LinkedBlockingQueue<>();
    }

    public int purchase(Payment payment) {

        while (payment.getChange() > 0) {
            if (!selectedProducts.isEmpty()) {
                try {
                    payment.pay(selectedProducts.peek().getPrice());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return getChange(payment);
                }
            }
        }
        return getChange(payment);
    }

    public void selectProduct(int productIndex) {
        this.selectedProducts.add(this.products.get(productIndex));

    }

    public int getChange(Payment payment) {
        return payment.getChange();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}



