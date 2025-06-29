import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameOver extends JPanel {
    private Image backgroundImage;
    private JLabel cow, robot;
    private int count = 0;
    private int totalMistakes = 0;
    private ArrayList<GarbageItem> tracked = new ArrayList<>();

    @SuppressWarnings("unused")
    public GameOver(int score, ArrayList<GarbageItem> mistakes){
        totalMistakes = mistakes.size();

        // Fix mistakes so no duplicates appear
        for (int i = 0; i < mistakes.size(); i++) {
            if (tracked.contains(mistakes.get(i))) {
                mistakes.remove(i);
            } else {
                tracked.add(mistakes.get(i));
            }
        }

        // Load background image
        backgroundImage = new ImageIcon("Illustrations/game-screen-wallp.png").getImage();

        // Create a JFrame instance
        JFrame frame = new JFrame("Garbage Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        this.setLayout(null);
        this.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // Descriptions
        JTextPane description = new JTextPane();
        description.setText("You made " + totalMistakes + " mistakes!\n\n" +
                "Click through to learn about which items go in which bin.");
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setEditable(false); // Make the text area non-editable
        description.setOpaque(true);
        description.setForeground(Color.BLACK);
        description.setBackground(Color.WHITE);
        description.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        description.setBounds(50, 50, 600, 300);
        this.add(description);

        ImageIcon cowIcon = new ImageIcon("Illustrations/cow.png");
        cow = new JLabel();
        cow.setIcon(cowIcon);
        cow.setBounds(500, 300, 200, 650);
        this.add(cow);

        ImageIcon r =  new ImageIcon("Illustrations/robot neutral.png");
        Image imr = r.getImage().getScaledInstance(250, 400, java.awt.Image.SCALE_SMOOTH);
        robot = new JLabel();
        robot.setBounds(50, 450, 400, 400);;
        robot.setIcon(new ImageIcon(imr));
        this.add(robot);

        // Advance button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setBounds((frame.getWidth()-250) / 2, 400, 250, 50);
        nextButton.addActionListener(e -> {
            count++;

            if (count < tracked.size()) {
                nextButton.setText("Next");
            } else if (count == tracked.size()) {
                nextButton.setText("Return To Title Screen");
            } else if (count > tracked.size()) {
                nextButton.setText("Returning to Title Screen...");
                frame.dispose(); // Close the game over screen
                Title mainGame = new Title(); // Return to the title screen
                return;
            }

            description.setText(tracked.get(count-1).Name + "\n\n" + tracked.get(count-1).GameOverTip);
        });
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(nextButton);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.setContentPane(this);
        frame.setVisible(true);
        frame.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        backgroundImage = new ImageIcon("Illustrations/info-screen-wallp.png").getImage();
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        this.repaint(); // Ensure the panel is repainted
    }
}