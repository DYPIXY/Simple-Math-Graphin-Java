package SimpleMathGraphing.src;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class MathGraphCanvas {
    private int width;
    private int heigth;

    public MathGraphCanvas(int w, int h) {
        this.width = w;
        this.heigth = h;
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    }
}
