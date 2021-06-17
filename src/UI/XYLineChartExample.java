package UI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class XYLineChartExample extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;

    public JFreeChart makechart(ArrayList<Double> x, ArrayList<Double> y) {

        // Create dataset
        XYDataset dataset = createDataset(x, y);
        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Эмпирическая функция распределения наработки",
                "Наработка",
                "Gamma",
                dataset,
                PlotOrientation.VERTICAL,
                true, false, false);
        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(new Color(232, 232, 232));

        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint (Color.black);


        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        plot.setRenderer(renderer);


        return chart;
    }

    private XYDataset createDataset(ArrayList<Double> x, ArrayList<Double> y) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series = new XYSeries("a");
        for (int i = 0; i < x.size(); i++) {
            series.add(x.get(i), y.get(i));
        }

       /* XYSeries series2 = new XYSeries("b");
        series2.add(-10, 41);
        series2.add(20, -40);*/

        //Add series to dataset
        dataset.addSeries(series);
//        dataset.addSeries(series2);

        return dataset;
    }

}