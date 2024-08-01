
package Frontend.home;

import Frontend.Categories.Women;
import Frontend.navbar1.CartManager;
import Frontend.navbar1.Product;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Frontend.home.Common_Gui.cartLabel;

public class Home_page {
    private int currentIndex = 0;
    private final JLabel imageLabel;
    private final String[] imagePaths;
    private final Timer timer;
    private final JPanel posterPanel;

    JFrame frame;

    public Home_page() {
        frame = new JFrame();

        frame.setTitle("Levis");
        frame.setBackground(Color.white);
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, 1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.white);
        mainPanel.setPreferredSize(new Dimension(1500, 4000)); // Ensure it's large enough to require scrolling

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBounds(20, 20, 1460, 760); // Add margins to the scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        mainPanel.add(navbar);

        JPanel navbar2 = Common_Gui.CreateMenu(frame);
        mainPanel.add(navbar2);

        JPanel footer = Common_Gui.Footer(frame);
        mainPanel.add(footer);

        posterPanel = new JPanel();
        posterPanel.setLayout(new BorderLayout()); // Use a layout manager
        posterPanel.setBounds(0, 200, 1465, 400); // Set bounds for the poster panel
        mainPanel.add(posterPanel);

        imagePaths = new String[]{
                "Poster1.png",
                "Poster2.png",
                "Poster1.png"
                // Add paths to your images here
        };

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        posterPanel.add(imageLabel, BorderLayout.CENTER);

