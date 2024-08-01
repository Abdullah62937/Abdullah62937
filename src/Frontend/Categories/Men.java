package Frontend.Categories;

/*package Frontend.Categories;

import Frontend.home.Common_Gui;
import Frontend.navbar1.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Men {

    public Men(){
        JFrame frame = new JFrame();
        frame.setTitle("Levis");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, 1500, 800);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());
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

        JLabel Men_categort = new JLabel("Men's Collection");
        Men_categort.setBounds(600, 220, 250, 50);
        Men_categort.setFont(new Font("Arial", Font.BOLD, 27));
        Men_categort.setForeground(Color.black);
        formPanel.add(Men_categort);


        JPanel MENs = new JPanel();
        MENs.setLayout(null); // Use a layout manager
        MENs.setBounds(0,350,1500,5000);
        //MENs.setBackground(Color.white);
        formPanel.add(MENs);


        String[] productImagePaths = {"men_shirt1.jpg", "men_shirt2.jpg", "men_shirt3.jpg", "men_shirt4.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt7.jpg",
                                       "men_shirt7.jpg", "men_shirt6.jpg", "men_shirt5.jpg", "men_shirt4.jpg", "men_shirt6.jpg",
                                        "men_shirt7.jpg" ,  "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt4.jpg", "men_shirt7.jpg",
                                        "men_shirt5.jpg", "men_shirt6.jpg",  "men_shirt4.jpg", "men_shirt7.jpg"
        };

        String[] productDescriptions = {"Men's Shirt 1", "Men's Shirt 2", "Men's Shirt 3",
                                         "Men's Shirt 4", "Men's Shirt 5", "Men's Shirt 6",
                                          "Men's Shirt 7" , "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6",
                "Men's Shirt 6", "Men's Shirt 6", "Men's Shirt 6","Men's Shirt 6","Men's Shirt 6", "Men's Shirt 6","Men's Shirt 6","Men's Shirt 6","Men's Shirt 6",
        };
        double[] productPrices = {19.99, 29.99, 39.99, 49.99, 59.99, 69.99, 79.99 , 79.99 , 79.99, 79.99, 79.99, 79.99 , 79.99 , 79.99 , 79.99 , 79.99 , 79.99 , 79.99 , 79.99, 79.99 , 79.99 , 79.99};

        String[] productNames = {"Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt","Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt",
        };

        *//*int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int verticalGapForPriceLabel = 100; // Space for price label
        int buttonHeight = 50;
        int panelWidth = 1500; // Width of MENs panel
        int startX1 = 65;
        int startY1 = 25;
        int maxProductsPerRow = 4;*//*

        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int panelWidth = 1500; // Width of MENs panel
        int verticalGapForPriceLabel = 150; // Space for price label
        int buttonHeight = 50;
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
            imageLabel1.setBounds(startX1 + (productPanelWidth1 + productPanelSpacing1) * col,
                    startY1 + (productPanelHeight1 + productPanelSpacing1 + verticalGapForPriceLabel + buttonHeight + 10) * row,
                    productPanelWidth1, productPanelHeight1);          //  imageLabel1.setBounds(currentX, currentY, productPanelWidth1, productPanelHeight1);
            MENs.add(imageLabel1);

            // Create a placeholder for the price label
            *//*JLabel priceLabel = new JLabel("Price: $XX.XX");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            priceLabel.setBounds(currentX, currentY + productPanelHeight1 + 10, productPanelWidth1, 20);
            MENs.add(priceLabel);*//*

            JLabel nameLabel = new JLabel(productNames[i]);
            nameLabel.setBounds(imageLabel1.getX(), imageLabel1.getY() + productPanelHeight1 + 10, productPanelWidth1, 30);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(nameLabel);

            JLabel priceLabel = new JLabel("Price: $" + productPrices[i]);
            priceLabel.setBounds(priceLabel.getX(), priceLabel.getY() + productPanelHeight1 + 10, productPanelWidth1, 50);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            formPanel.add(priceLabel);

            // Create the "Add To Cart" button
            JButton addToCart = new JButton("Add To Cart");
            addToCart.setBounds(imageLabel1.getX(), imageLabel1.getY()+75 + productPanelHeight1 + 60, productPanelWidth1, 50);
           // addToCart.setBounds(currentX, currentY + productPanelHeight1 + verticalGapForPriceLabel, productPanelWidth1, buttonHeight);
            addToCart.setFont(new Font("Arial", Font.BOLD, 15));
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

            int finalI = i;
            *//*int finalI1 = i;
            int finalI2 = i;*//*
            addToCart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Product product = new Product(productNames[finalI],productImagePaths[finalI], productDescriptions[finalI], productPrices[finalI]);
                    Common_Gui.getCartModel().addProduct(product);
                }
            });

            int totalRows = (productImagePaths.length + maxProductsPerRow - 1) / maxProductsPerRow;
            int totalHeight = startY1 + totalRows * (productPanelHeight1 + productPanelSpacing1 + verticalGapForPriceLabel + buttonHeight + 10);


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
        new Men();
    }
}*/


























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

