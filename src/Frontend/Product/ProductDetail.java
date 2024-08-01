package Frontend.Product;

import Frontend.home.Common_Gui;
import Frontend.navbar1.Product;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductDetail {

    JFrame frame;
    private JLabel mainImageLabel;
    private JLabel[] thumbnailLabels;
    private ImageIcon[] thumbnailImages;
    private ImageIcon[] fullSizeImages;
    public ProductDetail(String name, String imagePath, String description, double price) {

        frame = new JFrame("Product_Page");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, 1500, 800);

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


        // Product image

        JPanel product_image_panel = new JPanel();
        product_image_panel.setLayout(null); // Use a layout manager
        product_image_panel.setBounds(200, 300, 500, 600); // Set bounds for the poster panel
        formPanel.add(product_image_panel);

        ImageIcon productImage = new ImageIcon("men_shirt7.jpg"); // specify the path to your icon
        Image product_image = productImage.getImage();
        Image product_image_new = product_image.getScaledInstance(500, 600, Image.SCALE_SMOOTH);
        productImage = new ImageIcon(product_image_new);

        JLabel product_image_label =  new JLabel(productImage);
        product_image_label.setBounds(0,0,500,600);
        product_image_panel.add(product_image_label);

        JPanel product_details = new JPanel();
        product_details.setLayout(null); // Use a layout manager
        product_details.setBounds(800, 300, 750, 700); // Set bounds for the poster panel
        product_details.setBackground(Color.white);
        formPanel.add(product_details);

        JLabel product_name = new JLabel();
        product_name.setText("Printed Lawn 1 PCS");
        product_name.setBounds(0,0,400,50);
        product_name.setFont(new Font("Monospaced", Font.PLAIN, 30));
        product_name.setForeground(new Color(0, 0, 0));
        product_details.add(product_name);


        JLabel product_Sku = new JLabel();
        product_Sku.setText("Brand: Levi's");
        product_Sku.setBounds(0,50,400,20);
        product_Sku.setFont(new Font("Dialog", Font.PLAIN, 15));
        product_Sku.setForeground(new Color(121, 121, 121));
        product_details.add(product_Sku);



        ImageIcon starIcon = new ImageIcon("star_icon.png"); // Replace "star_icon.png" with your star icon file path
        Image star_image = starIcon.getImage();
        Image star_image_new = star_image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon starImage = new ImageIcon(star_image_new);

        int numberOfStars = 5;

// Position of the first star
        int startX = 0; // Adjust as needed
        int startY = 140; // Adjust as needed
        int scaledWidth = 20; // Adjust as needed
        int scaledHeight = 20; // Adjust as needed

// Spacing between stars
        int spacing = 5; // Adjust as needed

// Create and add star icons to the frame
        for (int i = 0; i < numberOfStars; i++) {
            JLabel starLabel = new JLabel(starImage);
            starLabel.setBounds(startX + i * (scaledWidth + spacing), startY, scaledWidth, scaledHeight);
            product_details.add(starLabel);
        }

        JLabel product_price = new JLabel();
        product_price.setText("RS.1,899");
        product_price.setBounds(0,90,400,30);
        product_price.setFont(new Font("Monospaced", Font.PLAIN, 25));
        product_price.setForeground(new Color(63, 63, 63));
        product_details.add(product_price);


        JPanel linePanel1 = new JPanel();
        linePanel1.setBounds(0, 175, 550, 1); // Adjust the position and size as needed
        linePanel1.setBorder(new LineBorder(new Color(169, 168, 168))); // Add a black line border
        product_details.add(linePanel1);

        JLabel product_Details= new JLabel("Product Details");
        product_Details.setBounds(0,210,400,30);
        product_Details.setFont(new Font("Monospaced", Font.PLAIN, 20));
        product_Details.setForeground(new Color(0, 0, 0));
        product_details.add(product_Details);

        JLabel Fabric= new JLabel("Fabric: Lawn");
        Fabric.setBounds(0,270,400,30);
        Fabric.setFont(new Font("Monospaced", Font.PLAIN, 20));
        Fabric.setForeground(new Color(0, 0, 0));
        product_details.add(Fabric);

        JLabel Colour= new JLabel("Colour: Multi");
        Colour.setBounds(0,330,400,30);
        Colour.setFont(new Font("Monospaced", Font.PLAIN, 20));
        Colour.setForeground(new Color(0, 0, 0));
        product_details.add(Colour);

        JLabel Share= new JLabel("Share");
        Share.setBounds(0,390,400,30);
        Share.setFont(new Font("Monospaced", Font.PLAIN, 18));
        Share.setForeground(new Color(0, 0, 0));
        product_details.add(Share);

        String[] iconPaths = {"facebook_icon.png", "instagram_icon.png"}; // Add more icon file paths as needed

        // Position and size variables
        int startX1 = 70;
        int startY1 = 400;
        int iconWidth = 20;
        int iconHeight = 20;
        int spacing1 = 30;

        // Create a panel to add icons
        // Create and add icons to the panel
        for (int i = 0; i < iconPaths.length; i++) {
            ImageIcon icon1 = new ImageIcon(iconPaths[i]);
            Image scaledIcon = icon1.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
            icon1 = new ImageIcon(scaledIcon);
            JLabel iconLabel = new JLabel(icon1);
            int x = startX1 + i * (iconWidth + spacing1);
            iconLabel.setBounds(x, startY1, iconWidth, iconHeight);
            product_details.add(iconLabel);
        }

        JPanel quantityy = new JPanel();
        quantityy.setLayout(null); // Use null layout to position elements manually
        quantityy.setBounds(0, 470, 170, 50);
        quantityy.setOpaque(false); // Make the background transparent
        quantityy.setBorder(new LineBorder(Color.LIGHT_GRAY, 1)); // Add a black border
        product_details.add(quantityy);


        JLabel quantityLabel = new JLabel("1");
        quantityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        quantityLabel.setBounds(70, 10, 30, 30);
        quantityy.add(quantityLabel);

        ImageIcon icon_increaser = new ImageIcon("plus.png");
        Image image1 = icon_increaser.getImage();
        Image newimg1 = image1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        icon_increaser = new ImageIcon(newimg1);

        JButton increaseButton = new JButton(icon_increaser);
        increaseButton.setBounds(20, 10, 15, 30);
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
            }
        });

        ImageIcon icon_decreaser = new ImageIcon("minus.png");
        Image image2 = icon_decreaser.getImage();
        Image newimg2 = image2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        icon_decreaser = new ImageIcon(newimg2);

        JButton decreaseButton = new JButton(icon_decreaser);
        decreaseButton.setBounds(130, 10, 15, 30);
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
                }
            }
        });

        JButton Addtocart_btn = new JButton("Add To Cart");
        Addtocart_btn.setBounds(0, 570, 400, 40);
        Addtocart_btn.setHorizontalTextPosition(SwingConstants.RIGHT);
        Addtocart_btn.setContentAreaFilled(false);
        Addtocart_btn.setBorderPainted(false);
        Addtocart_btn.setFocusPainted(false);
        Addtocart_btn.setBackground(new Color(255, 204, 51));
        Addtocart_btn.setOpaque(true);
        product_details.add(Addtocart_btn);

        Addtocart_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Addtocart_btn.setBackground(Color.white);

            }
            @Override
            public void mouseExited(MouseEvent e) {
                Addtocart_btn.setBackground(new Color(255, 204, 51));

            }
        });

        Addtocart_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel you_may_also_like = new JLabel("you may also like");
        you_may_also_like.setBounds(600, 1100, 400, 50);
        Font font1 = new Font("serif", Font.BOLD, 30); // Font style: Bold & Italic, size: 24
        you_may_also_like.setFont(font1);
        you_may_also_like.setForeground(new Color(10, 10, 10));
        //shopByCategories.setFont(new Font("Arial", Font.BOLD, 30));
        //  shopByCategories.setForeground(new Color(91, 90, 90));
        formPanel.add(you_may_also_like);

        JPanel linePanel3 = new JPanel();
        linePanel3.setBounds(100, 1130, 450, 1); // Adjust the position and size as needed
        linePanel3.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        formPanel.add(linePanel3); // Add the line panel to the order_summary panel

        JPanel linePanel4 = new JPanel();
        linePanel4.setBounds(870, 1130, 450, 1); // Adjust the position and size as needed
        linePanel4.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        formPanel.add(linePanel4);

        JPanel MENs = new JPanel();
        MENs.setLayout(null); // Use a layout manager
        MENs.setBounds(0,1200,1500,5000);
        //MENs.setBackground(Color.white);
        formPanel.add(MENs);

        String[] productImagePaths = {"men_shirt1.jpg", "men_shirt2.jpg", "men_shirt3.jpg", "men_shirt4.jpg"};

        String[] productDescriptions = {"Men's Shirt 1", "Men's Shirt 2", "Men's Shirt 3", "Men's Shirt 6"};
        double[] productPrices = {19.99, 29.99, 39.99, 49.99 };

        String[] productNames = {"Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt"
        };

        /*int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int verticalGapForPriceLabel = 100; // Space for price label
        int buttonHeight = 50;
        int panelWidth = 1500; // Width of MENs panel
        int startX1 = 65;
        int startY1 = 25;
        int maxProductsPerRow = 4;*/

        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int panelWidth = 1500; // Width of MENs panel
        int verticalGapForPriceLabel = 100; // Space for price label
        int buttonHeight = 50;
        int startX2 = 65;
        int startY2 = 25;
        int maxProductsPerRow = 4;

        int currentX = startX2;
        int currentY = startY2;

        for (int i = 0; i < productImagePaths.length; i++) {
            ImageIcon productImage1 = new ImageIcon(productImagePaths[i]);
            Image img1 = productImage1.getImage();
            Image resizedImg = img1.getScaledInstance(productPanelWidth1, productPanelHeight1, Image.SCALE_SMOOTH);
            productImage1 = new ImageIcon(resizedImg);

            int row = i / maxProductsPerRow;
            int col = i % maxProductsPerRow;

            // Create a JLabel for the product image
            JLabel imageLabel1 = new JLabel(productImage1);
            imageLabel1.setBounds(startX2 + (productPanelWidth1 + productPanelSpacing1) * col, startY2 + (productPanelHeight1 + productPanelSpacing1) * row, productPanelWidth1, productPanelHeight1);
            MENs.add(imageLabel1);

            // Create a JLabel for the product name
            JLabel nameLabel = new JLabel(productNames[i]);
            nameLabel.setBounds(imageLabel1.getX(), imageLabel1.getY() + productPanelHeight1 + 10, productPanelWidth1, 20);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(nameLabel);

            // Create a JLabel for the product price
            JLabel priceLabel = new JLabel("Price: $" + productPrices[i]);
            priceLabel.setBounds(imageLabel1.getX(), imageLabel1.getY() + productPanelHeight1 + 30, productPanelWidth1, 20);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 14));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(priceLabel);

            // Create the "Add To Cart" button
            JButton addToCart = new JButton("Add To Cart");
            addToCart.setBounds(imageLabel1.getX(), imageLabel1.getY() + productPanelHeight1 + 60, productPanelWidth1, 50);
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
                    Product product = new Product(productNames[finalI], productImagePaths[finalI], productDescriptions[finalI], productPrices[finalI]);
                    Common_Gui.getCartModel().addProduct(product);
                }
            });

            // Calculate the next position
            currentX += productPanelWidth1 + productPanelSpacing1;
            if (currentX + productPanelWidth1 > panelWidth) {
                currentX = startX2; // Reset to start of the next row
                currentY += productPanelHeight1 + productPanelSpacing1 + verticalGapForPriceLabel + buttonHeight + 10; // Move to next row, include button height and spacing
            }
        }





        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ProductDetail productDetail = new ProductDetail("classic shirt", "men_shirt1", "beautifully crafted", 3000.00);
    }
}



/*ImageIcon productImage = new ImageIcon("men_shirt1.jpg");
        Image img = productImage.getImage();
        Image resizedImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        productImage = new ImageIcon(resizedImg);
        JLabel imageLabel = new JLabel(productImage);*/

// Product details
        /*JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel descriptionLabel = new JLabel("<html><body style='width: 300px'>" + description + "</body></html>");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel priceLabel = new JLabel("Price: $" + price);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Layout the details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.add(nameLabel);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(descriptionLabel);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(priceLabel);

        // Add components to frame
        frame.add(imageLabel, BorderLayout.CENTER);
        frame.add(detailsPanel, BorderLayout.SOUTH);*/