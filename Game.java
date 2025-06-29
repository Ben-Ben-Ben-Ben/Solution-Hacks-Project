import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Game extends JPanel {
    private Image backgroundImage;
    private JFrame gameFrame;
    private final int width = 700;
    private final int height = 700;
    private int lifeCount = 3;
    GarbageItem chosen;
    ArrayList<GarbageItem> mistakes = new ArrayList<>();

    //list of items for randomization
    JLabel nextTrash, score, robot, life1, life2, life3, recycleCan, organicCan, garbageCan, frame;
    JButton recycle, organic, garbage;

    public Game() {
        gameFrame = new JFrame("Garbage Game");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setSize(new Dimension(width, height));
        gameFrame.setResizable(false);
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

        chosen = GarbageItem.getRandom();
        ImageIcon i =  new ImageIcon(chosen.Image);
        nextTrash = new JLabel();
        nextTrash.setSize(new Dimension(150, 150));
        nextTrash.setIcon(i);
        nextTrash.setText(chosen.Type);
        nextTrash.setIconTextGap(50);

        ImageIcon f =  new ImageIcon("Illustrations/hazard-panel.png");
        Image imf = f.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
        frame = new JLabel();
        frame.setSize(new Dimension(250, 250));
        frame.setIcon(new ImageIcon(imf));

        ImageIcon r =  new ImageIcon("Illustrations/robot neutral.png");
        Image imr = r.getImage().getScaledInstance(250, 400, java.awt.Image.SCALE_SMOOTH);
        robot = new JLabel();
        robot.setSize(new Dimension(250, 400));
        robot.setIcon(new ImageIcon(imr));

        ImageIcon l =  new ImageIcon("Illustrations/lightbulb life.png");
        life1 = new JLabel();
        life1.setSize(new Dimension(20, 20));
        life1.setIcon(l);
        life2 = new JLabel();
        life2.setSize(new Dimension(20, 20));
        life2.setIcon(l);
        life3 = new JLabel();
        life3.setSize(new Dimension(20, 20));
        life3.setIcon(l);

        ImageIcon rc =  new ImageIcon("Illustrations/garbage recycle.png");
        recycleCan = new JLabel();
        recycleCan.setSize(new Dimension(200, 500));
        recycleCan.setIcon(rc);
        ImageIcon oc =  new ImageIcon("Illustrations/garbage compost.png");
        organicCan = new JLabel();
        organicCan.setSize(new Dimension(200, 500));
        organicCan.setIcon(oc);
        ImageIcon gc =  new ImageIcon("Illustrations/garbage bin.png");
        garbageCan = new JLabel();
        garbageCan.setSize(new Dimension(200, 500));
        garbageCan.setIcon(gc);

        score = new JLabel("0"); score.setSize(100, 50); score.setFont(new Font("Arial", Font.BOLD, 20));
        
        recycle = new JButton("Recycle"); recycle.setPreferredSize(new Dimension(150, 50)); recycle.setForeground(Color.BLUE); recycle.setName("Recycle"); 
        recycle.setFont(new Font("Arial", Font.BOLD, 20));
        recycle.addActionListener(new ButtonListener());
        recycle.setCursor(new Cursor(Cursor.HAND_CURSOR));

        organic = new JButton("Organic"); organic.setPreferredSize(new Dimension(150, 50)); organic.setForeground(Color.GREEN); organic.setName("Organic"); 
        organic.setFont(new Font("Arial", Font.BOLD, 20));
        organic.addActionListener(new ButtonListener());
        organic.setCursor(new Cursor(Cursor.HAND_CURSOR));

        garbage = new JButton("Garbage"); garbage.setPreferredSize(new Dimension(150, 50)); garbage.setForeground(Color.BLACK); garbage.setName("Garbage"); 
        garbage.setFont(new Font("Arial", Font.BOLD, 20));
        garbage.addActionListener(new ButtonListener());
        garbage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.add(nextTrash); this.add(frame); this.add(robot); this.add(life1); this.add(life2); this.add(life3);
        this.add(recycleCan); this.add(organicCan); this.add(garbageCan);
        this.add(recycle); this.add(organic); this.add(garbage); this.add(score);

        gameFrame.add(this);
        gameFrame.pack();
        gameFrame.setLayout(null);
        gameFrame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        backgroundImage = new ImageIcon("Illustrations/game-screen-wallp.png").getImage();
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        nextTrash.setLocation(470, 25);
        frame.setLocation(450, 0);
        robot.setLocation(430, 300);
        score.setLocation(350, 80);
        life1.setLocation(-50, -20);
        life2.setLocation(50, -20);
        life3.setLocation(150, -20);
        recycleCan.setLocation(0, 150);
        organicCan.setLocation(0, 325);
        garbageCan.setLocation(0, 500);
        recycle.setLocation(200, 250);
        organic.setLocation(200, 425);
        garbage.setLocation(200, 600);

        this.repaint();
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
                ImageIcon r =  new ImageIcon("Illustrations/robot happy.png");
                Image imr = r.getImage().getScaledInstance(250, 400, java.awt.Image.SCALE_SMOOTH);
                robot.setIcon(new ImageIcon(imr));
            } else {
                ImageIcon r =  new ImageIcon("Illustrations/robot sad.png");
                Image imr = r.getImage().getScaledInstance(250, 400, java.awt.Image.SCALE_SMOOTH);
                robot.setIcon(new ImageIcon(imr));
                mistakes.add(chosen);
                if (lifeCount == 3) {
                    life3.setEnabled(false); lifeCount--;
                } else if (lifeCount == 2) {
                    life2.setEnabled(false); lifeCount--;
                } else {
                    life1.setEnabled(false); lifeCount--;
                    GameOver gover = new GameOver(Integer.parseInt(score.getText()), mistakes);
                    gameFrame.dispose();
                }
            }
        }
    }
}