/*
package Frontend.Product;

import Frontend.home.Common_Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class proceedToCheckout {

    JPanel details;
    JPanel products;

    JFrame frame;

    final int frameWidth = 1500;
    final int frameHeight = 800;

    proceedToCheckout(){

        frame = new JFrame("Login");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for custom absolute positioning
        formPanel.setPreferredSize(new Dimension(1500, 1550)); // Adjust height to fit all content
        formPanel.setBackground(Color.white);
        frame.add(formPanel);

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        formPanel.add(navbar);

        details = new JPanel();
        details.setLayout(null);
        details.setBounds(130, 150, 600, 1300);
        formPanel.add(details);

        JLabel contact = new JLabel("Contact");
        contact.setBounds(50, 50, 100, 50);
        contact.setFont(new Font("Dialog", Font.BOLD, 25));
        contact.setForeground(new Color(0, 0, 0));
        details.add(contact);

        JLabel emaillabel = new JLabel("Email");
        emaillabel.setBounds(50, 100, 100, 50);
        emaillabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        emaillabel.setForeground(new Color(0, 0, 0));
        details.add(emaillabel);

        JTextField email_field = createPaddedTextField();
        email_field.setBounds(50, 140, 500, 40);
        details.add(email_field);

        JLabel delivery = new JLabel("Delivery");
        delivery.setBounds(50, 200, 100, 50);
        delivery.setFont(new Font("Dialog", Font.BOLD, 22));
        delivery.setForeground(new Color(0, 0, 0));
        details.add(delivery);

        JLabel country = new JLabel("Country");
        country.setBounds(50, 250, 100, 50);
        country.setFont(new Font("Dialog", Font.PLAIN, 15));
        country.setForeground(new Color(0, 0, 0));
        details.add(country);

        JTextField country_field = createPaddedTextField();
        country_field.setBounds(50, 290, 500, 40);
        details.add(country_field);

        JLabel first_name = new JLabel("First Name");
        first_name.setBounds(50, 340, 100, 50);
        first_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        first_name.setForeground(new Color(0, 0, 0));
        details.add(first_name);

        JTextField first_name_field = createPaddedTextField();
        first_name_field.setBounds(50, 380, 250, 40);
        details.add(first_name_field);

        JLabel last_name = new JLabel("Last Name");
        last_name.setBounds(310, 340, 100, 50);
        last_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        last_name.setForeground(new Color(0, 0, 0));
        details.add(last_name);

        JTextField last_name_field = createPaddedTextField();
        last_name_field.setBounds(305, 380, 250, 40);
        details.add(last_name_field);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 430, 100, 50);
        address.setFont(new Font("Dialog", Font.PLAIN, 15));
        address.setForeground(new Color(0, 0, 0));
        details.add(address);

        JTextField address_field = createPaddedTextField();
        address_field.setBounds(50, 470, 500, 40);
        details.add(address_field);

        JLabel detail_Address = new JLabel("Appartment, Suit, etc (Optional)");
        detail_Address.setBounds(50, 520, 300, 50);
        detail_Address.setFont(new Font("Dialog", Font.PLAIN, 15));
        detail_Address.setForeground(new Color(0, 0, 0));
        details.add(detail_Address);

        JTextField detail_Address_field = createPaddedTextField();
        detail_Address_field.setBounds(50, 560, 500, 40);
        details.add(detail_Address_field);

        JLabel city= new JLabel("City");
        city.setBounds(50, 610, 100, 50);
        city.setFont(new Font("Dialog", Font.PLAIN, 15));
        city.setForeground(new Color(0, 0, 0));
        details.add(city);

        JTextField city_field = createPaddedTextField();
        city_field.setBounds(50, 650, 250, 40);
        details.add(city_field);

        JLabel postal_code = new JLabel("Postal Code");
        postal_code.setBounds(310, 610, 100, 50);
        postal_code.setFont(new Font("Dialog", Font.PLAIN, 15));
        postal_code.setForeground(new Color(0, 0, 0));
        details.add(postal_code);

        JTextField postal_Code_field = createPaddedTextField();
        postal_Code_field.setBounds(305, 650, 250, 40);
        details.add(postal_Code_field);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 700, 300, 50);
        phone.setFont(new Font("Dialog", Font.PLAIN, 15));
        phone.setForeground(new Color(0, 0, 0));
        details.add(phone);

        JTextField phone_field = createPaddedTextField();
        phone_field.setBounds(50, 740, 500, 40);
        details.add(phone_field);

        JLabel payment = new JLabel("Payment");
        payment.setBounds(50, 800, 250, 50);
        payment.setFont(new Font("Dialog", Font.BOLD, 25));
        payment.setForeground(new Color(0, 0, 0));
        details.add(payment);

        JLabel payment_note  = new JLabel("All transactions are secure and encrypted.");
        payment_note.setBounds(50, 830, 500, 50);
        payment_note.setFont(new Font("Dialog", Font.PLAIN, 15));
        payment_note.setForeground(new Color(145, 144, 144));
        details.add(payment_note);

        JPanel payment_option = new JPanel();
        payment_option.setLayout(null);
        payment_option.setBounds(50, 880, 500, 130);
        payment_option.setBorder(new LineBorder(Color.black, 1));
        details.add(payment_option);

        JRadioButton online_payment = new JRadioButton();
        JRadioButton cash_on_delivery = new JRadioButton();

        ButtonGroup group = new ButtonGroup();
        group.add(online_payment);
        group.add(cash_on_delivery);

        online_payment.setText("Debit - Credit Card");
        online_payment.setBounds(10,10,200,30);
        online_payment.setBackground(null);
        payment_option.add(online_payment);

        ImageIcon visa_icon = new ImageIcon("visa_icon.png");
        Image scaledImage = visa_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel visa_iconn = new JLabel(new ImageIcon(scaledImage));
        visa_iconn.setBounds(400, 10, 30, 30);
        payment_option.add(visa_iconn);

        ImageIcon mastercard_icon = new ImageIcon("mastercard_icon.png");
        Image scaledImage1 = mastercard_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel mastercard_iconn = new JLabel(new ImageIcon(scaledImage1));
        mastercard_iconn.setBounds(450, 10, 30, 30);
        payment_option.add(mastercard_iconn);

        int radioButtonSize = 20; // Increase size of radio button
        CustomRadioButtonIcon customIcon = new CustomRadioButtonIcon(radioButtonSize);
        online_payment.setIcon(customIcon);
        online_payment.setSelectedIcon(customIcon);
        online_payment.setIconTextGap(10); // Add some gap between icon and text

        cash_on_delivery.setText("Cash On Delivery COD");
        cash_on_delivery.setBounds(10,45,200,30);
        cash_on_delivery.setBackground(null);
        payment_option.add(cash_on_delivery);

        int radioButtonSize1 = 20; // Increase size of radio button
        CustomRadioButtonIcon customIcon1 = new CustomRadioButtonIcon(radioButtonSize1);
        cash_on_delivery.setIcon(customIcon1);
        cash_on_delivery.setSelectedIcon(customIcon1);
        cash_on_delivery.setIconTextGap(10);

        JLabel cash_note  = new JLabel("Only applicable for customers from Pakistan");
        cash_note.setBounds(30, 70, 500, 50);
        cash_note.setFont(new Font("Dialog", Font.PLAIN, 10));
        cash_note.setForeground(new Color(3, 3, 3));
        payment_option.add(cash_note);

        JButton CompleteOrder = new JButton("Complete Order");
        CompleteOrder.setBounds(50, 1050, 500, 40);
        CompleteOrder.setHorizontalTextPosition(SwingConstants.RIGHT);
        CompleteOrder.setContentAreaFilled(false);
        CompleteOrder.setBorderPainted(false);
        CompleteOrder.setFocusPainted(false);
        CompleteOrder.setBackground(new Color(255, 204, 51));
        CompleteOrder.setOpaque(true);
        details.add(CompleteOrder);

        CompleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = email_field.getText().trim();
                String country = country_field.getText().trim();
                String firstName = first_name_field.getText().trim();
                String lastName = last_name_field.getText().trim();
                String address = address_field.getText().trim();
                String appartment = detail_Address_field.getText().trim();
                String city = city_field.getText().trim();
                String postalcode = postal_Code_field.getText().trim();
                String phone = phone_field.getText().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty()
                        || address.isEmpty() || appartment.isEmpty() || city.isEmpty() || postalcode.isEmpty() || country.isEmpty())

                {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!isValidPhoneNumber(phone)){
                    JOptionPane.showMessageDialog(frame, "Enter valid phone number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(frame, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        products = new JPanel();
        products.setLayout(null);
        products.setBounds(750, 150, 600, 800);
        products.setBackground(new Color(238, 207, 207));
        formPanel.add(products);

        displayProductDetails();

        frame.setVisible(true);
    }


    private void displayProductDetails() {
        // Clear the existing content of the products panel
        //products.removeAll();
        products.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Example products data, you can replace this with your actual products data
        String[] productNames = {"Product 1", "Product 2", "Product 3"};
        double[] productPrices = {29.99, 49.99, 19.99};
        String[] productImages = {"men_shirt1.jpg", "men_shirt2.jpg", "men_shirt3.jpg"};


        for (int i = 0; i < productNames.length; i++) {
            // Load and resize the product image
            ImageIcon originalIcon = new ImageIcon(productImages[i]);
            Image originalImage = originalIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.CENTER;
            JLabel productImage = new JLabel(resizedIcon);
            products.add(productImage, gbc);

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            JLabel productName = new JLabel(productNames[i]);
            products.add(productName, gbc);

            gbc.gridx = 2;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.EAST;
            JLabel productPrice = new JLabel("$" + productPrices[i]);
            products.add(productPrice, gbc);
        }

        // Example total calculations
        double subtotal = 0;
        for (double price : productPrices) {
            subtotal += price;
        }
        double shipping = 5.99;
        double total = subtotal + shipping;

        int totalRow = productNames.length;

        gbc.gridx = 0;
        gbc.gridy = totalRow;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 2;
        JLabel subtotalLabel = new JLabel("Subtotal:");
        products.add(subtotalLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = totalRow;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 1;
        JLabel subtotalValueLabel = new JLabel("$" + subtotal);
        products.add(subtotalValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = totalRow + 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 2;
        JLabel shippingLabel = new JLabel("Shipping:");
        products.add(shippingLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = totalRow + 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 1;
        JLabel shippingValueLabel = new JLabel("$" + shipping);
        products.add(shippingValueLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = totalRow + 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 2;
        JLabel totalLabel = new JLabel("Total:");
        products.add(totalLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = totalRow + 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 1;
        JLabel totalValueLabel = new JLabel("$" + total);
        products.add(totalValueLabel, gbc);

        // Refresh the products panel to display the new content
        products.revalidate();
        products.repaint();
    }



    private JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 10, 5, 5) // Top, Left, Bottom, Right padding
        ));
        return textField;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberPattern = "^(03[0-9]{9})$";
        return Pattern.matches(phoneNumberPattern, phoneNumber);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }



    public static void main(String[] args) {
        proceedToCheckout p = new proceedToCheckout();
    }
}
*/



















