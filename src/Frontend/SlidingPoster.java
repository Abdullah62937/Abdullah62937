package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlidingPoster {

    private int currentIndex = 0;
    private final JLabel imageLabel;
    private final String[] imagePaths;
    private final Timer timer;

    public SlidingPoster() {
        JFrame frame = new JFrame();
        frame.setTitle("Levis");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel posterPanel = new JPanel();
        posterPanel.setBounds(0, 75, 1500, 400);
        frame.add(posterPanel);

        imagePaths = new String[]{
                "Poster1.png",
                "Poster1.png",
                "Poster1.png"
                // Add paths to your images here
        };

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        posterPanel.add(imageLabel);

        loadNextImage();

        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadNextImage();
            }
        });
        timer.start();

        frame.setVisible(true);
    }

    private void loadNextImage() {
        ImageIcon icon = new ImageIcon(imagePaths[currentIndex]);
        Image image = icon.getImage().getScaledInstance(1500, 400, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        imageLabel.setIcon(icon);

        currentIndex = (currentIndex + 1) % imagePaths.length;
    }

    public static void main(String[] args) {
        new SlidingPoster();
    }
}

