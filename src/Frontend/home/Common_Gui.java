package Frontend.home;

import Frontend.Categories.Men;
import Frontend.navbar1.Cart;
import Frontend.navbar1.CartModel;
import Frontend.navbar1.CartObserver;
import Frontend.navbar1.Register;
import Frontend.Categories.Categories;
import Frontend.Categories.Women;
import Frontend.footer.mainmenu.buttons.Collections;
import Frontend.footer.mainmenu.buttons.New_Arrivals;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class Common_Gui {

    public static JLabel cartLabel;
    public static CartModel cartModel = new CartModel();

    /*public static JPanel CreateNavbar(JFrame frame){
        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(255, 204, 51));
        navbar.setBounds(0, 0, 1470, 75);
        navbar.setLayout(null);
        frame.add(navbar);

        // Logo Button functionality
        ImageIcon Brand_logo = new ImageIcon("Levis_Logo.png");
        Image image = Brand_logo.getImage(); // transform it
        Image newimg = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // scale it the smooth way
        Brand_logo = new ImageIcon(newimg);  // transform it back

        // Add a JButton with an image
        JButton Logo = new JButton();
        Logo.setBounds(0, 10, 150, 80);
        Logo.setHorizontalTextPosition(SwingConstants.RIGHT); // Position text to the right of the icon
        Logo.setContentAreaFilled(false); // Remove default button background
        Logo.setBorderPainted(false); // Remove default button border
        Logo.setFocusPainted(false); // Remove focus border
        Logo.setOpaque(false); // Ensure transparency
        // Set the bounds for the button
        Logo.setIcon(Brand_logo); // Set the resized icon
        navbar.add(Logo); // Add button to the navbar panel

        Logo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                Logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }
        });

        Logo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home_page();
                frame.dispose();
            }
        });

        ImageIcon cancel_icon = new ImageIcon("cancel_icon.png");
        Image image5 = cancel_icon.getImage();
        Image newimg5 = image5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        cancel_icon = new ImageIcon(newimg5);

        JButton clear_text = new JButton();
        clear_text.setBounds(850, 20, 50, 30);
        clear_text.setVisible(false);
        clear_text.setHorizontalTextPosition(SwingConstants.RIGHT);
        clear_text.setContentAreaFilled(false);
        clear_text.setBorderPainted(false);
        clear_text.setFocusPainted(false);
        clear_text.setBackground(new Color(255, 204, 51));
        clear_text.setOpaque(true);
        clear_text.setIcon(cancel_icon);
        navbar.add(clear_text);

        clear_text.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                clear_text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }
        });

        JTextField search_bar = new JTextField();
        search_bar.setBounds(480, 20, 400, 30); // Adjust the bounds as needed
        search_bar.setBackground(new Color(255, 255, 255));
        search_bar.setFocusable(true);
        search_bar.setBorder(new LineBorder(Color.yellow));
        search_bar.setFont(new Font("Ariel", Font.BOLD, 15));
        navbar.add(search_bar);

        search_bar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                clear_text.setVisible(true);
                frame.repaint();
            }
        });


        clear_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search_bar.setText("");
                clear_text.setVisible(false);
                frame.repaint();
            }
        });

        ImageIcon loginIcon = new ImageIcon("logo_icon.png");
        Image image1 = loginIcon.getImage(); // transform it
        Image newimg1 = image1.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // scale it the smooth way
        loginIcon = new ImageIcon(newimg1);

        JButton login = new JButton("Login");
        login.setBounds(1050, 22, 100, 30);
        login.setBackground(new Color(255, 204, 51));
        login.setHorizontalTextPosition(SwingConstants.RIGHT); // Position text to the right of the icon
        login.setContentAreaFilled(false); // Remove default button background
        login.setBorderPainted(false); // Remove default button border
        login.setFocusPainted(false); // Remove focus border
        login.setOpaque(true); // Ensure transparency
        login.setIcon(loginIcon); // Set the resized icon
        navbar.add(login); // Add button to the navbar panel

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                login.setBackground(Color.white);
                login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.setBackground(new Color(255, 204, 51));
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frontend.navbar1.login();
            }
        });

        ImageIcon registerIcon = new ImageIcon("register_icon.png");
        Image image2 = registerIcon.getImage(); // transform it
        Image newimg2 = image2.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // scale it the smooth way
        registerIcon = new ImageIcon(newimg2);

        JButton Register = new JButton("Register");
        Register.setBounds(1160, 22, 110, 30);
        Register.setHorizontalTextPosition(SwingConstants.RIGHT);
        Register.setBackground(new Color(255, 204, 51));
        Register.setContentAreaFilled(false);
        Register.setBorderPainted(false);
        Register.setFocusPainted(false);
        Register.setOpaque(true);
        Register.setIcon(registerIcon);
        navbar.add(Register);

        Register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Register.setBackground(Color.white);
                Register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Register.setBackground(new Color(255, 204, 51));
            }
        });

        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register();
                frame.dispose();
            }
        });

        ImageIcon cartIcon = new ImageIcon("cart_icon1.png");
        Image image3 = cartIcon.getImage(); // transform it
        Image newimg3 = image3.getScaledInstance(30, 25, Image.SCALE_SMOOTH); // scale it the smooth way
        cartIcon = new ImageIcon(newimg3);

        JLabel cart_quan = new JLabel("0");
        cart_quan.setHorizontalAlignment(SwingConstants.CENTER);
        cart_quan.setFont(new Font("Arial", Font.BOLD, 20));
        cart_quan.setBounds(1300,25, 100,20);
        navbar.add(cart_quan);



        JButton cart = new JButton();
        cart.setBounds(1290, 20, 50, 30);
        cart.setBackground(new Color(255, 204, 51));
        cart.setHorizontalTextPosition(SwingConstants.RIGHT);
        cart.setContentAreaFilled(false);
        cart.setBorderPainted(false);
        cart.setFocusPainted(false);
        cart.setOpaque(true);
        cart.setIcon(cartIcon);
        navbar.add(cart);

        cart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // cart.setBackground(Color.white);
                cart.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                cart.setBackground(new Color(255, 204, 51));
            }
        });

        cart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cart();
            }
        });




        ImageIcon search_icon = new ImageIcon("search_icon1.png");
        Image image4 = search_icon.getImage(); // transform it
        Image newimg4 = image4.getScaledInstance(30, 25, Image.SCALE_SMOOTH); // scale it the smooth way
        search_icon = new ImageIcon(newimg4);

        JButton search = new JButton();
        search.setBounds(900, 20, 50, 30);
        search.setHorizontalTextPosition(SwingConstants.RIGHT);
        search.setContentAreaFilled(false);
        search.setBorderPainted(false);
        search.setFocusPainted(false);
        search.setBackground(new Color(255, 204, 51));
        search.setOpaque(true);
        search.setIcon(search_icon);
        navbar.add(search);

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                search.setBackground(Color.white);
                search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search.setBackground(new Color(255, 204, 51));
            }
        });
        return navbar;

    }*/
        public static JPanel CreateNavbar(JFrame frame) {
            JPanel navbar = new JPanel();
            navbar.setBackground(new Color(255, 204, 51));
            navbar.setBounds(0, 0, 1470, 75);
            navbar.setLayout(null);
            frame.add(navbar);

            // Logo Button functionality
            ImageIcon Brand_logo = new ImageIcon("Levis_Logo.png");
            Image image = Brand_logo.getImage(); // transform it
            Image newimg = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // scale it the smooth way
            Brand_logo = new ImageIcon(newimg);  // transform it back

            // Add a JButton with an image
            JButton Logo = new JButton();
            Logo.setBounds(0, 10, 150, 80);
            Logo.setHorizontalTextPosition(SwingConstants.RIGHT); // Position text to the right of the icon
            Logo.setContentAreaFilled(false); // Remove default button background
            Logo.setBorderPainted(false); // Remove default button border
            Logo.setFocusPainted(false); // Remove focus border
            Logo.setOpaque(false); // Ensure transparency
            // Set the bounds for the button
            Logo.setIcon(Brand_logo); // Set the resized icon
            navbar.add(Logo); // Add button to the navbar panel

            Logo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    Logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });

            Logo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Home_page();
                    frame.dispose();
                }
            });

            ImageIcon cancel_icon = new ImageIcon("cancel_icon.png");
            Image image5 = cancel_icon.getImage();
            Image newimg5 = image5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            cancel_icon = new ImageIcon(newimg5);

            JButton clear_text = new JButton();
            clear_text.setBounds(850, 20, 50, 30);
            clear_text.setVisible(false);
            clear_text.setHorizontalTextPosition(SwingConstants.RIGHT);
            clear_text.setContentAreaFilled(false);
            clear_text.setBorderPainted(false);
            clear_text.setFocusPainted(false);
            clear_text.setBackground(new Color(255, 204, 51));
            clear_text.setOpaque(true);
            clear_text.setIcon(cancel_icon);
            navbar.add(clear_text);

            clear_text.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    clear_text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });

            JTextField search_bar = new JTextField();
            search_bar.setBounds(480, 20, 400, 30); // Adjust the bounds as needed
            search_bar.setBackground(new Color(255, 255, 255));
            search_bar.setFocusable(true);
            search_bar.setBorder(new LineBorder(Color.yellow));
            search_bar.setFont(new Font("Ariel", Font.BOLD, 15));
            navbar.add(search_bar);

            search_bar.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    clear_text.setVisible(true);
                    frame.repaint();
                }
            });

            clear_text.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    search_bar.setText("");
                    clear_text.setVisible(false);
                    frame.repaint();
                }
            });

            ImageIcon loginIcon = new ImageIcon("logo_icon.png");
            Image image1 = loginIcon.getImage(); // transform it
            Image newimg1 = image1.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // scale it the smooth way
            loginIcon = new ImageIcon(newimg1);

            JButton login = new JButton("Login");
            login.setBounds(1050, 22, 100, 30);
            login.setBackground(new Color(255, 204, 51));
            login.setHorizontalTextPosition(SwingConstants.RIGHT); // Position text to the right of the icon
            login.setContentAreaFilled(false); // Remove default button background
            login.setBorderPainted(false); // Remove default button border
            login.setFocusPainted(false); // Remove focus border
            login.setOpaque(true); // Ensure transparency
            login.setIcon(loginIcon); // Set the resized icon
            navbar.add(login); // Add button to the navbar panel

            login.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    login.setBackground(Color.white);
                    login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    login.setBackground(new Color(255, 204, 51));
                }
            });

            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Frontend.navbar1.login();
                }
            });

            ImageIcon registerIcon = new ImageIcon("register_icon.png");
            Image image2 = registerIcon.getImage(); // transform it
            Image newimg2 = image2.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // scale it the smooth way
            registerIcon = new ImageIcon(newimg2);

            JButton Register = new JButton("Register");
            Register.setBounds(1160, 22, 110, 30);
            Register.setHorizontalTextPosition(SwingConstants.RIGHT);
            Register.setBackground(new Color(255, 204, 51));
            Register.setContentAreaFilled(false);
            Register.setBorderPainted(false);
            Register.setFocusPainted(false);
            Register.setOpaque(true);
            Register.setIcon(registerIcon);
            navbar.add(Register);

            Register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    Register.setBackground(Color.white);
                    Register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Register.setBackground(new Color(255, 204, 51));
                }
            });

            Register.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Register();
                    frame.dispose();
                }
            });

            ImageIcon cartIcon = new ImageIcon("cart_icon1.png");
            Image image3 = cartIcon.getImage(); // transform it
            Image newimg3 = image3.getScaledInstance(30, 25, Image.SCALE_SMOOTH); // scale it the smooth way
            cartIcon = new ImageIcon(newimg3);






