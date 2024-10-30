import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        TitleTypeHistogram titleTypeHistogram = new TitleTypeHistogram();

        Map<Title.TitleType, Integer> histogram = titleTypeHistogram.createHistogram(loadFile("./title.basics.tsv"));
        titleTypeHistogram.printHistogramValues(histogram);

        HistogramaEjemplo example = new HistogramaEjemplo(histogram);
        example.setSize(800, 600);
        example.setLocationRelativeTo(null);
        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        example.setVisible(true);

    }

    public static class HistogramaEjemplo extends JFrame {

        public HistogramaEjemplo(Map<Title.TitleType, Integer> histogram) {
            CategoryDataset dataset = createDataset(histogram);

            JFreeChart chart = ChartFactory.createBarChart(
                    "Histograma",
                    "Valores",
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

    }

    private static CategoryDataset createDataset(Map<Title.TitleType, Integer> histogram) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Title.TitleType titleType : histogram.keySet()) {
           dataset.addValue(histogram.get(titleType), "Frecuencia", titleType);
        }
        return dataset;
    }

    private static List<Title> loadFile(String s) throws IOException {
        TsvTitleReader reader = new TsvTitleReader(new File(s));
        return reader.read();
    }


}
