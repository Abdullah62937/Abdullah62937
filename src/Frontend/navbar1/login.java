package Frontend.navbar1;

import Frontend.home.Common_Gui;
import Frontend.home.Home_page;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.sql.*;

public class login {
    JFrame frame = new JFrame("Login");
    JPanel slidingLoginPanel;
    Timer timer;
    int panelX = 1500;
    final int panelWidth = 375;
    final int frameWidth = 1500;
    final int frameHeight = 800;

    public login() {
        this.frame.setLayout((LayoutManager)null);
        this.frame.setBounds(25, 15, 1500, 800);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("Levis_Logo.png");
        this.frame.setIconImage(icon.getImage());
        JPanel formPanel = new JPanel();
        formPanel.setLayout((LayoutManager)null);
        formPanel.setPreferredSize(new Dimension(1500, 1550));
        formPanel.setBackground(Color.white);
        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setBounds(0, 0, 1485, 760);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel navbar = Common_Gui.CreateNavbar(this.frame);
        formPanel.add(navbar);
        JPanel navbar2 = Common_Gui.CreateMenu(this.frame);
        formPanel.add(navbar2);
        JPanel footer = Common_Gui.Footer(this.frame);
        footer.setBounds(0, 850, 1500, 700);
        formPanel.add(footer);
        JLabel Register = new JLabel("Login");
        Register.setBounds(130, 250, 250, 50);
        Register.setFont(new Font("Arial", Font.BOLD, 27));
        Register.setForeground(Color.black);
        formPanel.add(Register);
        JLabel Register1 = new JLabel("Please enter your email and password below to access your account");
        Register1.setBounds(130, 300, 500, 50);
        Register1.setFont(new Font("Arial", Font.PLAIN, 15));
        Register1.setForeground(new Color(91, 90, 90));
        formPanel.add(Register1);
        JLabel first_name = new JLabel("Email Address");
        first_name.setBounds(130, 350, 400, 50);
        first_name.setFont(new Font("Arial", Font.PLAIN, 15));
        first_name.setForeground(new Color(0, 0, 0));
        formPanel.add(first_name);
        final JTextField t1 = this.createPaddedTextField();
        t1.setBounds(130, 390, 400, 40);
        formPanel.add(t1);
        JLabel password = new JLabel("Password");
        password.setBounds(130, 450, 400, 50);
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setForeground(new Color(0, 0, 0));
        formPanel.add(password);
        final JPasswordField t5 = new JPasswordField();
        t5.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(5, 10, 5, 5)));
        t5.setBounds(130, 490, 400, 40);
        formPanel.add(t5);
        final JButton forgot = new JButton("Forgot Password?");
        forgot.setBounds(130, 550, 400, 40);
        forgot.setText("<html><u>Forgot Password</u></html>");
        forgot.setForeground(Color.black);
        forgot.setBorder((Border)null);
        forgot.setOpaque(false);
        forgot.setContentAreaFilled(false);
        forgot.setFocusPainted(false);
        formPanel.add(forgot);
        forgot.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        });
        forgot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Forgot_Password();
            }
        });
        final JButton Sign_in = new JButton("SIGN IN");
        Sign_in.setBounds(130, 600, 400, 40);
        Sign_in.setHorizontalTextPosition(JButton.CENTER);
        Sign_in.setContentAreaFilled(false);
        Sign_in.setBorderPainted(false);
        Sign_in.setFocusPainted(false);
        Sign_in.setBackground(new Color(255, 204, 51));
        Sign_in.setOpaque(true);
        formPanel.add(Sign_in);
        Sign_in.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                Sign_in.setBackground(Color.white);
                Sign_in.setBorder(new LineBorder(Color.black));
                Sign_in.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                Sign_in.setBackground(new Color(255, 204, 51));
            }
        });
        Sign_in.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = t1.getText();
                String password = new String(t5.getPassword());

                // Validate the credentials
                if (validateCredentials(email, password)) {
                    JOptionPane.showMessageDialog(login.this.frame, "Login Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new Home_page();
                    login.this.frame.dispose();
                } else if (email.isBlank() || password.isBlank()) {
                    JOptionPane.showMessageDialog(login.this.frame, "Please fill out these fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(login.this.frame, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.frame.add(scrollPane);
        this.frame.setVisible(true);
    }

    private JTextField createPaddedTextField() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(5, 10, 5, 5)));
        return textField;
    }

    private boolean validateCredentials(String email, String password) {
        boolean isValid = false;

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/E_CommerceManagementSystem";
        String user = "root";
        String passwordDB = "Special42501";

        // SQL query to check credentials
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, user, passwordDB);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isValid = true;
                } else {
                    System.out.println("No Records found for the provided email and password.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database connection or query execution failed.");
            e.printStackTrace();
        }

        return isValid;
    }

    public static void main(String[] args) {
        new login();
    }
}
