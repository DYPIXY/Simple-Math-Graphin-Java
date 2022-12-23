import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
public class GraphLineChart extends JPanel{
    String[] functions;
    String tittle;

    // Constructor
    public GraphLineChart(String[] functionsArg){
        this.functions = functionsArg;
    }

    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GraphLineChart().setVisible(true);
                }
                catch (Exception exp) {
                    System.out.println(exp);
                }
            }
        }); 
    }
    private LineChart initializeChart()  {
	    LineChart lineChart = new LineChart();	
        List<String> functionsList = new ArrayList<String>();
        Collections.addAll(functionsList, functions);
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
            series2.setTitle("Quadratic equation: -3*x*x+(4*x+1)");
            lineChart.getSeries().add(series2);
                
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lineChart;
    }
    protected GraphLineChart() {
	    JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setSize(650, 400);
	    f.setTitle("Java Swing Library for Charts and Gauges: FunctionSeries");		
	    //add the chart to the ContentPane
	    f.getContentPane().add(initializeChart(), BorderLayout.CENTER);
        f.setVisible(true);
    }
}