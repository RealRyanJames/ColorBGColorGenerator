import javax.swing.*;
import java.awt.*;

private final JFrame frame = new JFrame();
private final JButton button = new JButton("Generate Code");


enum Col {
    BLACK,
    RED,
    WHITE,
}

public Color GetPanesColor(Col col) {
    if (col == Col.BLACK) {
        return new Color(0, 0, 0);
    }

    else if (col == Col.RED) {
        return new Color(255, 0, 0);
    }

    else if (col == Col.WHITE) {
        return new Color(255, 255, 255);
    }
    return null;
}


void main() {



    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    var pane = (JPanel) frame.getContentPane();
    pane.add(button, BorderLayout.SOUTH);
    button.setBackground(GetPanesColor(Col.BLACK));
    button.setForeground(GetPanesColor(Col.WHITE));
    JPanel panel = new JPanel(new GridLayout());
    JLabel label_r = new JLabel("R: 255", SwingConstants.CENTER);
    JLabel label_g = new JLabel("G: 255", SwingConstants.CENTER);
    JLabel label_b = new JLabel("B: 255", SwingConstants.CENTER);

    pane.setBorder(BorderFactory.createLineBorder(Color.black, 5));
    button.setPreferredSize(new Dimension(200, 35));
    button.setFocusPainted(false);
    label_r.setFont(new Font("Sans-serif", Font.BOLD, 15));
    label_g.setFont(new Font("Sans-serif", Font.BOLD, 15));
    label_b.setFont(new Font("Sans-serif", Font.BOLD, 15));

    panel.add(label_r, BorderLayout.CENTER);
    panel.add(label_g, BorderLayout.CENTER);
    panel.add(label_b, BorderLayout.CENTER);

    button.addActionListener(_ -> {
        Random r = new Random();
        int redX = r.nextInt(1, 254 + 1);
        int greenX = r.nextInt(1, 254 + 1);
        int blueX = r.nextInt(1, 254 + 1);
        label_r.setText("R: " + redX);
        label_g.setText("G: " + greenX);
        label_b.setText("B: " + blueX);

        panel.setBackground(new Color(redX, greenX, blueX));
    });

    pane.add(panel);
    frame.setSize(new Dimension(600 / 2, 300 * 2));
    frame.setVisible(true);
}