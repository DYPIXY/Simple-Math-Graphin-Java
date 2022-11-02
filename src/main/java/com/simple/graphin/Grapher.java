package com.simple.graphin;

import org.knowm.xchart.*;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

public class Grapher {
    public static void main(String[] args) {

        double[] xData = new double[] { 0.0, 1.0, 2.0 };
        double[] yData = new double[] { 2.0, 1.0, 0.0 };

        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

        // Show it
        new SwingWrapper(chart).displayChart();
        try {
            // Save it
            BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

            // or save it in high-res
            BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
        } catch(Exception e) {
            System.out.println(e);

        }
    }
}