import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class GUIexample2 {
    public static void main(String[] args) {
        // sound files
        String sound1 = "laser1.wav";
        String bgmusic = "bgmusic.wav";
        String fart = "fart-1.wav";
        String bruh = "Bruh-sound-effect.wav";

        // Image files
        BufferedImage img1;
        BufferedImage img2;


        try {
            img1 = ImageIO.read(new File("mario1_re.png"));
            img2 = ImageIO.read(new File("sonic1_re.png"));
        } catch (IOException ee) {return;}


        playSound(bgmusic);

        JFrame frame = new JFrame("Button Tests");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JButton okButton = new JButton("Poop");
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        JButton submitButton = new JButton("Weed");

        // images
        JLabel pic = new JLabel((new ImageIcon(img1)));
        panel.add(pic);

        //ToDo: Create Label and Text Objects
        JLabel a = new JLabel("Sample Text");
        JTextField t = new JTextField(" ", 20);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //ToDo: Modify what happens when button is pressed
                String s = t.getText();
                if(s.equals("Right")) {
                    a.setText("You went right and died. Try again loser");
                    t.setText(" ");
                } else if (s.equals("Left")) {
                    a.setText("You went left and lived");
                    t.setText(" ");
                }
                pic.setIcon(new ImageIcon(img1));


            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(frame, "Weed Button clicked.");
                playSound(fart);

                pic.setIcon(new ImageIcon(img2));
            }
        });

        frame.getRootPane().setDefaultButton(submitButton);

        //ToDo: Add Labels and Text to panel

        panel.add(a);
        panel.add(t);
        panel.add(okButton);
        panel.add(cancelButton);
        panel.add(submitButton);


        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setSize(410, 650);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void playSound(String s) {
        try {
            AudioInputStream x = AudioSystem.getAudioInputStream(new File(s).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(x);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ee) {
            ee.printStackTrace();

        }
    }

}