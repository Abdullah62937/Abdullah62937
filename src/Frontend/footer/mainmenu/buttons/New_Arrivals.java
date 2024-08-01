package Frontend.footer.mainmenu.buttons;

import javax.swing.*;
import java.awt.*;

public class New_Arrivals extends JFrame {

    JFrame frame;
    public New_Arrivals(){
        frame = new JFrame();

        frame.setTitle("Levis");
        frame.setBackground(Color.white);
        frame.setLayout(null); // Use null layout for custom absolute positioning
        frame.setBounds(25, 15, 1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
