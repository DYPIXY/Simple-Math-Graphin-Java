package src.main.dyp1xy;

import com.mindfusion.charting.FunctionSeries;
import com.mindfusion.charting.swing.LineChart;
import javax.swing.*;
import java.awt.*;

//Extends JPanel class 
public class GraphLineChart extends JPanel{
    //initialize variables it starts with a value in case the value was not provided
    String[] functions = {"(x+2) * 2", "x*x + x -30"};
    //String[] functions;
    boolean save;
    int width = 650;
    int height = 400;
    //how far should X be when graphing
    int minusRangeChart = -100;
    int plusRangeChart = 100;

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
            for (String i : functions) {
                series = new FunctionSeries(i, 5, minusRangeChart, plusRangeChart);

                series.setTitle("Equation: " + i);
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
	    //add the chart to the ContentPane
	    JFrame.getContentPane().add(initializeChart(), BorderLayout.CENTER);
        JFrame.setVisible(true);
    }
    //getters and setters
    //main method
    public static void main() {
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
    //setters and getters
    public void setSize(int width, int height) {
        JFrame.setSize(width, height);
    }
    public void setCalcRange(int minusRange, int plusRange) {
        minusRangeChart = minusRange;
        plusRangeChart = plusRange;
    }

    public void setTittle(String FrameTittle){
        JFrame.setTitle(FrameTittle);
    }
    public void setTittlesXY(String yTittle, String xTittle) {

    }
    public String getTittlesXY(){
        return "Temp return";
    }
    public void setLegendVisibility(boolean Visibility){
        this.visibility = Visibility;
    }
}
