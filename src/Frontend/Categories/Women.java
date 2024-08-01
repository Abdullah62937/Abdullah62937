package Frontend.Categories;

import Frontend.home.Common_Gui;
import Frontend.navbar1.CartManager;
import Frontend.navbar1.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Frontend.home.Common_Gui.cartLabel;

public class Women {

    public Women(){
        JFrame frame = new JFrame();
        frame.setTitle("Levis");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, 1500, 800);
        frame.setVisible(true);

        JPanel formPanel = new JPanel();

        formPanel.setLayout(null); // Use null layout for custom positioning
        formPanel.setPreferredSize(new Dimension(1500, 5000));
        formPanel.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        formPanel.add(navbar);

        JPanel navbar2 = Common_Gui.CreateMenu(frame);
        formPanel.add(navbar2);

        JPanel footer = Common_Gui.Footer(frame);
        footer.setBounds(0, 4300, 1500, 700);
        formPanel.add(footer);

        JLabel Women_categort = new JLabel("Women's Collection");
        Women_categort.setBounds(600, 220, 250, 50);
        Women_categort.setFont(new Font("Arial", Font.BOLD, 27));
        Women_categort.setForeground(Color.black);
        formPanel.add(Women_categort);

       /* JPanel MENs = new JPanel();
        MENs.setLayout(null); // Use a layout manager
        MENs.setBounds(0,350,1500,2400);
        //MENs.setBackground(Color.white);
        formPanel.add(MENs);


       *//* JPanel products = new JPanel();
        products.setBounds(0, 125, 1400, 650);
        products.setLayout(null);
        mainPanel.add(products);*//*

        String[] productImagePaths = {"men_shirt1.jpg","men_shirt2.jpg","men_shirt3.jpg","men_shirt4.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt7.jpg"};

        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int startX1 = 65;
        int startY1 = 25;

        for (int i = 0; i < productImagePaths.length; i++) {
            ImageIcon productImage1 = new ImageIcon(productImagePaths[i]);
            Image img1 = productImage1.getImage();
            Image resizedImg = img1.getScaledInstance(productPanelWidth1, productPanelHeight1, Image.SCALE_SMOOTH);
            productImage1 = new ImageIcon(resizedImg);

            JButton addToCart = new JButton("Add To Cart");
            addToCart.setBounds(startX1 + (productPanelWidth1 + productPanelSpacing1) * i, 150   + productPanelHeight1 + 5, productPanelWidth1, 50);
            addToCart.setFont(new Font("ariel", Font.BOLD, 15));
            addToCart.setHorizontalAlignment(SwingConstants.CENTER);
            addToCart.setContentAreaFilled(false);
            addToCart.setBorderPainted(false);
            addToCart.setFocusPainted(false);
            addToCart.setBackground(new Color(255, 204, 51));
            addToCart.setOpaque(true);
            MENs.add(addToCart);

            addToCart.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    addToCart.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    addToCart.setBackground(Color.lightGray);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    addToCart.setBackground(new Color(255, 204, 51));

                }
            });

            JLabel imageLabel1 = new JLabel(productImage1);
            imageLabel1.setBounds(startX1 + (productPanelWidth1 + productPanelSpacing1) * i, startY1, productPanelWidth1, productPanelHeight1);
            MENs.add(imageLabel1);
        }*/

        JPanel Women = new JPanel();
        Women.setLayout(null); // Use null layout for custom positioning
        Women.setBounds(0, 300, 1500, 6000);
        formPanel.add(Women);

        String[] productImagePaths = {"men_shirt1.jpg", "men_shirt2.jpg", "men_shirt3.jpg", "men_shirt4.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt7.jpg",
                "men_shirt7.jpg", "men_shirt6.jpg", "men_shirt5.jpg", "men_shirt4.jpg", "men_shirt6.jpg",
                "men_shirt7.jpg" ,  "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt4.jpg", "men_shirt7.jpg",
                "men_shirt5.jpg", "men_shirt6.jpg",  "men_shirt4.jpg", "men_shirt7.jpg"
        };

