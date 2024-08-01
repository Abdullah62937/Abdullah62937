package Frontend.navbar1;

import Frontend.Product.proceedToCheckout;
import Frontend.home.Common_Gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Cart {

    JFrame frame;
    JPanel slidingLoginPanel;
    Timer timer;
    int panelX = 1500;
    final int panelWidth = 375; // 1/4 of 1500
    final int frameWidth = 1500;
    final int frameHeight = 800;

    private double subtotalValue;
    private double totalValue;

    private double totalPrice = 0;

    private JLabel subtotalValueLabel;

   private JLabel totalValueLabel;

    JPanel mainPanel;
    JPanel cartPanel;


    public Cart(CartModel cartModel) {
        frame = new JFrame("Cart");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, 1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1500, 2500));
        mainPanel.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        mainPanel.add(navbar);

        JPanel navbar2 = Common_Gui.CreateMenu(frame);
        mainPanel.add(navbar2);

        JPanel footer = Common_Gui.Footer(frame);
        footer.setBounds(0, 1350, 1500, 700);
        mainPanel.add(footer);

        JPanel messagePanel = new JPanel();
        messagePanel.setBounds(0, 210, 1500, 35);
        messagePanel.setBackground(new Color(253, 212, 212));
        mainPanel.add(messagePanel);

        JLabel message = new JLabel("All orders are processed in PKR, using the latest exchange rates.");
        message.setFont(new Font("Ariel", Font.BOLD, 15));
        messagePanel.add(message);

        JLabel cart = new JLabel("Your Cart");
        cart.setBounds(130, 350, 200, 30);
        cart.setFont(new Font("Arial", Font.BOLD, 27));
        cart.setForeground(Color.black);
        mainPanel.add(cart);





        JPanel cartHeadingPanel = new JPanel();
        cartHeadingPanel.setLayout(null);
        cartHeadingPanel.setBounds(130, 400, 800, 50);
        cartHeadingPanel.setBackground(new Color(255, 255, 255));
        mainPanel.add(cartHeadingPanel);

