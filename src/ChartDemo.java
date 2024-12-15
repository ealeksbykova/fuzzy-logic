import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.ui.*;
import org.jfree.data.xy.*;

import java.awt.*;
import java.util.*;

public class ChartDemo extends ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */

    public static ChartPanel chartPanel = null;
    public static JFreeChart chart = null;
    public static XYSeries series1, series2;
    private String title;

    public ChartDemo(
        final String title,
        Map<Integer, Float> A,
        Map<Integer, Float> B,
        Map<Integer, Float> result
    ) {

        super("Fuzzy Logic operation demo");
        this.title = title;
        final XYDataset dataset = createDataset(A, B, result);
        final JFreeChart chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset.
     *
     * @return a sample dataset.
     */
    public static XYDataset createDataset(
        Map<Integer, Float> A,
        Map<Integer, Float> B,
        Map<Integer, Float> result
    ) {

        series1 = new XYSeries("set A");
        for(Map.Entry<Integer, Float> entry : A.entrySet()) {
            series1.add(entry.getKey(), entry.getValue());
        }

        if (B != null) {
            series2 = new XYSeries("set B");
            for (Map.Entry<Integer, Float> entry : B.entrySet()) {
                series2.add(entry.getKey(), entry.getValue());
            }
        }

        final XYSeries series3 = new XYSeries("result");
        for(Map.Entry<Integer, Float> entry : result.entrySet()) {
            series3.add(entry.getKey(), entry.getValue());
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series3);
        dataset.addSeries(series1);
        if (B != null) dataset.addSeries(series2);

        return dataset;
    }

    /**
     * Creates a chart.
     *
     * @param dataset  the data for the chart.
     *
     * @return a chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {

        chart = ChartFactory.createXYLineChart(
            title,
            "X",
            "Y",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesLinesVisible(2, true);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);

        plot.setRenderer(renderer);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;
    }
}