        String[] productNames = {
                "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt",
        };

        String[] productDescriptions = {
                "Men's Shirt 1", "Men's Shirt 2", "Men's Shirt 3",
                "Men's Shirt 4", "Men's Shirt 5", "Men's Shirt 6",
                "Men's Shirt 7", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6",
                "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6",
        };

        double[] productPrices = {
                19.99, 29.99, 39.99, 49.99, 59.99, 69.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99, 79.99
        };

        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int verticalGapForPriceLabel = 150; // Space for price label
        int buttonHeight = 50;
        int panelWidth = 1500; // Width of MENs panel
        int startX1 = 65;
        int startY1 = 25;
        int maxProductsPerRow = 4;


        int currentX = startX1;
        int currentY = startY1;

        for (int i = 0; i < productImagePaths.length; i++) {
            ImageIcon productImage1 = new ImageIcon(productImagePaths[i]);
            Image img1 = productImage1.getImage();
            Image resizedImg = img1.getScaledInstance(productPanelWidth1, productPanelHeight1, Image.SCALE_SMOOTH);
            productImage1 = new ImageIcon(resizedImg);

            int row = i / maxProductsPerRow;
            int col = i % maxProductsPerRow;

            int xPosition = startX1 + (productPanelWidth1 + productPanelSpacing1) * col;
            int yPosition = startY1 + (productPanelHeight1 + productPanelSpacing1) * row;

            // Create a JLabel for the product image
            JLabel imageLabel1 = new JLabel(productImage1);
            imageLabel1.setBounds(xPosition, currentY, productPanelWidth1, productPanelHeight1);
            Women.add(imageLabel1);

            JLabel nameLabel = new JLabel(productNames[i]);
            nameLabel.setBounds(xPosition, yPosition + productPanelHeight1 + 10, productPanelWidth1, 30);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Women.add(nameLabel);

            /*// Create a placeholder for the price label
            JLabel priceLabel = new JLabel("Price: $XX.XX");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            priceLabel.setBounds(currentX, currentY + productPanelHeight1 + 10, productPanelWidth1, 20);
            Women.add(priceLabel);*/

            JLabel priceLabel = new JLabel("Price: $" + productPrices[i]);
            priceLabel.setBounds(xPosition, yPosition + productPanelHeight1 + 40, productPanelWidth1, 30);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Women.add(priceLabel);

            // Create the "Add To Cart" button
            JButton addToCart = new JButton("Add To Cart");
            addToCart.setBounds(xPosition, currentY + productPanelHeight1 + 75, productPanelWidth1, 50);
            addToCart.setFont(new Font("Arial", Font.BOLD, 15));
            addToCart.setHorizontalAlignment(SwingConstants.CENTER);
            addToCart.setContentAreaFilled(false);
            addToCart.setBorderPainted(false);
            addToCart.setFocusPainted(false);
            addToCart.setBackground(new Color(255, 204, 51));
            addToCart.setOpaque(true);
            Women.add(addToCart);

            addToCart.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    addToCart.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    addToCart.setBackground(Color.lightGray);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    addToCart.setBackground(new Color(255, 204, 51));
                }
            });

            int finalI = i;
            addToCart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CartManager.getInstance().addToCart();
                    cartLabel.setText(String.valueOf(CartManager.getInstance().getQuantity()));
                    Product product = new Product(productNames[finalI], productImagePaths[finalI], productDescriptions[finalI], productPrices[finalI]);
                    Common_Gui.getCartModel().addProduct(product);
                }
            });

            // Calculate the next position
            currentX += productPanelWidth1 + productPanelSpacing1;
            if (currentX + productPanelWidth1 > panelWidth) {
                currentX = startX1; // Reset to start of the next row
                currentY += productPanelHeight1 + productPanelSpacing1 + verticalGapForPriceLabel + buttonHeight + 10; // Move to next row, include button height and spacing
            }
        }

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Women();
    }
}