        loadNextImage();

        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadNextImage();
            }
        });

        timer.start();

        JLabel shopByCategories = new JLabel("Shop By Category");
        shopByCategories.setBounds(550, 650, 400, 50);
        Font font = new Font("Serif", Font.BOLD, 40); // Font style: Bold & Italic, size: 24
        shopByCategories.setFont(font);
        shopByCategories.setForeground(new Color(10, 10, 10));
        //shopByCategories.setFont(new Font("Arial", Font.BOLD, 30));
        //  shopByCategories.setForeground(new Color(91, 90, 90));
        mainPanel.add(shopByCategories);

        JPanel linePanel = new JPanel();
        linePanel.setBounds(100, 680, 400, 1); // Adjust the position and size as needed
        linePanel.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        mainPanel.add(linePanel); // Add the line panel to the order_summary panel

        JPanel linePanel1 = new JPanel();
        linePanel1.setBounds(900, 680, 400, 1); // Adjust the position and size as needed
        linePanel1.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        mainPanel.add(linePanel1);

        JPanel categories = new JPanel();
        categories.setLayout(null); // Use a layout manager
        categories.setBounds(0,740,1500,300);
        // categories.setBackground(Color.white);
        mainPanel.add(categories);

        String [] category  = new String[3];
        category = new String[] {"men_shirt2.jpg", "men_shirt1.jpg"};
        String[] categoryNames = {"Men", "women"};


        int productPanelWidth = 200;
        int productPanelHeight = 220;
        int productPanelSpacing = 35;
        int startX = 250;
        int startY = 25;

        for (int i = 0; i < category.length; i++) {
            ImageIcon productImage = new ImageIcon(category[i]);
            Image img = productImage.getImage();
            Image resizedImg = img.getScaledInstance(productPanelWidth, productPanelHeight, Image.SCALE_SMOOTH);
            productImage = new ImageIcon(resizedImg);

            JButton categoryNameButton = new JButton(categoryNames[i]);
            categoryNameButton.setBounds(startX + (productPanelWidth + productPanelSpacing) * i, startY + productPanelHeight + 5, productPanelWidth, 30);
            categoryNameButton.setHorizontalAlignment(SwingConstants.CENTER);
            categoryNameButton.setContentAreaFilled(false);
            categoryNameButton.setBorderPainted(false);
            categoryNameButton.setFocusPainted(false);
            categoryNameButton.setBackground(new Color(255, 204, 51));
            categoryNameButton.setOpaque(true);
            categories.add(categoryNameButton);

            categoryNameButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    categoryNameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    categoryNameButton.setBackground(Color.lightGray);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    categoryNameButton.setBackground(new Color(255, 204, 51));

                }
            });

            JLabel imageLabel = new JLabel(productImage);
            imageLabel.setBounds(startX + (productPanelWidth + productPanelSpacing) * i, startY, productPanelWidth, productPanelHeight);
            categories.add(imageLabel);

            String categoryName = categoryNames[i];
            JLabel categoryLabel = new JLabel(categoryName);
            categoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
            categoryLabel.setBounds(imageLabel.getX(), imageLabel.getY() + productPanelHeight, productPanelWidth, 30);
            categories.add(categoryLabel);

            ImageIcon finalProductImage = productImage;
            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    imageLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    Image img = finalProductImage.getImage();
                    Image newImg = img.getScaledInstance(productPanelWidth + 30, productPanelHeight + 30, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(newImg));

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    imageLabel.setIcon(finalProductImage);

                }
            });


        }



        //Men's Collecttion..............




        JLabel Men = new JLabel("Men's");
        Men.setBounds(650, 1100, 400, 50);
        Font font1 = new Font("Serif", Font.BOLD, 40); // Font style: Bold & Italic, size: 24
        Men.setFont(font1);
        Men.setForeground(new Color(10, 10, 10));
        //shopByCategories.setFont(new Font("Arial", Font.BOLD, 30));
        //  shopByCategories.setForeground(new Color(91, 90, 90));
        mainPanel.add(Men);

        JPanel linePanel3 = new JPanel();
        linePanel3.setBounds(100, 1130, 500, 1); // Adjust the position and size as needed
        linePanel3.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        mainPanel.add(linePanel3); // Add the line panel to the order_summary panel

        JPanel linePanel4 = new JPanel();
        linePanel4.setBounds(820, 1130, 500, 1); // Adjust the position and size as needed
        linePanel4.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        mainPanel.add(linePanel4);

        JPanel MENs = new JPanel();
        MENs.setLayout(null); // Use a layout manager
        MENs.setBounds(0,1200,1500,800);
        //MENs.setBackground(Color.white);
        mainPanel.add(MENs);

        String[] Men_productImagePaths = {"men_shirt4.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt7.jpg"};

        String[] productDescriptions = {"Men's Shirt 1", "Men's Shirt 2", "Men's Shirt 3", "Men's Shirt 4"};

        double[] productPrices = {19.99, 29.99, 39.99, 49.99};

        String[] productNames = {"Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt"};


        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int maxProductsPerRow = 4;

        int startX1 = 45;
        int startY1 = 25;

        for (int i = 0; i < Men_productImagePaths.length; i++) {
            ImageIcon productImage1 = new ImageIcon(Men_productImagePaths[i]);
            Image img1 = productImage1.getImage();
            Image resizedImg = img1.getScaledInstance(productPanelWidth1, productPanelHeight1, Image.SCALE_SMOOTH);
            productImage1 = new ImageIcon(resizedImg);

            int row = i / maxProductsPerRow;
            int col = i % maxProductsPerRow;

            int xPosition = startX1 + (productPanelWidth1 + productPanelSpacing1) * col;
            int yPosition = startY1 + (productPanelHeight1 + productPanelSpacing1) * row;

            JLabel imageLabel1 = new JLabel(productImage1);
            imageLabel1.setBounds(xPosition, yPosition, productPanelWidth1, productPanelHeight1);
            MENs.add(imageLabel1);

            JLabel nameLabel = new JLabel(productNames[i]);
            nameLabel.setBounds(xPosition, yPosition + productPanelHeight1 + 10, productPanelWidth1, 30);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(nameLabel);

            JLabel priceLabel = new JLabel("Price: $" + productPrices[i]);
            priceLabel.setBounds(xPosition, yPosition + productPanelHeight1 + 40, productPanelWidth1, 30);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(priceLabel);

            JButton addToCart = new JButton("Add To Cart");
            addToCart.setBounds(xPosition, yPosition + productPanelHeight1 + 75, productPanelWidth1, 50);
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
                    Product product = new Product(productNames[finalI], Men_productImagePaths[finalI], productDescriptions[finalI], productPrices[finalI]);
                    Common_Gui.getCartModel().addProduct(product);

                    CartManager.getInstance().addToCart();
                    cartLabel.setText(String.valueOf(CartManager.getInstance().getQuantity()));
                }
            });
        }

        JButton view_more = new JButton("view More");
        view_more.setBounds(600, 750, 200, 40);
        view_more.setFont(new Font("ariel", Font.BOLD, 15));
        view_more.setHorizontalTextPosition(SwingConstants.RIGHT);
        view_more.setContentAreaFilled(false);
        view_more.setBorderPainted(false);
        view_more.setFocusPainted(false);
        view_more.setBackground(new Color(255, 204, 51));
        view_more.setOpaque(true);
        MENs.add(view_more);

        view_more.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                view_more.setCursor(new Cursor(Cursor.HAND_CURSOR));
                view_more.setBackground(Color.lightGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                view_more.setBackground(new Color(255, 204, 51));

            }
        });

        view_more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        //Women's Collecttion..............


        JLabel Women = new JLabel("Women's");
        Women.setBounds(650, 2070, 400, 50);
        Font women_font1 = new Font("Serif", Font.BOLD, 40); // Font style: Bold & Italic, size: 24
        Women.setFont(women_font1);
        Women.setForeground(new Color(10, 10, 10));
        //shopByCategories.setFont(new Font("Arial", Font.BOLD, 30));
        //  shopByCategories.setForeground(new Color(91, 90, 90));
        mainPanel.add(Women);

        JPanel linePanel5 = new JPanel();
        linePanel5.setBounds(100, 2100, 500, 1); // Adjust the position and size as needed
        linePanel5.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        mainPanel.add(linePanel5); // Add the line panel to the order_summary panel

        JPanel linePanel6 = new JPanel();
        linePanel6.setBounds(820, 2100, 500, 1); // Adjust the position and size as needed
        linePanel6.setBorder(new LineBorder(Color.BLACK)); // Add a black line border
        mainPanel.add(linePanel6);

        JPanel Womens = new JPanel();
        Womens.setLayout(null); // Use a layout manager
        Womens.setBounds(0,2200,1500,800);
        Womens.setBackground(Color.white);
        mainPanel.add(Womens);


       /* JPanel products = new JPanel();
        products.setBounds(0, 125, 1400, 650);
        products.setLayout(null);
        mainPanel.add(products);*/

        String[] women_product_image_paths = {"men_shirt8.jpg", "men_shirt7.jpg", "men_shirt6.jpg", "men_shirt5.jpg"};
        String[] women_productDescriptions = {"Women's Shirt 1", "Women's Shirt 2", "Women's Shirt 3", "Women's Shirt 4"};
        double[] women_productPrices = {19.99, 29.99, 39.99, 49.99};
        String[] women_productNames = {"Women's Shirt", "Women's Shirt", "Women's Shirt", "Women's Shirt"};

        int womenPanelWidth1 = 300;
        int womenPanelHeight1 = 450;
        int womenPanelSpacing1 = 35;
        int WomenmaxProductsPerRow = 4;

        int womenstartX1 = 45;
        int womenstartY1 = 25;

        for (int i = 0; i < women_product_image_paths.length; i++) {
            ImageIcon women_product_Image1 = new ImageIcon(women_product_image_paths[i]);
            Image women_img1 = women_product_Image1.getImage();
            Image women_resizedImg = women_img1.getScaledInstance(womenPanelWidth1, womenPanelHeight1, Image.SCALE_SMOOTH);
            women_product_Image1 = new ImageIcon(women_resizedImg);

            int row = i / WomenmaxProductsPerRow;
            int col = i % WomenmaxProductsPerRow;

            int xPosition = womenstartX1 + (womenPanelWidth1 + womenPanelSpacing1) * col;
            int yPosition = womenstartY1 + (womenPanelHeight1 + womenPanelSpacing1) * row;

            JLabel women_imageLabel1 = new JLabel(women_product_Image1);
            women_imageLabel1.setBounds(xPosition, yPosition, womenPanelWidth1, womenPanelHeight1);
            Womens.add(women_imageLabel1);

            JLabel nameLabel = new JLabel(women_productNames[i]);
            nameLabel.setBounds(xPosition, yPosition + womenPanelHeight1 + 10, womenPanelWidth1, 30);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Womens.add(nameLabel);

            JLabel priceLabel = new JLabel("Price: $" + women_productPrices[i]);
            priceLabel.setBounds(xPosition, yPosition + womenPanelHeight1 + 40, womenPanelWidth1, 30);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Womens.add(priceLabel);

            JButton women_addToCart = new JButton("Add To Cart");
            women_addToCart.setBounds(xPosition, yPosition + womenPanelHeight1 + 75, womenPanelWidth1, 50);
            women_addToCart.setFont(new Font("Arial", Font.BOLD, 15));
            women_addToCart.setHorizontalAlignment(SwingConstants.CENTER);
            women_addToCart.setContentAreaFilled(false);
            women_addToCart.setBorderPainted(false);
            women_addToCart.setFocusPainted(false);
            women_addToCart.setBackground(new Color(255, 204, 51));
            women_addToCart.setOpaque(true);
            Womens.add(women_addToCart);

            women_addToCart.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    women_addToCart.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    women_addToCart.setBackground(Color.lightGray);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    women_addToCart.setBackground(new Color(255, 204, 51));
                }
            });

            int finalI = i;
            women_addToCart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Product product = new Product(women_productNames[finalI], women_product_image_paths[finalI], women_productDescriptions[finalI], women_productPrices[finalI]);
                    Common_Gui.getCartModel().addProduct(product);

                    CartManager.getInstance().addToCart();
                    cartLabel.setText(String.valueOf(CartManager.getInstance().getQuantity()));

                }
            });
        }


        JButton womene_view_more = new JButton("view More");
        womene_view_more.setBounds(600, 750, 200, 40);
        womene_view_more.setFont(new Font("ariel", Font.BOLD, 15));
        womene_view_more.setHorizontalTextPosition(SwingConstants.RIGHT);
        womene_view_more.setContentAreaFilled(false);
        womene_view_more.setBorderPainted(false);
        womene_view_more.setFocusPainted(false);
        womene_view_more.setBackground(new Color(255, 204, 51));
        womene_view_more.setOpaque(true);
        Womens.add(womene_view_more);

        womene_view_more.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                womene_view_more.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                womene_view_more.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

        });

        womene_view_more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Women();
                frame.dispose();
            }
        });



        JLabel feature = new JLabel("Features");
        feature.setBounds(630, 3100, 400, 50);
        Font features_font1 = new Font("Serif", Font.BOLD, 40); // Font st
        feature.setFont(features_font1);
        feature.setForeground(new Color(10, 10, 10));
        //shopByCategories.setFont(new Font("Arial", Font.BOLD, 30));
        //  shopByCategories.setForeground(new Color(91, 90, 90));
        mainPanel.add(feature);

        JPanel linePanel7 = new JPanel();
        linePanel7.setBounds(100, 3130, 500, 1); // Adjust the position an
        linePanel7.setBorder(new LineBorder(Color.BLACK)); // Add a black
        mainPanel.add(linePanel7); // Add the line panel to the order_summ

        JPanel linePanel8 = new JPanel();
        linePanel8.setBounds(820, 3130, 500, 1); // Adjust the position an
        linePanel8.setBorder(new LineBorder(Color.BLACK)); // Add a black
        mainPanel.add(linePanel8);

        JPanel features = new JPanel();
        features.setLayout(null); // Use a layout manager*/
        // features.setBackground(Color.black);
        features.setBounds(0,3200,1500,150);
        features.setBackground(Color.white);
        mainPanel.add(features);



        ImageIcon track_icon = new ImageIcon("track_icon1.png"); // specify the path to your icon
        Image tract_image = track_icon.getImage();
        Image track_iconn_new = tract_image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        track_icon = new ImageIcon(track_iconn_new);

        JButton trac_btn = new JButton();
        trac_btn.setBounds(80, 40, 60, 50);
