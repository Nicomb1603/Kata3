import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class JFrameTitleTypeDrawHistogram extends JFrame implements DrawHistogram<Title.TitleType, Integer> {
    public JFrameTitleTypeDrawHistogram(Map<Title.TitleType, Integer> histogram) {
        CategoryDataset dataset = createDataset(histogram);

        JFreeChart chart = ChartFactory.createBarChart(
                "Histogram",
                "Títulos",
                "Frecuencia",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);



    }

    public void showHistogram(){
        this.setSize(800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public CategoryDataset createDataset(Map<Title.TitleType, Integer> histogram) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Title.TitleType titleType : histogram.keySet()) {
            dataset.addValue(histogram.get(titleType), "Frecuencia", titleType);
        }
        return dataset;
    }
}
