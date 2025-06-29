import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Title extends JPanel{
    private Image backgroundImage;
    JLabel cow, title;

    @SuppressWarnings("unused")
    public Title() {
        // Load background image
        backgroundImage = new ImageIcon("Illustrations/title-screen-wallp.png").getImage();
        
        // Create a JFrame instance
        JFrame frame = new JFrame("Garbage Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        this.setLayout(null);

        // Title
        title = new JLabel();
        title.setIcon(new ImageIcon("Illustrations/garbage-game [LOGO].png"));
        this.add(title);

        // Descriptions
        JTextPane description = new JTextPane();
        description.setText("This game educates about how to dispose of waste properly! In support of the United Nations' Responsible Consumption and Production Sustainable Development Goal.");
        description.setFont(new Font("Arial", Font.PLAIN, 18));
        description.setEditable(false); // Make the text area non-editable
        description.setOpaque(false); 
        description.setForeground(Color.BLACK);
        description.setBounds((frame.getWidth()-500) / 2, 350, 500, 100);
        description.setFocusable(false); // Prevent focus

        StyledDocument doc = description.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        this.add(description);

        // Start button
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setBounds((frame.getWidth()-250) / 2, 500, 250, 50);
        startButton.addActionListener(e -> {
            // Action to start the game
            Game game = new Game();
            frame.dispose(); // Close the title screen
        });
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.setForeground(Color.BLUE);
        this.add(startButton);

        //Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setBounds((frame.getWidth()-100) / 2, 600, 100, 50);
        exitButton.addActionListener(e -> {
            // Action to exit the game
            System.exit(0);
        });
        exitButton.setForeground(Color.BLUE);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(exitButton);

        ImageIcon cowIcon = new ImageIcon("Illustrations/cow.png");
        cow = new JLabel();
        cow.setIcon(cowIcon);
        this.add(cow);
        exitButton.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.setContentPane(this); // Set this panel as the content pane
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        backgroundImage = new ImageIcon("Illustrations/title-screen-wallp.png").getImage();
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        title.setBounds(50, 0, 700, 300);
        cow.setBounds(500, 300, 200, 650);

        this.repaint(); // Ensure the panel is repainted
    }
}