package Frontend.navbar1;

import java.util.ArrayList;
import java.util.List;

public class CartModel {
    private List<Product> products;
    private List<CartObserver> observers;

    public CartModel() {
        this.products = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        notifyObservers();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (CartObserver observer : observers) {
            observer.cartUpdated(products.size());
        }
    }
}
