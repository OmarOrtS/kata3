import org.jfree.chart.ChartPanel;
import software.ulpgc.es.model.Barchart;
import software.ulpgc.es.view.BarchartDisplay;

import javax.swing.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {

    @Override
    public void display(Barchart barchart, String selectedGenre) {
        removeAll();
        add(new ChartPanel(JFreeBarchartAdapter.adapt(barchart, selectedGenre)));
        revalidate();
    }
}
