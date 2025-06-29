import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GameOver extends JPanel {
    private Image backgroundImage;
    private int count = 0;
    private int totalMistakes = 0;
    private ArrayList<GarbageItem> tracked = new ArrayList<GarbageItem>();

    public GameOver(int score, ArrayList<GarbageItem> mistakes){
        totalMistakes = mistakes.size();

        //fix mistakes so no duplicates appear
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
        frame.setSize(300, 225);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        this.setLayout(null);
        this.setBounds(0, 0, frame.getWidth(), frame.getHeight());


        // descriptions
        JTextPane description = new JTextPane();
        description.setText("You made " + totalMistakes + " mistakes!\n\n" +
                "Click through to learn about which items go in which bin.");
        description.setFont(new Font("Arial", Font.PLAIN, 18));
        description.setEditable(false); // Make the text area non-editable
        description.setOpaque(false);
        description.setForeground(Color.BLACK);
        description.setBounds((frame.getWidth()-300) / 2, 0, 300, 150);
        this.add(description);

        

        // Advance button
        JButton startButton = new JButton("Next");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBounds((frame.getWidth()-250) / 2, 150, 250, 50);
        startButton.addActionListener(e -> {
            count++;

            if (count < tracked.size()) {
                startButton.setText("Next");
            } else if (count == tracked.size()){
                startButton.setText("Return To Title Screen");
            } else if (count > tracked.size()) {
                startButton.setText("Returning to Title Screen...");
                frame.dispose(); // Close the game over screen
                Title title = new Title(); // Return to the title screen
                return;
            }


            description.setText(tracked.get(count-1).Name + "\n\n" + tracked.get(count-1).GameOverTip);

        });


        this.add(startButton);
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