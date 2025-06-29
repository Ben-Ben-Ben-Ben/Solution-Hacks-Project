import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends JPanel {
    private Image backgroundImage;
    private final int width = 700;
    private final int height = 700;
    private Conveyor Conveyor;

    //list of items for randomization
    private ArrayList<ImageIcon> trashList = new ArrayList<>();
    JLabel nextTrash, score, robot;
    JButton recycle, organic, garbage;

    public Game() {

        JFrame gameFrame = new JFrame("Garbage Game");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setSize(new Dimension(width, height));
        //gameFrame.setResizable(false);
        gameFrame.setUndecorated(true);
        gameFrame.setLocationRelativeTo(null);

        //trash list
        new GarbageItem("Chips", "Garbage", "chips-org.png","Chip bags are garbage! They are made of material that cannot be recycled or composted.");
        new GarbageItem("Diaper", "Organic", "diaper-org.png", "Diapers are organic! They contain organic matter and must be recycled.");
        new GarbageItem("Crumpled Paper", "Recycle", "crumpled-paper-recycle.png", "Paper is recyclable!");
        new GarbageItem("Gum", "Garbage", "gum-gen.png", "Gum cannot be recycled, nor is it organic as it is not composed of many natural ingredients.");
        new GarbageItem("Mask", "Garbage", "mask-gen.png", "Masks should not be recycled. Surgical masks are also not made of organic material.");
        new GarbageItem("Plastic Bag", "Recycle", "plast-bag-recycle.png", "Plastic bags can and should be recycled!");
        new GarbageItem("Poop", "Organic", "poop-org.png", "Pet waste is organic!");
        new GarbageItem("Straw", "Garbage", "straw-gen.png", "Straws are for the garbage! They are not recyclable because of the size and plastic they are made from. They are not made of any organic material either.");
        new GarbageItem("Toilet Paper Core", "Recycle", "toilet core - recycle.png", "The core part of the toilet paper is recyclable! It is typically made of cardboard");

        GarbageItem chosen = GarbageItem.getRandom();
        ImageIcon i =  new ImageIcon(chosen.Image);
        nextTrash = new JLabel();
        nextTrash.setSize(new Dimension(150, 150));
        nextTrash.setIcon(i);
        nextTrash.setText(chosen.Type);
        nextTrash.setIconTextGap(20);

        ImageIcon r =  new ImageIcon("Illustrations/robot neutral.png");
        robot = new JLabel();
        robot.setSize(new Dimension(200, 500));
        robot.setIcon(r);

        Conveyor = new Conveyor();

        score = new JLabel("0"); score.setSize(100, 50);
        recycle = new JButton("Recycle"); recycle.setSize(200, 100); recycle.setForeground(Color.BLUE); recycle.setName("Recycle"); 
        recycle.addActionListener(new ButtonListener());
        organic = new JButton("Organic"); organic.setSize(200, 100); organic.setForeground(Color.GREEN); organic.setName("Organic"); 
        organic.addActionListener(new ButtonListener());
        garbage = new JButton("Garbage"); garbage.setSize(200, 100); garbage.setForeground(Color.BLACK); garbage.setName("Garbage"); 
        garbage.addActionListener(new ButtonListener());
        
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createEtchedBorder());

        this.add(nextTrash); this.add(robot);
        this.add(recycle); this.add(organic); this.add(garbage); this.add(score);

        gameFrame.add(this);
        gameFrame.pack();
        gameFrame.setLayout(null);
        gameFrame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        Conveyor.draw(g);

        nextTrash.setLocation(480, 10);
        robot.setLocation(480, 200);
        score.setLocation(50, 50);
        recycle.setLocation(50, 250);
        organic.setLocation(50, 400);
        garbage.setLocation(50, 550);

        this.repaint();
    }

    public void animate() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.repaint();
        }
    }

    public class Conveyor extends JComponent {
        private int x = 460, y = -1, cWidth = 240, cHeight = 1000;

        public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GRAY);
            g2d.fillRect(x, y, cWidth, cHeight);
        }
    }

    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getName().equals(nextTrash.getText())) {
                int points = Integer.parseInt(score.getText())+10;
                score.setText(Integer.toString(points));
                GarbageItem chosen = GarbageItem.getRandom();
                ImageIcon i =  new ImageIcon(chosen.Image);
                nextTrash.setIcon(i);
                nextTrash.setText(chosen.Type);
                // ImageIcon r =  new ImageIcon("Illustrations/robot happy.png");
                // robot.setIcon(r);
            } else {
                // ImageIcon r =  new ImageIcon("Illustrations/robot sad.png");
                // robot.setIcon(r);
            }
        }
    }
}