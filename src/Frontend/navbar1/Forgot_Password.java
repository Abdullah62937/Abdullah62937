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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Forgot_Password {

    JFrame frame;
    final int frameWidth = 1500;
    final int frameHeight = 800;
    JTextField t1; // Make this a class-level variable for easy access

    // Database credentials
    String url = "jdbc:mysql://localhost:3306/E_CommerceManagementSystem";
    String user = "root";
    String password = "Special42501";

    Forgot_Password() {
        frame = new JFrame("Forgot Password");
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        frame.setIconImage(icon.getImage());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Use null layout for custom absolute positioning
        formPanel.setPreferredSize(new Dimension(1500, 1250)); // Adjust height to fit all content
        formPanel.setBackground(Color.white);

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel navbar = Common_Gui.CreateNavbar(frame);
        formPanel.add(navbar);

        JPanel navbar2 = Common_Gui.CreateMenu(frame);
        formPanel.add(navbar2);

        JPanel footer = Common_Gui.Footer(frame);
        footer.setBounds(0, 600, 1500, 700);
        formPanel.add(footer);

        JLabel Register = new JLabel("Reset");
        Register.setBounds(130, 250, 250, 50);
        Register.setFont(new Font("Arial", Font.BOLD, 27));
        Register.setForeground(Color.black);
        formPanel.add(Register);

        JLabel Register1 = new JLabel("We will send you an email to reset your password");
        Register1.setBounds(130, 300, 500, 50);
        Register1.setFont(new Font("Arial", Font.PLAIN, 15));
        Register1.setForeground(new Color(91, 90, 90));
        formPanel.add(Register1);

        JLabel first_name = new JLabel("Email Address");
        first_name.setBounds(130, 350, 400, 50);
        first_name.setFont(new Font("Arial", Font.PLAIN, 15));
        first_name.setForeground(new Color(0, 0, 0));
        formPanel.add(first_name);

        t1 = createPaddedTextField();
        t1.setBounds(130, 390, 400, 40);
        formPanel.add(t1);

        JButton forgot = new JButton("Forgot");
        forgot.setBounds(130, 450, 250, 40);
        forgot.setHorizontalTextPosition(SwingConstants.RIGHT);
        forgot.setContentAreaFilled(false);
        forgot.setBorderPainted(false);
        forgot.setFocusPainted(false);
        forgot.setBackground(new Color(255, 204, 51));
        forgot.setOpaque(true);
        formPanel.add(forgot);

        forgot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                forgot.setBackground(Color.white);
                forgot.setBorder(new LineBorder(Color.black));
                forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgot.setBackground(new Color(255, 204, 51));
            }
        });

        forgot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleForgotPassword();
            }
        });

        JButton cancel = new JButton("cancel");
        cancel.setBounds(400, 450, 100, 40);
        cancel.setHorizontalTextPosition(SwingConstants.RIGHT);
        cancel.setContentAreaFilled(false);
        cancel.setBorderPainted(false);
        cancel.setFocusPainted(false);
        cancel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cancel.setBackground(new Color(0, 0, 0));
        cancel.setForeground(Color.white);
        cancel.setOpaque(true);
        formPanel.add(cancel);

        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(Color.WHITE);
                cancel.setForeground(Color.BLACK);
                //  cancel.setBorder(new LineBorder(Color.black));
                cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBackground(Color.black);
                cancel.setForeground(Color.WHITE);
            }
        });

        frame.add(scrollPane);
        frame.setVisible(true);
    }

    private JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK),
                new EmptyBorder(5, 10, 5, 5) // Top, Left, Bottom, Right padding
        ));
        return textField;
    }

    private void handleForgotPassword() {
        String email = t1.getText().trim();

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter your email address.");
            return;
        }

        // Check if the email exists in the database
        if (isEmailRegistered(email)) {
            // Simulate sending an email (for now just show a message)
            JOptionPane.showMessageDialog(frame, "We have sent you an email with a link to update your password.");
            // You can add actual email sending logic here using JavaMail API or similar
            new login();
        } else {
            JOptionPane.showMessageDialog(frame, "Email address not registered.");
        }
    }

    private boolean isEmailRegistered(String email) {
        boolean isRegistered = false;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT COUNT(*) FROM user WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next() && resultSet.getInt(1) > 0) {
                        isRegistered = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database connection error.");
        }
        return isRegistered;
    }

    public static void main(String[] args) {
        new Forgot_Password();
    }
}