/*
package Frontend.Product;

import Frontend.home.Common_Gui;
import Frontend.navbar1.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import static Frontend.home.Common_Gui.cartModel;

public class proceedToCheckout {

    JPanel details;
    JPanel products;

    JFrame frame;

    final int frameWidth = 1500;
    final int frameHeight = 800;

    proceedToCheckout(){

        frame = new JFrame("Login");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for custom absolute positioning
        formPanel.setPreferredSize(new Dimension(1500, 1550)); // Adjust height to fit all content
        formPanel.setBackground(Color.white);
        frame.add(formPanel);

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        formPanel.add(navbar);

        details = new JPanel();
        details.setLayout(null);
        details.setBounds(130, 150, 600, 1300);
        formPanel.add(details);

        JLabel contact = new JLabel("Contact");
        contact.setBounds(50, 50, 100, 50);
        contact.setFont(new Font("Dialog", Font.BOLD, 25));
        contact.setForeground(new Color(0, 0, 0));
        details.add(contact);

        JLabel emaillabel = new JLabel("Email");
        emaillabel.setBounds(50, 100, 100, 50);
        emaillabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        emaillabel.setForeground(new Color(0, 0, 0));
        details.add(emaillabel);

        JTextField email_field = createPaddedTextField();
        email_field.setBounds(50, 140, 500, 40);
        details.add(email_field);

        JLabel delivery = new JLabel("Delivery");
        delivery.setBounds(50, 200, 100, 50);
        delivery.setFont(new Font("Dialog", Font.BOLD, 22));
        delivery.setForeground(new Color(0, 0, 0));
        details.add(delivery);

        JLabel country = new JLabel("Country");
        country.setBounds(50, 250, 100, 50);
        country.setFont(new Font("Dialog", Font.PLAIN, 15));
        country.setForeground(new Color(0, 0, 0));
        details.add(country);

        JTextField country_field = createPaddedTextField();
        country_field.setBounds(50, 290, 500, 40);
        details.add(country_field);

        JLabel first_name = new JLabel("First Name");
        first_name.setBounds(50, 340, 100, 50);
        first_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        first_name.setForeground(new Color(0, 0, 0));
        details.add(first_name);

        JTextField first_name_field = createPaddedTextField();
        first_name_field.setBounds(50, 380, 250, 40);
        details.add(first_name_field);

        JLabel last_name = new JLabel("Last Name");
        last_name.setBounds(310, 340, 100, 50);
        last_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        last_name.setForeground(new Color(0, 0, 0));
        details.add(last_name);

        JTextField last_name_field = createPaddedTextField();
        last_name_field.setBounds(305, 380, 250, 40);
        details.add(last_name_field);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 430, 100, 50);
        address.setFont(new Font("Dialog", Font.PLAIN, 15));
        address.setForeground(new Color(0, 0, 0));
        details.add(address);

        JTextField address_field = createPaddedTextField();
        address_field.setBounds(50, 470, 500, 40);
        details.add(address_field);

        JLabel detail_Address = new JLabel("Appartment, Suit, etc (Optional)");
        detail_Address.setBounds(50, 520, 300, 50);
        detail_Address.setFont(new Font("Dialog", Font.PLAIN, 15));
        detail_Address.setForeground(new Color(0, 0, 0));
        details.add(detail_Address);

        JTextField detail_Address_field = createPaddedTextField();
        detail_Address_field.setBounds(50, 560, 500, 40);
        details.add(detail_Address_field);

        JLabel city= new JLabel("City");
        city.setBounds(50, 610, 100, 50);
        city.setFont(new Font("Dialog", Font.PLAIN, 15));
        city.setForeground(new Color(0, 0, 0));
        details.add(city);

        JTextField city_field = createPaddedTextField();
        city_field.setBounds(50, 650, 250, 40);
        details.add(city_field);

        JLabel postal_code = new JLabel("Postal Code");
        postal_code.setBounds(310, 610, 100, 50);
        postal_code.setFont(new Font("Dialog", Font.PLAIN, 15));
        postal_code.setForeground(new Color(0, 0, 0));
        details.add(postal_code);

        JTextField postal_Code_field = createPaddedTextField();
        postal_Code_field.setBounds(305, 650, 250, 40);
        details.add(postal_Code_field);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 700, 300, 50);
        phone.setFont(new Font("Dialog", Font.PLAIN, 15));
        phone.setForeground(new Color(0, 0, 0));
        details.add(phone);

        JTextField phone_field = createPaddedTextField();
        phone_field.setBounds(50, 740, 500, 40);
        details.add(phone_field);

        JLabel payment = new JLabel("Payment");
        payment.setBounds(50, 800, 250, 50);
        payment.setFont(new Font("Dialog", Font.BOLD, 25));
        payment.setForeground(new Color(0, 0, 0));
        details.add(payment);

        JLabel payment_note  = new JLabel("All transactions are secure and encrypted.");
        payment_note.setBounds(50, 830, 500, 50);
        payment_note.setFont(new Font("Dialog", Font.PLAIN, 15));
        payment_note.setForeground(new Color(145, 144, 144));
        details.add(payment_note);

        JPanel payment_option = new JPanel();
        payment_option.setLayout(null);
        payment_option.setBounds(50, 880, 500, 130);
        payment_option.setBorder(new LineBorder(Color.black, 1));
        details.add(payment_option);

        JRadioButton online_payment = new JRadioButton();
        JRadioButton cash_on_delivery = new JRadioButton();

        ButtonGroup group = new ButtonGroup();
        group.add(online_payment);
        group.add(cash_on_delivery);

        online_payment.setText("Debit - Credit Card");
        online_payment.setBounds(10,10,200,30);
        online_payment.setBackground(null);
        payment_option.add(online_payment);

        ImageIcon visa_icon = new ImageIcon("visa_icon.png");
        Image scaledImage = visa_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel visa_iconn = new JLabel(new ImageIcon(scaledImage));
        visa_iconn.setBounds(400, 10, 30, 30);
        payment_option.add(visa_iconn);

        ImageIcon mastercard_icon = new ImageIcon("mastercard_icon.png");
        Image scaledImage1 = mastercard_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel mastercard_iconn = new JLabel(new ImageIcon(scaledImage1));
        mastercard_iconn.setBounds(450, 10, 30, 30);
        payment_option.add(mastercard_iconn);

        int radioButtonSize = 20; // Increase size of radio button
        CustomRadioButtonIcon customIcon = new CustomRadioButtonIcon(radioButtonSize);
        online_payment.setIcon(customIcon);
        online_payment.setSelectedIcon(customIcon);
        online_payment.setIconTextGap(10); // Add some gap between icon and text

        cash_on_delivery.setText("Cash On Delivery COD");
        cash_on_delivery.setBounds(10,45,200,30);
        cash_on_delivery.setBackground(null);
        payment_option.add(cash_on_delivery);

        int radioButtonSize1 = 20; // Increase size of radio button
        CustomRadioButtonIcon customIcon1 = new CustomRadioButtonIcon(radioButtonSize1);
        cash_on_delivery.setIcon(customIcon1);
        cash_on_delivery.setSelectedIcon(customIcon1);
        cash_on_delivery.setIconTextGap(10); // Add some gap between icon and text

        JButton continueButton = new JButton("Continue to Payment");
        continueButton.setBounds(50, 1150, 500, 40);
        continueButton.setForeground(Color.white);
        continueButton.setBackground(Color.black);
        details.add(continueButton);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailText = email_field.getText();
                String countryText = country_field.getText();
                String firstNameText = first_name_field.getText();
                String lastNameText = last_name_field.getText();
                String addressText = address_field.getText();
                String detailAddressText = detail_Address_field.getText();
                String cityText = city_field.getText();
                String postalCodeText = postal_Code_field.getText();
                String phoneText = phone_field.getText();

                if (!isValidEmail(emailText)) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.");
                    return;
                }

                if (countryText.isEmpty() || firstNameText.isEmpty() || lastNameText.isEmpty() || addressText.isEmpty() || cityText.isEmpty() || postalCodeText.isEmpty() || phoneText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields.");
                    return;
                }

                JOptionPane.showMessageDialog(frame, "Form submitted successfully!");
            }
        });

        products = new JPanel();
        products.setLayout(null); // Use GridBagLayout for better control
        products.setBounds(850, 150, 600, 1300);
        formPanel.add(products);

        List<Product> products = cartModel.getProducts();
        int yPosition = 10; // Starting y position for products

        JLabel productImage = new JLabel();


        frame.setVisible(true);
    }

    private void addProduct(String imagePath, String productName, String productPrice, GridBagConstraints gbc) {
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(new LineBorder(Color.BLACK, 1));

        JLabel productImage = new JLabel();
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        productImage.setIcon(new ImageIcon(scaledImage));

        JLabel productNameLabel = new JLabel(productName, SwingConstants.CENTER);
        productNameLabel.setFont(new Font("Dialog", Font.BOLD, 18)); // Increased font size
        JLabel productPriceLabel = new JLabel(productPrice, SwingConstants.CENTER);

        productPanel.add(productImage, BorderLayout.CENTER);
        productPanel.add(productNameLabel, BorderLayout.NORTH);
        productPanel.add(productPriceLabel, BorderLayout.SOUTH);

        products.add(productPanel, gbc);
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding inside the text field
        return textField;
    }

    public static void main(String[] args) {
        new proceedToCheckout();
    }
}*/











































