// Add headings to the cartHeadingPanel
        JLabel productHeading = new JLabel("Product");
        productHeading.setBounds(10, 10, 200, 30);
        cartHeadingPanel.add(productHeading);

        JLabel priceHeading = new JLabel("Price");
        priceHeading.setBounds(350, 10, 100, 30);
        cartHeadingPanel.add(priceHeading);

        JLabel quantityHeading = new JLabel("Quantity");
        quantityHeading.setBounds(530, 10, 100, 30);
        cartHeadingPanel.add(quantityHeading);

        JLabel totalHeading = new JLabel("Total");
        totalHeading.setBounds(750, 10, 100, 30);
        cartHeadingPanel.add(totalHeading);



        cartPanel = new JPanel();
        cartPanel.setLayout(null); // Use null layout to position elements manually
        cartPanel.setBounds(130, 450, 850, 300);
        cartPanel.setBackground(new Color(255, 255, 255));
        cartPanel.setBorder(new LineBorder(Color.BLACK, 1));
        mainPanel.add(cartPanel);

        // Column Headers
        /*JLabel product = new JLabel("PRODUCT");
        product.setFont(new Font("Ariel", Font.BOLD, 13));
        product.setBounds(10, 10, 200, 30); // x, y, width, height
        cartPanel.add(product);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Ariel", Font.BOLD, 13));
        price.setBounds(350, 10, 200, 30); // x, y, width, height
        cartPanel.add(price);

        JLabel quantity = new JLabel("Quantity");
        quantity.setFont(new Font("Ariel", Font.BOLD, 13));
        quantity.setBounds(500, 10, 200, 30); // x, y, width, height
        cartPanel.add(quantity);

        JLabel total = new JLabel("Total");
        total.setFont(new Font("Ariel", Font.BOLD, 13));
        total.setBounds(750, 10, 200, 30); // x, y, width, height
        cartPanel.add(total);*/



        // Add Products to Cart Panel
        List<Product> products = cartModel.getProducts();
        int yPosition = 10; // Starting y position for products

        JLabel productImage = new JLabel();

        totalPrice = 0;
        for (Product productItem : products) {
            totalPrice += productItem.getPrice();

            try {
                ImageIcon productIcon = new ImageIcon(productItem.getImagePath());
                Image scaledImage = productIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

                productImage = new JLabel(new ImageIcon(scaledImage));
                productImage.setBounds(10, yPosition, 50, 50);
                cartPanel.add(productImage);
            } catch (Exception e) {
                System.err.println("Error loading image: " + productItem.getImagePath());
                e.printStackTrace();
            }

            JLabel productDescription = new JLabel(productItem.getDescription());
            productDescription.setBounds(70, yPosition, 200, 50);
            cartPanel.add(productDescription);

            JLabel productPrice = new JLabel("$" + productItem.getPrice());
            productPrice.setBounds(350, yPosition, 100, 50);
            cartPanel.add(productPrice);

            JLabel productQuantity = new JLabel("1");
            productQuantity.setBounds(550, yPosition, 50, 50);
            cartPanel.add(productQuantity);

            JLabel productTotal = new JLabel("$" + productItem.getPrice());
            productTotal.setBounds(750, yPosition, 100, 50);
            cartPanel.add(productTotal);

            // Create quantityy panel for increase/decrease buttons within each product row
            JPanel quantityy = new JPanel();
            quantityy.setLayout(null); // Use null layout to position elements manually
            quantityy.setBounds(600, yPosition, 110, 50);
            quantityy.setOpaque(false); // Make the background transparent
            quantityy.setBorder(new LineBorder(Color.BLACK, 1)); // Add a black border
            cartPanel.add(quantityy);

            JLabel quantityLabel = new JLabel("1");
            quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
            quantityLabel.setBounds(38, 10, 30, 30);
            quantityy.add(quantityLabel);

            ImageIcon icon_increaser = new ImageIcon("plus.png");
            Image image1 = icon_increaser.getImage();
            Image newimg1 = image1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            icon_increaser = new ImageIcon(newimg1);

            JButton increaseButton = new JButton(icon_increaser);
            increaseButton.setBounds(7, 10, 20, 30);
            increaseButton.setContentAreaFilled(false); // Remove button background
            increaseButton.setBorderPainted(false); // Remove button border
            increaseButton.setFocusPainted(false); // Remove focus painting
            quantityy.add(increaseButton);

            increaseButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    increaseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    increaseButton.setBackground(new Color(201, 198, 198));
                }
            });

            increaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int currentQuantity = Integer.parseInt(quantityLabel.getText());
                    currentQuantity++;
                    quantityLabel.setText(String.valueOf(currentQuantity));
                    // Update total price of the product
                    productTotal.setText("$" + (productItem.getPrice() * currentQuantity));
                    // Update total cart price

                    totalPrice += productItem.getPrice();
                    updateTotalAndSubtotal(subtotalValue, totalValue);
                }
            });

            ImageIcon icon_decreaser = new ImageIcon("minus.png");
            Image image2 = icon_decreaser.getImage();
            Image newimg2 = image2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            icon_decreaser = new ImageIcon(newimg2);

            JButton decreaseButton = new JButton(icon_decreaser);
            decreaseButton.setBounds(75, 10, 20, 30);
            decreaseButton.setContentAreaFilled(false); // Remove button background
            decreaseButton.setBorderPainted(false); // Remove button border
            decreaseButton.setFocusPainted(false); // Remove focus painting
            quantityy.add(decreaseButton);

            decreaseButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    decreaseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    decreaseButton.setBackground(new Color(201, 198, 198));
                }
            });

            decreaseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int currentQuantity = Integer.parseInt(quantityLabel.getText());
                    if (currentQuantity > 1) {
                        currentQuantity--;
                        quantityLabel.setText(String.valueOf(currentQuantity));
                        // Update total price of the product
                        productTotal.setText("$" + (productItem.getPrice() * currentQuantity));
                        // Update total cart price
                        totalPrice -= productItem.getPrice();
                        updateTotalAndSubtotal(subtotalValue, totalValue);
                    }
                }
            });

            ImageIcon cancelIcon = new ImageIcon("cancel_icon.png");
            Image cancelImage = cancelIcon.getImage();
            Image scaledCancelImage = cancelImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            cancelIcon = new ImageIcon(scaledCancelImage);

            JButton cancelButton = new JButton(cancelIcon);
            cancelButton.setBounds(820, yPosition + 15, 20, 20);
            cancelButton.setContentAreaFilled(false); // Remove button background
            cancelButton.setBorderPainted(false); // Remove button border
            cancelButton.setFocusPainted(false); // Remove focus painting
            cartPanel.add(cancelButton);

            cancelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    cancelButton.setBackground(new Color(201, 198, 198));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    cancelButton.setBackground(null);
                }
            });

            JLabel finalProductImage = productImage;
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    products.remove(productItem);
                    totalPrice -= productItem.getPrice() * Integer.parseInt(quantityLabel.getText());
                    updateTotalAndSubtotal(subtotalValue, totalValue);
                    cartPanel.remove(finalProductImage);
                    cartPanel.remove(productDescription);
                    cartPanel.remove(productPrice);
                    cartPanel.remove(quantityy);
                    cartPanel.remove(productQuantity);
                    cartPanel.remove(productTotal);
                    cartPanel.remove(cancelButton);
                    cartPanel.revalidate();
                    cartPanel.repaint();
                    adjustCartPanelSize(cartPanel, products.size());

                }
            });

            yPosition += 60; // Update y position for the next product

            adjustCartPanelSize(cartPanel, products.size());

        }

        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(null); // Use null layout to position elements manually
        summaryPanel.setBounds(130, 480, 800, 150);
        summaryPanel.setOpaque(false); // Make the background transparent
        summaryPanel.setBorder(new LineBorder(Color.BLACK, 1)); // Add a black border
        mainPanel.add(summaryPanel);

        JLabel quantityLabel = new JLabel("0");
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quantityLabel.setBounds(38, 10, 30, 20);
        summaryPanel.add(quantityLabel);

        JPanel order_summary = new JPanel();
        order_summary.setLayout(null); // Use null layout to position elements manually
        order_summary.setBounds(1000, 400, 500, 400);
        order_summary.setOpaque(false); // Make the background transparent
        mainPanel.add(order_summary);

        JLabel Order_summary = new JLabel("Order Summary");
        Order_summary.setFont(new Font("Ariel", Font.BOLD, 13));
        Order_summary.setBounds(20, 7, 200, 30); // x, y, width, height
        order_summary.add(Order_summary);

        JPanel linePanel = new JPanel();
        linePanel.setBounds(20, 40, 350, 1); // Adjust the position and size as needed
        linePanel.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        order_summary.add(linePanel); // Add the line panel to the order_summary panel

        JLabel subtotal = new JLabel("Subtotal");
        subtotal.setFont(new Font("Ariel", Font.BOLD, 13));
        subtotal.setBounds(20, 70, 200, 30); // x, y, width, height
        order_summary.add(subtotal);

        /*JLabel subtotalValue = new JLabel("$" + totalPrice);
        subtotalValue.setFont(new Font("Ariel", Font.BOLD, 13));
        subtotalValue.setBounds(300, 70, 200, 30); // x, y, width, height
        order_summary.add(subtotalValue);*/

        subtotalValueLabel = new JLabel("$" + totalPrice);
        subtotalValueLabel.setFont(new Font("Arial", Font.BOLD, 13));
        subtotalValueLabel.setBounds(300 , 70, 200, 30); // Adjust position and size as needed
        order_summary.add(subtotalValueLabel);

        JPanel linePanel1 = new JPanel();
        linePanel1.setBounds(20, 100, 350, 1); // Adjust the position and size as needed
        linePanel1.setBorder(new LineBorder(Color.lightGray)); // Add a black line border
        order_summary.add(linePanel1); // Add the line panel to the order_summary panel

        JLabel Total = new JLabel("Total");
        Total.setFont(new Font("Ariel", Font.BOLD, 13));
        Total.setBounds(20, 120, 200, 30); // x, y, width, height
        order_summary.add(Total);

        totalValueLabel = new JLabel("$" + totalPrice);
        totalValueLabel.setFont(new Font("Ariel", Font.BOLD, 13));
        totalValueLabel.setBounds(300, 120, 200, 30); // x, y, width, height
        order_summary.add(totalValueLabel);

        JPanel linePanel3 = new JPanel();
        linePanel3.setBounds(20, 150, 350, 1); // Adjust the position and size as needed
        linePanel3.setBorder(new LineBorder(Color.lightGray)); // Add a black line border
        order_summary.add(linePanel3);

        JButton Checkout = new JButton("Proceed To Checkout");
        Checkout.setBounds(20, 180, 350, 40);
        Checkout.setFont(new Font("Ariel", Font.BOLD, 15));
        Checkout.setHorizontalTextPosition(SwingConstants.RIGHT);
        Checkout.setContentAreaFilled(false);
        Checkout.setBorderPainted(false);
        Checkout.setFocusPainted(false);
        Checkout.setBackground(new Color(255, 204, 51));
        Checkout.setOpaque(true);
        order_summary.add(Checkout);

        Checkout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Checkout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Checkout.setBackground(Color.white);
                Checkout.setBorder(new LineBorder(Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Checkout.setBackground(new Color(255, 204, 51));
            }
        });

        Checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new proceedToCheckout();
            }
        });

        JButton continue_shopping = new JButton("Continue Shopping");
        continue_shopping.setBounds(20, 240, 350, 40);
        continue_shopping.setFont(new Font("Ariel", Font.BOLD, 15));
        continue_shopping.setHorizontalTextPosition(SwingConstants.RIGHT);
        continue_shopping.setContentAreaFilled(false);
        continue_shopping.setBorderPainted(false);
        continue_shopping.setFocusPainted(false);
        continue_shopping.setBackground(new Color(253, 253, 253));
        continue_shopping.setOpaque(true);
        order_summary.add(continue_shopping);

        continue_shopping.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                continue_shopping.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                continue_shopping.setBackground(new Color(255, 204, 51));
                continue_shopping.setBorder(new LineBorder(Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                continue_shopping.setBackground(Color.white);
            }
        });

        frame.setVisible(true);
    }


    private void adjustCartPanelSize(JPanel cartPanel, int productCount) {
        int newHeight = productCount * 80 + 20; // Adjust height based on number of products
        cartPanel.setBounds(cartPanel.getX(), cartPanel.getY(), cartPanel.getWidth(), newHeight);
        cartPanel.revalidate();
    }

    private void adjustMainPanelSize() {
        // Calculate the required height for the main panel
        int requiredHeight = cartPanel.getY() + cartPanel.getHeight() + 50; // 50 for some padding at the bottom
        int currentHeight = mainPanel.getHeight();

        if (requiredHeight > currentHeight) {
            mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), requiredHeight));
            mainPanel.revalidate();
        }
    }

    private void updateTotalAndSubtotal(double subtotal, double total) {
        subtotalValueLabel.setText("$" + totalPrice);
        totalValueLabel.setText("$" + totalPrice);
    }

    private void updateTotalAndSubtotal() {
        // Update subtotalValue and totalValue directly
        subtotalValue = totalPrice;
        totalValue = totalPrice;
        // Update labels
        subtotalValueLabel.setText("$" + subtotalValue);
        totalValueLabel.setText("$" + totalValue);
    }

    public static void main(String[] args) {
        CartModel cartModel = new CartModel();
        // Add sample products to the cartModel for testing
        cartModel.addProduct(new Product("Levi's Jeans", "men_shirt1", "beautifully", 500.00));
        cartModel.addProduct(new Product("Levi's Jacket", "men_shirt2", "beautiful", 500.00));

        Cart cart = new Cart(cartModel);
    }
}
