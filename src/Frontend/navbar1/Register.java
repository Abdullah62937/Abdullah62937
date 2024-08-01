package Frontend.navbar1;

import Frontend.home.Common_Gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Register {

    final int frameWidth = 1500;
    final int frameHeight = 800;

    public Register() {
        JFrame frame = new JFrame();
        frame.setTitle("Register");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, frameWidth, frameHeight);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for custom positioning
        formPanel.setPreferredSize(new Dimension(1500, 1550));
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
        footer.setBounds(0, 850, 1500, 700);
        formPanel.add(footer);

        JLabel registerLabel = new JLabel("Create Account");
        registerLabel.setBounds(130, 250, 250, 50);
        registerLabel.setFont(new Font("Arial", Font.BOLD, 27));
        registerLabel.setForeground(Color.black);
        formPanel.add(registerLabel);

        JLabel registerInfo = new JLabel("Please register below to create an account");
        registerInfo.setBounds(130, 300, 400, 50);
        registerInfo.setFont(new Font("Arial", Font.PLAIN, 15));
        registerInfo.setForeground(new Color(91, 90, 90));
        formPanel.add(registerInfo);

        // Define arrays for the labels and field names
        String[] labels = {"First Name", "Last Name", "Your Email Address", "Phone", "Password"};
        JTextField[] textFields = new JTextField[labels.length];

        // Loop to create and position labels and text fields
        int yPosition = 350; // Initial Y position
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setBounds(130, yPosition, 400, 50);
            label.setFont(new Font("Arial", Font.PLAIN, 15));
            label.setForeground(new Color(0, 0, 0));
            formPanel.add(label);

            JTextField textField = createPaddedTextField();
            textField.setBounds(130, yPosition + 40, 400, 40);
            formPanel.add(textField);

            textFields[i] = textField; // Store the text field in the array
            yPosition += 100; // Increment Y position for next label and field
        }

        // Special handling for password field if needed
        JTextField passwordField = textFields[4]; // Password field
        passwordField.setBounds(800, 390, 400, 40);
        formPanel.add(passwordField);

        JLabel subscribeLabel = new JLabel("Subscribe To Email Marketing");
        subscribeLabel.setBounds(840, 440, 400, 50);
        subscribeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        subscribeLabel.setForeground(new Color(0, 0, 0));
        formPanel.add(subscribeLabel);

        JButton createAccountButton = new JButton("Create An Account");
        createAccountButton.setBounds(800, 500, 400, 40);
        createAccountButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        createAccountButton.setContentAreaFilled(false);
        createAccountButton.setBorderPainted(false);
        createAccountButton.setFocusPainted(false);
        createAccountButton.setBackground(new Color(255, 204, 51));
        createAccountButton.setOpaque(true);
        formPanel.add(createAccountButton);

        createAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                createAccountButton.setBackground(Color.white);
                createAccountButton.setBorder(new LineBorder(Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createAccountButton.setBackground(new Color(255, 204, 51));
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = textFields[0].getText().trim();
                String lastName = textFields[1].getText().trim();
                String email = textFields[2].getText().trim();
                String phone = textFields[3].getText().trim();
                String password = passwordField.getText().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
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

                if (!isStrongPassword(password)) {
                    JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long, contain upper and lower case letters, digits, and special characters.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                // Save data to database
                try {
                    saveToDatabase(firstName, lastName, email, phone, password);
                    JOptionPane.showMessageDialog(frame, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving to database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 10, 5, 5) // Top, Left, Bottom, Right padding
        ));
        return textField;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;
        if (!Pattern.compile("[A-Z]").matcher(password).find()) return false;
        if (!Pattern.compile("[a-z]").matcher(password).find()) return false;
        if (!Pattern.compile("[0-9]").matcher(password).find()) return false;
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) return false;
        return true;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneNumberPattern = "^(03[0-9]{9})$";
        return Pattern.matches(phoneNumberPattern, phoneNumber);
    }

    private void saveToDatabase(String firstName, String lastName, String email, String phone, String password) throws SQLException {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/E_CommerceManagementSystem";
        String user = "root";
        String passwordDB = "Special42501";
        // SQL query to insert data
        String sql = "INSERT INTO user (First_name, Last_name, Email,Phone_No, Password) VALUES (?, ?, ?, ?, ?)";

        // Establish connection and execute query
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/E_CommerceManagementSystem", "root", "Special42501");
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (First_name, Last_name, Email,Phone_No, Password) VALUES (?, ?, ?, ?, ?)")) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, password);
            pstmt.executeUpdate();
        }

    }

    public static void main(String[] args) {
        new Register();
    }
}
