package SimpleGraphing.src;

import java.awt.BorderLayout;

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
    JFrame f;

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
        FunctionSeries series;	  
        //add functions to graph
        try
        {			
            for(String i : functions){
                series = new FunctionSeries(i, 1000, -5, 5 );
                series.setTitle("Equation: "+i);
                lineChart.getSeries().add(series);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lineChart;
    }
    //show on screen
    protected GraphLineChart() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //add the chart to the ContentPane
	    f.getContentPane().add(initializeChart(), BorderLayout.CENTER);
        f.setVisible(true);
    }
    public void style(){
        int weightSize;
        int heigthSize;



        f.setSize(650, 400);
        f.setTitle("Java Swing Library for Charts and Gauges: FunctionSeries");

    }
    public static void main() {

    }
}