public class Men {

    public Men() {
        JFrame frame = new JFrame();
        frame.setTitle("Levis");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, 1500, 800);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());
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

        JLabel Men_categort = new JLabel("Men's Collection");
        Men_categort.setBounds(600, 220, 250, 50);
        Men_categort.setFont(new Font("Arial", Font.BOLD, 27));
        Men_categort.setForeground(Color.black);
        formPanel.add(Men_categort);

        JPanel MENs = new JPanel();
        MENs.setLayout(null); // Use null layout for custom positioning
        MENs.setBounds(0, 350, 1500, 5000);
        formPanel.add(MENs);

        String[] productImagePaths = {
                "men_shirt1.jpg", "men_shirt2.jpg", "men_shirt3.jpg", "men_shirt4.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt7.jpg",
                "men_shirt7.jpg", "men_shirt6.jpg", "men_shirt5.jpg", "men_shirt4.jpg", "men_shirt6.jpg",
                "men_shirt7.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt4.jpg", "men_shirt7.jpg",
                "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt4.jpg", "men_shirt7.jpg"
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

        String[] productNames = {
                "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt",
                "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt",
        };

        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int panelWidth = 1500; // Width of MENs panel
        int verticalGapForPriceLabel = 150; // Space for price label
        int buttonHeight = 50;
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
            MENs.add(imageLabel1);

            // Create a label for the product name
            JLabel nameLabel = new JLabel(productNames[i]);
            nameLabel.setBounds(xPosition, yPosition + productPanelHeight1 + 10, productPanelWidth1, 30);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(nameLabel);

            // Create a label for the price
            JLabel priceLabel = new JLabel("Price: $" + productPrices[i]);
            priceLabel.setBounds(xPosition, yPosition + productPanelHeight1 + 40, productPanelWidth1, 30);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(priceLabel);

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
        new Men();
    }
}















/*

import Frontend.home.Common_Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mens {
    private JFrame frame;

    public Mens() {
        frame = new JFrame();
        frame.setTitle("MENs");
        frame.setLayout(null);
        frame.setBounds(25, 15, 1500, 800);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        frame.add(navbar);

        JPanel productsPanel = new JPanel();
        productsPanel.setLayout(null);
        productsPanel.setBounds(0, 50, 1500, 2400);
        frame.add(productsPanel);

        String[] productImagePaths = {"men_shirt1.jpg", "men_shirt2.jpg", "men_shirt3.jpg", "men_shirt4.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt7.jpg"};

        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int verticalGapForPriceLabel = 100;
        int buttonHeight = 50;
        int panelWidth = 1500;
        int startX1 = 65;
        int startY1 = 25;

        int currentX = startX1;
        int currentY = startY1;

        for (int i = 0; i < productImagePaths.length; i++) {
            ImageIcon productImage1 = new ImageIcon(productImagePaths[i]);
            Image img1 = productImage1.getImage();
            Image resizedImg = img1.getScaledInstance(productPanelWidth1, productPanelHeight1, Image.SCALE_SMOOTH);
            productImage1 = new ImageIcon(resizedImg);

            JLabel imageLabel1 = new JLabel(productImage1);
            imageLabel1.setBounds(currentX, currentY, productPanelWidth1, productPanelHeight1);
            productsPanel.add(imageLabel1);

            JLabel priceLabel = new JLabel("Price: $XX.XX");
            priceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            priceLabel.setBounds(currentX, currentY + productPanelHeight1 + 10, productPanelWidth1, 20);
            productsPanel.add(priceLabel);

            JButton addToCart = new JButton("Add To Cart");
            addToCart.setBounds(currentX, currentY + productPanelHeight1 + verticalGapForPriceLabel, productPanelWidth1, buttonHeight);
            addToCart.setFont(new Font("Arial", Font.BOLD, 15));
            addToCart.setHorizontalAlignment(SwingConstants.CENTER);
            addToCart.setContentAreaFilled(false);
            addToCart.setBorderPainted(false);
            addToCart.setFocusPainted(false);
            addToCart.setBackground(new Color(255, 204, 51));
            addToCart.setOpaque(true);
            productsPanel.add(addToCart);

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

            addToCart.addActionListener(e -> {
                Common_Gui.getCartModel().addToCart();
            });

            currentX += productPanelWidth1 + productPanelSpacing1;
            if (currentX + productPanelWidth1 > panelWidth) {
                currentX = startX1;
                currentY += productPanelHeight1 + productPanelSpacing1 + verticalGapForPriceLabel + buttonHeight + 10;
            }
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Mens();
    }
}
*/




        /*JPanel products = new JPanel();
        products.setBounds(0, 125, 1400, 650);
        products.setLayout(null);
        formPanel.add(products);
*/
/*

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