/*

package Frontend.Product;

import Frontend.home.Common_Gui;
import Frontend.navbar1.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import static Frontend.home.Common_Gui.cartModel;

public class proceedToCheckout {

    JPanel details;
    JPanel products;
    JFrame frame;

    final int frameWidth = 1500;
    final int frameHeight = 800;

    public proceedToCheckout() {
        frame = new JFrame("Proceed to Checkout");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for custom absolute positioning
        formPanel.setPreferredSize(new Dimension(1500, 1550)); // Adjust height to fit all content
        formPanel.setBackground(Color.white);
        frame.add(formPanel);

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        formPanel.add(navbar);

        details = new JPanel();
        details.setLayout(null);
        details.setBounds(130, 150, 600, 1300);
        formPanel.add(details);

        JLabel contact = new JLabel("Contact");
        contact.setBounds(50, 50, 100, 50);
        contact.setFont(new Font("Dialog", Font.BOLD, 25));
        contact.setForeground(new Color(0, 0, 0));
        details.add(contact);

        JLabel emaillabel = new JLabel("Email");
        emaillabel.setBounds(50, 100, 100, 50);
        emaillabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        emaillabel.setForeground(new Color(0, 0, 0));
        details.add(emaillabel);

        JTextField email_field = createPaddedTextField();
        email_field.setBounds(50, 140, 500, 40);
        details.add(email_field);

        JLabel delivery = new JLabel("Delivery");
        delivery.setBounds(50, 200, 100, 50);
        delivery.setFont(new Font("Dialog", Font.BOLD, 22));
        delivery.setForeground(new Color(0, 0, 0));
        details.add(delivery);

        JLabel country = new JLabel("Country");
        country.setBounds(50, 250, 100, 50);
        country.setFont(new Font("Dialog", Font.PLAIN, 15));
        country.setForeground(new Color(0, 0, 0));
        details.add(country);

        JTextField country_field = createPaddedTextField();
        country_field.setBounds(50, 290, 500, 40);
        details.add(country_field);

        JLabel first_name = new JLabel("First Name");
        first_name.setBounds(50, 340, 100, 50);
        first_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        first_name.setForeground(new Color(0, 0, 0));
        details.add(first_name);

        JTextField first_name_field = createPaddedTextField();
        first_name_field.setBounds(50, 380, 250, 40);
        details.add(first_name_field);

        JLabel last_name = new JLabel("Last Name");
        last_name.setBounds(310, 340, 100, 50);
        last_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        last_name.setForeground(new Color(0, 0, 0));
        details.add(last_name);

        JTextField last_name_field = createPaddedTextField();
        last_name_field.setBounds(305, 380, 250, 40);
        details.add(last_name_field);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 430, 100, 50);
        address.setFont(new Font("Dialog", Font.PLAIN, 15));
        address.setForeground(new Color(0, 0, 0));
        details.add(address);

        JTextField address_field = createPaddedTextField();
        address_field.setBounds(50, 470, 500, 40);
        details.add(address_field);

        JLabel detail_Address = new JLabel("Appartment, Suit, etc (Optional)");
        detail_Address.setBounds(50, 520, 300, 50);
        detail_Address.setFont(new Font("Dialog", Font.PLAIN, 15));
        detail_Address.setForeground(new Color(0, 0, 0));
        details.add(detail_Address);

        JTextField detail_Address_field = createPaddedTextField();
        detail_Address_field.setBounds(50, 560, 500, 40);
        details.add(detail_Address_field);

        JLabel city = new JLabel("City");
        city.setBounds(50, 610, 100, 50);
        city.setFont(new Font("Dialog", Font.PLAIN, 15));
        city.setForeground(new Color(0, 0, 0));
        details.add(city);

        JTextField city_field = createPaddedTextField();
        city_field.setBounds(50, 650, 250, 40);
        details.add(city_field);

        JLabel postal_code = new JLabel("Postal Code");
        postal_code.setBounds(310, 610, 100, 50);
        postal_code.setFont(new Font("Dialog", Font.PLAIN, 15));
        postal_code.setForeground(new Color(0, 0, 0));
        details.add(postal_code);

        JTextField postal_Code_field = createPaddedTextField();
        postal_Code_field.setBounds(305, 650, 250, 40);
        details.add(postal_Code_field);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 700, 300, 50);
        phone.setFont(new Font("Dialog", Font.PLAIN, 15));
        phone.setForeground(new Color(0, 0, 0));
        details.add(phone);

        JTextField phone_field = createPaddedTextField();
        phone_field.setBounds(50, 740, 500, 40);
        details.add(phone_field);

        JLabel payment = new JLabel("Payment");
        payment.setBounds(50, 800, 250, 50);
        payment.setFont(new Font("Dialog", Font.BOLD, 25));
        payment.setForeground(new Color(0, 0, 0));
        details.add(payment);

        JLabel payment_note = new JLabel("All transactions are secure and encrypted.");
        payment_note.setBounds(50, 830, 500, 50);
        payment_note.setFont(new Font("Dialog", Font.PLAIN, 15));
        payment_note.setForeground(new Color(145, 144, 144));
        details.add(payment_note);

        JPanel payment_option = new JPanel();
        payment_option.setLayout(null);
        payment_option.setBounds(50, 880, 500, 130);
        payment_option.setBorder(new LineBorder(Color.black, 1));
        details.add(payment_option);

        JRadioButton online_payment = new JRadioButton();
        JRadioButton cash_on_delivery = new JRadioButton();

        ButtonGroup group = new ButtonGroup();
        group.add(online_payment);
        group.add(cash_on_delivery);

        online_payment.setText("Debit - Credit Card");
        online_payment.setBounds(10, 10, 200, 30);
        online_payment.setBackground(null);
        payment_option.add(online_payment);

        ImageIcon visa_icon = new ImageIcon("visa_icon.png");
        Image scaledImage = visa_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel visa_iconn = new JLabel(new ImageIcon(scaledImage));
        visa_iconn.setBounds(400, 10, 30, 30);
        payment_option.add(visa_iconn);

        ImageIcon mastercard_icon = new ImageIcon("mastercard_icon.png");
        Image scaledImage1 = mastercard_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel mastercard_iconn = new JLabel(new ImageIcon(scaledImage1));
        mastercard_iconn.setBounds(450, 10, 30, 30);
        payment_option.add(mastercard_iconn);

        int radioButtonSize = 20; // Increase size of radio button
        CustomRadioButtonIcon customIcon = new CustomRadioButtonIcon(radioButtonSize);
        online_payment.setIcon(customIcon);
        online_payment.setSelectedIcon(customIcon);
        online_payment.setIconTextGap(10); // Add some gap between icon and text

        cash_on_delivery.setText("Cash On Delivery COD");
        cash_on_delivery.setBounds(10, 45, 200, 30);
        cash_on_delivery.setBackground(null);
        payment_option.add(cash_on_delivery);

        int radioButtonSize1 = 20; // Increase size of radio button
        CustomRadioButtonIcon customIcon1 = new CustomRadioButtonIcon(radioButtonSize1);
        cash_on_delivery.setIcon(customIcon1);
        cash_on_delivery.setSelectedIcon(customIcon1);
        cash_on_delivery.setIconTextGap(10); // Add some gap between icon and text

        JButton continueButton = new JButton("Continue to Payment");
        continueButton.setBounds(50, 1150, 500, 40);
        continueButton.setForeground(Color.white);
        continueButton.setBackground(Color.black);
        details.add(continueButton);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailText = email_field.getText();
                String countryText = country_field.getText();
                String firstNameText = first_name_field.getText();
                String lastNameText = last_name_field.getText();
                String addressText = address_field.getText();
                String detailAddressText = detail_Address_field.getText();
                String cityText = city_field.getText();
                String postalCodeText = postal_Code_field.getText();
                String phoneText = phone_field.getText();

                if (!isValidEmail(emailText)) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.");
                    return;
                }

                if (countryText.isEmpty() || firstNameText.isEmpty() || lastNameText.isEmpty() || addressText.isEmpty() || cityText.isEmpty() || postalCodeText.isEmpty() || phoneText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all required fields.");
                    return;
                }

                new Thankyoupage();
            }
        });



        products = new JPanel();
        products.setLayout(null); // Use null layout for manual positioning
        products.setBounds(850, 150, 600, 1300);
        formPanel.add(products);

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

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(new EmptyBorder(10, 10, 10, 10)); // Add padding inside the text field
        return textField;
    }

    public static void main(String[] args) {
        new proceedToCheckout();
    }
}
*/

