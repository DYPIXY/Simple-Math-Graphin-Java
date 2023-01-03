package dyp1xy;

import java.awt.Canvas;
    import java.awt.Graphics;
    import javax.swing.*;

public class GraphSwing extends Canvas{
        static JTextField fun, abc;

        public static void main(String[] args) {
            GraphSwing gm = new GraphSwing();
            JFrame frame = new JFrame("Coordinate system");
            Canvas canvas = new GraphSwing();

            JPanel panel = new JPanel();
            JButton button = new JButton();


            fun = new JTextField(40);
            //abc = new JTextField(40);
            //abc.setText("x: ");
            fun.setText("function: ");

            canvas.setSize(500,500);    // paint area
            frame.setSize(500, 550);    //
            button.setSize(10,10);
            button.addActionListener(e->gm.repaint(1)); // action that button do

           // panel.add(abc); // x field
            panel.add(button); //button field
            panel.add(fun); //
            panel.add(button);
            panel.add(canvas);
            frame.add(panel);
            frame.setVisible(true);


            //canvas = new DisplayCanvas();      // Create the canvas, and set it to do zooming.
            //canvas.setHandleMouseZooms(true);
        }

        public void paint(Graphics g) {
            int x ;


            int width = getWidth();
            int height = getHeight();

            int xold=0;
            int yold=0;

            g.drawLine(0, height/2, width - 1, height/2);
            g.drawLine(width/2, 0, width/2, height-1);

            for(x= width/-2; x < width/2; x ++){

                int y= (-1*(int)func());

                g.drawLine(x + width/2, y + height/2, x+ width/2, y + height/2);
                if(x > (width/-2 )+1){
                g.drawLine(xold + width/2, yold + height/2 , x + width/2, y + height/2);
                }
                xold=x;
                yold=y;
            }
            //g.drawPoint(x, func(x));
        }



        public double func(){
            /*
                int y;
                double dy;
                double dx;

                dx = x;
                dy = 20* Math.sin(dx);
                y=(int)Math.round(dy); // convert to the bigger number

              return y;
              */
            String x = abc.getText();
            String func = fun.getText();  //get what in in the function field
            boolean boo = false; //
            func.trim(); // expresion, which delete swide spaces
            String arr[] = func.split(""); // stplit element by element

            double value = 0;
            for(int i= 0; i< arr.length; i++){ // if my arr is 5 elements long it will irretate 5 times

                if(boo == false){
                switch(arr[i]){

                    case "+":

                    if (arr[i-1] == "x"){
                        value = Double.parseDouble(x) + Double.parseDouble(arr[i+1]);   //parse -> convert string to double
                    }else if(arr[i+1] == "x"){
                        value = Double.parseDouble(x) + Double.parseDouble(arr[i-1]);
                    }else{
                        value = Double.parseDouble(arr[i+1]) + Double.parseDouble(arr[i-1]);
                    }
                    break;

                    case "-":
                    if (arr[i-1] == "x"){
                        value = Double.parseDouble(x) - Double.parseDouble(arr[i+1]);   //parse -> convert string to double
                    }else if(arr[i+1] == "x"){
                        value = Double.parseDouble(x) - Double.parseDouble(arr[i-1]);
                    }else{
                        value = Double.parseDouble(arr[i+1]) - Double.parseDouble(arr[i-1]);
                    }

                    break;
                    case "*":

                    if (arr[i-1] == "x"){
                        value = Double.parseDouble(x) * Double.parseDouble(arr[i+1]);   //parse -> convert string to double
                    }else if(arr[i+1] == "x"){
                        value = Double.parseDouble(x) * Double.parseDouble(arr[i-1]);
                    }else{
                        value = Double.parseDouble(arr[i+1]) * Double.parseDouble(arr[i-1]);
                    }

                    break;
                    case "/":

                    if (arr[i-1] == "x"){
                        value = Double.parseDouble(x) / Double.parseDouble(arr[i+1]);   //parse -> convert string to double
                    }else if(arr[i+1] == "x"){
                        value = Double.parseDouble(x) / Double.parseDouble(arr[i-1]);
                    }else{
                        value = Double.parseDouble(arr[i+1]) / Double.parseDouble(arr[i-1]);
                    }

                    break;

                    /*
                    case "^":
                    if (arr[i-1] == "x"){
                        value = Double.parseDouble(x) * Double.parseDouble(x);   //parse -> convert string to double
                    }else if(arr[i+1] == "x"){
                        value = Double.parseDouble(x) + Double.parseDouble(arr[i-1]);
                    }else{
                        value = Double.parseDouble(arr[i+1]) + Double.parseDouble(arr[i-1]);
                    }

                    break;
                    case "!":

                    break;
                    */
                }
                    boo=true;
                } else{

                switch (arr[i]){

                    case "+":
                        value = value + Double.parseDouble(arr[i-1]);
                    break;

                    case "-":
                        value = value - Double.parseDouble(arr[i-1]);
                    break;
                    case "*":
                        value = value * Double.parseDouble(arr[i-1]);
                    break;
                    case "/":
                        value = value / Double.parseDouble(arr[i-1]);
                    break;

                   /* case "^":

                    break;
                    case "!":

                    break;
                    */
                }
            }

            }

            return value;

        }
    }




/*  y = 4 * x + 2
4 -> arr[i-1]
x -> arr[i+1]
*/
