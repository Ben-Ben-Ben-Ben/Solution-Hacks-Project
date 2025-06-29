import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.util.ArrayList;

public class GameOver{
    private Image backgroundImage;

    private int count = 0;

    public GameOver(int score, ArrayList<GarbageItem> mistakes){
        // Load background image
        backgroundImage = new ImageIcon("Illustrations/game-screen-wallp.png").getImage();


        // Create a JFrame instance
        JFrame frame = new JFrame("Garbage Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Custom JPanel for background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());


        // descriptions
        JTextPane description = new JTextPane();
        description.setText("You made " + mistakes.size() + " mistakes!\n\n" +
                "Click through to learn about which items go in which bin.\n\n");
        description.setFont(new Font("Arial", Font.PLAIN, 18));
        description.setEditable(false); // Make the text area non-editable
        description.setOpaque(false);
        description.setForeground(Color.PINK);
        description.setBounds((frame.getWidth()-300) / 2, 0, 300, 100);
        backgroundPanel.add(description);


        // Advance button
        JButton startButton = new JButton("Next");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBounds((frame.getWidth()-250) / 2, 150, 100, 50);
        startButton.addActionListener(e -> {
            description.setText(mistakes.get(count).Name + "\n" + mistakes.get(count).GameOverTip);
            count++;
            if (count+1 >= mistakes.size()) {
                startButton.setText("Return To Title Screen");
            } else if (count >= mistakes.size()) {
                frame.dispose(); // Close the game over screen
                new Title(); // Return to the title screen
            }
        });
        backgroundPanel.add(startButton);
        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
        frame.repaint();

    }

}