package Frontend.Product;

import Frontend.home.Common_Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class proceedToCheckout {

    JFrame frame;
    JPanel details;

    JTextField email_field;
    JTextField country_field;
    JTextField first_name_field;
    JTextField last_name_field;
    JTextField address_field;
    JTextField detail_Address_field;
    JTextField city_field;
    JTextField postal_Code_field;
    JTextField phone_field;

    JRadioButton online_payment;
    JRadioButton cash_on_delivery;

    final int frameWidth = 1500;
    final int frameHeight = 800;

    public proceedToCheckout() {
        frame = new JFrame("Checkout");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for custom absolute positioning
        formPanel.setPreferredSize(new Dimension(1500, 1550)); // Adjust height to fit all content
        formPanel.setBackground(Color.white);
        frame.add(formPanel);

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        formPanel.add(navbar);

        details = new JPanel();
        details.setLayout(null);
        details.setBounds(130, 150, 600, 1300);
        formPanel.add(details);

        JLabel contact = new JLabel("Contact");
        contact.setBounds(50, 50, 100, 50);
        contact.setFont(new Font("Dialog", Font.BOLD, 25));
        contact.setForeground(new Color(0, 0, 0));
        details.add(contact);

        JLabel emaillabel = new JLabel("Email");
        emaillabel.setBounds(50, 100, 100, 50);
        emaillabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        emaillabel.setForeground(new Color(0, 0, 0));
        details.add(emaillabel);

        email_field = createPaddedTextField();
        email_field.setBounds(50, 140, 500, 40);
        details.add(email_field);

        JLabel delivery = new JLabel("Delivery");
        delivery.setBounds(50, 200, 100, 50);
        delivery.setFont(new Font("Dialog", Font.BOLD, 22));
        delivery.setForeground(new Color(0, 0, 0));
        details.add(delivery);

        JLabel country = new JLabel("Country");
        country.setBounds(50, 250, 100, 50);
        country.setFont(new Font("Dialog", Font.PLAIN, 15));
        country.setForeground(new Color(0, 0, 0));
        details.add(country);

        country_field = createPaddedTextField();
        country_field.setBounds(50, 290, 500, 40);
        details.add(country_field);

        JLabel first_name = new JLabel("First Name");
        first_name.setBounds(50, 340, 100, 50);
        first_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        first_name.setForeground(new Color(0, 0, 0));
        details.add(first_name);

        first_name_field = createPaddedTextField();
        first_name_field.setBounds(50, 380, 250, 40);
        details.add(first_name_field);

        JLabel last_name = new JLabel("Last Name");
        last_name.setBounds(310, 340, 100, 50);
        last_name.setFont(new Font("Dialog", Font.PLAIN, 15));
        last_name.setForeground(new Color(0, 0, 0));
        details.add(last_name);

        last_name_field = createPaddedTextField();
        last_name_field.setBounds(305, 380, 250, 40);
        details.add(last_name_field);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 430, 100, 50);
        address.setFont(new Font("Dialog", Font.PLAIN, 15));
        address.setForeground(new Color(0, 0, 0));
        details.add(address);

        address_field = createPaddedTextField();
        address_field.setBounds(50, 470, 500, 40);
        details.add(address_field);

        JLabel detail_Address = new JLabel("Apartment, Suit, etc (Optional)");
        detail_Address.setBounds(50, 520, 300, 50);
        detail_Address.setFont(new Font("Dialog", Font.PLAIN, 15));
        detail_Address.setForeground(new Color(0, 0, 0));
        details.add(detail_Address);

        detail_Address_field = createPaddedTextField();
        detail_Address_field.setBounds(50, 560, 500, 40);
        details.add(detail_Address_field);

        JLabel city = new JLabel("City");
        city.setBounds(50, 610, 100, 50);
        city.setFont(new Font("Dialog", Font.PLAIN, 15));
        city.setForeground(new Color(0, 0, 0));
        details.add(city);

        city_field = createPaddedTextField();
        city_field.setBounds(50, 650, 250, 40);
        details.add(city_field);

        JLabel postal_code = new JLabel("Postal Code");
        postal_code.setBounds(310, 610, 100, 50);
        postal_code.setFont(new Font("Dialog", Font.PLAIN, 15));
        postal_code.setForeground(new Color(0, 0, 0));
        details.add(postal_code);

        postal_Code_field = createPaddedTextField();
        postal_Code_field.setBounds(305, 650, 250, 40);
        details.add(postal_Code_field);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 700, 300, 50);
        phone.setFont(new Font("Dialog", Font.PLAIN, 15));
        phone.setForeground(new Color(0, 0, 0));
        details.add(phone);

        phone_field = createPaddedTextField();
        phone_field.setBounds(50, 740, 500, 40);
        details.add(phone_field);

        JLabel payment = new JLabel("Payment");
        payment.setBounds(50, 800, 250, 50);
        payment.setFont(new Font("Dialog", Font.BOLD, 25));
        payment.setForeground(new Color(0, 0, 0));
        details.add(payment);

        JLabel payment_note = new JLabel("All transactions are secure and encrypted.");
        payment_note.setBounds(50, 830, 500, 50);
        payment_note.setFont(new Font("Dialog", Font.PLAIN, 15));
        payment_note.setForeground(new Color(145, 144, 144));
        details.add(payment_note);

        JPanel payment_option = new JPanel();
        payment_option.setLayout(null);
        payment_option.setBounds(50, 880, 500, 130);
        payment_option.setBorder(new LineBorder(Color.black, 1));
        details.add(payment_option);

        online_payment = new JRadioButton();
        cash_on_delivery = new JRadioButton();

        ButtonGroup group = new ButtonGroup();
        group.add(online_payment);
        group.add(cash_on_delivery);

        online_payment.setText("Debit - Credit Card");
        online_payment.setBounds(10, 10, 200, 30);
        online_payment.setBackground(null);
        payment_option.add(online_payment);

        ImageIcon visa_icon = new ImageIcon("visa_icon.png");
        Image scaledImage = visa_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel visa_iconn = new JLabel(new ImageIcon(scaledImage));
        visa_iconn.setBounds(400, 10, 30, 30);
        payment_option.add(visa_iconn);

        ImageIcon mastercard_icon = new ImageIcon("mastercard_icon.png");
        Image scaledImage1 = mastercard_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        JLabel mastercard_iconn = new JLabel(new ImageIcon(scaledImage1));
        mastercard_iconn.setBounds(435, 10, 30, 30);
        payment_option.add(mastercard_iconn);

        cash_on_delivery.setText("Cash on Delivery");
        cash_on_delivery.setBounds(10, 50, 150, 30);
        cash_on_delivery.setBackground(null);
        payment_option.add(cash_on_delivery);

        JButton proceed = new JButton("Proceed");
        proceed.setBounds(250, 1030, 150, 30);
        proceed.setFont(new Font("Dialog", Font.BOLD, 15));
        proceed.setBackground(new Color(255, 0, 0));
        proceed.setForeground(Color.white);
        details.add(proceed);

        proceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (validateFields()) {
                        saveShippingDetailsToDatabase();

                        // Close current frame
                        frame.dispose();

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }

    private boolean validateFields() {
        String email = email_field.getText();
        String country = country_field.getText();
        String firstName = first_name_field.getText();
        String lastName = last_name_field.getText();
        String address = address_field.getText();
        String city = city_field.getText();
        String postalCode = postal_Code_field.getText();
        String phone = phone_field.getText();

        if (email.isEmpty() || country.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                address.isEmpty() || city.isEmpty() || postalCode.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
            return false;
        }

        // Validate email format
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid email address.");
            return false;
        }

        // Validate phone number format
        Pattern phonePattern = Pattern.compile("^03[0-9]{9}$");
        Matcher phoneMatcher = phonePattern.matcher(phone);
        if (!phoneMatcher.matches()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid phone number starting with '03' and followed by 9 digits.");
            return false;
        }

        return true;
    }

    public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/E_CommerceManagementSystem"; // Replace 'your_database' with your database name
        private static final String USER = "root"; // Replace 'your_username' with your database username
        private static final String PASSWORD = "Special42501"; // Replace 'your_password' with your database password

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

    private void saveShippingDetailsToDatabase() throws SQLException {
        String email = email_field.getText();
        String country = country_field.getText();
        String firstName = first_name_field.getText();
        String lastName = last_name_field.getText();
        String address = address_field.getText();
        String detailAddress = detail_Address_field.getText();
        String city = city_field.getText();
        String postalCode = postal_Code_field.getText();
        String phone = phone_field.getText();
        String paymentMethod = online_payment.isSelected() ? "Online Payment" : "Cash on Delivery";

        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Shipping_address (email, country, first_name, last_name, address, detail_address, city, postal_code, phone, payment_method) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, country);
        statement.setString(3, firstName);
        statement.setString(4, lastName);
        statement.setString(5, address);
        statement.setString(6, detailAddress);
        statement.setString(7, city);
        statement.setString(8, postalCode);
        statement.setString(9, phone);
        statement.setString(10, paymentMethod);

        statement.executeUpdate();
        statement.close();
        connection.close();

        JOptionPane.showMessageDialog(frame, "Shipping details saved successfully!");
    }

    private JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(new EmptyBorder(0, 10, 0, 0));
        return textField;
    }

    public static void main(String[] args) {
        new proceedToCheckout();
    }
}
