package src.main.dyp1xy;

import com.mindfusion.charting.FunctionSeries;
import com.mindfusion.charting.GridType;
import com.mindfusion.charting.Plot2D;
import com.mindfusion.charting.swing.LineChart;
import com.mindfusion.drawing.DashStyle;
import com.mindfusion.drawing.SolidBrush;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

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
    //


    // Constructor overloading, multiple instance
    public GraphLineChart(String[] functionsArg){ this.functions = functionsArg; }

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

    private LineChart initializeChart()  {
        //initialize default chart settings
        JFrame.setSize(width, height);
        JFrame.setTitle("SimpleGraphing");
        JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.setResizable(true);
        FunctionSeries series;
        //add functions to graph
        /*
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
        */

        lineChart.getXAxis().setMinValue(-50.0);
        lineChart.getXAxis().setMaxValue(50.0);
        lineChart.getXAxis().setInterval(10.0);
        lineChart.getXAxis().setOrigin(0.0);
        lineChart.getXAxis().setTitle("X-axis");

        lineChart.getYAxis().setMaxValue(1000.0);
        lineChart.getYAxis().setTitle("Y-axis");
        lineChart.getYAxis().setMinValue(0.0);
        lineChart.getYAxis().setInterval(100.0);

        //specifying color and stroke for the axes
        lineChart.getTheme().setAxisStroke(new SolidBrush(new Color(190, 190, 190)));
        lineChart.getTheme().setAxisStrokeThickness(1.0);

        //styling the legend
        lineChart.getLegendRenderer().setShowTitle(false);
        lineChart.getTheme().setDataLabelsFontSize(12);

        //styling the grid
        lineChart.setGridType(GridType.Crossed);
        lineChart.getTheme().setGridLineColor(new Color(192, 192, 192));
        lineChart.getTheme().setGridLineStyle(DashStyle.Dash);

        //setting the chart colors
        lineChart.getTheme().setHighlightStroke(new SolidBrush(new Color(255, 147, 66)));
        lineChart.getTheme().setCommonSeriesStrokes(
                Arrays.asList(
                        new SolidBrush( new Color (98, 94, 96 )),
                        new SolidBrush( new Color (40, 133, 161)),
                        new SolidBrush( new Color (255, 109, 93))));
        lineChart.getTheme().setCommonSeriesFills(
                Arrays.asList(
                        new SolidBrush( new Color (98, 94, 96 )),
                        new SolidBrush( new Color (40, 133, 161)),
                        new SolidBrush( new Color (255, 109, 93))));
        lineChart.getTheme().setCommonSeriesStrokeThicknesses(
                Arrays.asList(3.0));

        FunctionSeries series1;
        FunctionSeries series2;
        FunctionSeries series3;

        try
        {
            series1 = new FunctionSeries("x*x*x",
                    1000, -50, 50);
            series1.setTitle("Cubic function");
            lineChart.getSeries().add(series1);

            series2 = new FunctionSeries("2*x*x + 10*x + 4",
                    1000, -50, 50);
            series2.setTitle("Square function");
            lineChart.getSeries().add(series2);

            series3 = new FunctionSeries("Abs(x)",
                    1000, -50, 50);
            series3.setTitle("Absolute value");
            lineChart.getSeries().add(series3);
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }

        lineChart.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e)
            {
                lineChart.grabFocus();
            }
        });

        lineChart.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e)
            {
                if(e.isShiftDown())
                {
                    Plot2D plot = (Plot2D)lineChart.getPlot();
                    plot.setVerticalScroll(true);
                }

                if(e.getKeyChar() == 'r')
                    lineChart.resetZoom();
            }

            public void keyReleased(KeyEvent e)
            {
                if(!e.isShiftDown())
                {
                    Plot2D plot = (Plot2D)lineChart.getPlot();
                    plot.setVerticalScroll(false);
                }
            }
        });
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
