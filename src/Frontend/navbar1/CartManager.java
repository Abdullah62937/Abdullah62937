package Frontend.navbar1;

public class CartManager {
    private static CartManager instance;
    private int quantity;

    private CartManager() {
        quantity = 0;
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addToCart() {
        quantity++;
    }
}
