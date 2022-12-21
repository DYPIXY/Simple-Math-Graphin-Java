import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.mindfusion.charting.FunctionSeries;
import com.mindfusion.charting.GridType;
import com.mindfusion.charting.swing.LineChart;
import com.mindfusion.drawing.Brushes;
import com.mindfusion.drawing.DashStyle;
import com.mindfusion.drawing.SolidBrush;

//Extends JPanel class 
public class Graph extends JPanel{
    private static final long serialVersionUID = 1L;

    //the main method of the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Graph().setVisible(true);
                }
                catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        }); 
    }
    private LineChart initializeChart()  {
	LineChart lineChart = new LineChart();	
        
        FunctionSeries series1;
        FunctionSeries series2;	  
        try
        {			
        
            series1 = new FunctionSeries("3*x*x+2*x+2", 1000, -5, 5 );
            series1.setTitle("Quadratic equation: 3*x*x+2*x+2");
            lineChart.getSeries().add(series1);
                
            //mean value is -2
            series2 = new FunctionSeries(
                "-3*x*x+4*x+1", 1000, -5, 5);
            series2.setTitle("Quadratic equation: -3*x*x+4*x+1");
            lineChart.getSeries().add(series2);
                
        }
        catch (Exception e)
        {
            // could not parse the expression
            e.printStackTrace();
        }
        return lineChart;
    }
    protected Graph() {
	    JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setSize(650, 400);
	    f.setTitle("Java Swing Library for Charts and Gauges: FunctionSeries");		
	    //add the chart to the ContentPane
	    f.getContentPane().add(initializeChart(), BorderLayout.CENTER);
        f.setVisible(true);
    }
}