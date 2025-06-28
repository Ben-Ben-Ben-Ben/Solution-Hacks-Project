import java.awt.*;

import javax.swing.*;



public class Title extends JPanel {

    public Title() {



        // Create a JFrame instance

        JFrame frame = new JFrame("Garbage Game");



        // Set default close operation

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);

        frame.setVisible(true);





        this.setBackground(Color.BLACK);

        frame.add(this);

    }




    
}