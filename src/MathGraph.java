package SimpleMathGraphing.src;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MathGraph extends JPanel{
    public static void main(String[] args) {
        int width = 640;
        int height = 480;
        JFrame jf = new JFrame();
        jf.setSize(width, height);
        jf.setTitle("Graph");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}