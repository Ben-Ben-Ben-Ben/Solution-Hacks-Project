import java.awt.*;
import javax.swing.*;

public class Game extends JPanel {
    private final int width = 500;
    private final int height = 500;
    private Pile gamePile;


    public Game() {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.WHITE);

        JFrame gameFrame = new JFrame("Title");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        gamePile = new Pile();

        JLabel crumbledPaper = new JLabel(new ImageIcon("a", "Crumbled"));
        crumbledPaper.setSize(new Dimension(width-400, height-400));

        this.add(gamePile);
        this.add(crumbledPaper);

        
        gameFrame.pack();
        gameFrame.setLayout(null);
        gameFrame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // gamePile.draw();
    }

    public class Pile extends JComponent {
        private int x = width-(width/3), y = height-(height/3);
        private int dx, dy = 1;
        private final int pileWidth = (int) width/3;
        private final int pileHeight = (int) height/3;


        public void draw(Graphics g) {
            x += dx; 
            y += dy;

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.fillRect(x, y, pileWidth, pileHeight);
        }


    }
}