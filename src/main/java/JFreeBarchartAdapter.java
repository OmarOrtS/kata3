import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.es.model.Barchart;

import java.util.Map;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart, String selectedGenre){
        return ChartFactory.createBarChart(
                "",
                barchart.getTitle(),
                "count",
                datasetOf(barchart, selectedGenre)
        );
    }

    private static CategoryDataset datasetOf(Barchart barchart, String selectedGenre) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : barchart.numberOfMoviesPerGenre()) {
            if (selectedGenre.equals("All")) dataset.addValue(entry.getValue(), "Total films", entry.getKey());
            if (entry.getKey().equals(selectedGenre)) dataset.addValue(entry.getValue(), selectedGenre, entry.getKey());
        }

        return dataset;
    }
}
