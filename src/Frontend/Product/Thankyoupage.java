
package Frontend.Product;

import Frontend.home.Common_Gui;
import Frontend.home.Home_page;
import Frontend.navbar1.Product;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static Frontend.home.Common_Gui.cartModel;

public class Thankyoupage {

    JFrame frame;
    final int frameWidth = 1500;
    final int frameHeight = 800;

    JPanel products;
    Thankyoupage(){
        frame = new JFrame("Proceed to Checkout");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for custom positioning
        formPanel.setPreferredSize(new Dimension(1500, 2400));
        formPanel.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        formPanel.add(navbar);

        JPanel footer = Common_Gui.Footer(frame);
        footer.setBounds(0, 1700, 1500, 700);
        formPanel.add(footer);

        JPanel information  = new JPanel();
        information.setLayout(null); // Use null layout for custom positioning
        information.setBounds(100, 150, 1200, 1300);
        information.setOpaque(false); // Make the background transparent
        information.setBorder(new LineBorder(Color.BLACK, 1)); // Add a black border
        information.setBackground(Color.lightGray);
        formPanel.add(information);

        JPanel linepanel = new JPanel();
        linepanel.setLayout(null); // Use null layout to position elements manually
        linepanel.setBounds(50, 50, 500, 150);
        linepanel.setOpaque(false); // Make the background transparent
        linepanel.setBorder(new LineBorder(Color.BLACK, 1)); // Add a black border
        information.add(linepanel);

        JLabel Order_id = new JLabel("Order ID " +"123456789");
        Order_id.setFont(new Font("Ariel", Font.PLAIN, 13));
        Order_id.setBounds(20, 20, 200, 30);
        linepanel.add(Order_id);

        JLabel thankyou = new JLabel("Thank You Maaz!");
        thankyou.setFont(new Font("Ariel", Font.BOLD, 20));
        thankyou.setBounds(20, 60, 200, 30);
        linepanel.add(thankyou);

        JLabel confirm_order = new JLabel("Your Order Is Confirmed");
        confirm_order.setFont(new Font("Ariel", Font.PLAIN, 15));
        confirm_order.setBounds(20, 100, 200, 30);
        linepanel.add(confirm_order);

        products = new JPanel();
        products.setLayout(null); // Use null layout for manual positioning
        products.setBounds(50, 250, 600, 800);
        products.setOpaque(false); // Make the background transparent
        products.setBorder(new LineBorder(Color.BLACK, 1)); // Add a black border
        information.add(products);

        JButton continue_shopping = new JButton("Continue Shopping");
        continue_shopping.setBounds(150, 1100, 350, 40);
        continue_shopping.setFont(new Font("Ariel", Font.BOLD, 15));
        continue_shopping.setHorizontalTextPosition(SwingConstants.RIGHT);
        continue_shopping.setContentAreaFilled(false);
        continue_shopping.setBorderPainted(false);
        continue_shopping.setFocusPainted(false);
        continue_shopping.setBackground(new Color(255, 204, 51));
        continue_shopping.setOpaque(true);
        information.add(continue_shopping);

        continue_shopping.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                continue_shopping.setBackground(Color.WHITE);
                continue_shopping.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                continue_shopping.setBackground(new Color(255, 204, 51));
            }
        });

        continue_shopping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home_page();
            }
        });


        JButton Exit = new JButton("Exit");
        Exit.setBounds(150, 1200, 350, 40);
        Exit.setFont(new Font("Ariel", Font.BOLD, 15));
        Exit.setHorizontalTextPosition(SwingConstants.RIGHT);
        Exit.setContentAreaFilled(false);
        Exit.setBorderPainted(false);
        Exit.setFocusPainted(false);
        Exit.setOpaque(true);
        Exit.setBackground(Color.WHITE);
        information.add(Exit);

        Exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Exit.setBackground(new Color(255, 204, 51));
                Exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Exit.setBackground(Color.WHITE);
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });

        displayProducts();

        frame.setVisible(true);

    }
    private void displayProducts() {
        List<Product> productList = cartModel.getProducts();
        int yPosition = 10; // Starting y position for products
        int totalPrice = 0;

        for (Product product : productList) {
            String imagePath = product.getImagePath();
            String productName = product.getName();
            int productPrice = (int) product.getPrice();

            totalPrice += productPrice;

            JPanel productPanel = new JPanel();
            productPanel.setLayout(null);
            productPanel.setBounds(10, yPosition, 580, 120);
            productPanel.setBorder(new LineBorder(Color.BLACK, 1));

            JLabel productImage = new JLabel();
            ImageIcon icon = new ImageIcon(imagePath);
            Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            productImage.setIcon(new ImageIcon(scaledImage));
            productImage.setBounds(10, 10, 100, 100);
            productPanel.add(productImage);

            JLabel productNameLabel = new JLabel(productName);
            productNameLabel.setFont(new Font("Dialog", Font.BOLD, 18));
            productNameLabel.setBounds(120, 10, 200, 30);
            productPanel.add(productNameLabel);

            JLabel productPriceLabel = new JLabel("Price: $" + productPrice);
            productPriceLabel.setBounds(120, 50, 200, 30);
            productPanel.add(productPriceLabel);

            products.add(productPanel);

            yPosition += 130;
        }

        int shippingFee = 0;
        int totalWithShipping = totalPrice + shippingFee;

        JLabel subtotalLabel = new JLabel("Subtotal");
        subtotalLabel.setFont(new Font("Ariel", Font.PLAIN, 15));
        subtotalLabel.setBounds(20, yPosition, 200, 30);
        products.add(subtotalLabel);

        JLabel subtotalLabel_1 = new JLabel(String.valueOf(+totalPrice));
        subtotalLabel_1.setFont(new Font("Ariel", Font.PLAIN, 15));
        subtotalLabel_1.setBounds(500, yPosition, 200, 30);
        products.add(subtotalLabel_1);

        JLabel shippingLabel = new JLabel("Shipping");
        shippingLabel.setBounds(20, yPosition + 40, 200, 30);
        shippingLabel.setFont(new Font("Ariel", Font.PLAIN, 15));
        products.add(shippingLabel);

        JLabel shippingLabel_1 = new JLabel("Free");
        shippingLabel_1.setBounds(500, yPosition + 40, 200, 30);
        shippingLabel_1.setFont(new Font("Ariel", Font.PLAIN, 15));
        products.add(shippingLabel_1);

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setBounds(20, yPosition + 80, 200, 30);
        totalLabel.setFont(new Font("Ariel", Font.BOLD, 20));
        products.add(totalLabel);

        JLabel totalLabel_1 = new JLabel("Rs " +totalWithShipping);
        totalLabel_1.setBounds(500, yPosition + 80, 200, 30);
        totalLabel_1.setFont(new Font("Ariel", Font.BOLD, 20));
        products.add(totalLabel_1);
    }

    public static void main(String[] args) {
        Thankyoupage thankyoupage = new Thankyoupage();
    }
}





















   /* JPanel linepanel_Details = new JPanel();
        linepanel_Details.setLayout(null); // Use null layout to position elements manually
                linepanel_Details.setBounds(50, 250, 500, 250);
                linepanel_Details.setOpaque(false); // Make the background transparent
                linepanel_Details.setBorder(new LineBorder(Color.BLACK, 1)); // Add a black border
                information.add(linepanel_Details);

                proceedToCheckout checkoutForm = new proceedToCheckout();
                // Retrieve user-entered details
                String email = checkoutForm.getEmail();
                String country = checkoutForm.getCountry();
                String firstName = checkoutForm.getFirstName();
                String lastName = checkoutForm.getLastName();
                String address = checkoutForm.getAddress();
                String detailAddress = checkoutForm.getDetailsAddress();
                String city = checkoutForm.getCity();
                String postalCode = checkoutForm.getPostalCode();
                String phone = checkoutForm.getPhone();

        // Display user details in linepanel_Details
        JLabel emailLabel = new JLabel("Email: " + email);
        emailLabel.setBounds(20, 20, 400, 30);
        linepanel_Details.add(emailLabel);

        JLabel nameLabel = new JLabel("Name: " + firstName + " " + lastName);
        nameLabel.setBounds(20, 60, 400, 30);
        linepanel_Details.add(nameLabel);

        JLabel addressLabel = new JLabel("Address: " + address + ", " + detailAddress + ", " + city + ", " + postalCode);
        addressLabel.setBounds(20, 100, 400, 30);
        linepanel_Details.add(addressLabel);

        JLabel phoneLabel = new JLabel("Phone: " + phone);
        phoneLabel.setBounds(20, 140, 400, 30);
        linepanel_Details.add(phoneLabel);*/