// =======================================================================================================================================





            cartLabel = new JLabel("0");
            cartLabel.setHorizontalAlignment(SwingConstants.CENTER);
            cartLabel.setFont(new Font("Arial", Font.BOLD, 15));
            cartLabel.setBounds(1300, 25, 100, 20);
            navbar.add(cartLabel);

            JButton cartt = new JButton();
            cartt.setBounds(1290, 20, 50, 30);
            cartt.setBackground(new Color(255, 204, 51));
            cartt.setHorizontalTextPosition(SwingConstants.RIGHT);
            cartt.setContentAreaFilled(false);
            cartt.setBorderPainted(false);
            cartt.setFocusPainted(false);
            cartt.setOpaque(true);
            cartt.setIcon(cartIcon);
            navbar.add(cartt);

            cartt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cartt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    cartt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    cartt.setBackground(new Color(255, 204, 51));
                    cartt.setBorder(null);
                }
            });

            cartt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Cart(cartModel);
                }
            });

            cartModel.addObserver(new CartObserver() {
                @Override
                public void cartUpdated(int quantity) {
                    cartLabel.setText(String.valueOf(quantity));
                }
            });

            ImageIcon search_icon = new ImageIcon("search_icon1.png");
            Image image4 = search_icon.getImage(); // transform it
            Image newimg4 = image4.getScaledInstance(30, 25, Image.SCALE_SMOOTH); // scale it the smooth way
            search_icon = new ImageIcon(newimg4);

            JButton search = new JButton();
            search.setBounds(900, 20, 50, 30);
            search.setHorizontalTextPosition(SwingConstants.RIGHT);
            search.setContentAreaFilled(false);
            search.setBorderPainted(false);
            search.setFocusPainted(false);
            search.setBackground(new Color(255, 204, 51));
            search.setOpaque(true);
            search.setIcon(search_icon);
            navbar.add(search);

            search.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    search.setBackground(Color.white);
                    search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    search.setBackground(new Color(255, 204, 51));
                }
            });

            cartModel.addObserver(quantity -> cartLabel.setText(String.valueOf(quantity)));

            return navbar;
        }

        public static CartModel getCartModel() {
            return cartModel;
        }


    public static JPanel CreateMenu(JFrame frame){

        JPanel navbar2 = new JPanel(frame.getLayout());

        navbar2.setBackground(new Color(255, 255, 255)); // Set background color
        navbar2.setBounds(0, 100, 1470, 60); // Position it below the first navbar
        navbar2.setLayout(null);
        frame.add(navbar2);

        int buttonWidth = 150;
        int buttonHeight = 30;
        int xOffset = 350;

        JButton Home = new JButton("Home");
        Home.setBounds(350, 30, 150, 30);
        Home.setFocusPainted(false);
        Home.setContentAreaFilled(false);
        Home.setBorderPainted(false);
        Home.setOpaque(true);
        Home.setBackground(new Color(255, 204, 51));
        navbar2.add(Home);

        Home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Home.setBackground(Color.white);
                Home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Home.setBackground(new Color(255, 204, 51));
            }
        });

        Home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home_page();
                frame.dispose();
            }
        });

        JButton Categories = new JButton("Categories");
        Categories.setBounds(550, 30, 150, 30);
        Categories.setFocusPainted(false);
        Categories.setContentAreaFilled(false);
        Categories.setBorderPainted(false);
        Categories.setOpaque(true);
        Categories.setBackground(new Color(255, 204, 51));
        navbar2.add(Categories);

        Categories.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Categories.setBackground(Color.white);
                Categories.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Categories.setBackground(new Color(255, 204, 51));
            }
        });

        Categories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Categories();
            }
        });

        JButton Men = new JButton("Men");
        Men.setBounds(750, 30, 150, 30);
        Men.setFocusPainted(false);
        Men.setContentAreaFilled(false);
        Men.setBorderPainted(false);
        Men.setOpaque(true);
        Men.setBackground(new Color(255, 204, 51));
        navbar2.add(Men);

        Men.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Men.setBackground(Color.white);
                Men.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Men.setBackground(new Color(255, 204, 51));
            }
        });

        Men.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Men();
            }
        });


        JButton Women = new JButton("Women");
        Women.setBounds(950, 30, 150, 30);
        Women.setFocusPainted(false);
        Women.setContentAreaFilled(false);
        Women.setBorderPainted(false);
        Women.setOpaque(true);
        Women.setBackground(new Color(255, 204, 51));
        navbar2.add(Women);

        Women.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Women.setBackground(Color.white);
                Women.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Women.setBackground(new Color(255, 204, 51));
            }
        });

        Women.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Women();
            }
        });

        return navbar2;
    }

    public static JPanel scrollbar(JFrame frame) {


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1500, 2000)); // Ensure it's large enough to require scrolling

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        frame.add(scrollPane, BorderLayout.CENTER);

        return mainPanel;
    }

    public static JPanel Footer(JFrame frame){
    /*navbar2.setBackground(new Color(255, 255, 255)); // Set background color
    navbar2.setBounds(0, 100, 1470, 60); // Position it below the first navbar
    navbar2.setLayout(null);
    frame.add(navbar2);*/

        JPanel footer = new JPanel();
        footer.setLayout(null);
        footer.setBackground(new Color(255, 204, 51));
        footer.setBounds(0, 3360, 1500, 700);
        frame.add(footer);

        //  features.setBackground(Color.white);

        ImageIcon footer_logo = new ImageIcon("levis_logo2.png");
        Image footer_image = footer_logo.getImage();
        Image footer_iconn_new = footer_image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        footer_logo = new ImageIcon(footer_iconn_new);

        JButton footer_Logo = new JButton();
        footer_Logo.setBounds(50, 20, 150, 150);
        footer_Logo.setHorizontalTextPosition(SwingConstants.RIGHT);
        footer_Logo.setContentAreaFilled(false);
        footer_Logo.setBorderPainted(false);
        footer_Logo.setFocusPainted(false);
        footer_Logo.setOpaque(false);
        footer_Logo.setIcon(footer_logo);
        footer.add(footer_Logo);

        JPanel text_panel = new JPanel();
        text_panel.setBackground(null);
        text_panel.setBounds(50, 150, 300,270);
        footer.add(text_panel);

        String labelText = "<html>"
                + "The Fabric Store is a Women Clothing Brand by East<br><br>\n"
                + "Gate Industries Pvt Ltd. established in 2016 Currently<br><br>"
                + "having presence in Punjab and KPK with 34 outlets<br><br>"
                + "and many more yet to come TFS offers an extensive<br><br>"
                + " range of ready to wear & unstitched categories<br><br>"
                + "Consisting of formal and casual featuring printed,<br><br>"
                + "embroidered and embellished dresses. for quality <br><br>"
                + "conscious fashion connoisseurs and progressive <br><br>"
                + "</html>";



        JLabel footer_label = new JLabel(labelText);
        footer_label.setBounds(50,90,1500,400);
        footer_label.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        footer_label.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        footer_label.setFont(new Font("Arial", Font.PLAIN, 13));
        text_panel.add(footer_label);

        ImageIcon facebook_logo = new ImageIcon("facebook_icon.png");
        Image facebook_image = facebook_logo.getImage();
        Image facbook_iconn_new = facebook_image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        facebook_logo = new ImageIcon(facbook_iconn_new);

        JButton facbook_Logo = new JButton();
        facbook_Logo.setBounds(100, 425, 50, 50);
        facbook_Logo.setHorizontalTextPosition(SwingConstants.RIGHT);
        facbook_Logo.setContentAreaFilled(false);
        facbook_Logo.setBorderPainted(false);
        facbook_Logo.setFocusPainted(false);
        facbook_Logo.setOpaque(false);
        facbook_Logo.setIcon(facebook_logo);
        footer.add(facbook_Logo);

        facbook_Logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                facbook_Logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                facbook_Logo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

        });

        ImageIcon instagram_logo = new ImageIcon("instagram_icon.png");
        Image instagram_image = instagram_logo.getImage();
        Image instagram_iconn_new = instagram_image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        instagram_logo = new ImageIcon(instagram_iconn_new);

        JButton instagram_Logo = new JButton();
        instagram_Logo.setBounds(200, 425, 50, 50);
        instagram_Logo.setHorizontalTextPosition(SwingConstants.RIGHT);
        instagram_Logo.setContentAreaFilled(false);
        instagram_Logo.setBorderPainted(false);
        instagram_Logo.setFocusPainted(false);
        instagram_Logo.setOpaque(false);
        // instagram_Logo.setBackground(Color.WHITE);
        instagram_Logo.setIcon(instagram_logo);
        footer.add(instagram_Logo);

        instagram_Logo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                instagram_Logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                instagram_Logo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

        });

        instagram_Logo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register();
            }
        });


        JLabel footer_mainmenu = new JLabel("Maine Menu");
        footer_mainmenu.setBounds(500,100,200,20);
        footer_mainmenu.setBackground(null);
        footer_mainmenu.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        footer_mainmenu.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        footer_mainmenu.setFont(new Font("Arial", Font.BOLD, 18));
        footer.add(footer_mainmenu);

        JPanel footer_buttonPanel = new JPanel();
        footer_buttonPanel.setBackground(null);
        footer_buttonPanel.setLayout(new BoxLayout(footer_buttonPanel, BoxLayout.Y_AXIS)); // Vertical layout
        footer_buttonPanel.setBounds(450, 150, 200, 250);
        footer.add(footer_buttonPanel);

        String[] buttonTexts = {
                "Collection", "New Arrivals", "Special Offer", "Button1", "Button2"
        };

        for (String text : buttonTexts) {
            JButton footer_buttons = new JButton("<html><u>" + text + "</u></html>");
            footer_buttons.setBackground(null); // Set background to null for transparency
            footer_buttons.setContentAreaFilled(false); // Remove default button background
            footer_buttons.setBorderPainted(false); // Remove default button border
            footer_buttons.setFocusPainted(false); // Remove focus border
            footer_buttons.setOpaque(false); // Ensure transparency
            footer_buttons.setAlignmentX(Component.LEFT_ALIGNMENT); // Align the button to the left
            footer_buttonPanel.add(footer_buttons);

            footer_buttons.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    footer_buttons.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });

            footer_buttons.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (text) {
                        case "Collection":
                            new Collections();
                            break;
                        case "New Arrivals":
                            new New_Arrivals();
                            JOptionPane.showMessageDialog(frame, "New Arrivals button clicked!");
                            break;
                        case "Special Offer":
                            JOptionPane.showMessageDialog(frame, "Special Offer button clicked!");
                            break;
                        case "Button1":
                            JOptionPane.showMessageDialog(frame, "Button1 clicked!");
                            break;
                        case "Button2":
                            JOptionPane.showMessageDialog(frame, "Button2 clicked!");
                            break;
                        default:
                            break;
                    }
                }
            });

            footer_buttonPanel.add(Box.createVerticalStrut(20)); // Add a gap of 10 pixels


        }

        JLabel footer_informationn= new JLabel("Information");
        footer_informationn.setBounds(800,100,200,20);
        footer_informationn.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        footer_informationn.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        footer_informationn.setFont(new Font("Arial", Font.BOLD, 18));
        footer.add(footer_informationn);

        JPanel footer_information = new JPanel();
        footer_information.setLayout(new BoxLayout(footer_information, BoxLayout.Y_AXIS)); // Vertical layout
        footer_information.setBounds(750, 150, 200, 250);
        footer_information.setBackground(null);
        footer.add(footer_information);

        String[] footer_information_buttons = {
                "Shipping Policy", "Privacy Policy", "Store Locator", "Track Your Order"
        };

        for (String text2 : footer_information_buttons) {
            JButton information_buttons = new JButton("<html><u>" + text2 + "</u></html>");//
            information_buttons.setBackground(null);
            information_buttons.setContentAreaFilled(false); // Remove default button background
            information_buttons.setBorderPainted(false); // Remove default button border
            information_buttons.setFocusPainted(false); // Remove focus border
            information_buttons.setOpaque(true); // Ensure transparency
            information_buttons.setAlignmentX(Component.LEFT_ALIGNMENT); // Align the button to the left
            footer_information.add(information_buttons);

            footer_information.add(Box.createVerticalStrut(20)); // Add a gap of 10 pixels


        }

        JLabel footer_contact_informationn= new JLabel("Contact Information");
        footer_contact_informationn.setBounds(1070,100,200,20);
        footer_contact_informationn.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        footer_contact_informationn.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        footer_contact_informationn.setFont(new Font("Arial", Font.BOLD, 18));
        footer.add(footer_contact_informationn);

        JPanel footer_contact_information = new JPanel();
        footer_contact_information.setLayout(new BoxLayout(footer_contact_information, BoxLayout.Y_AXIS)); // Vertical layout
        footer_contact_information.setBounds(1010, 150, 300, 150);
        footer_contact_information.setBackground(null);
        footer.add(footer_contact_information);

        String[] footer_contact_buttons = {
                "Call us: +92 330-8299410", "Email Us: Cs@Levi'sstore.Pk"
        };

        for (String text3 : footer_contact_buttons) {
            JButton contact_buttons = new JButton("<html><u>" + text3 + "</u></html>");//
            contact_buttons.setBackground(null);
            contact_buttons.setFont(new Font("Arial", Font.PLAIN, 15));
            contact_buttons.setContentAreaFilled(false); // Remove default button background
            contact_buttons.setBorderPainted(false); // Remove default button border
            contact_buttons.setFocusPainted(false); // Remove focus border
            contact_buttons.setOpaque(true); // Ensure transparency
            contact_buttons.setAlignmentX(Component.LEFT_ALIGNMENT); // Align the button to the left
            footer_contact_information.add(contact_buttons);

            footer_contact_information.add(Box.createVerticalStrut(20)); // Add a gap of 10 pixels


        }

        JLabel footer_news_label = new JLabel("NEWSLETTER SIGN UP");
        footer_news_label.setBounds(50,500,200,30);
        footer_news_label.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        footer_news_label.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        footer_news_label.setFont(new Font("Arial", Font.BOLD, 15));
        footer.add(footer_news_label);

        JLabel footer_news1_label = new JLabel("Sign up for exclusive updates");
        footer_news1_label.setBounds(50,530,250,30);
        footer_news1_label.setHorizontalTextPosition(JLabel.RIGHT); // Text to the right of icon
        footer_news1_label.setVerticalTextPosition(JLabel.CENTER); // Text centered vertically
        footer_news1_label.setFont(new Font("Arial", Font.PLAIN, 15));
        footer.add(footer_news1_label);


        JTextField subscribe_bar = new JTextField();
        subscribe_bar.setBounds(50, 570, 250, 35); // Adjust the bounds as needed
        subscribe_bar.setBackground(new Color(255, 255, 255));
        subscribe_bar.setFocusable(true);
        subscribe_bar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.WHITE),
                new EmptyBorder(5, 10, 5, 5)
        ));
        subscribe_bar.setFont(new Font("Ariel", Font.BOLD, 15));
        footer.add(subscribe_bar);

        /*subscribe_bar.setInputVerifier(new InputVerifier() {
            private final Pattern emailPattern = Pattern.compile(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                if (!emailPattern.matcher(text).matches()) {
                    JOptionPane.showMessageDialog(frame, "Invalid email format. Please enter a valid email (e.g., aba@gmail.com).");
                    return false;
                }
                return true;
            }
        });*/

        JButton submit = new JButton("Submit");
        submit.setBounds(320, 570, 100, 35);
        submit.setHorizontalTextPosition(SwingConstants.RIGHT);
        submit.setContentAreaFilled(false);
        submit.setBorderPainted(false);
        submit.setFocusPainted(false);
        submit.setBackground(new Color(5, 5, 5));
        submit.setForeground(Color.white);
        submit.setOpaque(true);
        footer.add(submit);

        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                submit.setBackground(Color.white);
                submit.setForeground(Color.BLACK);
            }

            public void mouseExited(MouseEvent e) {
                submit.setBackground(Color.BLACK);
                submit.setForeground(Color.WHITE);
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Thank you for subscribing");
                new Register();
            }
        });

        return footer;


    }

}
