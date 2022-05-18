import javax.swing.*; //Main gui elements
import java.awt.*;  //Colors and containers
public class GUIexample {
    public static void main(String[] args) {
        //Let's make a GUI!!!!!!!
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Optional Java Fun!");
        theGUI.setSize(400,600);
        //NEED, otherwise you will have memory issues (restart computer)
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.MAGENTA);

        Container pane = theGUI.getContentPane();
        pane.add(panel);

        theGUI.setVisible(true);

    }
}