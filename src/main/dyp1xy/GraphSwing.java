package src.main.dyp1xy;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphSwing extends Canvas {

    String[] equations;
    static JTextField fun;
    static JTextField abc;

    public GraphSwing(String[] equations) { this.equations = equations; }
    public GraphSwing() {
    }

    public static void main(String[] args) {
        GraphSwing gm = new GraphSwing();
        JFrame frame = new JFrame("Coordinate system");
        Canvas canvas = new GraphSwing();
        JPanel panel = new JPanel();
        JButton button = new JButton();
        fun = new JTextField(40);
        fun.setText("function: ");
        canvas.setSize(500, 500);
        frame.setSize(500, 550);
        button.setSize(10, 10);
        button.addActionListener((e) -> {
            gm.repaint(1L);
        });
        panel.add(button);
        panel.add(fun);
        panel.add(button);
        panel.add(canvas);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        int xold = 0;
        int yold = 0;
        g.drawLine(0, height / 2, width - 1, height / 2);
        g.drawLine(width / 2, 0, width / 2, height - 1);

        for(int x = width / -2; x < width / 2; ++x) {
            int y = -1 * (int)this.func();
            g.drawLine(x + width / 2, y + height / 2, x + width / 2, y + height / 2);
            if (x > width / -2 + 1) {
                g.drawLine(xold + width / 2, yold + height / 2, x + width / 2, y + height / 2);
            }

            xold = x;
            yold = y;
        }

    }

    public double func() {
        String x = abc.getText();
        String func = fun.getText();
        boolean boo = false;
        func.trim();
        String[] arr = func.split("");
        double value = 0.0;

        for(int i = 0; i < arr.length; ++i) {
            if (!boo) {
                switch (arr[i]) {
                    case "+":
                        if (arr[i - 1] == "x") {
                            value = Double.parseDouble(x) + Double.parseDouble(arr[i + 1]);
                        } else if (arr[i + 1] == "x") {
                            value = Double.parseDouble(x) + Double.parseDouble(arr[i - 1]);
                        } else {
                            value = Double.parseDouble(arr[i + 1]) + Double.parseDouble(arr[i - 1]);
                        }
                        break;
                    case "-":
                        if (arr[i - 1] == "x") {
                            value = Double.parseDouble(x) - Double.parseDouble(arr[i + 1]);
                        } else if (arr[i + 1] == "x") {
                            value = Double.parseDouble(x) - Double.parseDouble(arr[i - 1]);
                        } else {
                            value = Double.parseDouble(arr[i + 1]) - Double.parseDouble(arr[i - 1]);
                        }
                        break;
                    case "*":
                        if (arr[i - 1] == "x") {
                            value = Double.parseDouble(x) * Double.parseDouble(arr[i + 1]);
                        } else if (arr[i + 1] == "x") {
                            value = Double.parseDouble(x) * Double.parseDouble(arr[i - 1]);
                        } else {
                            value = Double.parseDouble(arr[i + 1]) * Double.parseDouble(arr[i - 1]);
                        }
                        break;
                    case "/":
                        if (arr[i - 1] == "x") {
                            value = Double.parseDouble(x) / Double.parseDouble(arr[i + 1]);
                        } else if (arr[i + 1] == "x") {
                            value = Double.parseDouble(x) / Double.parseDouble(arr[i - 1]);
                        } else {
                            value = Double.parseDouble(arr[i + 1]) / Double.parseDouble(arr[i - 1]);
                        }
                }

                boo = true;
            } else {
                switch (arr[i]) {
                    case "+":
                        value += Double.parseDouble(arr[i - 1]);
                        break;
                    case "-":
                        value -= Double.parseDouble(arr[i - 1]);
                        break;
                    case "*":
                        value *= Double.parseDouble(arr[i - 1]);
                        break;
                    case "/":
                        value /= Double.parseDouble(arr[i - 1]);
                }
            }
        }

        return value;
    }
}