// trac_btn.setBackground(new Color(255, 204, 51));
        trac_btn.setContentAreaFilled(false);
        trac_btn.setBorderPainted(false);
        trac_btn.setFocusPainted(false);
        trac_btn.setOpaque(false);
        trac_btn.setIcon(track_icon);
        features.add(trac_btn);

        // Create labels with icon and text
        JLabel track_label = new JLabel("Track Your Order");
        track_label.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        track_label.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        track_label.setBounds(150,35,1500,30);
        track_label.setFont(new Font("Arial", Font.BOLD, 18));
        features.add(track_label);


        JLabel track_label1 = new JLabel("Track your order using your");
        track_label1.setBounds(150,60,1500,30);
        track_label1.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        track_label1.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        track_label1.setFont(new Font("Arial", Font.PLAIN, 13));
        features.add(track_label1);

        JLabel track_label2 = new JLabel("order ID");
        track_label2.setBounds(150,80,1500,30);
        track_label2.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        track_label2.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        track_label2.setFont(new Font("Arial", Font.PLAIN, 13));
        features.add(track_label2);

        ImageIcon shipping_policy = new ImageIcon("shipping_icon.png"); // specify the path to your icon
        Image shipping_image = shipping_policy.getImage();
        Image shipping_iconn_new = shipping_image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        shipping_policy = new ImageIcon(shipping_iconn_new);

        JButton shipping_btn = new JButton();
        shipping_btn.setBounds(430, 50, 60, 50);
