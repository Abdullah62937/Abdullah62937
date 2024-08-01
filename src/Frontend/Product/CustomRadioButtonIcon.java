package Frontend.Product;/*
package Frontend.Product;

import javax.swing.*;
import java.awt.*;

public class CustomRadioButtonIcon implements Icon {
    private final int size;

    public CustomRadioButtonIcon(int size) {
        this.size = size;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();
        AbstractButton button = (AbstractButton) c;
        ButtonModel model = button.getModel();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the inner circle
        if (model.isSelected()) {
            g2.setColor(new Color(255, 204, 51)); // Yellow color for selected state
            g2.fillOval(x, y, size, size);
        } else {
            g2.setColor(Color.WHITE); // White background color for unselected state
            g2.fillOval(x, y, size, size);
        }

        g2.dispose();
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }
}
*/


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CustomRadioButtonIcon implements Icon {
    private int size;

    public CustomRadioButtonIcon(int size) {
        this.size = size;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, size, size);

        g2d.setColor(new Color(255, 204, 51)); // Change color when selected
        if (((AbstractButton) c).isSelected()) {
            g2d.fillOval(x + size / 4, y + size / 4, size / 2, size / 2);
        }

        g2d.dispose();
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }}