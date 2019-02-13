import payment.Payment;
import product.Product;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class VendingMachine {

    List<Product> products;
    long watingTimeMillis = 5000;

    Queue<Product> selectedProducts; // polling
    long lastSelectTime;

    VendingMachine(List<Product> products) {
        this.products = products;
        this.selectedProducts = new LinkedBlockingQueue<>();
    }

    public int purchase(Payment payment) {
        this.lastSelectTime = System.currentTimeMillis();

        while (payment.getBalance() > 0) {
            if (!selectedProducts.isEmpty()) {
                try {
                    payment.pay(selectedProducts.poll().getPrice());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return getChange(payment);
                }
            }
            if (System.currentTimeMillis() - lastSelectTime > watingTimeMillis) {
                System.out.println("Timeout!");
                return getChange(payment);
            }
        }

        return 0;
    }

    public void selectProduct(int productIndex) {
        this.selectedProducts.add(this.products.get(productIndex));
        this.lastSelectTime = System.currentTimeMillis();
    }

    public int getChange(Payment payment) {
        return payment.getBalance();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}