// shipping_btn.setBackground(new Color(255, 204, 51));
        shipping_btn.setContentAreaFilled(false);
        shipping_btn.setBorderPainted(false);
        shipping_btn.setFocusPainted(false);
        shipping_btn.setOpaque(false);
        shipping_btn.setIcon(track_icon);
        features.add(shipping_btn);

        // Create labels with icon and text
        JLabel shipping_label = new JLabel("Shipping Policy");
        shipping_label.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        shipping_label.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        shipping_label.setBounds(500,35,1500,30);
        shipping_label.setFont(new Font("Arial", Font.BOLD, 18));
        features.add(shipping_label);

        String Shipping_Label_Text = "<html>"
                                     + "The Levi's Store offers free<br>"
                                     + "shipping on order above Rs<br>"
                                     + "2000/ all over Pakistan."
                                     + "</html>";

        JLabel shipping_label1 = new JLabel(Shipping_Label_Text);
        shipping_label1.setBounds(500,60,200,50);
        shipping_label1.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        shipping_label1.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        shipping_label1.setFont(new Font("Arial", Font.PLAIN, 13));
        features.add(shipping_label1);

        ImageIcon exchange_policy = new ImageIcon("exchange_icon.png"); // specify the path to your icon
        Image exchange_image = exchange_policy.getImage();
        Image exchange_iconn_new = exchange_image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        exchange_policy = new ImageIcon(exchange_iconn_new);

        JButton exchange_btn = new JButton();
        exchange_btn.setBounds(780, 50, 60, 50);
