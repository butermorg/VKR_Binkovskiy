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
    XYSeriesCollection XYSC = new XYSeriesCollection();

    public JFreeChart makechart() {

        // Create dataset
        XYDataset dataset = XYSC;
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
        plot.setRangeGridlinePaint(Color.black);


        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        plot.setRenderer(renderer);


        return chart;
    }

    public void createSeries(ArrayList<Double> x, ArrayList<Double> y, XYSeries s) {

        for (int i = 0; i < x.size(); i++) {
            s.add(x.get(i), y.get(i));
        }
        //Add series to dataset
        XYSC.addSeries(s);

    }

}