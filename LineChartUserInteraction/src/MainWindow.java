import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.mindfusion.charting.FunctionSeries;
import com.mindfusion.charting.GridType;
import com.mindfusion.charting.Plot2D;
import com.mindfusion.charting.swing.LineChart;
import com.mindfusion.drawing.DashStyle;
import com.mindfusion.drawing.SolidBrush;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					new MainWindow().setVisible(true);
				}
				catch (Exception exp)
				{
				}
			}
		});
	}
	
	protected MainWindow()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(650, 400);
		setTitle("Java Swing Library for Charts and Gauges: FunctionSeries");
		
		getContentPane().add(initializeChart(), BorderLayout.CENTER);
		
	}
	
	private LineChart initializeChart()
	{
		LineChart lineChart = new LineChart();
		
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
	
}