// shipping_btn.setBackground(new Color(255, 204, 51));
        exchange_btn.setContentAreaFilled(false);
        exchange_btn.setBorderPainted(false);
        exchange_btn.setFocusPainted(false);
        exchange_btn.setOpaque(false);
        exchange_btn.setIcon(exchange_policy);
        features.add(exchange_btn);

        // Create labels with icon and text
        JLabel exchange_label = new JLabel("Exchange Policy");
        exchange_label.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        exchange_label.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        exchange_label.setBounds(850,35,1500,30);
        exchange_label.setFont(new Font("Arial", Font.BOLD, 18));
        features.add(exchange_label);

        String Exchange_Label_Text = "<html>"
                + "Exchange purchased articles<br><br>"
                + "if purchase was made in<br><br>"
                + "Pakistan."
                + "</html>";


        JLabel exchange_label1 = new JLabel("Exchange purchased articles");
        exchange_label1.setBounds(850,60,200,60);
        exchange_label1.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        exchange_label1.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        exchange_label1.setFont(new Font("Arial", Font.PLAIN, 13));
        features.add(exchange_label1);


        ImageIcon privacy_policy = new ImageIcon("privacy_icon.png"); // specify the path to your icon
        Image privacy_image = privacy_policy.getImage();
        Image privacy_iconn_new = privacy_image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        privacy_policy = new ImageIcon(privacy_iconn_new);

        JButton privacy_btn = new JButton();
        privacy_btn.setBounds(1130, 50, 60, 50);
        //  privacy_btn.setBackground(new Color(255, 204, 51));
        privacy_btn.setContentAreaFilled(false);
        privacy_btn.setBorderPainted(false);
        privacy_btn.setFocusPainted(false);
        privacy_btn.setOpaque(false);
        privacy_btn.setIcon(privacy_policy);
        features.add(privacy_btn);

        privacy_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                privacy_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                privacy_btn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

        });

        // Create labels with icon and text
        JLabel privacy_label = new JLabel("Privacy Policy");
        privacy_label.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        privacy_label.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        privacy_label.setBounds(1200,35,1500,30);
        privacy_label.setFont(new Font("Arial", Font.BOLD, 18));
        features.add(privacy_label);


        JLabel privacy_label1 = new JLabel("We protect evey");
        privacy_label1.setBounds(1200,60,1500,30);
        privacy_label1.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        privacy_label1.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        privacy_label1.setFont(new Font("Arial", Font.PLAIN, 13));
        features.add(privacy_label1);

        JLabel privacy_label2 = new JLabel("information that you shared");
        privacy_label2.setBounds(1200,80,1500,30);
        privacy_label2.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        privacy_label2.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        privacy_label2.setFont(new Font("Arial", Font.PLAIN, 13));
        features.add(privacy_label2);

        JLabel privacy_label3 = new JLabel("with us via our website");
        privacy_label3.setBounds(1200,100,1500,30);
        privacy_label3.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        privacy_label3.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        privacy_label3.setFont(new Font("Arial", Font.PLAIN, 13));
        features.add(privacy_label3);

        frame.setVisible(true);

    }

    public void loadNextImage() {
        ImageIcon icon1 = new ImageIcon(imagePaths[currentIndex]);
        Image image6 = icon1.getImage().getScaledInstance(1400, 400, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(image6);
        imageLabel.setIcon(icon1);

        currentIndex = (currentIndex + 1) % imagePaths.length;
    }


    public static void main(String[] args) {
        Home_page checkUser = new Home_page();

    }
}



