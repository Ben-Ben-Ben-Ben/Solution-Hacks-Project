import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class Title{



    public Title() {
        // Create a JFrame instance
        JFrame frame = new JFrame("Garbage Game");

        // Changing window settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);

        //title
        JLabel title = new JLabel("Garbage Game");
        title.setFont(new Font("Arial", Font.BOLD, 60));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.NORTH);
        title.setForeground(Color.PINK);
        title.setBounds(0,75,700,700);
        frame.add(title);

        // descriptions
        JTextPane description = new JTextPane();
        description.setText("This game educates about how to dispose of waste properly! In support of the United Nations' Responsible Consumption and Production Sustainable Development Goal.");
        description.setFont(new Font("Arial", Font.PLAIN, 18));
        description.setEditable(false); // Make the text area non-editable
        description.setOpaque(false); 
        description.setForeground(Color.PINK);
        description.setBounds((frame.getWidth()-500) / 2, 150, 500, 100);

        StyledDocument doc = description.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        frame.add(description);

        // Start button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBounds((frame.getWidth()-250) / 2, 500, 250, 50);
        startButton.addActionListener(e -> {
            // Action to start the game
            System.out.println("Game Started");
            Game game = new Game();
            frame.dispose(); // Close the title screen
        });
        frame.add(startButton);

        //Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setBounds((frame.getWidth()-100) / 2, 600, 100, 50);
        exitButton.addActionListener(e -> {
            // Action to exit the game
            System.exit(0);
        });
        exitButton.setVisible(true);
        frame.add(exitButton);

        frame.repaint();
    }

}