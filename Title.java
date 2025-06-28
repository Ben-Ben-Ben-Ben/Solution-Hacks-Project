import java.awt.*;
import javax.swing.*;

public class Title extends JPanel {
    public static void main(String[] args) {

        // Create a JFrame instance
        JFrame frame = new JFrame("Garbage Game");

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);


        this.setBackground(Color.BLACK);
        frame.add(this);

        frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);





//endregion

    }
}