/* *//* JPanel products = new JPanel();
        products.setBounds(0, 125, 1400, 650);
        products.setLayout(null);
        mainPanel.add(products);*//*

        String[] Men_productImagePaths = {"men_shirt4.jpg", "men_shirt5.jpg", "men_shirt6.jpg", "men_shirt7.jpg"};

        String[] productDescriptions = {"Men's Shirt 1", "Men's Shirt 2", "Men's Shirt 3", "Men's Shirt 4"};

        double[] productPrices = {19.99, 29.99, 39.99, 49.99};

        String[] productNames = {"Men's Shirt", "Men's Shirt", "Men's Shirt", "Men's Shirt"};


        int productPanelWidth1 = 300;
        int productPanelHeight1 = 450;
        int productPanelSpacing1 = 35;
        int maxProductsPerRow = 4;

        int startX1 = 45;
        int startY1 = 25;

        for (int i = 0; i < Men_productImagePaths.length; i++) {
            ImageIcon productImage1 = new ImageIcon(Men_productImagePaths[i]);
            Image img1 = productImage1.getImage();
            Image resizedImg = img1.getScaledInstance(productPanelWidth1, productPanelHeight1, Image.SCALE_SMOOTH);
            productImage1 = new ImageIcon(resizedImg);

            int row = i / maxProductsPerRow;
            int col = i % maxProductsPerRow;

            int xPosition = startX1 + (productPanelWidth1 + productPanelSpacing1) * col;
            int yPosition = startY1 + (productPanelHeight1 + productPanelSpacing1) * row;

            JLabel imageLabel1 = new JLabel(productImage1);
            imageLabel1.setBounds(startX1 + (productPanelWidth1 + productPanelSpacing1) * i, startY1, productPanelWidth1, productPanelHeight1);
            MENs.add(imageLabel1);

            JLabel nameLabel = new JLabel(productNames[i]);
            nameLabel.setBounds(startX1, startY1 + productPanelHeight1 + 10, productPanelWidth1, 30);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(nameLabel);

            JLabel priceLabel = new JLabel("Price: $" + productPrices[i]);
            priceLabel.setBounds(startX1, startY1 + productPanelHeight1 + 40, productPanelWidth1, 30);
            priceLabel.setFont(new Font("Arial", Font.BOLD, 15));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            MENs.add(priceLabel);

            JButton addToCart = new JButton("Add To Cart");
            addToCart.setBounds(startX1, startY1 + productPanelHeight1 + 75, productPanelWidth1, 50);
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

            int finalI = i;
            addToCart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Product product = new Product(productNames[finalI], Men_productImagePaths[finalI], productDescriptions[finalI], productPrices[finalI]);
                    Common_Gui.getCartModel().addProduct(product);
                }
            });


        }*/
