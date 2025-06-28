import java.awt.*;
import javax.swing.*;


public class Title{



    public Title() {
        // Create a JFrame instance
        JFrame frame = new JFrame("Garbage Game");

        // Changing window settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
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
        title.setBounds(0,100,500,500);
        frame.add(title);

        // Start button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBounds((frame.getWidth()-250) / 2, 300, 250, 50);
        startButton.addActionListener(e -> {
            // Action to start the game
            System.out.println("Game Started");
            frame.dispose(); // Close the title screen
            //new Game(); // Start the game
        });
        frame.add(startButton);

        //Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setBounds((frame.getWidth()-100) / 2, 359, 100, 50);
        exitButton.addActionListener(e -> {
            // Action to exit the game
            System.exit(0);
        });
        exitButton.setVisible(true);
        frame.add(exitButton);

    }

}