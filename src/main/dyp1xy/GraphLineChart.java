package src.main.dyp1xy;

import com.mindfusion.charting.FunctionSeries;
import com.mindfusion.charting.swing.LineChart;
import javax.swing.*;
import java.awt.*;

//Extends JPanel class 
public class GraphLineChart extends JPanel{
    //initialize variables
    String[] functions;
    final String demoFunction = "(x+2) * 2";
    int width = 650;
    int height = 400;
    int xMax = 5;
    int yMax = 30;

    //initialize objects
    boolean visibility = true;
    JFrame JFrame = new JFrame();
    LineChart lineChart = new LineChart();


    // Constructor overloading, multiple instance
    public GraphLineChart(String[] functionsArg){ this.functions = functionsArg; }
    private LineChart initializeChart()  {
        //initialize default chart settings
        JFrame.setSize(width, height);
        JFrame.setTitle("SimpleGraphing");
        JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setResizable(true);

        FunctionSeries series;	  
        //add functions to graph
        try
        {
            //if functions array is empty, show a demo function
            if(functions == null) {
                series = new FunctionSeries(demoFunction, 1000, -5, 5 );
                series.setTitle("Equation: " + demoFunction);
                lineChart.getSeries().add(series);
            } else {
                for (String i : functions) {
                    series = new FunctionSeries(i, 1000, -5, 5);
                    series.setTitle("Equation: " + i);
                    lineChart.getSeries().add(series);
                }
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
	    //add the chart to the ContentPane
	    JFrame.getContentPane().add(initializeChart(), BorderLayout.CENTER);
        JFrame.setVisible(true);
    }
    //getters and setters
    public void setSize(int width, int height){
        JFrame.setSize(width, height);
    }
    public void setMaxValue(int xMaxValue, int yMaxValue) {

    }
    public void setTittlesXY(String yTittle, String xTittle) {

    }
    public String getTittlesXY(){
        return "Temp return";
    }
    public void setTittle(String Tittle) { }
    public void setLegendVisibility(boolean Visibility){
        this.visibility = Visibility;
    }
    //main method
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
}
